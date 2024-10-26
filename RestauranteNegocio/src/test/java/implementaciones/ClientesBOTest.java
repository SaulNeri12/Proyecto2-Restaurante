/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import dto.ClienteDTO;
import excepciones.ServicioException;
import excepciones.NoEncontradoException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test para la clase ClientesBO.
 */
public class ClientesBOTest {

    private ClientesBO clientesBO;

    
    
    @BeforeEach
    public void setUp() {
        clientesBO = ClientesBO.getInstance();
    }

    /**
     * Test para verificar la obtención de la instancia de ClientesBO.
     */
    @Test
    public void testGetInstance() {
        assertNotNull(clientesBO, "La instancia de ClientesBO no debe ser nula");
    }

    /**
     * Test para el método insercionMasivaClientes en ClientesBO.
     */
    @Test
public void testInsercionMasivaClientes() throws ServicioException {
    // Arrange
    List<ClienteDTO> clientes = Arrays.asList(
            new ClienteDTO(1L, "Alberto Perez Perez", "6444112233"),
            new ClienteDTO(2L, "Jorge Perez Soto", "6444112252"),
            new ClienteDTO(3L, "Arely Cruz Perez", "1234567890")
    );

    // Act
    assertDoesNotThrow(() -> clientesBO.insercionMasivaClientes(clientes));

    // Assert - se podría verificar si los datos están en la base de datos.
}

    /**
     * Test para obtener todos los clientes.
     */
    @Test
    public void testObtenerClientesTodos() throws ServicioException {
        // Act
        List<ClienteDTO> clientes = clientesBO.obtenerClientesTodos();

        // Assert
        assertNotNull(clientes, "La lista de clientes no debe ser nula");
        assertTrue(clientes.size() > 0, "Debe haber al menos un cliente en la lista");
    }

    /**
     * Test para obtener un cliente por su número de teléfono.
     */
    @Test
    public void testObtenerClientePorTelefono() throws NoEncontradoException {
        // Arrange
        String telefono = "6444112252";

        // Act y Assert
        try {
            ClienteDTO cliente = clientesBO.obtenerClientePorTelefono(telefono);
            assertNotNull(cliente, "El cliente no debe ser null");
            assertEquals(telefono, cliente.getTelefono(), "El teléfono debe coincidir");
        } catch (ServicioException e) {
            fail("No se esperaba excepción: " + e.getMessage());
        }
    }

    /**
     * Test para el caso de excepción al buscar un cliente que no existe.
     */
    @Test
    public void testObtenerClientePorTelefono_NoEncontrado() {
        String telefonoInexistente = "0000000000";
        
        Exception exception = assertThrows(NoEncontradoException.class, () -> {
            clientesBO.obtenerClientePorTelefono(telefonoInexistente);
        });

        assertTrue(exception.getMessage().contains("Cliente no encontrado"));
    }
}
