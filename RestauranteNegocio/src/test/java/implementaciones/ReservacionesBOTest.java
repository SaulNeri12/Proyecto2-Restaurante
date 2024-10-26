/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import dao.interfaces.IReservacionesDAO;
import dto.ReservacionDTO;
import dto.MesaDTO;
import dto.ClienteDTO;
import dto.EstadoReservacionDTO;
import entidades.Reservacion;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import dto.convertidores.ReservacionConvertidor;
import excepciones.DAOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReservacionesBOTest {

    @Mock
    private IReservacionesDAO reservacionesDAO;

    @Mock
    private ReservacionConvertidor reservacionConvertidor;

    @InjectMocks
    private ReservacionesBO reservacionesBO;

    private ReservacionDTO reservacionDTO;
    private Reservacion reservacionEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Datos de prueba de mesa
        MesaDTO mesa = new MesaDTO();
        mesa.setId(1L);
        mesa.setCodigo("MESA01");

        // Datos de prueba de cliente
        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(1L);
        cliente.setTelefono("1234567890");

        // Datos de prueba de reservación
        reservacionDTO = new ReservacionDTO();
        reservacionDTO.setId(1L);
        reservacionDTO.setFechaHora(LocalDateTime.now().plusDays(1));
        reservacionDTO.setNumeroPersonas(4);
        reservacionDTO.setEstado(EstadoReservacionDTO.PENDIENTE);
        reservacionDTO.setMesa(mesa);
        reservacionDTO.setCliente(cliente);
        reservacionDTO.setMontoTotal(100.0f);

        // Crear entidad correspondiente
        reservacionEntity = new Reservacion();
        reservacionEntity.setId(reservacionDTO.getId());
        reservacionEntity.setFechaHora(reservacionDTO.getFechaHora());
        reservacionEntity.setNumeroPersonas(reservacionDTO.getNumeroPersonas());
        reservacionEntity.setMontoTotal(reservacionDTO.getMontoTotal());
        // Configura otros campos necesarios aquí

        // Configurar el convertidor mock
        when(reservacionConvertidor.convertFromDto(reservacionDTO))
                .thenReturn(reservacionEntity);
        when(reservacionConvertidor.convertFromEntity(reservacionEntity))
                .thenReturn(reservacionDTO);
        when(reservacionConvertidor.createFromEntities(anyList()))
                .thenReturn(Arrays.asList(reservacionDTO));
    }

    @Test
    public void testGetInstance() {
        ReservacionesBO instance1 = ReservacionesBO.getInstance();
        ReservacionesBO instance2 = ReservacionesBO.getInstance();
        assertNotNull(instance1);
        assertSame(instance1, instance2, "Las instancias deberían ser la misma");
    }

    @Test
    public void testObtenerReservacionesDeMesa_Exitoso() throws Exception {
        String codigoMesa = "MESA01";
        when(reservacionesDAO.obtenerReservacionesDeMesa(codigoMesa))
                .thenReturn(Arrays.asList(reservacionEntity));

        List<ReservacionDTO> resultado = reservacionesBO.obtenerReservacionesDeMesa(codigoMesa);

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        verify(reservacionesDAO).obtenerReservacionesDeMesa(codigoMesa);
    }

    @Test
    public void testObtenerReservacionesDeMesa_Error() {
        String codigoMesa = "MESA01";
        try {
            when(reservacionesDAO.obtenerReservacionesDeMesa(codigoMesa))
                    .thenThrow(new RuntimeException("Error de base de datos"));
        } catch (DAOException ex) {
            Logger.getLogger(ReservacionesBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertThrows(ServicioException.class, () -> reservacionesBO.obtenerReservacionesDeMesa(codigoMesa));
    }

    @Test
    public void testCancelarReservacion_Exitoso() throws Exception {
        Long idReservacion = 1L;
        doNothing().when(reservacionesDAO).cancelarReservacion(idReservacion);

        assertDoesNotThrow(() -> reservacionesBO.cancelarReservacion(idReservacion));

        verify(reservacionesDAO).cancelarReservacion(idReservacion);
    }

    @Test
    public void testCancelarReservacion_NoEncontrado() throws DAOException {
        Long idReservacion = 1L;
        doThrow(new NoEncontradoException("Reservación no encontrada"))
                .when(reservacionesDAO).cancelarReservacion(idReservacion);

        assertThrows(NoEncontradoException.class, () -> reservacionesBO.cancelarReservacion(idReservacion));
    }

    @Test
    public void testAgregarReservacion_Exitoso() throws Exception {
        doNothing().when(reservacionesDAO).agregarReservacion(any(Reservacion.class));

        assertDoesNotThrow(() -> reservacionesBO.agregarReservacion(reservacionDTO));

        verify(reservacionConvertidor).convertFromDto(reservacionDTO);
        verify(reservacionesDAO).agregarReservacion(any(Reservacion.class));
    }

    @Test
    public void testActualizarReservacion_Exitoso() throws Exception {
        doNothing().when(reservacionesDAO).actualizarReservacion(any(Reservacion.class));

        assertDoesNotThrow(() -> reservacionesBO.actualizarReservacion(reservacionDTO));

        verify(reservacionConvertidor).convertFromDto(reservacionDTO);
        verify(reservacionesDAO).actualizarReservacion(any(Reservacion.class));
    }

    @Test
    public void testObtenerReservacionPorID_Exitoso() throws Exception {
        Long id = 1L;
        when(reservacionesDAO.obtenerReservacionPorID(id)).thenReturn(reservacionEntity);

        ReservacionDTO resultado = reservacionesBO.obtenerReservacionPorID(id);

        assertNotNull(resultado);
        assertEquals(reservacionDTO.getId(), resultado.getId());
        verify(reservacionesDAO).obtenerReservacionPorID(id);
    }

    @Test
    public void testEliminarReservacion_Exitoso() throws Exception {
        Long id = 1L;
        doNothing().when(reservacionesDAO).eliminarReservacion(id);

        assertDoesNotThrow(() -> reservacionesBO.eliminarReservacion(id));

        verify(reservacionesDAO).eliminarReservacion(id);
    }

    @Test
    public void testObtenerReservacionesPorPeriodo_Exitoso() throws Exception {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = LocalDateTime.now().plusDays(7);

        when(reservacionesDAO.obtenerReservacionesPorPeriodo(inicio, fin))
                .thenReturn(Arrays.asList(reservacionEntity));

        List<ReservacionDTO> resultado = reservacionesBO.obtenerReservacionesPorPeriodo(inicio, fin);

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        verify(reservacionesDAO).obtenerReservacionesPorPeriodo(inicio, fin);
    }

    @Test
    public void testObtenerReservacionesCliente_Exitoso() throws Exception {
        String telefono = "1234567890";
        when(reservacionesDAO.obtenerReservacionesCliente(telefono))
                .thenReturn(Arrays.asList(reservacionEntity));

        List<ReservacionDTO> resultado = reservacionesBO.obtenerReservacionesCliente(telefono);

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        verify(reservacionesDAO).obtenerReservacionesCliente(telefono);
    }
}
