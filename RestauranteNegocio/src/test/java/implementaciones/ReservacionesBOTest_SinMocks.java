/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import dto.ReservacionDTO;
import dto.MesaDTO;
import dto.ClienteDTO;
import dto.EstadoReservacionDTO;
import dto.convertidores.Converter;
import entidades.Reservacion;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import dto.convertidores.ReservacionConvertidor;
import excepciones.DAOException;
import interfacesBO.IClientesBO;
import interfacesBO.IMesasBO;
import interfacesBO.IReservacionesBO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class ReservacionesBOTest_SinMocks {

    private Converter<ReservacionDTO, Reservacion> reservacionConvertidor = new ReservacionConvertidor();
    private IReservacionesBO reservacionesBO = ReservacionesBO.getInstance();
    private IClientesBO clientesBO = ClientesBO.getInstance();
    private IMesasBO mesasBO = MesasBO.getInstance();

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testObtenerReservacionesDeMesa_Exitoso() throws Exception {
        
        // arrange
        String codigoMesa = "GEN-8-349";

        // act
        List<ReservacionDTO> resultado = reservacionesBO.obtenerReservacionesDeMesa(codigoMesa);

        // assert
        assertNotNull(resultado, "El resultado no debe ser null");
        assertFalse(resultado.isEmpty(), "La lista no debe estar vacia");
    }

    @Test
    public void testObtenerReservacionesDeMesa_MesaInexistente() {
        // arrange
        String codigoMesa = "MESA01";

        // act
        
        // assert
        assertThrows(ServicioException.class, () -> reservacionesBO.obtenerReservacionesDeMesa(codigoMesa));
    }

    @Test
    public void testCancelarReservacion_Exitoso() throws Exception {
        
        // arrange
        Long idReservacion = 3L;

        // act
        assertDoesNotThrow(() -> reservacionesBO.cancelarReservacion(idReservacion));

        // assert
    }

    @Test
    public void testCancelarReservacion_NoEncontrado() {
        // arrange
        Long idReservacion = 100L;

        // act
        
        // assert
        assertThrows(ServicioException.class, () -> reservacionesBO.cancelarReservacion(idReservacion));
    }

    @Test
    public void testAgregarReservacion_Exitoso() throws Exception {

        // arrange
        MesaDTO mesa = this.mesasBO.obtenerMesasTodas().stream().findAny().orElse(null);
        assertNotNull(mesa, "La mesa no debe ser null");
        
        ClienteDTO cliente = this.clientesBO.obtenerClientesTodos().stream().findAny().orElse(null);
        assertNotNull(cliente, "El cliente no debe ser null");
        
        // -- fecha para la reservacion
        LocalDateTime fechaHora = LocalDateTime.now().plusDays(15l);
         
        ReservacionDTO r = new ReservacionDTO();
        r.setCliente(cliente);
        r.setMesa(mesa);
        r.setFechaHora(fechaHora);
        r.setNumeroPersonas(mesa.getTipoMesa().getMaximoPersonas());
        
        // act
        
        // assert
        assertDoesNotThrow(() -> reservacionesBO.agregarReservacion(r));
    }

    @Test
    public void testActualizarReservacion_Exitoso() throws Exception {
        // arrange
        MesaDTO mesa = this.mesasBO.obtenerMesasTodas().stream().findAny().orElse(null);
        assertNotNull(mesa, "La mesa no debe ser null");
        
        ReservacionDTO res = this.reservacionesBO.obtenerReservacionesTodos().getFirst();
        assertNotNull(res, "La reservacion no debe ser null");
        
        res.setMesa(mesa);

        // act
        
        // assert
        assertDoesNotThrow(() -> reservacionesBO.actualizarReservacion(res));
    }

    @Test
    public void testObtenerReservacionPorID_Exitoso() throws Exception {
        
        // arrange
        Long id = 3L;
        
        // act
        ReservacionDTO resultado = reservacionesBO.obtenerReservacionPorID(id);

        // assert
        assertNotNull(resultado);
        assertEquals(resultado.getId(), id);
    }
    
    @Test
    public void testObtenerReservacionPorID_ConMulta() throws Exception {
        
        // arrange
        Long id = 3L;
        
        // act
        ReservacionDTO resultado = reservacionesBO.obtenerReservacionPorID(id);

        // assert
        assertNotNull(resultado);
        assertEquals(resultado.getId(), id);
        assertNotNull(resultado.getMulta(), "La multa no debe ser null");
        assertNotNull(resultado.getMulta().getId(), "El id de la multa no debe ser null");
        assertNotNull(resultado.getMulta().getDescripcion(), "La descripcion de la multa no debe ser null");
        assertNotNull(resultado.getMulta().getPorcentaje(), "El porcentaje de la multa no debe ser null");
    }

    @Test
    public void testEliminarReservacion_Exitoso() throws Exception {
        
        // arrange
        Long id = 2L;

        // act
        
        // assert
        assertDoesNotThrow(() -> reservacionesBO.eliminarReservacion(id));
    }

    @Test
    public void testObtenerReservacionesPorPeriodo_Exitoso() throws Exception {
        // arrange
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = LocalDateTime.now().plusDays(30);

        // act
        List<ReservacionDTO> resultado = reservacionesBO.obtenerReservacionesPorPeriodo(inicio, fin);

        // assert
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty(), "La lista no debe estar vacia");
    }

    @Test
    public void testObtenerReservacionesCliente_Exitoso() throws Exception {
        // arrange
        String telefono = "6444412219";
        
        // act
        List<ReservacionDTO> resultado = reservacionesBO.obtenerReservacionesCliente(telefono);

        // assert
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertEquals(resultado.getFirst().getCliente().getTelefono(), telefono);
    }
}
