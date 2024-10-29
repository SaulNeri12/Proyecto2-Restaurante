/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package implementaciones;

import dao.implementaciones.RestaurantesDAO;
import dao.interfaces.IRestaurantesDAO;
import dto.RestauranteDTO;
import excepciones.ServicioException;
import interfacesBO.IRestaurantesBO;
import java.util.List;

/**
 * Implementa los metodos de la interfaz IRestaurantesBO para completar su funcionalidad
 * @author Saul Neri
 * @author caarl
 */
public class RestaurantesBO implements IRestaurantesBO {
    
    private static IRestaurantesBO instancia;

    private IRestaurantesDAO restaurantesDAO = RestaurantesDAO.getInstance();
    
    private RestaurantesBO() {
        
    }

    public static IRestaurantesBO getInstance() {
        if (instancia == null) {
            instancia = new RestaurantesBO();
        }
        return instancia;
    }

    @Override
    public List<RestauranteDTO> obtenerRestaurantesTodos() throws ServicioException {
        // TODO: IMPLEMENTAR ESTE
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RestauranteDTO obtenerRestaurantePorID(Long id) throws ServicioException {
        // TODO: IMPLEMENTAR ESTE
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RestauranteDTO obtenerRestaurantePorNumeroTelefono(String numeroTelefono) throws ServicioException {
        // TODO: IMPLEMENTAR ESTE
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarRestaurante(RestauranteDTO restaurante) throws ServicioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarRestaurante(RestauranteDTO restaurante) throws ServicioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarRestaurante(Long idRestaurante) throws ServicioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
