/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dao.interfaces.IMesasDAO;
import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import dto.convertidores.MesaConvertidor;
import dto.convertidores.TipoMesaConvertidor;
import entidades.Mesa;
import entidades.TipoMesa;
import entidades.UbicacionMesa;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.IMesasBO;

import java.util.List;

/**
 * Implementación de la interfaz IMesasBO para manejar la lógica de negocio
 * relacionada con las mesas.
 * 
 * @author Saul Neri
 */
public class MesasBO implements IMesasBO {

    private final IMesasDAO mesasDAO;
    private final MesaConvertidor mesaConvertidor;
    private final TipoMesaConvertidor tipoMesaConvertidor;

    public MesasBO(IMesasDAO mesasDAO) {
        this.mesasDAO = mesasDAO;
        this.mesaConvertidor = new MesaConvertidor();
        this.tipoMesaConvertidor = new TipoMesaConvertidor();
    }

    @Override
    public List<MesaDTO> obtenerMesasTodas() throws ServicioException {
        try {
            List<Mesa> mesas = mesasDAO.obtenerMesasTodas();
            return mesaConvertidor.createFromEntities(mesas);
        } catch (Exception e) {
            throw new ServicioException("Error al obtener todas las mesas");
        }
    }

    @Override
    public List<MesaDTO> obtenerMesasPorTipo(TipoMesaDTO tipo) throws ServicioException {
        try {
            TipoMesa tipoMesa = tipoMesaConvertidor.convertFromDto(tipo);
            List<Mesa> mesas = mesasDAO.obtenerMesasPorTipo(tipoMesa);
            return mesaConvertidor.createFromEntities(mesas);
        } catch (Exception e) {
            throw new ServicioException("Error al obtener mesas por tipo");
        }
    }

    @Override
    public void insertarMesas(TipoMesaDTO tipo, UbicacionMesaDTO ubicacion, int cantidad) throws ServicioException {
        try {
            TipoMesa tipoMesa = tipoMesaConvertidor.convertFromDto(tipo);
            UbicacionMesa ubicacionMesa = UbicacionMesa.valueOf(ubicacion.toString());
            mesasDAO.insertarMesas(tipoMesa, ubicacionMesa, cantidad);
        } catch (Exception e) {
            throw new ServicioException("Error al insertar mesas");
        }
    }

    @Override
    public void eliminarMesa(String codigo) throws ServicioException, NoEncontradoException {
        try {
            mesasDAO.eliminarMesa(codigo);
        }catch (Exception e) {
            throw new ServicioException("Error al eliminar la mesa");
        }
       
        
    }
}
