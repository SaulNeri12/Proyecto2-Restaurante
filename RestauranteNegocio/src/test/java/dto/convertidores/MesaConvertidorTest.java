
package dto.convertidores;

import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import entidades.Mesa;
import entidades.TipoMesa;
import entidades.UbicacionMesa;
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
public class MesaConvertidorTest {
    private Converter<MesaDTO, Mesa> mesaConvertidor = new MesaConvertidor();
    private Converter<TipoMesaDTO, TipoMesa> tipoMesaConvertidor = new TipoMesaConvertidor();
    
    public MesaConvertidorTest() {
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
        TipoMesaDTO tipoMesa = new TipoMesaDTO();
        tipoMesa.setId(1l);
        tipoMesa.setMaximoPersonas(5);
        tipoMesa.setMinimoPersonas(2);
        tipoMesa.setNombre("Mesa Mediana");
        tipoMesa.setPrecio(10.0f);
        
        MesaDTO dto = new MesaDTO();
        dto.setId(1l);
        dto.setCodigo("SHESH-12345");
        dto.setTipoMesa(tipoMesa);
        dto.setUbicacion(UbicacionMesaDTO.VENTANA);
        
        // act
        Mesa result = this.mesaConvertidor.convertFromDto(dto);
        
        // assert
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getCodigo(), result.getCodigo());
        assertEquals(dto.getTipoMesa(), this.tipoMesaConvertidor.convertFromEntity(result.getTipoMesa()));
        assertEquals(dto.getUbicacion().toString(), result.getUbicacion().toString());
        
    }

    /**
     * Realiza una prueba a la operacion de conversion de Entidad a DTO
     */
    @Test
    public void testConvertirADTO() {
        System.out.println("convertirADTO");

        // arrange
        TipoMesa tipoMesa = new TipoMesa();
        tipoMesa.setId(1L);
        tipoMesa.setMaximoPersonas(5);
        tipoMesa.setMinimoPersonas(2);
        tipoMesa.setNombre("Mesa Mediana");
        tipoMesa.setPrecio(10.0f);
        
        Mesa mesa = new Mesa();
        mesa.setId(1l);
        mesa.setCodigo("SHESH-12345");
        mesa.setTipoMesa(tipoMesa);
        mesa.setUbicacion(UbicacionMesa.VENTANA);

        // act
        MesaDTO resultDto = this.mesaConvertidor.convertFromEntity(mesa);

        // assert
        assertEquals(mesa.getId(), resultDto.getId());
        assertEquals(mesa.getCodigo(), resultDto.getCodigo());
        assertEquals(this.tipoMesaConvertidor.convertFromEntity(mesa.getTipoMesa()), resultDto.getTipoMesa());
        assertEquals(mesa.getUbicacion().toString(), resultDto.getUbicacion().toString());

    }

}
