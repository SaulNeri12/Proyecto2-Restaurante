/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao.implementaciones;

import conexion.Conexion;
import dao.interfaces.IClientesDAO;
import entidades.Cliente;
import excepciones.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase concreta de IClientesDAO
 * @author Saul Neri
 */
public class ClientesDAO implements IClientesDAO {

    private static IClientesDAO instancia;

    private ClientesDAO() {
    }
    
    public static IClientesDAO getInstance() {
        if (instancia == null) {
            instancia = new ClientesDAO();
        }
        
        return instancia;
    }
    
    @Override
    public void insercionMasivaClientes(List<Cliente> clientes) throws DAOException {
        
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        
        try {
            for (Cliente cliente : clientes) {
                entityManager.persist(cliente);
            }
            entityManager.flush();
        } catch (Exception e) {
            throw new DAOException("Error al insertar clientes de manera masiva.");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Cliente> obtenerClientesTodos() throws DAOException {
         
        EntityManager entityManager = Conexion.getInstance().crearConexion();
        
        try {
            TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DAOException("Error al obtener la lista de todos los clientes");
        } finally {
            entityManager.close();
        }
    }
}
