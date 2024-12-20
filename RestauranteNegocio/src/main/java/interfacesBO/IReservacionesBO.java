package interfacesBO;

import dto.ReservacionDTO;
import excepciones.ServicioException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Define las operaciones necesarias para interactuar con los objetos de negocio
 *
 * @author neri
 */
public interface IReservacionesBO {

    /**
     * Obtiene la lista de reservaciones registradas de una mesa a partir de su
     * código.
     *
     * @param idRestaurante ID del restaurante en donde se quiere consultar las
     * reservas
     * @param codigoMesa Código de la mesa a buscar
     * @return Reservaciones de dicha mesa
     * @throws ServicioException si ocurre un error en la consulta
     */
    public List<ReservacionDTO> obtenerReservacionesDeMesa(Long idRestaurante, String codigoMesa) throws ServicioException;

    /**
     * Cancela la reservación con el ID dado y le asigna una multa por
     * cancelación.
     *
     * @param idReservacion ID de la reservación en cuestión
     * @throws ServicioException si ocurre un error en la cancelación
     */
    public void cancelarReservacion(Long idReservacion) throws ServicioException;

    /**
     * Obtiene una lista de todas las reservaciones almacenadas.
     *
     * @param idRestaurante ID del restaurante en cuestión
     * @return Una lista de objetos `ReservacionDTO`.
     * @throws ServicioException si ocurre un error durante la obtención de los
     * datos.
     */
    public List<ReservacionDTO> obtenerReservacionesTodos(Long idRestaurante) throws ServicioException;

    /**
     * Obtiene una lista de reservaciones dentro de un período de tiempo
     * específico.
     *
     * @param idRestaurante ID del restaurante en cuestión
     * @param fechaInicio La fecha y hora de inicio del período.
     * @param fechaFin La fecha y hora de fin del período.
     * @return Una lista de objetos `ReservacionDTO` que se encuentran en el
     * rango especificado.
     * @throws ServicioException si ocurre un error durante la obtención de los
     * datos.
     */
    public List<ReservacionDTO> obtenerReservacionesPorPeriodo(Long idRestaurante, LocalDateTime fechaInicio, LocalDateTime fechaFin) throws ServicioException;

    /**
     * Obtiene una lista de reservaciones asociadas a un cliente específico
     * basado en su número de teléfono.
     *
     * @param idRestaurante ID del restaurante en cuestión
     * @param telefono El número de teléfono del cliente.
     * @return Una lista de objetos `ReservacionDTO` pertenecientes al cliente.
     * @throws ServicioException si ocurre un error durante la obtención de los
     * datos.
     */
    public List<ReservacionDTO> obtenerReservacionesCliente(Long idRestaurante, String telefono) throws ServicioException;

    /**
     * Obtiene una reservación específica basada en su identificador único.
     *
     * @param id El identificador de la reservación.
     * @return Un objeto `ReservacionDTO` correspondiente al identificador
     * proporcionado.
     * @throws ServicioException si ocurre un error durante la obtención de los
     * datos.
     */
    public ReservacionDTO obtenerReservacionPorID(Long id) throws ServicioException;

    /**
     * Agrega una nueva reservación al sistema.
     *
     * @param reservacion El objeto `ReservacionDTO` que se desea agregar.
     * @throws ServicioException si ocurre un error durante la inserción de los
     * datos.
     */
    public void agregarReservacion(ReservacionDTO reservacion) throws ServicioException;

    /**
     * Actualiza los detalles de una reservación existente en el sistema.
     *
     * @param reservacion El objeto `ReservacionDTO` que contiene los datos
     * actualizados.
     * @throws ServicioException si ocurre un error durante la actualización de
     * los datos.
     */
    public void actualizarReservacion(ReservacionDTO reservacion) throws ServicioException;

    /**
     * Elimina una reservación del sistema basada en su identificador único.
     *
     * @param id El identificador de la reservación que se desea eliminar.
     * @throws ServicioException si ocurre un error durante la eliminación de
     * los datos.
     */
    public void eliminarReservacion(Long id) throws ServicioException;

}
