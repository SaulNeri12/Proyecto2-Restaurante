/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dto.ClienteDTO;
import dto.convertidores.ClienteConvertidor;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.IClientesBO;
import dao.interfaces.IClientesDAO;
import dao.implementaciones.ClientesDAO;
import entidades.Cliente;
import excepciones.DAOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Clase de negocio que implementa la interfaz IClientesBO para la gestión de
 * clientes en el sistema.
 * @author caarl
 */
public class ClientesBO implements IClientesBO {

    private final IClientesDAO clientesDAO;
    private final ClienteConvertidor clienteConvertidor;

    // Instancia única de la clase
    private static ClientesBO instance;

    /**
     * Constructor privado para implementar Singleton.
     */
    private ClientesBO() {
        this.clientesDAO = ClientesDAO.getInstance();
        this.clienteConvertidor = new ClienteConvertidor();
    }

    /**
     * Método para obtener la instancia única de ClientesBO.
     *
     * @return instancia única de ClientesBO
     */
    public static synchronized ClientesBO getInstance() {
        if (instance == null) {
            instance = new ClientesBO();
        }
        return instance;
    }

    @Override
    public void insercionMasivaClientes(List<ClienteDTO> clientes) throws ServicioException {
        try {
            List<Cliente> entidadesClientes = clientes.stream()
                    .map(clienteConvertidor::convertFromDto)
                    .collect(Collectors.toList());
            clientesDAO.insercionMasivaClientes(entidadesClientes);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> obtenerClientesTodos() throws ServicioException {
        try {
            List<Cliente> entidadesClientes = clientesDAO.obtenerClientesTodos();
            return entidadesClientes.stream()
                    .map(clienteConvertidor::convertFromEntity)
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public ClienteDTO obtenerClientePorTelefono(String numeroTelefono) throws ServicioException, NoEncontradoException {
        try {
            Cliente entidadCliente = clientesDAO.obtenerClientePorTelefono(numeroTelefono);
            if (entidadCliente == null) {
                throw new NoEncontradoException("No se encontro al cliente con el telefono dado");
            }
            return clienteConvertidor.convertFromEntity(entidadCliente);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

}
