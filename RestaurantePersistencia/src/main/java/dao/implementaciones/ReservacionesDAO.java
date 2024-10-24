
package dao.implementaciones;

import conexion.Conexion;
import dao.interfaces.IMultasDAO;
import dao.interfaces.IReservacionesDAO;
import entidades.EstadoReservacion;
import entidades.Multa;
import entidades.Reservacion;
import excepciones.DAOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Clase concreta de la interfaz IReservacionesDAO
 * @author Saul Neri
 */
public class ReservacionesDAO implements IReservacionesDAO {

    private static IReservacionesDAO instancia;

    private ReservacionesDAO() {
    }

    public static IReservacionesDAO getInstance() {
        if (instancia == null) {
            instancia = new ReservacionesDAO();
        }
        return instancia;
    }

    @Override
    public List<Reservacion> obtenerReservacionesTodos() throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion(); 

        try {
            TypedQuery<Reservacion> query = entityManager.createQuery("SELECT r FROM Reservacion r", Reservacion.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener todas las reservaciones");
        } finally {
            entityManager.close(); 
        }
    }
    
    @Override
    public List<Reservacion> obtenerReservacionesDeMesa(String codigoMesa) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        
        try { 
            return entityManager.createQuery("SELECT r FROM Reservacion r WHERE r.mesa.codigo = :codigoMesa", Reservacion.class)
                    .setParameter("codigoMesa", codigoMesa)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("No se pudo cancelar la reservacion debido a un error, porfavor intente mas tarde");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Reservacion> obtenerReservacionesPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        try {
            TypedQuery<Reservacion> query = entityManager.createQuery(
                    "SELECT r FROM Reservacion r WHERE r.fechaHora BETWEEN :fechaInicio AND :fechaFin",
                    Reservacion.class
            );
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener reservaciones por período");
        } finally {
            entityManager.close(); 
        }
    }

