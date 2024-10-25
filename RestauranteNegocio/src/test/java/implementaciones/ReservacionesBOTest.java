/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import dto.ReservacionDTO;
import java.time.LocalDateTime;
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
public class ReservacionesBOTest {
    
    public ReservacionesBOTest() {
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
     * Test of getInstance method, of class ReservacionesBO.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ReservacionesBO expResult = null;
        ReservacionesBO result = ReservacionesBO.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerReservacionesDeMesa method, of class ReservacionesBO.
     */
    @Test
    public void testObtenerReservacionesDeMesa() throws Exception {
        System.out.println("obtenerReservacionesDeMesa");
        String codigoMesa = "";
        ReservacionesBO instance = null;
        List<ReservacionDTO> expResult = null;
        List<ReservacionDTO> result = instance.obtenerReservacionesDeMesa(codigoMesa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelarReservacion method, of class ReservacionesBO.
     */
    @Test
    public void testCancelarReservacion() throws Exception {
        System.out.println("cancelarReservacion");
        Long idReservacion = null;
        ReservacionesBO instance = null;
        instance.cancelarReservacion(idReservacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerReservacionesTodos method, of class ReservacionesBO.
     */
    @Test
    public void testObtenerReservacionesTodos() throws Exception {
        System.out.println("obtenerReservacionesTodos");
        ReservacionesBO instance = null;
        List<ReservacionDTO> expResult = null;
        List<ReservacionDTO> result = instance.obtenerReservacionesTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerReservacionesPorPeriodo method, of class ReservacionesBO.
     */
    @Test
    public void testObtenerReservacionesPorPeriodo() throws Exception {
        System.out.println("obtenerReservacionesPorPeriodo");
        LocalDateTime fechaInicio = null;
        LocalDateTime fechaFin = null;
        ReservacionesBO instance = null;
        List<ReservacionDTO> expResult = null;
        List<ReservacionDTO> result = instance.obtenerReservacionesPorPeriodo(fechaInicio, fechaFin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerReservacionesCliente method, of class ReservacionesBO.
     */
    @Test
    public void testObtenerReservacionesCliente() throws Exception {
        System.out.println("obtenerReservacionesCliente");
        String telefono = "";
        ReservacionesBO instance = null;
        List<ReservacionDTO> expResult = null;
        List<ReservacionDTO> result = instance.obtenerReservacionesCliente(telefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerReservacionPorID method, of class ReservacionesBO.
     */
    @Test
    public void testObtenerReservacionPorID() throws Exception {
        System.out.println("obtenerReservacionPorID");
        Long id = null;
        ReservacionesBO instance = null;
        ReservacionDTO expResult = null;
        ReservacionDTO result = instance.obtenerReservacionPorID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarReservacion method, of class ReservacionesBO.
     */
    @Test
    public void testAgregarReservacion() throws Exception {
        System.out.println("agregarReservacion");
        ReservacionDTO reservacion = null;
        ReservacionesBO instance = null;
        instance.agregarReservacion(reservacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarReservacion method, of class ReservacionesBO.
     */
    @Test
    public void testActualizarReservacion() throws Exception {
        System.out.println("actualizarReservacion");
        ReservacionDTO reservacion = null;
        ReservacionesBO instance = null;
        instance.actualizarReservacion(reservacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarReservacion method, of class ReservacionesBO.
     */
    @Test
    public void testEliminarReservacion() throws Exception {
        System.out.println("eliminarReservacion");
        Long id = null;
        ReservacionesBO instance = null;
        instance.eliminarReservacion(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
