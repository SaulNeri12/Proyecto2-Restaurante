
package implementaciones;

import dto.TipoMesaDTO;
import entidades.TipoMesa;
import excepciones.DAOException;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.ITiposMesaBO;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class TiposMesaBOTest_SinMocks {

    private ITiposMesaBO tiposMesaBO = TiposMesaBO.getInstance();

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testObtenerTiposMesaTodos() throws ServicioException {
        // arrange
        
        // act
        List<TipoMesaDTO> resultado = tiposMesaBO.obtenerTiposMesaTodos();

        // assert
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty(), "La lista no debe estar vacia");
    }

    @Test
    public void testAgregarTipoMesa_ServicioException() throws ServicioException {

        // arrange
        TipoMesaDTO tipo = new TipoMesaDTO();
        tipo.setMaximoPersonas(10);
        tipo.setMinimoPersonas(7);
        tipo.setNombre("Extra Grande");
        tipo.setPrecio(1000.f);

        // act
        
        // assert
        assertThrows(ServicioException.class, () -> {
            tiposMesaBO.agregarTipoMesa(tipo);
        });
    }

    @Test
    public void testAgregarTipoMesa() throws ServicioException {
        // arrange
        TipoMesaDTO tipo = new TipoMesaDTO();
        tipo.setMaximoPersonas(10);
        tipo.setMinimoPersonas(7);
        tipo.setNombre("Extra Grande");
        tipo.setPrecio(1000.f);

        // act
        tiposMesaBO.agregarTipoMesa(tipo);
        
        // assert
            
    }

    @Test
    public void testEliminarTipoMesa_Exitoso() throws ServicioException, NoEncontradoException {
        // arrange
        Long id = 10l;
        
        // act
        this.tiposMesaBO.eliminarTipoMesa(id);
        
        // assert
    }
    
    @Test
    public void testEliminarTipoMesa_NoEncontrado() throws ServicioException {
        // arrange
        Long id = 1000l;
        
        // act
        
        // assert
        assertThrows(ServicioException.class, () -> {
            tiposMesaBO.eliminarTipoMesa(id);
        });
    }

}