    @Override
    public List<Reservacion> obtenerReservacionesCliente(String telefono) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        try {
            TypedQuery<Reservacion> query = entityManager.createQuery(
                    "SELECT r FROM Reservacion r WHERE r.cliente.telefono = :telefono",
                    Reservacion.class
            );
            query.setParameter("telefono", telefono);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener reservaciones del cliente");
        } finally {
            entityManager.close(); 
        }
    }

    @Override
    public Reservacion obtenerReservacionPorID(Long id) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion(); 

        try {
            return entityManager.find(Reservacion.class, id);
        } catch (Exception e) {
            throw new DAOException("Error al obtener la reservación por ID");
        } finally {
            entityManager.close(); 
        }
    }

    @Override
    public void agregarReservacion(Reservacion reservacion) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion(); 
        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            boolean reservacionActiva = entityManager.createQuery("SELECT COUNT(r) FROM Reservacion r WHERE r.cliente.id = :idCliente AND r.estado LIKE 'PENDIENTE'", Long.class)
                            .setParameter("idCliente", reservacion.getCliente().getId())
                            .getSingleResult() > 0;
            
            if (reservacionActiva) {
                throw new DAOException("No se puede realizar la reservacion debido a que el cliente cuenta con una reservacion activa");
            }
            
            boolean mesaOcupada = entityManager.createQuery("SELECT COUNT(r) FROM Reservacion r WHERE r.mesa.codigo = :codigoMesa AND r.estado LIKE 'PENDIENTE'", Long.class)
                            .setParameter("codigoMesa", reservacion.getMesa().getCodigo())
                            .getSingleResult() > 0;
            
            if (mesaOcupada) {
                throw new DAOException("La mesa que se intenta reservar ya se encuentra ocupada");
            }
            
            transaction.begin();
            entityManager.persist(reservacion);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); 
            }
            //System.out.println("ERROR EN AGREGARRESERVACION: " + e.getMessage());
            throw new DAOException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarReservacion(Reservacion reservacion) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(reservacion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DAOException("Error al actualizar la reservación");
        } finally {
            entityManager.close(); 
        }
    }

    @Override
    public void eliminarReservacion(Long id) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion(); 
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Reservacion reservacion = entityManager.find(Reservacion.class, id);
            if (reservacion != null) {
                entityManager.remove(reservacion);
            } else {
                throw new DAOException("No se encontro la reservacion a eliminar");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            //System.out.println("ELIMINAR RESERVACION: " + e.getMessage());
            throw new DAOException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


    @Override
    public void cancelarReservacion(Long idReservacion) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        
        Reservacion reservacion = entityManager.find(Reservacion.class, idReservacion);
        if (reservacion == null) {
            throw new DAOException("No se encontro la reservacion");
        }
        
        if (reservacion.getEstado().equals(EstadoReservacion.CANCELADA)) {
            throw new DAOException("La reservacion ya fue cancelada con anterioridad");
        }
        
        if (reservacion.getEstado().equals(EstadoReservacion.FINALIZADA)) {
            throw new DAOException("La reservacion que se intenta cancelar ya fue termino");
        }
        
        // se calcula la multa correspondiente al tiempo en el que fue cancelada
        LocalDateTime fechaHoraReservacion = reservacion.getFechaHora();
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        
        Duration diffTemporal = Duration.between(fechaHoraActual, fechaHoraReservacion);
        
        long horasRestantes = diffTemporal.toHours();
        
        // NOTE: DEBUG
        System.out.println("DIFERENCIA TEMPORAL DE CANCELACION: " + horasRestantes + " horas...");
        
        Multa multa = null;
        
        // multa de 25%
        if (horasRestantes > 24 && horasRestantes <= 48) {
            multa = this.obtenerTiposMultaTodos()
                    .stream()
                    .filter(m -> m.getPorcentaje() == 25f)
                    .findFirst()
                    .orElse(null);
            
            if (multa == null) {
                throw new DAOException("Ocurrio un error al aplicar la multa en la reservacion, porfavor intente mas tarde...");
            }
        // multa de 50%
        } else if (horasRestantes <= 24) {
            multa = this.obtenerTiposMultaTodos()
                    .stream()
                    .filter(m -> m.getPorcentaje() == 50f)
                    .findFirst()
                    .orElse(null);
            
            if (multa == null) {
                throw new DAOException("Ocurrio un error al aplicar la multa en la reservacion, porfavor intente mas tarde...");
            }
        }
        
        // se asigna la multa correspondiente a las horas restantes para la reservacion
        reservacion.setMulta(multa);
        
        if (multa != null) {
            // se calcula el nuevo total para la reservacion
            Float montoTotal = reservacion.getMesa().getTipoMesa().getPrecio() * (multa.getPorcentaje() / 100);
            reservacion.setMontoTotal(montoTotal);
        }
        
        // se cambia el estado de la reservacion
        reservacion.setEstado(EstadoReservacion.CANCELADA);
        
        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            transaction.begin();
            entityManager.merge(reservacion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DAOException("Error al cancelar la reservacion");
        } finally {
            entityManager.close(); 
        }
    }

    @Override
    public List<Multa> obtenerTiposMultaTodos() throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        try {
            return entityManager.createQuery("SELECT m FROM Multa m", Multa.class).getResultList();
        } catch (Exception e) {
            throw new DAOException("No se pudo obtener los tipos de multa en el sistema");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void agregarTipoMulta(Multa multa) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion(); 
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(multa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); 
            }
            //System.out.println("ERROR EN AGREGARRESERVACION: " + e.getMessage());
            throw new DAOException("Error al agregar el tipo de multa al sistema");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarTipoMulta(Long idMulta) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion(); 
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Multa multa = entityManager.find(Multa.class, idMulta);
            if (multa != null) {
                entityManager.remove(multa);
            } else {
                throw new DAOException("No se encontro el tipo de multa a eliminar");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ELIMINAR RESERVACION: " + e.getMessage());
            throw new DAOException("Error al eliminar el tipo de multa");
        } finally {
            entityManager.close();
        }
    }
}
