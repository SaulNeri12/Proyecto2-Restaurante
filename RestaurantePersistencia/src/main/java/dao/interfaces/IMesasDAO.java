
package dao.interfaces;

import entidades.Mesa;
import entidades.TipoMesa;
import entidades.UbicacionMesa;
import excepciones.DAOException;
import java.util.List;

/**
 * Define las operaciones necesarias para las mesas en el restaurante
 * @author neri
 */
public interface IMesasDAO {
    
    /**
     * Devuelve todas las mesas registradas en el sistema
     * @return
     * @throws DAOException Si ocurre un error en la consulta
     */
    public List<Mesa> obtenerMesasTodas() throws DAOException;
    
    /**
     * Devuelve todas las mesas del tipo especificado
     * @param tipo Tipo de mesa
     * @return
     * @throws DAOException Si ocurre un error en la consulta
     */
    public List<Mesa> obtenerMesasPorTipo(TipoMesa tipo) throws DAOException;
    
    /**
     * Inserta de manera "masiva" el numero dado de mesas con el tipo y
     * ubicacion especifica.
     * @param tipo Tipo de mesas a insertar
     * @param ubicacion Ubicacion de las mesas a insertar
     * @param cantidad Cantidad de las mesas a insertar
     * @throws DAOException 
     */
    public void insertarMesas(TipoMesa tipo, UbicacionMesa ubicacion, int cantidad) throws DAOException;
    
    /**
     * Elimina una mesa en el sistema por su codigo especificado
     * @param codigo Codigo de la mesa a eliminar
     * @throws DAOException Si ocurre un error en la eliminacion
     */
    public void eliminarMesa(String codigo) throws DAOException;
}
