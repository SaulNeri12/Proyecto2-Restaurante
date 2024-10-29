/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao.implementaciones;

import conexion.Conexion;
import dao.interfaces.IRestaurantesDAO;
import entidades.Restaurante;
import excepciones.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Implementa los metodos definidos por IRestaurantesDAO
 * @author Saul Neri
 */
public class RestaurantesDAO implements IRestaurantesDAO {

    private static IRestaurantesDAO instancia;

    private RestaurantesDAO() {
    }

    public static IRestaurantesDAO getInstance() {
        if (instancia == null) {
            instancia = new RestaurantesDAO();
        }
        return instancia;
    }
    
    @Override
    public List<Restaurante> obtenerRestaurantesTodos() throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        try {
            TypedQuery<Restaurante> query = entityManager.createQuery("SELECT r FROM Restaurante r", Restaurante.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los restaurantes");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Restaurante obtenerRestaurantePorID(Long id) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        try {
            return entityManager.find(Restaurante.class, id);
        } catch (Exception e) {
            throw new DAOException("Error al obtener el restaurante por ID");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Restaurante obtenerRestaurantePorNumeroTelefono(String numeroTelefono) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        try {
            TypedQuery<Restaurante> query = entityManager.createQuery(
                "SELECT r FROM Restaurante r WHERE r.telefono = :telefono", Restaurante.class);
            query.setParameter("telefono", numeroTelefono);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DAOException("Error al obtener el restaurante por número de teléfono");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void agregarRestaurante(Restaurante restaurante) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarRestaurante(Restaurante restaurante) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarRestaurante(Long idRestaurante) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
