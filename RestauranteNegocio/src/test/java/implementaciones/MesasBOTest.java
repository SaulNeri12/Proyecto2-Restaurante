/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
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
public class MesasBOTest {
    
    public MesasBOTest() {
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
     * Test of getInstance method, of class MesasBO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MesasBO expResult = null;
        MesasBO result = MesasBO.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerMesasTodas method, of class MesasBO.
     */
    @Test
    public void testObtenerMesasTodas() throws Exception {
        System.out.println("obtenerMesasTodas");
        MesasBO instance = null;
        List<MesaDTO> expResult = null;
        List<MesaDTO> result = instance.obtenerMesasTodas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerMesasPorTipo method, of class MesasBO.
     */
    @Test
    public void testObtenerMesasPorTipo() throws Exception {
        System.out.println("obtenerMesasPorTipo");
        TipoMesaDTO tipo = null;
        MesasBO instance = null;
        List<MesaDTO> expResult = null;
        List<MesaDTO> result = instance.obtenerMesasPorTipo(tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarMesas method, of class MesasBO.
     */
    @Test
    public void testInsertarMesas() throws Exception {
        System.out.println("insertarMesas");
        TipoMesaDTO tipo = null;
        UbicacionMesaDTO ubicacion = null;
        int cantidad = 0;
        MesasBO instance = null;
        instance.insertarMesas(tipo, ubicacion, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarMesa method, of class MesasBO.
     */
    @Test
    public void testEliminarMesa() throws Exception {
        System.out.println("eliminarMesa");
        String codigo = "";
        MesasBO instance = null;
        instance.eliminarMesa(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
