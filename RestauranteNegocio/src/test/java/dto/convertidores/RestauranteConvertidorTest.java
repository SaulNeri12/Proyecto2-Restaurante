/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dto.convertidores;

import dto.RestauranteDTO;
import entidades.Restaurante;
import java.time.LocalTime;
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
public class RestauranteConvertidorTest {
    
    public RestauranteConvertidorTest() {
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
     * Test of convertirAEntidad method, of class RestauranteConvertidor.
     */
    @Test
    public void testConvertirAEntidad() {
        System.out.println("convertirAEntidad");
        
        // arrange
        RestauranteDTO dto = new RestauranteDTO(
                1l,
                "Restaurante Sucursal 1",
                "23919012900",
                "Ali 11010. Col Faustino",
                LocalTime.now(),
                LocalTime.now().plusHours(10l)
        );
        
        // act
        Restaurante result = RestauranteConvertidor.convertirAEntidad(dto);
        
        // assert
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getNombre(), result.getNombre());
        assertEquals(dto.getTelefono(), result.getTelefono());
        assertEquals(dto.getDireccion(), result.getDireccion());
        assertEquals(dto.getHoraApertura(), result.getHoraApertura());
        assertEquals(dto.getHoraCierre(), result.getHoraCierre());
        assertNotNull(result.getMesas(), "La lista de mesas no debe ser null");
        assertEquals(dto.getMesas().size(), result.getMesas().size());
    }

    /**
     * Test of convertirADTO method, of class RestauranteConvertidor.
     */
    @Test
    public void testConvertirADTO() {
        System.out.println("convertirADTO");
        
        // arrange
        Restaurante entidad = new Restaurante(
                1l,
                "Restaurante Sucursal 1",
                "23919012900",
                "Ali 11010. Col Faustino",
                LocalTime.now(),
                LocalTime.now().plusHours(10l)
        );
        
        // act
        RestauranteDTO result = RestauranteConvertidor.convertirADTO(entidad);
        
        // assert
        assertEquals(entidad.getId(), result.getId());
        assertEquals(entidad.getNombre(), result.getNombre());
        assertEquals(entidad.getTelefono(), result.getTelefono());
        assertEquals(entidad.getDireccion(), result.getDireccion());
        assertEquals(entidad.getHoraApertura(), result.getHoraApertura());
        assertEquals(entidad.getHoraCierre(), result.getHoraCierre());
        assertNotNull(result.getMesas(), "La lista de mesas no debe ser null");
        assertEquals(entidad.getMesas().size(), result.getMesas().size());
    }
    
}
