
package dto.convertidores;

import dto.ClienteDTO;
import entidades.Cliente;

/**
 * Hace de convertidor para objetos Cliente en el sistema
 * @author Saul Neri
 */
public class ClienteConvertidor extends Converter<ClienteDTO, Cliente> {

    public ClienteConvertidor() {
        super(ClienteConvertidor::convertirAEntidad, ClienteConvertidor::convertirADTO);
    }
    
    public static Cliente convertirAEntidad(ClienteDTO clienteDTO) {
        Cliente c = new Cliente();
        c.setId(clienteDTO.getId());
        c.setNombreCompleto(clienteDTO.getNombreCompleto());
        c.setTelefono(clienteDTO.getTelefono());
        return c;
    }
    
    public static ClienteDTO convertirADTO(Cliente cliente) {
        ClienteDTO c = new ClienteDTO();
        c.setId(cliente.getId());
        c.setNombreCompleto(cliente.getNombreCompleto());
        c.setTelefono(cliente.getTelefono());
        return c;
    }

}
