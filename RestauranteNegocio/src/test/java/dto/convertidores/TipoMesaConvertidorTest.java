/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dto.convertidores;

import dto.TipoMesaDTO;
import entidades.TipoMesa;
import dto.convertidores.TipoMesaConvertidor;
import dto.convertidores.Converter;
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
public class TipoMesaConvertidorTest {
    
    private Converter<TipoMesaDTO, TipoMesa> tipoMesaConvertidor;
    
    public TipoMesaConvertidorTest() {
        this.tipoMesaConvertidor = new TipoMesaConvertidor();
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
     * Test of convertirAEntidad method, of class TipoMesaConvertidor.
     */
    @Test
    public void testConvertirAEntidad() {
        System.out.println("convertirAEntidad");
        
        // arrange
        TipoMesaDTO dto = new TipoMesaDTO();
        dto.setId(1l);
        dto.setMaximoPersonas(10);
        dto.setMinimoPersonas(2);
        dto.setNombre("Mesa Chica");
        dto.setPrecio(10.0f);
        
        // act
        TipoMesa result = this.tipoMesaConvertidor.convertFromDto(dto);
        
        // assert
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getMaximoPersonas(), result.getMaximoPersonas());
        assertEquals(dto.getMinimoPersonas(), result.getMinimoPersonas());
        assertEquals(dto.getNombre(), result.getNombre());
        assertEquals(dto.getPrecio(), result.getPrecio());
    }

    /**
     * Test of convertirADTO method, of class TipoMesaConvertidor.
     */
    @Test
    public void testConvertirADTO() {
        System.out.println("convertirADTO");
        // arrange
        
        TipoMesa entity = new TipoMesa();
        entity.setId(1l);
        entity.setMaximoPersonas(10);
        entity.setMinimoPersonas(2);
        entity.setNombre("Mesa Chica");
        entity.setPrecio(10.0f);
        
        // act
        TipoMesaDTO result = this.tipoMesaConvertidor.convertFromEntity(entity);
        
        // assert
        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getMaximoPersonas(), result.getMaximoPersonas());
        assertEquals(entity.getMinimoPersonas(), result.getMinimoPersonas());
        assertEquals(entity.getNombre(), result.getNombre());
        assertEquals(entity.getPrecio(), result.getPrecio());
    }
    
}
