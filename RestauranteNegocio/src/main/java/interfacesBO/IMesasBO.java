/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesBO;

import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import excepciones.NoEncontradoException;
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
     * Devuelve todas las mesas registradas en el sistema
     *
     * @return Lista de `MesaDTO`
     * @throws ServicioException Si ocurre un error en la consulta
     */
    public List<MesaDTO> obtenerMesasTodas() throws ServicioException;

    /**
     * Devuelve todas las mesas del tipo especificado
     *
     * @param tipo Tipo de mesa
     * @return Lista de `MesaDTO`
     * @throws ServicioException Si ocurre un error en la consulta
     */
    public List<MesaDTO> obtenerMesasPorTipo(TipoMesaDTO tipo) throws ServicioException;

    /**
     * Inserta de manera "masiva" el número dado de mesas con el tipo y
     * ubicación específica.
     *
     * @param tipo Tipo de mesas a insertar
     * @param ubicacion Ubicación de las mesas a insertar
     * @param cantidad Cantidad de las mesas a insertar
     * @throws ServicioException Si ocurre un error en la inserción
     */
    public void insertarMesas(TipoMesaDTO tipo, UbicacionMesaDTO ubicacion, int cantidad) throws ServicioException;

    /**
     * Elimina una mesa en el sistema por su código especificado
     *
     * @param codigo Código de la mesa a eliminar
     * @throws ServicioException Si ocurre un error en la eliminación
     * @throws NoEncontradoException Si no se encuentra la mesa
     */
    public void eliminarMesa(String codigo) throws ServicioException, NoEncontradoException;

}
