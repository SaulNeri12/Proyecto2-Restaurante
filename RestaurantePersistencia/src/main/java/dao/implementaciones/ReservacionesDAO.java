
package dao.implementaciones;

import conexion.Conexion;
import dao.interfaces.IReservacionesDAO;
import entidades.Reservacion;
import excepciones.DAOException;
import java.time.Instant;
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
    public List<Reservacion> obtenerReservacionesPorPeriodo(Instant fechaInicio, Instant fechaFin) throws DAOException {
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
            throw new DAOException("Error al obtener reservaciones por cliente");
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
            transaction.begin();
            entityManager.persist(reservacion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DAOException("Error al agregar la reservación");
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
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new DAOException("Error al eliminar la reservación");
        } finally {
            entityManager.close();
        }
    }
}
