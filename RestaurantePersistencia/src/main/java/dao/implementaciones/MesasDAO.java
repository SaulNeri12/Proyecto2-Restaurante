/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implementaciones;

import conexion.Conexion;
import dao.interfaces.IMesasDAO;
import entidades.Mesa;
import entidades.Restaurante;
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
 * Clase concreta que implementa los métodos definidos por IMesasDAO
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

        try {
            TypedQuery<Mesa> query = entityManager.createQuery("SELECT m FROM Mesa m WHERE m.restaurante.id = :idRestaurante", Mesa.class);
            query.setParameter("idRestaurante", idRestaurante);
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

        try {
            TypedQuery<Mesa> query = entityManager.createQuery("SELECT m FROM Mesa m WHERE m.tipoMesa = :tipo AND m.restaurante.id = :idRestaurante", Mesa.class);
            query.setParameter("tipo", tipo);
            query.setParameter("idRestaurante", idRestaurante);
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

        try {
            TypedQuery<Mesa> consulta = entityManager.createQuery("SELECT m FROM Mesa m WHERE m.codigo = :codigo AND m.restaurante.id = :idRestaurante", Mesa.class);
            consulta.setParameter("codigo", codigo);
            consulta.setParameter("idRestaurante", idRestaurante);
            Mesa mesa = consulta.getSingleResult();

            if (mesa == null) {
                throw new DAOException("No se encontró la mesa con el código dado");
            }

            transaction.begin();
            entityManager.remove(mesa);
            transaction.commit();

        } catch (NoResultException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DAOException("No se encontró la mesa a eliminar");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DAOException("No se pudo eliminar la mesa debido a un error, por favor intente más tarde");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void insertarMesas(Long idRestaurante, TipoMesa tipo, UbicacionMesa ubicacion, int cantidad) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        UbicacionMesa ubicacionReal = UbicacionMesa.valueOf(ubicacion.toString());

        if (ubicacionReal == null) {
            throw new DAOException("La ubicación de las mesas dada es incorrecta, ingrese una ubicación de mesa válida");
        }

        if (cantidad < 1) {
            throw new DAOException("La cantidad de mesas a crear debe ser de al menos 1, ingrese una cantidad correcta");
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
                
                // Obtener el restaurante por ID
                Restaurante restaurante = entityManager.find(Restaurante.class, idRestaurante);
                if (restaurante == null) {
                    throw new DAOException("El restaurante especificado no existe.");
                }
                m.setRestaurante(restaurante);

                entityManager.persist(m);
                cantidadRestante--;
            }

            entityManager.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DAOException("Error al insertar las mesas: " + e.getMessage());

        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Mesa> obtenerMesasDisponibles(Long idRestaurante) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        try {
            String jpql = "SELECT m FROM Mesa m WHERE m.restaurante.id = :idRestaurante AND NOT EXISTS " +
                "(SELECT r FROM Reservacion r WHERE r.mesa = m AND r.estado LIKE 'PENDIENTE')";
            TypedQuery<Mesa> query = entityManager.createQuery(jpql, Mesa.class);
            query.setParameter("idRestaurante", idRestaurante);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener mesas disponibles");
        } finally {
            entityManager.close();
        }
    }
}
