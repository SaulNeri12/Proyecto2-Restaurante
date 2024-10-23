/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao.implementaciones;

import dao.interfaces.IClientesDAO;
import entidades.Cliente;
import java.util.Arrays;
import java.util.List;
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
public class ClientesDAOTest {
    private IClientesDAO instancia;
    
    public ClientesDAOTest() {
        this.instancia = ClientesDAO.getInstance();
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
     * Test of insercionMasivaClientes method, of class ClientesDAO.
     */
    @Test
    public void testInsercionMasivaClientes() throws Exception {
        System.out.println("insercionMasivaClientes");
        
        Cliente c1 = new Cliente();
        c1.setNombreCompleto("Alberto Perez Perez");
        c1.setTelefono("6444112233");
                
        Cliente c2 = new Cliente();
        c2.setNombreCompleto("Jorge Perez Soto");
        c2.setTelefono("6444112252");
        
        Cliente c3 = new Cliente();
        c3.setNombreCompleto("Arely Cruz Perez");
        c3.setTelefono("6444112210");
        
        Cliente c4 = new Cliente();
        c4.setNombreCompleto("Nicole Perez Lopez");
        c4.setTelefono("6444012210");
        
        Cliente c5 = new Cliente();
        c5.setNombreCompleto("Nomar Quintero Lopez");
        c5.setTelefono("6444412210");
        
        Cliente c6 = new Cliente();
        c6.setNombreCompleto("Bryan Quintero Lopez");
        c6.setTelefono("6444412219");
        
        Cliente c7 = new Cliente();
        c7.setNombreCompleto("Carlos Damian Perez Bernal");
        c7.setTelefono("6444412299");
        
        Cliente c8 = new Cliente();
        c8.setNombreCompleto("Carlos Jorge Perez Rodriguez");
        c8.setTelefono("6444812299");
        
        Cliente c9 = new Cliente();
        c9.setNombreCompleto("Hannia Campoa Lopez");
        c9.setTelefono("6404412299");
        
        Cliente c10 = new Cliente();
        c10.setNombreCompleto("Hannia Castillo Lopez");
        c10.setTelefono("6044412299");
        
        List<Cliente> clientes = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
        instancia.insercionMasivaClientes(clientes);
    }

    /**
     * Test of obtenerClientesTodos method, of class ClientesDAO.
     */
    @Test
    public void testObtenerClientesTodos() throws Exception {
        System.out.println("obtenerClientesTodos");
        List<Cliente> result = instancia.obtenerClientesTodos();
        System.out.println("Resultados: " + result.size());
        for (Cliente c: result) {
            System.out.println(c);
        }
        assertNotNull(result, "La lista no debe ser nula");
    }
    
}
