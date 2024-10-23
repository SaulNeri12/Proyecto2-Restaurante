
package dao.interfaces;

import entidades.Reservacion;
import excepciones.DAOException;
import java.time.Instant;
import java.util.List;

/**
 * Define las operaciones para el DAO de reservaciones
 * @author neri
 */
public interface IReservacionesDAO {

    /**
     * Obtiene una lista de todas las reservaciones almacenadas.
     *
     * @return Una lista de objetos `Reservacion`.
     * @throws DAOException Si ocurre un error durante la obtención de los
     * datos.
     */
    public List<Reservacion> obtenerReservacionesTodos() throws DAOException;

    /**
     * Obtiene una lista de reservaciones dentro de un período de tiempo
     * específico.
     *
     * @param fechaInicio La fecha y hora de inicio del período.
     * @param fechaFin La fecha y hora de fin del período.
     * @return Una lista de objetos `Reservacion` que se encuentran en el rango
     * especificado.
     * @throws DAOException Si ocurre un error durante la obtención de los
     * datos.
     */
    public List<Reservacion> obtenerReservacionesPorPeriodo(Instant fechaInicio, Instant fechaFin) throws DAOException;

    /**
     * Obtiene una lista de reservaciones asociadas a un cliente específico
     * basado en su número de teléfono.
     *
     * @param telefono El número de teléfono del cliente.
     * @return Una lista de objetos `Reservacion` pertenecientes al cliente.
     * @throws DAOException Si ocurre un error durante la obtención de los
     * datos.
     */
    public List<Reservacion> obtenerReservacionesCliente(String telefono) throws DAOException;

    /**
     * Obtiene una reservación específica basada en su identificador único.
     *
     * @param id El identificador de la reservación.
     * @return Un objeto `Reservacion` correspondiente al identificador
     * proporcionado.
     * @throws DAOException Si ocurre un error durante la obtención de los
     * datos.
     */
    public Reservacion obtenerReservacionPorID(Long id) throws DAOException;

    /**
     * Agrega una nueva reservación al sistema.
     *
     * @param reservacion El objeto `Reservacion` que se desea agregar.
     * @throws DAOException Si ocurre un error durante la inserción de los
     * datos.
     */
    public void agregarReservacion(Reservacion reservacion) throws DAOException;

    /**
     * Actualiza los detalles de una reservación existente en el sistema.
     *
     * @param reservacion El objeto `Reservacion` que contiene los datos
     * actualizados.
     * @throws DAOException Si ocurre un error durante la actualización de los
     * datos.
     */
    public void actualizarReservacion(Reservacion reservacion) throws DAOException;

    /**
     * Elimina una reservación del sistema basada en su identificador único.
     *
     * @param id El identificador de la reservación que se desea eliminar.
     * @throws DAOException Si ocurre un error durante la eliminación de los
     * datos.
     */
    public void eliminarReservacion(Long id) throws DAOException;
}
