//
//package dao.implementaciones;
//
//import dao.interfaces.IClientesDAO;
//import dao.interfaces.IMesasDAO;
//import dao.interfaces.IReservacionesDAO;
//import entidades.Cliente;
//import entidades.EstadoReservacion;
//import entidades.Mesa;
//import entidades.Multa;
//import entidades.Reservacion;
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.List;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author neri
// */
//public class ReservacionesDAOTest {
//    private IReservacionesDAO reservaciones = ReservacionesDAO.getInstance();
//    private IMesasDAO mesas = MesasDAO.getInstance();
//    private IClientesDAO clientes = ClientesDAO.getInstance();
//    
//    public ReservacionesDAOTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of obtenerReservacionesTodos method, of class ReservacionesDAO.
//     */
//    @Test
//    public void testAgregarTipoMulta_Multa25Porciento() throws Exception {
//        System.out.println("agregarTipoMulta - 25%");
//        
//        // arrange 
//        Multa m = new Multa();
//        m.setDescripcion("Multa de 25% del total de la reservacion por cancelacion en un lapso entre 1 a 2 dias antes de la misma");
//        m.setPorcentaje(25.0f);
//        
//        // act
//        this.reservaciones.agregarTipoMulta(m);
//       
//        // assert
//    }
//    
//    @Test
//    public void testAgregarTipoMulta_Multa50Porciento() throws Exception {
//        System.out.println("agregarTipoMulta - 50%");
//        
//        // arrange 
//        Multa m = new Multa();
//        m.setDescripcion("Multa de 50% del total de la reservacion por cancelacion menos de un dia antes de la misma");
//        m.setPorcentaje(50.0f);
//        
//        // act
//        this.reservaciones.agregarTipoMulta(m);
//        
//        // assert
//    }
//    
//    @Test
//    public void testAgregarTipoMulta_Multa75Porciento() throws Exception {
//        System.out.println("agregarTipoMulta - 75%");
//        
//        // arrange 
//        Multa m = new Multa();
//        m.setDescripcion("Multa de 75% del total de la reservacion por cancelacion 1 hora antes de la misma [TEST]");
//        m.setPorcentaje(75.0f);
//        
//        // act
//        this.reservaciones.agregarTipoMulta(m);
//        
//        // assert
//    }
//    
//    @Test
//    public void testObtenerTiposMultaTodos() throws Exception {
//        System.out.println("obtenerTiposMultaTodos");
//        
//        // arrange 
//        
//        
//        // act
//        List<Multa> tiposMulta = this.reservaciones.obtenerTiposMultaTodos();
//        
//        // assert
//        assertNotNull(tiposMulta, "La lista no debe ser null");
//        assertTrue(!tiposMulta.isEmpty(), "La lista no debe estar vacia");
//    }
//    
//    @Test
//    public void testObtenerRerservacionConMulta() throws Exception {
//        System.out.println("obtenerReservacionConMulta");
//        
//        // arrange 
//        Long id = 6l;
//        
//        // act
//        Reservacion reservacion = this.reservaciones.obtenerReservacionPorID(id);
//        System.out.println("Multa de la reservacion: " + reservacion.getMulta().getDescripcion());
//        
//        // assert
//        assertNotNull(reservacion.getMulta(), "La multa de esta reservacion no debe ser null");
//    }
//    
//    @Test
//    public void testEliminarTipoMulta() throws Exception {
//        System.out.println("obtenerTiposMultaTodos");
//        
//        // arrange 
//        Long idMulta = 4l;
//        
//        // act
//        this.reservaciones.eliminarTipoMulta(idMulta);
//        
//        // assert
//    }
//    
//    /**
//     * Test of obtenerReservacionesTodos method, of class ReservacionesDAO.
//     */
//    @Test
//    public void testObtenerReservacionesTodos() throws Exception {
//        System.out.println("obtenerReservacionesTodos");
//        
//        // arrange 
//        //List<Reservacion> expResult = null;
//        
//        // act
//        List<Reservacion> result = this.reservaciones.obtenerReservacionesTodos();
//        
//        // assert
//        assertTrue(!result.isEmpty(), "La lista de reservaciones no debe estar vacia");
//    }
//
//    /**
//     * Test of obtenerReservacionesPorPeriodo method, of class ReservacionesDAO.
//     */
//    @Test
//    public void testObtenerReservacionesPorPeriodo() throws Exception {
//        System.out.println("obtenerReservacionesPorPeriodo");
//        
//        // arrange
//        LocalDateTime fechaInicio = LocalDateTime.now().minus(Duration.ofDays(5)); // 5 dias atras
//        LocalDateTime fechaFin = LocalDateTime.now().plus(Duration.ofDays(20)); // 20 dias
//        
//        // act
//        List<Reservacion> result = this.reservaciones.obtenerReservacionesPorPeriodo(fechaInicio, fechaFin);
//        
//        // assert
//        assertTrue(!result.isEmpty(), "La lista de reservaciones no debe estar vacia");
//    }
//
//    /**
//     * Test of obtenerReservacionesCliente method, of class ReservacionesDAO.
//     */
//    @Test
//    public void testObtenerReservacionesCliente() throws Exception {
//        System.out.println("obtenerReservacionesCliente");
//        
//        // arrange
//        String telefono = "1234567890";
//        
//        // act
//        List<Reservacion> result = this.reservaciones.obtenerReservacionesCliente(telefono);
//        
//        // assert
//        assertNotNull(result, "La lista no debe ser null");
//        assertTrue(!result.isEmpty(), "La lista no debe ser estar vacia");
//    }
//
//    /**
//     * Test of obtenerReservacionPorID method, of class ReservacionesDAO.
//     */
//    @Test
//    public void testObtenerReservacionPorID() throws Exception {
//        System.out.println("obtenerReservacionPorID");
//        
//        // arrange
//        Long id = 2l;
//        
//        // act
//        Reservacion result = this.reservaciones.obtenerReservacionPorID(id);
//        
//        // assert
//        assertNotNull(result, "La reservacion no debe ser null");
//    }
//
//    /**
//     * Test of agregarReservacion method, of class ReservacionesDAO.
//     */
//    @Test
//    public void testAgregarReservacion_Reciente() throws Exception {
//        System.out.println("agregarReservacion Mas Reciente");
//        
//        // arrange
//        String telefono = "1234567890";
//        LocalDateTime fechaReservacion = LocalDateTime.now().plus(Duration.ofHours(6));
//        
//        Mesa mesa = this.mesas.obtenerMesasTodas().getLast();
//        Cliente cliente = this.clientes.obtenerClientePorTelefono(telefono);
//        
//        // assert
//        assertNotNull(cliente, "El cliente no debe ser null");
//        
//        Reservacion r = new Reservacion();
//        r.setCliente(cliente);
//        r.setMesa(mesa);
//        r.setFechaHora(fechaReservacion);
//        r.setNumeroPersonas(mesa.getTipoMesa().getMaximoPersonas());
//        r.setMontoTotal(mesa.getTipoMesa().getPrecio());
//        
//        // act
//        this.reservaciones.agregarReservacion(r);
//        
//        // assert
//    }
//    
//    @Test
//    public void testAgregarReservacion_OtraPersona() throws Exception {
//        System.out.println("agregarReservacion Mas Reciente");
//        
//        // arrange
//        String telefono = "6444412219";
//        LocalDateTime fechaReservacion = LocalDateTime.now().plus(Duration.ofHours(6));
//        
//        Mesa mesa = this.mesas.obtenerMesasTodas().getLast();
//        Cliente cliente = this.clientes.obtenerClientePorTelefono(telefono);
//        
//        // assert
//        assertNotNull(cliente, "El cliente no debe ser null");
//        
//        Reservacion r = new Reservacion();
//        r.setCliente(cliente);
//        r.setMesa(mesa);
//        r.setFechaHora(fechaReservacion);
//        r.setNumeroPersonas(mesa.getTipoMesa().getMaximoPersonas());
//        r.setMontoTotal(mesa.getTipoMesa().getPrecio());
//        
//        // act
//        this.reservaciones.agregarReservacion(r);
//        
//        // assert
//    }
//
//    /**
//     * Test of actualizarReservacion method, of class ReservacionesDAO.
//    */
//    @Test
//    public void testActualizarReservacion() throws Exception {
//        System.out.println("actualizarReservacion");
//        
//        // arrange
//        Long id = 2l;
//        Mesa mesa = this.mesas.obtenerMesasTodas().getLast();
//        
//        Reservacion reservacion = this.reservaciones.obtenerReservacionPorID(id);
//        reservacion.setMesa(mesa);
//        reservacion.setNumeroPersonas(mesa.getTipoMesa().getMaximoPersonas());
//        reservacion.setMontoTotal(mesa.getTipoMesa().getPrecio());
//        
//        // act
//        this.reservaciones.actualizarReservacion(reservacion);
//        
//        // assert
//    }
//    
//    @Test
//    public void testObtenerReservacionPorID_VerificarFechaRegistro() throws Exception {
//        // arrange
//        Long id = 2l;
//        
//        // act
//        Reservacion r = this.reservaciones.obtenerReservacionPorID(id);
//        
//        // assert
//        assertNotNull(r, "La reservacion no debe ser null");
//        assertNotNull(r.getFechaHoraRegistro(), "La fecha y hora de registro no debe ser null");
//    }
//
//    /**
//     * Test of eliminarReservacion method, of class ReservacionesDAO.
//     */
//    @Test
//    public void testEliminarReservacion() throws Exception {
//        System.out.println("eliminarReservacion");
//        
//        // arrange
//        Long id = 1l;
//        
//        // act
//        this.reservaciones.eliminarReservacion(id);
//        
//        // assert
//    }
//    
//    
//    @Test
//    public void testCancelarReservacion_SinMulta() throws Exception {
//        System.out.println("eliminarReservacion");
//        
//        // arrange
//        Reservacion res = this.reservaciones.obtenerReservacionesTodos()
//                .stream()
//                .filter(r -> r.getEstado().equals(EstadoReservacion.PENDIENTE))
//                .findFirst()
//                .orElse(null);
//        
//        // act
//        this.reservaciones.cancelarReservacion(res.getId());
//        
//        // assert
//    }
//}
