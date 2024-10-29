/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesBO;

import dto.RestauranteDTO;
import excepciones.ServicioException;
import java.util.List;

/**
 * Define las operaciones necesarias para administrar sucursales de restaurantes en el sistema
 * @author neri
 * @author caarl
 */
public interface IRestaurantesBO {
    /**
     * Obtiene todos las sucursales del restaurante en el sistema
     * @return Lista sucursales restaurante
     * @throws ServicioException Si ocurre un error en la consulta
     */
    public List<RestauranteDTO> obtenerRestaurantesTodos() throws ServicioException;
    
    /**
     * Obtiene la sucursal del restaurante con el ID dado
     * @param id ID de la sucursal del restaurante
     * @return Restaurante sucursal
     * @throws ServicioException Si ocurre un error en la consulta
     */
    public RestauranteDTO obtenerRestaurantePorID(Long id) throws ServicioException;
    
    /**
     * Obtiene la sucursal del restaurante con el numero telefonico dado
     * @param numeroTelefono Numero de telefono de la sucursal
     * @return Restaurante sucursal
     * @throws ServicioException Si ocurre un error en la consulta 
     */
    public RestauranteDTO obtenerRestaurantePorNumeroTelefono(String numeroTelefono) throws ServicioException;
    
    /**
     * Agrega una nueva sucursal del restaurante al sistema
     * @param restaurante Nueva sucursal del restaurante
     * @throws ServicioException Si ocurre un error en la insercion
     */
    public void agregarRestaurante(RestauranteDTO restaurante) throws ServicioException;
    
    /**
     * Actualiza la informacion de la sucursal del restaurante dado
     * @param restaurante Sucursal del restaurante
     * @throws ServicioException Si ocurre un error en la modificacion
     */
    public void actualizarRestaurante(RestauranteDTO restaurante) throws ServicioException;
    
    /**
     * Elimina una sucursal en el sistema
     * @param idRestaurante ID de la sucursal a eliminar
     * @throws ServicioException Si ocurre un error en la eliminacion
     */
    public void eliminarRestaurante(Long idRestaurante) throws ServicioException;
}
