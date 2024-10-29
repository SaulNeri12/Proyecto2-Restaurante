/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao.implementaciones;

import dao.interfaces.IRestaurantesDAO;
import entidades.Restaurante;
import excepciones.DAOException;
import java.util.List;

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
        // TODO: IMPLEMENTAR ESTE
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Restaurante obtenerRestaurantePorID(Long id) throws DAOException {
        // TODO: IMPLEMENTAR ESTE
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Restaurante obtenerRestaurantePorNumeroTelefono(String numeroTelefono) throws DAOException {
        // TODO: IMPLEMENTAR ESTE
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
