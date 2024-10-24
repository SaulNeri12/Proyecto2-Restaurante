/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao.implementaciones;

import dao.interfaces.IClientesDAO;
import dao.interfaces.IMesasDAO;
import dao.interfaces.IReservacionesDAO;
import entidades.Cliente;
import entidades.Mesa;
import entidades.Reservacion;
import java.time.Duration;
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
 * @author neri
 */
public class ReservacionesDAOTest {
    private IReservacionesDAO reservaciones = ReservacionesDAO.getInstance();
    private IMesasDAO mesas = MesasDAO.getInstance();
    private IClientesDAO clientes = ClientesDAO.getInstance();
    
    public ReservacionesDAOTest() {
        
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
     * Test of obtenerReservacionesTodos method, of class ReservacionesDAO.
     */
    @Test
    public void testObtenerReservacionesTodos() throws Exception {
        System.out.println("obtenerReservacionesTodos");
        
        // arrange 
        //List<Reservacion> expResult = null;
        
        // act
        List<Reservacion> result = this.reservaciones.obtenerReservacionesTodos();
        
        // assert
        assertTrue(!result.isEmpty(), "La lista de reservaciones no debe estar vacia");
    }

    /**
     * Test of obtenerReservacionesPorPeriodo method, of class ReservacionesDAO.
     */
    @Test
    public void testObtenerReservacionesPorPeriodo() throws Exception {
        System.out.println("obtenerReservacionesPorPeriodo");
        
        // arrange
        LocalDateTime fechaInicio = LocalDateTime.now().minus(Duration.ofDays(5)); // 5 dias atras
        LocalDateTime fechaFin = LocalDateTime.now().plus(Duration.ofDays(1)); // manana
        
        // act
        List<Reservacion> result = this.reservaciones.obtenerReservacionesPorPeriodo(fechaInicio, fechaFin);
        
        // assert
        assertTrue(!result.isEmpty(), "La lista de reservaciones no debe estar vacia");
    }

    /**
     * Test of obtenerReservacionesCliente method, of class ReservacionesDAO.
     */
    @Test
    public void testObtenerReservacionesCliente() throws Exception {
        System.out.println("obtenerReservacionesCliente");
        
        // arrange
        String telefono = "1234567890";
        
        // act
        List<Reservacion> result = this.reservaciones.obtenerReservacionesCliente(telefono);
        
        // assert
        assertNotNull(!result.isEmpty(), "La lista no debe ser estar vacia");
    }

    /**
     * Test of obtenerReservacionPorID method, of class ReservacionesDAO.
     */
    @Test
    public void testObtenerReservacionPorID() throws Exception {
        System.out.println("obtenerReservacionPorID");
        
        // arrange
        Long id = 1l;
        
        // act
        Reservacion result = this.reservaciones.obtenerReservacionPorID(id);
        
        // assert
        assertNotNull(result, "La reservacion no debe ser null");
    }

    /**
     * Test of agregarReservacion method, of class ReservacionesDAO.
     */
    @Test
    public void testAgregarReservacion() throws Exception {
        System.out.println("agregarReservacion");
        
        // arrange
        String telefono = "1234567890";
        LocalDateTime fechaReservacion = LocalDateTime.now()
                .plus(Duration.ofDays(7)).plus(Duration.ofHours(6));
        
        Mesa mesa = this.mesas.obtenerMesasTodas().getFirst();
        Cliente cliente = this.clientes.obtenerClientePorTelefono(telefono);
        
        // assert
        assertNotNull(cliente, "El cliente no debe ser null");
        
        Reservacion r = new Reservacion();
        r.setCliente(cliente);
        r.setMesa(mesa);
        r.setFechaHora(fechaReservacion);
        r.setNumeroPersonas(mesa.getTipoMesa().getMaximoPersonas());
        r.setMontoTotal(mesa.getTipoMesa().getPrecio());
        
        // act
        this.reservaciones.agregarReservacion(r);
        
        // assert
    }

    /**
     * Test of actualizarReservacion method, of class ReservacionesDAO.
    */
    @Test
    public void testActualizarReservacion() throws Exception {
        System.out.println("actualizarReservacion");
        
        // arrange
        Long id = 2l;
        Mesa mesa = this.mesas.obtenerMesasTodas().getLast();
        
        Reservacion reservacion = this.reservaciones.obtenerReservacionPorID(id);
        reservacion.setMesa(mesa);
        reservacion.setNumeroPersonas(mesa.getTipoMesa().getMaximoPersonas());
        reservacion.setMontoTotal(mesa.getTipoMesa().getPrecio());
        
        // act
        this.reservaciones.actualizarReservacion(reservacion);
        
        // assert
    }

    /**
     * Test of eliminarReservacion method, of class ReservacionesDAO.
     */
    @Test
    public void testEliminarReservacion() throws Exception {
        System.out.println("eliminarReservacion");
        
        // arrange
        Long id = 1l;
        
        // act
        this.reservaciones.eliminarReservacion(id);
        
        // assert
    }
}
