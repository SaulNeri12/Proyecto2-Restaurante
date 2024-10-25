/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import dto.ClienteDTO;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author caarl
 */
public class ClientesBOTest {
    
    public ClientesBOTest() {
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
     * Test of getInstance method, of class ClientesBO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ClientesBO expResult = null;
        ClientesBO result = ClientesBO.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insercionMasivaClientes method, of class ClientesBO.
     */
    @Test
    public void testInsercionMasivaClientes() throws Exception {
        System.out.println("insercionMasivaClientes");
        List<ClienteDTO> clientes = null;
        ClientesBO instance = null;
        instance.insercionMasivaClientes(clientes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerClientesTodos method, of class ClientesBO.
     */
    @Test
    public void testObtenerClientesTodos() throws Exception {
        System.out.println("obtenerClientesTodos");
        ClientesBO instance = null;
        List<ClienteDTO> expResult = null;
        List<ClienteDTO> result = instance.obtenerClientesTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerClientePorTelefono method, of class ClientesBO.
     */
    @Test
    public void testObtenerClientePorTelefono() throws Exception {
        System.out.println("obtenerClientePorTelefono");
        String numeroTelefono = "";
        ClientesBO instance = null;
        ClienteDTO expResult = null;
        ClienteDTO result = instance.obtenerClientePorTelefono(numeroTelefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
