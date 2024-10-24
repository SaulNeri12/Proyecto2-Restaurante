
package dao.interfaces;

import entidades.Cliente;
import excepciones.DAOException;
import java.util.List;

/**
 * Define las operaciones necesarias para manejar clientes en el sistema
 * @author neri
 */
public interface IClientesDAO {
    /**
     * Inserta la lista de clientes dada
     * @param clientes clientes a registrar
     * @throws DAOException Si ocurre un error en la insercion
     */
    public void insercionMasivaClientes(List<Cliente> clientes) throws DAOException;

    /**
     * Regresa una lista con todos los clientes en el sistema.
     * @return Lista de clientes
     * @throws DAOException Si ocurre un error en la consulta
     */
    public List<Cliente> obtenerClientesTodos() throws DAOException;
    
    /**
     * Obtiene el cliente por su numero de telefono registrado en el sistema
     * @param numeroTelefono Numero de telefono del cliente
     * @return Objeto Cliente
     * @throws DAOException Si ocurre un error en la consulta
     */
    public Cliente obtenerClientePorTelefono(String numeroTelefono) throws DAOException;
}
