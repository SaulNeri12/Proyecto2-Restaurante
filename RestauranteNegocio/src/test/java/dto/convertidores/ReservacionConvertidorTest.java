/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dto.convertidores;

import dto.ClienteDTO;
import dto.EstadoReservacionDTO;
import dto.MesaDTO;
import dto.MultaDTO;
import dto.ReservacionDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import entidades.Cliente;
import entidades.EstadoReservacion;
import entidades.Mesa;
import entidades.Multa;
import entidades.Reservacion;
import entidades.TipoMesa;
import entidades.UbicacionMesa;
import java.time.LocalDateTime;
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
public class ReservacionConvertidorTest {
    private Converter<ClienteDTO, Cliente> clienteConvertidor = new ClienteConvertidor();
    private Converter<MesaDTO, Mesa> mesaConvertidor = new MesaConvertidor();
    private Converter<MultaDTO, Multa> multaConvertidor = new MultaConvertidor();
    private Converter<ReservacionDTO, Reservacion> reservacionConvertidor = new ReservacionConvertidor();
    
    public ReservacionConvertidorTest() {
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
     * Test of convertirAEntidad method, of class ReservacionConvertidor.
     */
    @Test
    public void testConvertirAEntidad() {
        System.out.println("convertirAEntidad");
        
        // assert
        ClienteDTO cl = new ClienteDTO();
        cl.setId(1l);
        cl.setNombreCompleto("Saul Armando");
        cl.setTelefono("1234567890");
        
        TipoMesaDTO t = new TipoMesaDTO();
        t.setId(1l);
        t.setMaximoPersonas(10);
        t.setMinimoPersonas(4);
        t.setNombre("Mesa Mediana-Grande");
        t.setPrecio(100.f);
        
        MultaDTO multa = new MultaDTO();
        multa.setId(1l);
        multa.setDescripcion("Multa del 25% por llegar tarde");
        multa.setPorcentaje(25.f);
        
        MesaDTO m = new MesaDTO();
        m.setId(1l);
        m.setCodigo("VEN-1-012");
        m.setUbicacion(UbicacionMesaDTO.VENTANA);
        m.setTipoMesa(t);
        
        ReservacionDTO dto = new ReservacionDTO();
        dto.setId(1l);
        dto.setCliente(cl);
        dto.setMesa(m);
        dto.setMulta(multa);
        dto.setFechaHora(LocalDateTime.now());
        dto.setNumeroPersonas(5);
        
        // act
        Reservacion result = this.reservacionConvertidor.convertFromDto(dto);
        
        // assert
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getCliente(), this.clienteConvertidor.convertFromEntity(result.getCliente()));
        assertEquals(dto.getMesa(), this.mesaConvertidor.convertFromEntity(result.getMesa()));
        // multa assert
        assertEquals(dto.getMulta().getId(), this.multaConvertidor.convertFromEntity(result.getMulta()).getId());
        assertEquals(dto.getMulta().getPorcentaje(), this.multaConvertidor.convertFromEntity(result.getMulta()).getPorcentaje());
        assertEquals(dto.getMulta().getDescripcion(), this.multaConvertidor.convertFromEntity(result.getMulta()).getDescripcion());
        assertEquals(dto.getEstado(), EstadoReservacionDTO.valueOf(result.getEstado().toString()));
        assertEquals(dto.getFechaHora(), result.getFechaHora());
        assertEquals(dto.getMontoTotal(), result.getMontoTotal());
        assertEquals(dto.getNumeroPersonas(), result.getNumeroPersonas());
    }

    /**
     * Test of convertirADTO method, of class ReservacionConvertidor.
     */
    @Test
    public void testConvertirADTO() {
        System.out.println("convertirADTO");
        // assert
        Cliente cl = new Cliente();
        cl.setId(1l);
        cl.setNombreCompleto("Saul Armando");
        cl.setTelefono("1234567890");
        
        TipoMesa t = new TipoMesa();
        t.setId(1l);
        t.setMaximoPersonas(10);
        t.setMinimoPersonas(4);
        t.setNombre("Mesa Mediana-Grande");
        t.setPrecio(100.f);
        
        Multa multa = new Multa();
        multa.setId(1l);
        multa.setDescripcion("Multa del 25% por llegar tarde");
        multa.setPorcentaje(25.f);
        
        Mesa m = new Mesa();
        m.setId(1l);
        m.setCodigo("VEN-1-012");
        m.setUbicacion(UbicacionMesa.VENTANA);
        m.setTipoMesa(t);
        
        Reservacion entidad = new Reservacion();
        entidad.setId(1l);
        entidad.setCliente(cl);
        entidad.setMesa(m);
        entidad.setMulta(multa);
        entidad.setFechaHora(LocalDateTime.now());
        entidad.setNumeroPersonas(5);
        
        // act
        ReservacionDTO result = this.reservacionConvertidor.convertFromEntity(entidad);
        
        // assert
        assertEquals(entidad.getId(), result.getId());
        assertEquals(entidad.getCliente(), this.clienteConvertidor.convertFromDto(result.getCliente()));
        assertEquals(entidad.getMesa(), this.mesaConvertidor.convertFromDto(result.getMesa()));
        assertEquals(entidad.getMulta(), this.multaConvertidor.convertFromDto(result.getMulta()));
        assertEquals(entidad.getEstado(), EstadoReservacion.valueOf(result.getEstado().toString()));
        assertEquals(entidad.getFechaHora(), result.getFechaHora());
        assertEquals(entidad.getMontoTotal(), result.getMontoTotal());
        assertEquals(entidad.getNumeroPersonas(), result.getNumeroPersonas());
    }
    
}
