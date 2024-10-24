
package dao.implementaciones;

import dao.interfaces.IMesasDAO;
import entidades.Mesa;
import entidades.TipoMesa;
import entidades.UbicacionMesa;
import java.util.List;
import java.util.stream.Collectors;
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
public class MesasDAOTest {
    private IMesasDAO instancia;
    
    public MesasDAOTest() {
        this.instancia = MesasDAO.getInstance();
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
     * Test of obtenerMesasTodas method, of class MesasDAO.
     */
    @Test
    public void testObtenerMesasTodas() throws Exception {
        System.out.println("obtenerMesasTodas");
        List<Mesa> result = instancia.obtenerMesasTodas();
        assertNotNull(result, "La lista de mesas no debe ser null");
    }

    /**
     * Test of obtenerMesasPorTipo method, of class MesasDAO.
     */
    @Test
    public void testObtenerMesasPorTipo() throws Exception {
        System.out.println("obtenerMesasPorTipo");
        TipoMesa tipo = instancia.obtenerTiposMesaTodos().getFirst();
        List<Mesa> result = instancia.obtenerMesasPorTipo(tipo);
        assertNotNull(result, "La lista de mesas no debe ser nula");
    }

    /**
     * Test of eliminarMesa method, of class MesasDAO.
     */
    @Test
    public void testEliminarMesa() throws Exception {
        System.out.println("eliminarMesa");
        String codigo = "VEN-8-121";
        instancia.eliminarMesa(codigo);
    }

    /**
     * Test of insertarMesas method, of class MesasDAO.
    */ 
    @Test
    public void testInsertarMesas_TipoPequenia() throws Exception {
        System.out.println("insertarMesas - mesas pequenas");
        
        // arrange
        TipoMesa tipo = instancia.obtenerTiposMesaTodos()
                .stream()
                .filter(t -> t.getNombre().equalsIgnoreCase("pequenia"))
                .findFirst()
                .orElse(null);
        
        assertNotNull(tipo, "El tipo de mesa no debe ser null");
        
        UbicacionMesa ubicacion = UbicacionMesa.TERRAZA;
        
        int cantidad = 15;
        
        // act
        instancia.insertarMesas(tipo, ubicacion, cantidad);
        
        // assert
    }
    
    /**
     * Test of insertarMesas method, of class MesasDAO.
    */ 
    @Test
    public void testInsertarMesas_TipoMediana() throws Exception {
        System.out.println("insertarMesas - mesas medianas");
        
        // arrange
        TipoMesa tipo = instancia.obtenerTiposMesaTodos()
                .stream()
                .filter(t -> t.getNombre().equalsIgnoreCase("mediana"))
                .findFirst()
                .orElse(null);
        
        assertNotNull(tipo, "El tipo de mesa no debe ser null");
        
        UbicacionMesa ubicacion = UbicacionMesa.GENERAL;
        
        int cantidad = 10;
        
        // act
        instancia.insertarMesas(tipo, ubicacion, cantidad);
        
        // assert
    }
    
    /**
     * Test of insertarMesas method, of class MesasDAO.
    */ 
    @Test
    public void testInsertarMesas_TipoGrande() throws Exception {
        System.out.println("insertarMesas - mesas grandes");
        
        // arrange
        TipoMesa tipo = instancia.obtenerTiposMesaTodos()
                .stream()
                .filter(t -> t.getNombre().equalsIgnoreCase("grande"))
                .findFirst()
                .orElse(null);
        
        assertNotNull(tipo, "El tipo de mesa no debe ser null");
        
        UbicacionMesa ubicacion = UbicacionMesa.VENTANA;
        
        int cantidad = 10;
        
        // act
        instancia.insertarMesas(tipo, ubicacion, cantidad);
        
        // assert
    }
    
    /**
     * Test of insertarMesas method, of class MesasDAO.
     */
    @Test
    public void testInsertarMesas_CantidadMesasErronea() {
        System.out.println("insertarMesas");
        TipoMesa tipo = null;
        try {
            tipo = instancia.obtenerTiposMesaTodos().getFirst();
        } catch (Exception ex) {
            fail("No se pudo obtener el tipo de mesa");
            return;
        }
        
        UbicacionMesa ubicacion = UbicacionMesa.VENTANA;
        int cantidad = 0;
        try {
            instancia.insertarMesas(tipo, ubicacion, cantidad);
            fail("Debio haber dado error debido a la cantidad de mesas (0)");
        } catch (Exception ex) {
            
        }
    }

    /**
     * Test of obtenerTiposMesaTodos method, of class MesasDAO.
     */
    @Test
    public void testObtenerTiposMesaTodos() throws Exception {
        System.out.println("obtenerTiposMesaTodos");
        List<TipoMesa> result = instancia.obtenerTiposMesaTodos();
        assertNotNull(result, "La lista de tipos de mesa no debe ser null");
    }

    /**
     * Test of agregarTipoMesa method, of class MesasDAO.
     */
    @Test
    public void testAgregarTipoMesa_MesaPequena() throws Exception {
        System.out.println("agregarTipoMesa");
        TipoMesa tipoMesa = new TipoMesa();
        tipoMesa.setNombre("Pequenia");
        tipoMesa.setMaximoPersonas(2);
        tipoMesa.setMinimoPersonas(1);
        tipoMesa.setPrecio(300.f);
       
        instancia.agregarTipoMesa(tipoMesa);
    }
        
    /**
     * Test of agregarTipoMesa method, of class MesasDAO.
     */
    @Test
    public void testAgregarTipoMesa_MesaMediana() throws Exception {
        System.out.println("agregarTipoMesa Mediana");
        
        TipoMesa tipoMesa = new TipoMesa();
        tipoMesa.setNombre("Mediana");
        tipoMesa.setMaximoPersonas(4);
        tipoMesa.setMinimoPersonas(3);
        tipoMesa.setPrecio(500.f);
        
        instancia.agregarTipoMesa(tipoMesa);
    }
        
    /**
     * Test of agregarTipoMesa method, of class MesasDAO.
     */
    @Test
    public void testAgregarTipoMesa_MesaGrande() throws Exception {
        System.out.println("agregarTipoMesa Grande");
        
        TipoMesa tipoMesa = new TipoMesa();
        tipoMesa.setNombre("Grande");
        tipoMesa.setMaximoPersonas(8);
        tipoMesa.setMinimoPersonas(5);
        tipoMesa.setPrecio(700.f);
        
        instancia.agregarTipoMesa(tipoMesa);
    }

    /**
     * Test of eliminarTipoMesa method, of class MesasDAO.
     */
    @Test
    public void testEliminarTipoMesa() throws Exception {
        System.out.println("eliminarTipoMesa");
        Long id = 2l;
        instancia.eliminarTipoMesa(id);
    }
}
