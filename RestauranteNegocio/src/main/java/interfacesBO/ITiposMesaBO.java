
package interfacesBO;

import dto.TipoMesaDTO;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import java.util.List;

/**
 * Define las operaciones necesarias para interactuar con los tipos de mesa en el sistema
 * @author neri
 */
public interface ITiposMesaBO {

    /**
     * Devuelve todos los tipos de mesa en el sistema
     *
     * @return Lista de `TipoMesaDTO`
     * @throws ServicioException Si ocurre un error en la consulta
     */
    public List<TipoMesaDTO> obtenerTiposMesaTodos() throws ServicioException;

    /**
     * Agrega un tipo de mesa en el sistema
     *
     * @param tipoMesa Tipo de mesa a registrar
     * @throws ServicioException Si ocurre un error en la agregación
     */
    public void agregarTipoMesa(TipoMesaDTO tipoMesa) throws ServicioException;

    /**
     * Elimina un tipo de mesa en el sistema
     *
     * @param id ID del tipo de mesa a eliminar
     * @throws ServicioException Si ocurre un error en la eliminación del tipo
     * @throws NoEncontradoException Cuando no se encuentra el tipo de mesa
     */
    public void eliminarTipoMesa(Long id) throws ServicioException, NoEncontradoException;

}
