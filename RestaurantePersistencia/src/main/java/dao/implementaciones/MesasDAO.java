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
    public List<Mesa> obtenerMesasTodas() throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

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
    public List<Mesa> obtenerMesasPorTipo(TipoMesa tipo) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

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
    public void eliminarMesa(String codigo) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            TypedQuery<Mesa> consulta = entityManager.createQuery("SELECT m FROM Mesa m WHERE m.codigo = :codigo", Mesa.class);
            consulta.setParameter("codigo", codigo);
            Mesa mesa = consulta.getSingleResult();

            if (mesa != null) {
                transaction.begin();

                System.out.println("ELIMINACION DE: " + mesa);
                entityManager.remove(mesa);

                transaction.commit();
            }

        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR EN MESA: " + e.getMessage());
            throw new DAOException("Error al eliminar la mesa");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void insertarMesas(TipoMesa tipo, UbicacionMesa ubicacion, int cantidad) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        UbicacionMesa ubicacionReal = UbicacionMesa.valueOf(ubicacion.toString());

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
    public List<TipoMesa> obtenerTiposMesaTodos() throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        try {
            TypedQuery<TipoMesa> query = entityManager.createQuery("SELECT t FROM TipoMesa t", TipoMesa.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los tipos de mesas");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void agregarTipoMesa(TipoMesa tipoMesa) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(tipoMesa);
            transaction.commit();
        } catch (Exception e) {
            //transaction.rollback();
            System.out.println(e.getMessage());
            throw new DAOException("Error al agregar el tipo de mesa");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarTipoMesa(Long id) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        try {
            entityManager.getTransaction().begin();

            TipoMesa tipoMesa = entityManager.find(TipoMesa.class, id);
            if (tipoMesa != null) {
                entityManager.remove(tipoMesa);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DAOException("Error al eliminar el tipo de mesa");
        } finally {
            entityManager.close();
        }
    }
}
