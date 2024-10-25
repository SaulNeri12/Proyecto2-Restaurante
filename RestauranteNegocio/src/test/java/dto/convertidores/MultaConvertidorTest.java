/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dto.convertidores;

import dto.MultaDTO;
import entidades.Multa;
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
public class MultaConvertidorTest {
    private Converter<MultaDTO, Multa> multaConvertidor = new MultaConvertidor();
    
    public MultaConvertidorTest() {
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
     * Realiza una prueba a la operacion de conversion de DTO a Entidad
     */
    @Test
    public void testConvertirAEntidad() {
        System.out.println("convertirAEntidad");
        
        // arrange
        MultaDTO dto = new MultaDTO();
        dto.setId(1l);
        dto.setDescripcion("Multa del 25% por llegar tarde");
        dto.setPorcentaje(25.0f);
        
        // act
        Multa result = this.multaConvertidor.convertFromDto(dto);
        
        // assert
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getDescripcion(), result.getDescripcion());
        assertEquals(dto.getPorcentaje(), result.getPorcentaje());
    }

    /**
     * Realiza una prueba a la operacion de conversion de Entidad a DTO
     */
    @Test
    public void testConvertirADTO() {
        System.out.println("convertirADTO");
        
        // arrange
        Multa multa = new Multa();
        multa.setId(1L);
        multa.setDescripcion("Multa del 25% por llegar tarde");
        multa.setPorcentaje(25.0f);

        // act
        MultaDTO resultDto = this.multaConvertidor.convertFromEntity(multa);

        // assert
        assertEquals(multa.getId(), resultDto.getId());
        assertEquals(multa.getDescripcion(), resultDto.getDescripcion());
        assertEquals(multa.getPorcentaje(), resultDto.getPorcentaje());

    }

}
