
package interfacesBO;

import dto.ClienteDTO;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import java.util.List;

/**
 * Define las operaciones necesarias para interactuar con la informacion de 
 * clientes en el sistema
 * @author neri
 */
public interface IClientesBO {

    /**
     * Inserta la lista de clientes dada
     *
     * @param clientes clientes a registrar
     * @throws ServicioException Si ocurre un error en la inserción
     */
    public void insercionMasivaClientes(List<ClienteDTO> clientes) throws ServicioException;

    /**
     * Regresa una lista con todos los clientes en el sistema.
     *
     * @return Lista de `ClienteDTO`
     * @throws ServicioException Si ocurre un error en la consulta
     */
    public List<ClienteDTO> obtenerClientesTodos() throws ServicioException;

    /**
     * Obtiene el cliente por su número de teléfono registrado en el sistema
     *
     * @param numeroTelefono Número de teléfono del cliente
     * @return Objeto `ClienteDTO`
     * @throws ServicioException Si ocurre un error en la consulta
     * @throws NoEncontradoException Si no se encuentra el cliente
     */
    public ClienteDTO obtenerClientePorTelefono(String numeroTelefono) throws ServicioException, NoEncontradoException;

}
