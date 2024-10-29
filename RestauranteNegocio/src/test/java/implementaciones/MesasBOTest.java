///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package implementaciones;
//
//import dto.MesaDTO;
//import dto.TipoMesaDTO;
//import dto.UbicacionMesaDTO;
//import excepciones.NoEncontradoException;
//import excepciones.ServicioException;
//import interfacesBO.IMesasBO;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class MesasBOTest {
//
//    private IMesasBO mesasBO;
//
//    @BeforeEach
//    public void setUp() {
//        mesasBO = Mockito.mock(IMesasBO.class);
//    }
//
//    @Test
//    public void testObtenerMesasTodas() throws ServicioException {
//        List<MesaDTO> mesasMock = new ArrayList<>();
//        mesasMock.add(new MesaDTO(1L));
//
//        when(mesasBO.obtenerMesasTodas()).thenReturn(mesasMock);
//
//        List<MesaDTO> result = mesasBO.obtenerMesasTodas();
//        assertNotNull(result);
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    public void testObtenerMesasPorTipo() throws ServicioException {
//        TipoMesaDTO tipo = new TipoMesaDTO();
//        List<MesaDTO> mesasMock = new ArrayList<>();
//        mesasMock.add(new MesaDTO(1L));
//
//        when(mesasBO.obtenerMesasPorTipo(tipo)).thenReturn(mesasMock);
//
//        List<MesaDTO> result = mesasBO.obtenerMesasPorTipo(tipo);
//        assertNotNull(result);
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    public void testInsertarMesas() throws ServicioException {
//        TipoMesaDTO tipo = new TipoMesaDTO();
//        UbicacionMesaDTO ubicacion = UbicacionMesaDTO.GENERAL; // Usa un valor válido de la enumeración
//        int cantidad = 5;
//
//        doNothing().when(mesasBO).insertarMesas(tipo, ubicacion, cantidad);
//
//        mesasBO.insertarMesas(tipo, ubicacion, cantidad);
//        verify(mesasBO, times(1)).insertarMesas(tipo, ubicacion, cantidad);
//    }
//
//    @Test
//    public void testEliminarMesa() throws ServicioException, NoEncontradoException {
//        String codigo = "M001";
//
//        doNothing().when(mesasBO).eliminarMesa(codigo);
//
//        mesasBO.eliminarMesa(codigo);
//        verify(mesasBO, times(1)).eliminarMesa(codigo);
//    }
//}
