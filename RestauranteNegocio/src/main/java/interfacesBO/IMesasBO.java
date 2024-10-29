/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesBO;

import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import excepciones.ServicioException;
import java.util.List;

/**
 * Define las operaciones necesarias para interactuar con las mesas en el
 * sistema
 *
 * @author neri
 */
public interface IMesasBO {

    /**
     * Devuelve todas las mesas registradas en el sistema.
     *
     * @param idRestaurante ID del restaurante
     * @return lista de mesas registradas
     * @throws ServicioException si ocurre un error en la consulta
     */
    public List<MesaDTO> obtenerMesasTodas(Long idRestaurante) throws ServicioException;

    /**
     * Devuelve una lista con las mesas disponibles para su reservación.
     *
     * @param idRestaurante ID del restaurante
     * @return mesas disponibles
     * @throws ServicioException si ocurre un error en la consulta
     */
    public List<MesaDTO> obtenerMesasDisponibles(Long idRestaurante) throws ServicioException;

    /**
     * Devuelve todas las mesas del tipo especificado.
     *
     * @param idRestaurante ID del restaurante en cuestión
     * @param tipo tipo de mesa
     * @return lista de mesas del tipo especificado
     * @throws ServicioException si ocurre un error en la consulta
     */
    public List<MesaDTO> obtenerMesasPorTipo(Long idRestaurante, TipoMesaDTO tipo) throws ServicioException;

    /**
     * Inserta de manera "masiva" el número dado de mesas con el tipo y
     * ubicación especificados.
     *
     * @param idRestaurante ID del restaurante donde se agregarán las mesas
     * @param tipo tipo de mesas a insertar
     * @param ubicacion ubicación de las mesas a insertar
     * @param cantidad cantidad de mesas a insertar
     * @throws ServicioException si ocurre un error al insertar las mesas
     */
    public void insertarMesas(Long idRestaurante, TipoMesaDTO tipo, UbicacionMesaDTO ubicacion, int cantidad) throws ServicioException;

    /**
     * Elimina una mesa en el sistema por su código especificado.
     *
     * @param idRestaurante ID del restaurante donde se eliminará la mesa
     * @param codigo código de la mesa a eliminar
     * @throws ServicioException si ocurre un error en la eliminación
     */
    public void eliminarMesa(Long idRestaurante, String codigo) throws ServicioException;

}
