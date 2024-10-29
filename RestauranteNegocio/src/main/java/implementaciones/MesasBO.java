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
import excepciones.ServicioException;
import interfacesBO.IMesasBO;

import java.util.List;

/**
 * Implementación de la interfaz IMesasBO para manejar la lógica de negocio
 * relacionada con las mesas. Implementa el patrón Singleton para asegurar
 * que solo exista una instancia de esta clase.
 * 
 */
public class MesasBO implements IMesasBO {

    // DAO para acceder a los datos de las mesas
    private final IMesasDAO mesasDAO;
    
    // Convertidor para transformar entidades de Mesa a DTOs y viceversa
    private final MesaConvertidor mesaConvertidor;
    
    // Convertidor para transformar entidades de TipoMesa a DTOs y viceversa
    private final TipoMesaConvertidor tipoMesaConvertidor;

    // Instancia única de la clase
    private static MesasBO instance;

    /**
     * Constructor privado para implementar el patrón Singleton.
     * Inicializa los DAOs y los convertidores necesarios.
     */
    private MesasBO() {
        this.mesasDAO = MesasDAO.getInstance(); // Obtiene la instancia del DAO
        this.mesaConvertidor = new MesaConvertidor(); // Crea un nuevo convertidor de Mesa
        this.tipoMesaConvertidor = new TipoMesaConvertidor(); // Crea un nuevo convertidor de TipoMesa
    }

    /**
     * Método para obtener la instancia única de MesasBO.
     * Se utiliza sincronización para asegurar que no se creen instancias
     * simultáneamente en un entorno multihilo.
     * 
     * @return instancia única de MesasBO
     */
    public static synchronized MesasBO getInstance() {
        if (instance == null) {
            instance = new MesasBO(); // Crea una nueva instancia si no existe
        }
        return instance; // Retorna la instancia existente
    }

    @Override
    public List<MesaDTO> obtenerMesasTodas(Long idRestaurante) throws ServicioException {
        try {
            // Obtiene la lista de todas las mesas a través del DAO
            List<Mesa> mesas = mesasDAO.obtenerMesasTodas(idRestaurante);
            // Convierte la lista de entidades a DTOs antes de devolverla
            return mesaConvertidor.createFromEntities(mesas);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<MesaDTO> obtenerMesasDisponibles(Long idRestaurante) throws ServicioException {
        try {
            // Obtiene la lista de mesas disponibles a través del DAO
            return mesaConvertidor.createFromEntities(mesasDAO.obtenerMesasDisponibles(idRestaurante));
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<MesaDTO> obtenerMesasPorTipo(Long idRestaurante, TipoMesaDTO tipo) throws ServicioException {
        try {
            // Convierte el DTO de TipoMesa a entidad
            TipoMesa tipoMesa = tipoMesaConvertidor.convertFromDto(tipo);
            // Obtiene las mesas de un tipo específico a través del DAO
            List<Mesa> mesas = mesasDAO.obtenerMesasPorTipo(idRestaurante, tipoMesa);
            // Convierte la lista de entidades a DTOs antes de devolverla
            return mesaConvertidor.createFromEntities(mesas);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void insertarMesas(Long idRestaurante, TipoMesaDTO tipo, UbicacionMesaDTO ubicacion, int cantidad) throws ServicioException {
        try {
            // Convierte el DTO de TipoMesa a entidad
            TipoMesa tipoMesa = tipoMesaConvertidor.convertFromDto(tipo);
            // Convierte el DTO de UbicacionMesa a entidad
            UbicacionMesa ubicacionMesa = UbicacionMesa.valueOf(ubicacion.toString());
            // Inserta las mesas a través del DAO
            mesasDAO.insertarMesas(idRestaurante, tipoMesa, ubicacionMesa, cantidad);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void eliminarMesa(Long idRestaurante, String codigo) throws ServicioException {
        try {
            // Elimina una mesa específica a través del DAO
            mesasDAO.eliminarMesa(idRestaurante, codigo);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }
}
