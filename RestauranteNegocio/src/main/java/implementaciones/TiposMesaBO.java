/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package implementaciones;

/**
 *
 * @author caarl
 */
import dao.interfaces.ITiposMesaDAO;
import dto.TipoMesaDTO;
import dto.convertidores.TipoMesaConvertidor;
import entidades.TipoMesa;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.ITiposMesaBO;

import java.util.List;

/**
 * Implementación de la interfaz ITiposMesaBO para manejar la lógica de negocio
 * relacionada con los tipos de mesa.
 * 
 */
public class TiposMesaBO implements ITiposMesaBO {

    private final ITiposMesaDAO tiposMesaDAO;
    private final TipoMesaConvertidor tipoMesaConvertidor;

    public TiposMesaBO(ITiposMesaDAO tiposMesaDAO) {
        this.tiposMesaDAO = tiposMesaDAO;
        this.tipoMesaConvertidor = new TipoMesaConvertidor();
    }

    @Override
    public List<TipoMesaDTO> obtenerTiposMesaTodos() throws ServicioException {
        try {
            List<TipoMesa> tiposMesa = tiposMesaDAO.obtenerTiposMesaTodos();
            return tipoMesaConvertidor.createFromEntities(tiposMesa);
        } catch (Exception e) {
            throw new ServicioException("Error al obtener todos los tipos de mesa");
        }
    }

    @Override
    public void agregarTipoMesa(TipoMesaDTO tipoMesaDTO) throws ServicioException {
        try {
            TipoMesa tipoMesa = tipoMesaConvertidor.convertFromDto(tipoMesaDTO);
            tiposMesaDAO.agregarTipoMesa(tipoMesa);
        } catch (Exception e) {
            throw new ServicioException("Error al agregar el tipo de mesa");
        }
    }

    @Override
    public void eliminarTipoMesa(Long id) throws ServicioException, NoEncontradoException {
        try {
            tiposMesaDAO.eliminarTipoMesa(id);
        }catch (Exception e) {
            throw new ServicioException("Error al eliminar el tipo de mesa con ID: " );
        }
       
        
    }
}