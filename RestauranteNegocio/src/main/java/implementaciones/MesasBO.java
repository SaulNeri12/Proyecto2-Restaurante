/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;



import dao.interfaces.IMesasDAO;
import dao.implementaciones.MesasDAO;
import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.convertidores.MesaConvertidor;
import dto.convertidores.TipoMesaConvertidor;
import entidades.Mesa;
import entidades.TipoMesa;
import entidades.UbicacionMesa;
import excepciones.BOException;
import excepciones.DAOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase de negocio para manejar las operaciones con Mesas
 * Implementa el patrón Singleton
 * @author Saul Neri
 */
public class MesasBO {

    private static MesasBO instancia;
    private IMesasDAO mesasDAO;
    private MesaConvertidor mesaConvertidor;
    private TipoMesaConvertidor tipoMesaConvertidor;

    private MesasBO() {
        mesasDAO = MesasDAO.getInstance(); // Usamos el Singleton del DAO
        mesaConvertidor = new MesaConvertidor();
        tipoMesaConvertidor = new TipoMesaConvertidor();
    }

    public static MesasBO getInstance() {
        if (instancia == null) {
            instancia = new MesasBO();
        }
        return instancia;
    }
    

    /**
     * Obtiene todas las mesas en formato DTO
     * @return Lista de MesaDTO
     * @throws BOException 
     */
  public List<MesaDTO> obtenerMesasTodas() throws BOException {
    try {
        List<Mesa> mesas = mesasDAO.obtenerMesasTodas();
        return mesas.stream()
                    .map(MesaConvertidor::convertirADTO) // Usar directamente la clase en lugar de la instancia
                    .collect(Collectors.toList());
    } catch (DAOException e) {
        throw new BOException("Error al obtener todas las mesas", e);
    }
}
  
      /**
     * Obtiene todos los tipos de mesa en formato DTO
     * @return Lista de TipoMesaDTO
     * @throws BOException 
     */

public List<TipoMesaDTO> obtenerTiposMesaTodos() throws BOException {
    try {
        List<TipoMesa> tiposMesa = mesasDAO.obtenerTiposMesaTodos();
        return tiposMesa.stream()
                        .map(TipoMesaConvertidor::convertirADTO) // Usar directamente la clase en lugar de la instancia
                        .collect(Collectors.toList());
    } catch (DAOException e) {
        throw new BOException("Error al obtener todos los tipos de mesa", e);
    }
}

    

    /**
     * Obtiene mesas por tipo en formato DTO
     * @param tipoMesaDTO Tipo de mesa a buscar
     * @return Lista de MesaDTO
     * @throws BOException 
     */
    public List<MesaDTO> obtenerMesasPorTipo(TipoMesaDTO tipoMesaDTO) throws BOException {
    try {
        // Convertir TipoMesaDTO a TipoMesa usando la clase directamente
        TipoMesa tipoMesa = TipoMesaConvertidor.convertirAEntidad(tipoMesaDTO);
        
        // Obtener la lista de mesas por tipo
        List<Mesa> mesas = mesasDAO.obtenerMesasPorTipo(tipoMesa);
        
        // Convertir la lista de mesas a DTOs
        return mesas.stream()
                    .map(MesaConvertidor::convertirADTO) // Usar directamente la clase en lugar de la instancia
                    .collect(Collectors.toList());
    } catch (DAOException e) {
        throw new BOException("Error al obtener mesas por tipo", e);
    }
}


    /**
     * Elimina una mesa por su código
     * @param codigo Código de la mesa a eliminar
     * @throws BOException 
     */
    public void eliminarMesa(String codigo) throws BOException {
        try {
            mesasDAO.eliminarMesa(codigo);
        } catch (DAOException e) {
            throw new BOException("Error al eliminar la mesa con código: " + codigo, e);
        }
    }

    /**
     * Inserta varias mesas de un tipo y ubicación específica
     * @param tipoMesaDTO Tipo de mesa
     * @param ubicacion Ubicación de las mesas
     * @param cantidad Cantidad de mesas a insertar
     * @throws BOException 
     */
    public void insertarMesas(TipoMesaDTO tipoMesaDTO, String ubicacion, int cantidad) throws BOException {
        try {
            TipoMesa tipoMesa = tipoMesaConvertidor.convertirAEntidad(tipoMesaDTO);
            mesasDAO.insertarMesas(tipoMesa, UbicacionMesa.valueOf(ubicacion), cantidad);
        } catch (DAOException e) {
            throw new BOException("Error al insertar mesas", e);
        }
    }


    

    /**
     * Agrega un nuevo tipo de mesa
     * @param tipoMesaDTO Tipo de mesa a agregar
     * @throws BOException 
     */
    public void agregarTipoMesa(TipoMesaDTO tipoMesaDTO) throws BOException {
        try {
            TipoMesa tipoMesa = tipoMesaConvertidor.convertirAEntidad(tipoMesaDTO);
            mesasDAO.agregarTipoMesa(tipoMesa);
        } catch (DAOException e) {
            throw new BOException("Error al agregar el tipo de mesa", e);
        }
    }

    /**
     * Elimina un tipo de mesa por su ID
     * @param id ID del tipo de mesa a eliminar
     * @throws BOException 
     */
    public void eliminarTipoMesa(Long id) throws BOException {
        try {
            mesasDAO.eliminarTipoMesa(id);
        } catch (DAOException e) {
            throw new BOException("Error al eliminar el tipo de mesa", e);
        }
    }
}
