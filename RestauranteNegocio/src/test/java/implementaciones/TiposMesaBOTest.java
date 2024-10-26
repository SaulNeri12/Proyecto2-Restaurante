/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import dao.interfaces.ITiposMesaDAO;
import dto.TipoMesaDTO;
import dto.convertidores.TipoMesaConvertidor;
import entidades.TipoMesa;
import excepciones.DAOException;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.ITiposMesaBO;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class TiposMesaBOTest {
    
    @Mock
    private ITiposMesaDAO tiposMesaDAO;
    
    @InjectMocks
    private TiposMesaBO tiposMesaBO;
    
    private TipoMesaDTO tipoMesaDTO;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Inicialización de un TipoMesaDTO de ejemplo
        tipoMesaDTO = new TipoMesaDTO();
        tipoMesaDTO.setId(1L);
        tipoMesaDTO.setNombre("Mesa de ejemplo");
        tipoMesaDTO.setMaximoPersonas(6);
        tipoMesaDTO.setMinimoPersonas(2);
        tipoMesaDTO.setPrecio(100.0f);
    }

    @Test
public void testObtenerTiposMesaTodos() throws ServicioException {
    // Crear una lista que contenga un TipoMesa de ejemplo
    List<TipoMesa> listaTiposMesa = new ArrayList<>();
    listaTiposMesa.add(new TipoMesa()); // Simula que el DAO devuelve al menos un tipo de mesa
        try {
            // Configuramos el comportamiento del mock
            when(tiposMesaDAO.obtenerTiposMesaTodos()).thenReturn(listaTiposMesa);
        } catch (DAOException ex) {
            Logger.getLogger(TiposMesaBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    List<TipoMesaDTO> resultado = tiposMesaBO.obtenerTiposMesaTodos();
    
    assertNotNull(resultado);
    assertEquals(1, resultado.size());
}

@Test
public void testEliminarTipoMesaNoEncontrado() throws ServicioException {
        try {
            // Configura el mock para lanzar NoEncontradoException específicamente
            doThrow(new NoEncontradoException("Tipo de mesa no encontrado"))
                    .when(tiposMesaDAO).eliminarTipoMesa(tipoMesaDTO.getId());
        } catch (DAOException ex) {
            Logger.getLogger(TiposMesaBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    // Verificamos que al eliminar, lanza la excepción NoEncontradoException
    Exception exception = assertThrows(NoEncontradoException.class, () -> {
        tiposMesaBO.eliminarTipoMesa(tipoMesaDTO.getId());
    });
    
    assertEquals("Tipo de mesa no encontrado", exception.getMessage());
}

@Test
public void testAgregarTipoMesaServicioException() throws ServicioException {
        try {
            // Configura el mock para que lanzar una excepción de ServicioException
            doThrow(new ServicioException("Error al agregar tipo de mesa"))
                    .when(tiposMesaDAO).agregarTipoMesa(any());
        } catch (DAOException ex) {
            Logger.getLogger(TiposMesaBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    // Verificamos que lanza ServicioException
    Exception exception = assertThrows(ServicioException.class, () -> {
        tiposMesaBO.agregarTipoMesa(tipoMesaDTO);
    });
    
    assertEquals("Error al agregar tipo de mesa", exception.getMessage());
}


    @Test
    public void testAgregarTipoMesa() throws ServicioException {
        try {
            doNothing().when(tiposMesaDAO).agregarTipoMesa(any());
        } catch (DAOException ex) {
            Logger.getLogger(TiposMesaBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertDoesNotThrow(() -> tiposMesaBO.agregarTipoMesa(tipoMesaDTO));
    }

    @Test
    public void testEliminarTipoMesaExitoso() throws ServicioException, NoEncontradoException {
        try {
            // Configura el mock para que no lance excepciones al eliminar
            doNothing().when(tiposMesaDAO).eliminarTipoMesa(tipoMesaDTO.getId());
        } catch (DAOException ex) {
            Logger.getLogger(TiposMesaBOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Prueba la eliminación
        assertDoesNotThrow(() -> tiposMesaBO.eliminarTipoMesa(tipoMesaDTO.getId()));
    }

    
}
