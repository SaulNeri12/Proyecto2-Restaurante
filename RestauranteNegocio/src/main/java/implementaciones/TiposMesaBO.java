/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package implementaciones;


import dao.interfaces.ITiposMesaDAO;
import dto.TipoMesaDTO;
import dto.convertidores.TipoMesaConvertidor;
import entidades.TipoMesa;
import excepciones.DAOException;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.ITiposMesaBO;

import java.util.List;

/**
 * Implementación de la interfaz ITiposMesaBO para manejar la lógica de negocio
 * relacionada con los tipos de mesa.
 * @author caarl
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
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void agregarTipoMesa(TipoMesaDTO tipoMesaDTO) throws ServicioException {
        try {
            TipoMesa tipoMesa = tipoMesaConvertidor.convertFromDto(tipoMesaDTO);
            tiposMesaDAO.agregarTipoMesa(tipoMesa);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void eliminarTipoMesa(Long id) throws ServicioException, NoEncontradoException {
        try {
            tiposMesaDAO.eliminarTipoMesa(id);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }
}
