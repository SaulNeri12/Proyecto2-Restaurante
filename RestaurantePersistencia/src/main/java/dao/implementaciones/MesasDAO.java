/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implementaciones;

import conexion.Conexion;
import dao.interfaces.IMesasDAO;
import entidades.Mesa;
import entidades.TipoMesa;
import entidades.UbicacionMesa;
import excepciones.DAOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Clase concreta que implementa los metodos definidos por IMesasDAO
 *
 * @author Saul Neri
 */
public class MesasDAO implements IMesasDAO {

    private static IMesasDAO instancia;

    private MesasDAO() {
    }

    public static IMesasDAO getInstance() {
        if (instancia == null) {
            instancia = new MesasDAO();
        }
        return instancia;
    }

    @Override
    public List<Mesa> obtenerMesasTodas(Long idRestaurante) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        
        // TODO: Las mesas se obtendran por restaurante... SELECT m FROM Mesa m WHERE m.restaurante.id = :idRestaurante

        try {
            TypedQuery<Mesa> query = entityManager.createQuery("SELECT m FROM Mesa m", Mesa.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener todas las mesas");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Mesa> obtenerMesasPorTipo(Long idRestaurante, TipoMesa tipo) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        // TODO: HACER QUE BUSQUE LAS MESAS POR TIPO PERO DENTRO DE ESE RESTAURANTE
        
        try {
            TypedQuery<Mesa> query = entityManager.createQuery("SELECT m FROM Mesa m WHERE m.tipoMesa = :tipo", Mesa.class);
            query.setParameter("tipo", tipo);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener mesas por tipo");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarMesa(Long idRestaurante, String codigo) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        // TODO: SOLO ELIMINA LA MESA CON EL CODIGO ESPECIFICADO EN EL RESTAURANTE INDICADO
        
        try {
            TypedQuery<Mesa> consulta = entityManager.createQuery("SELECT m FROM Mesa m WHERE m.codigo = :codigo", Mesa.class);
            consulta.setParameter("codigo", codigo);
            Mesa mesa = consulta.getSingleResult();

            if (mesa == null) {
                throw new DAOException("No se encontro la mesa con el codigo dado");
            }

            transaction.begin();

            //System.out.println("ELIMINACION DE: " + mesa);
            entityManager.remove(mesa);

            transaction.commit();

        } catch (NoResultException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DAOException("No se encontro la mesa a eliminar");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DAOException("No se pudo eliminar la mesa debido a un error, porfavor intente mas tarde");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void insertarMesas(Long idRestaurante, TipoMesa tipo, UbicacionMesa ubicacion, int cantidad) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        UbicacionMesa ubicacionReal = UbicacionMesa.valueOf(ubicacion.toString());

        // TODO: INSERTAR LAS MESAS EN EL RESTAURANTE INDICADO
        
        if (ubicacionReal == null) {
            throw new DAOException("La ubicacion de las mesas dada es incorrecta, ingrese una ubicacion de mesa valida");
        }

        if (cantidad < 1) {
            throw new DAOException("La cantidad de mesas a crear debe ser de almenos 1, ingrese una cantidad correcta");
        }
        transaction.begin();

        int cantidadRestante = cantidad;

        try {
            while (cantidadRestante > 0) {
                Mesa m = new Mesa();
                String codigoMesa;
                boolean codigoValido = false;

                while (!codigoValido) {
                    int numeroRandom = ThreadLocalRandom.current().nextInt(0, 999);
                    codigoMesa = String.format("%3s-%d-%03d", ubicacionReal.toString().substring(0, 3), tipo.getMaximoPersonas(), numeroRandom);

                    // Verificar si el código ya existe
                    if (entityManager.createQuery("SELECT COUNT(m) FROM Mesa m WHERE m.codigo = :codigo", Long.class)
                            .setParameter("codigo", codigoMesa)
                            .getSingleResult() == 0) {
                        codigoValido = true;
                        m.setCodigo(codigoMesa);
                    }
                }

                m.setTipoMesa(tipo);
                m.setUbicacion(ubicacionReal);

                entityManager.persist(m);

                cantidadRestante--;
            }

            entityManager.flush();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DAOException("Error al insertar las mesas");

        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Mesa> obtenerMesasDisponibles(Long idRestaurante) throws DAOException {
       
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        // TODO: OBTENER LAS MESAS DISPONIBLES EN EL RESTAURANTE INDICADO
        
        try {
            String jpql = "SELECT m FROM Mesa m WHERE NOT EXISTS " +
             "(SELECT r FROM Reservacion r WHERE r.mesa = m AND r.estado LIKE 'PENDIENTE')";

            List<Mesa> mesasDisponibles = entityManager.createQuery(jpql, Mesa.class).getResultList();
            
            return mesasDisponibles;
        } catch (Exception e) {
            throw new DAOException("Error al obtener mesas por tipo");
        } finally {
            entityManager.close();
        }
    }
}
