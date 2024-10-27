/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dao.interfaces.IMesasDAO;
import dao.implementaciones.MesasDAO;
import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import dto.convertidores.MesaConvertidor;
import dto.convertidores.TipoMesaConvertidor;
import entidades.Mesa;
import entidades.TipoMesa;
import entidades.UbicacionMesa;
import excepciones.DAOException;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.IMesasBO;
import java.util.List;

/**
 * Implementación de la interfaz IMesasBO para manejar la lógica de negocio
 * relacionada con las mesas. Implementa el patrón Singleton.
 *
 * @author caarl
 */
public class MesasBO implements IMesasBO {

    private final IMesasDAO mesasDAO;
    private final MesaConvertidor mesaConvertidor;
    private final TipoMesaConvertidor tipoMesaConvertidor;

    // Instancia única de la clase
    private static MesasBO instance;

    /**
     * Constructor privado para implementar Singleton.
     */
    private MesasBO() {
        this.mesasDAO = MesasDAO.getInstance();
        this.mesaConvertidor = new MesaConvertidor();
        this.tipoMesaConvertidor = new TipoMesaConvertidor();
    }

    /**
     * Método para obtener la instancia única de MesasBO.
     *
     * @return instancia única de MesasBO
     */
    public static synchronized MesasBO getInstance() {
        if (instance == null) {
            instance = new MesasBO();
        }
        return instance;
    }

    @Override
    public List<MesaDTO> obtenerMesasTodas() throws ServicioException {
        try {
            List<Mesa> mesas = mesasDAO.obtenerMesasTodas();
            return mesaConvertidor.createFromEntities(mesas);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<MesaDTO> obtenerMesasPorTipo(TipoMesaDTO tipo) throws ServicioException {
        try {
            TipoMesa tipoMesa = tipoMesaConvertidor.convertFromDto(tipo);
            List<Mesa> mesas = mesasDAO.obtenerMesasPorTipo(tipoMesa);
            return mesaConvertidor.createFromEntities(mesas);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void insertarMesas(TipoMesaDTO tipo, UbicacionMesaDTO ubicacion, int cantidad) throws ServicioException {
        try {
            TipoMesa tipoMesa = tipoMesaConvertidor.convertFromDto(tipo);
            UbicacionMesa ubicacionMesa = UbicacionMesa.valueOf(ubicacion.toString());
            mesasDAO.insertarMesas(tipoMesa, ubicacionMesa, cantidad);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void eliminarMesa(String codigo) throws ServicioException, NoEncontradoException {
        try {
            mesasDAO.eliminarMesa(codigo);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<MesaDTO> obtenerMesasDisponibles() throws ServicioException {
        try {
            return this.mesaConvertidor.createFromEntities(mesasDAO.obtenerMesasDisponibles());
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }
}
