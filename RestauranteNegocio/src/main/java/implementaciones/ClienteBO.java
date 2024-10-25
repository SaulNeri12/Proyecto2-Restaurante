/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dao.implementaciones.ClientesDAO;
import entidades.Cliente;
import excepciones.DAOException;
import excepciones.NoEncontradoException;

/**
 *
 * @author caarl
 */
public class ClienteBO {
    private static ClienteBO instancia;
    private final ClientesDAO clientesDAO;

    private ClienteBO() {
        this.clientesDAO = (ClientesDAO) ClientesDAO.getInstance();
    }

    public static ClienteBO getInstance() {
        if (instancia == null) {
            instancia = new ClienteBO();
        }
        return instancia;
    }

    public void agregarCliente(Cliente cliente) throws NoEncontradoException, DAOException {
        try {
            if (cliente.getNombreCompleto() == null || cliente.getNombreCompleto().trim().isEmpty()) {
                throw new NoEncontradoException("El nombre del cliente es requerido");
            }
            if (cliente.getTelefono() == null || !cliente.getTelefono().matches("\\d{10}")) {
                throw new NoEncontradoException("El teléfono debe tener 10 dígitos");
            }
            clientesDAO.obtenerClientesTodos();
        } catch (NoEncontradoException e) {
            throw new NoEncontradoException("Error al agregar el cliente: " + e.getMessage());
        }
    }

    public Cliente consultarCliente(String telefono) throws NoEncontradoException {
        try {
            return clientesDAO.obtenerClientePorTelefono(telefono);
        } catch (DAOException e) {
            throw new NoEncontradoException("Error al consultar el cliente: " + e.getMessage());
        }
    }
}