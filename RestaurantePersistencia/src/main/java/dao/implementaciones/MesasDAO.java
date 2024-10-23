/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.implementaciones;

import conexion.Conexion;
import dao.interfaces.IMesasDAO;
import entidades.Mesa;
import entidades.TipoMesa;
import excepciones.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Clase concreta que implementa los metodos definidos por IMesasDAO
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
         
        try {
            entityManager.getTransaction().begin();
            
            Mesa mesa = entityManager.find(Mesa.class, codigo);
            if (mesa != null) {
                entityManager.remove(mesa);
            }
            
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DAOException("Error al eliminar la mesa");
        } finally {
            entityManager.close();
        }
    }
}
