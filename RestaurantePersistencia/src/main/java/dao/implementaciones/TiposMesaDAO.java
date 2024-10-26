
package dao.implementaciones;

import conexion.Conexion;
import dao.interfaces.ITiposMesaDAO;
import entidades.TipoMesa;
import excepciones.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * Clase concreta de la interfaz ITiposMesaDAO
 * @author Saul Neri
 */
public class TiposMesaDAO implements ITiposMesaDAO {

    private static ITiposMesaDAO instancia;

    private TiposMesaDAO() {
        
    }

    public static ITiposMesaDAO getInstance() {
        if (instancia == null) {
            instancia = new TiposMesaDAO();
        }
        return instancia;
    }
    
    @Override
    public List<TipoMesa> obtenerTiposMesaTodos() throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        try {
            TypedQuery<TipoMesa> query = entityManager.createQuery("SELECT t FROM TipoMesa t", TipoMesa.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los tipos de mesas");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void agregarTipoMesa(TipoMesa tipoMesa) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(tipoMesa);
            transaction.commit();
        } catch (Exception e) {
            //transaction.rollback();
            System.out.println(e.getMessage());
            throw new DAOException("Error al agregar el tipo de mesa");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarTipoMesa(Long id) throws DAOException {
        EntityManager entityManager = Conexion.getInstance().crearConexion();

        try {
            entityManager.getTransaction().begin();

            TipoMesa tipoMesa = entityManager.find(TipoMesa.class, id);
            if (tipoMesa != null) {
                entityManager.remove(tipoMesa);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DAOException("Error al eliminar el tipo de mesa");
        } finally {
            entityManager.close();
        }
    }
}
