/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.IMesasBO;
import interfacesBO.ITiposMesaBO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MesasBOTest_SinMocks {

    private IMesasBO mesasBO = MesasBO.getInstance();
    private ITiposMesaBO tiposMesaBO = TiposMesaBO.getInstance();

    @BeforeEach
    public void setUp() {
        
    }

    @Test
    public void testObtenerMesasTodas() throws ServicioException {
        System.out.println("testObtenerMesasTodas");
        
        // arrange
        List<MesaDTO> result = null;
        
        // act
        result = mesasBO.obtenerMesasTodas();
        
        // assert
        assertNotNull(result, "La lista no debe ser null");
        assertTrue(!result.isEmpty(), "La lista no debe estar vacia");
        
    }

    @Test
    public void testObtenerMesasPorTipo_TipoPequenia() throws ServicioException {
        System.out.println("testObtenerMesasPorTipo_TipoPequenia");
        
        // arrange
        TipoMesaDTO tipo = this.tiposMesaBO.obtenerTiposMesaTodos()
                .stream()
                .filter(t -> t.getNombre().equalsIgnoreCase("pequenia"))
                .findFirst()
                .orElse(null);
        
        assertNotNull(tipo, "El tipo de mesa no debe ser null");
        
        // act
        List<MesaDTO> result = mesasBO.obtenerMesasPorTipo(tipo);
        
        // assert
        assertNotNull(result, "El resultado no debe ser null");
        assertTrue(!result.isEmpty(), "La lista no debe estar vacia");
    }
    
    @Test
    public void testObtenerMesasPorTipo_TipoMediana() throws ServicioException {
        System.out.println("testObtenerMesasPorTipo_TipoMediana");
        
        // arrange
        TipoMesaDTO tipo = this.tiposMesaBO.obtenerTiposMesaTodos()
                .stream()
                .filter(t -> t.getNombre().equalsIgnoreCase("mediana"))
                .findFirst()
                .orElse(null);
        
        assertNotNull(tipo, "El tipo de mesa no debe ser null");
        
        // act
        List<MesaDTO> result = mesasBO.obtenerMesasPorTipo(tipo);
        
        // assert
        assertNotNull(result, "El resultado no debe ser null");
        assertTrue(!result.isEmpty(), "La lista no debe estar vacia");
    }
    
    @Test
    public void testObtenerMesasPorTipo_TipoGrande() throws ServicioException {
        System.out.println("testObtenerMesasPorTipo_TipoGrande");
        
        // arrange
        TipoMesaDTO tipo = this.tiposMesaBO.obtenerTiposMesaTodos()
                .stream()
                .filter(t -> t.getNombre().equalsIgnoreCase("grande"))
                .findFirst()
                .orElse(null);
        
        assertNotNull(tipo, "El tipo de mesa no debe ser null");
        
        // act
        List<MesaDTO> result = mesasBO.obtenerMesasPorTipo(tipo);
        
        // assert
        assertNotNull(result, "El resultado no debe ser null");
        assertTrue(!result.isEmpty(), "La lista no debe estar vacia");
    }

    @Test
    public void testInsertarMesas() throws ServicioException {
        System.out.println("testInsertarMesas");
        
        // arrange
        TipoMesaDTO tipo = this.tiposMesaBO.obtenerTiposMesaTodos()
                .stream()
                .filter(t -> t.getNombre().equalsIgnoreCase("grande"))
                .findFirst()
                .orElse(null);
        
        UbicacionMesaDTO ubicacion = UbicacionMesaDTO.GENERAL;
        int cantidad = 5;

        // act
        mesasBO.insertarMesas(tipo, ubicacion, cantidad);

        // assert
    }

    @Test
    public void testEliminarMesa() throws ServicioException, NoEncontradoException {
        System.out.println("testEliminarMesa");
        
        // arrange
        String codigo = "GEN-4-163";

        // act
        mesasBO.eliminarMesa(codigo);

        // assert
        
    }
}
