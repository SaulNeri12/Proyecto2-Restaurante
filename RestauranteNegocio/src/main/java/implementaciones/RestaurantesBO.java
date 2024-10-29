/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package implementaciones;

import dao.implementaciones.RestaurantesDAO;
import dao.interfaces.IRestaurantesDAO;
import dto.RestauranteDTO;
import dto.convertidores.RestauranteConvertidor;
import excepciones.DAOException;
import excepciones.ServicioException;
import entidades.Restaurante;
import interfacesBO.IRestaurantesBO;
import java.util.List;

/**
 * Implementa los metodos de la interfaz IRestaurantesBO para completar su funcionalidad
 * @author Saul Neri
 * @author caarl
 */
public class RestaurantesBO implements IRestaurantesBO {
    
   private final IRestaurantesDAO restaurantesDAO;
    private final RestauranteConvertidor restauranteConvertidor;
    
    // Instancia única de la clase
    private static RestaurantesBO instance;
    
    
    private RestaurantesBO() {
      this.restaurantesDAO = RestaurantesDAO.getInstance();
        this.restauranteConvertidor = new RestauranteConvertidor();   
    }

   public static synchronized RestaurantesBO getInstance() {
        if (instance == null) {
            instance = new RestaurantesBO();
        }
        return instance;
    }

 @Override
    public List<RestauranteDTO> obtenerRestaurantesTodos() throws ServicioException {
        try {
            List<Restaurante> restaurantes = restaurantesDAO.obtenerRestaurantesTodos();
            return restauranteConvertidor.createFromEntities(restaurantes); // Método para convertir a DTO
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }


    @Override
    public RestauranteDTO obtenerRestaurantePorID(Long id) throws ServicioException {
        try {
            Restaurante restaurante = restaurantesDAO.obtenerRestaurantePorID(id);
            return restauranteConvertidor.convertFromEntity(restaurante); // Método para convertir a DTO
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public RestauranteDTO obtenerRestaurantePorNumeroTelefono(String numeroTelefono) throws ServicioException {
        try {
            Restaurante restaurante = restaurantesDAO.obtenerRestaurantePorNumeroTelefono(numeroTelefono);
            return restauranteConvertidor.convertFromEntity(restaurante); // Método para convertir a DTO
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
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
