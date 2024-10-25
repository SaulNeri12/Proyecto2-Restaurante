
package dto.convertidores;

import dto.ClienteDTO;
import entidades.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author neri
 */
public class ClienteConvertidorTest {
    private Converter<ClienteDTO, Cliente> clienteConvertidor = new ClienteConvertidor();
    
    public ClienteConvertidorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Realiza una prueba a la operacion de conversion de DTO a Entidad
     */
    @Test
    public void testConvertirAEntidad() {
        System.out.println("convertirAEntidad");
        
        // arrange
        ClienteDTO dto = new ClienteDTO();
        dto.setId(1l);
        dto.setNombreCompleto("Arely Cruz");
        dto.setTelefono("1234567890");
        
        // act
        Cliente result = this.clienteConvertidor.convertFromDto(dto);
        
        // act
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getNombreCompleto(), result.getNombreCompleto());
        assertEquals(dto.getTelefono(), result.getTelefono());   
    }

    /**
     * Realiza una prueba a la operacion de conversion de Entidad a DTO
     */
    @Test
    public void testConvertirADTO() {
        System.out.println("convertirADTO");
        
        // arrange
        Cliente entidad = new Cliente();
        entidad.setId(1l);
        entidad.setNombreCompleto("Arely Cruz");
        entidad.setTelefono("1234567890");
        
        // act
        ClienteDTO result = this.clienteConvertidor.convertFromEntity(entidad);
        
        // act
        assertEquals(entidad.getId(), result.getId());
        assertEquals(entidad.getNombreCompleto(), result.getNombreCompleto());
        assertEquals(entidad.getTelefono(), result.getTelefono());  
    }
}
