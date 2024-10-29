/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dao.interfaces.IReservacionesDAO;
import dao.implementaciones.ReservacionesDAO;
import dto.ReservacionDTO;
import dto.convertidores.ReservacionConvertidor;
import entidades.Reservacion;
import excepciones.DAOException;
import excepciones.ServicioException;
import interfacesBO.IReservacionesBO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementación de la interfaz IReservacionesBO para manejar la lógica de negocio
 * relacionada con las reservaciones. Implementa el patrón Singleton para asegurar
 * que solo exista una instancia de esta clase.
 * 
 * @autor caarl
 */
public class ReservacionesBO implements IReservacionesBO {

    // DAO para acceder a los datos de reservaciones
    private final IReservacionesDAO reservacionesDAO;
    
    // Convertidor para transformar entidades a DTOs y viceversa
    private final ReservacionConvertidor reservacionConvertidor;

    // Instancia única de la clase
    private static ReservacionesBO instance;

    /**
     * Constructor privado para implementar el patrón Singleton.
     * Inicializa el DAO y el convertidor.
     */
    private ReservacionesBO() {
        this.reservacionesDAO = ReservacionesDAO.getInstance(); // Obtiene la instancia del DAO
        this.reservacionConvertidor = new ReservacionConvertidor(); // Crea un nuevo convertidor
    }

    /**
     * Método para obtener la instancia única de ReservacionesBO.
     * Se utiliza sincronización para asegurar que no se creen instancias
     * simultáneamente en un entorno multihilo.
     * 
     * @return instancia única de ReservacionesBO
     */
    public static synchronized ReservacionesBO getInstance() {
        if (instance == null) {
            instance = new ReservacionesBO(); // Crea una nueva instancia si no existe
        }
        return instance; // Retorna la instancia existente
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesDeMesa(Long idRestaurante, String codigoMesa) throws ServicioException {
        try {
            // Obtiene las reservaciones de la mesa especificada a través del DAO
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesDeMesa(idRestaurante, codigoMesa);
            // Convierte la lista de entidades a DTOs antes de devolverla
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void cancelarReservacion(Long idReservacion) throws ServicioException {
        try {
            // Cancela la reservación a través del DAO
            reservacionesDAO.cancelarReservacion(idReservacion);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesTodos(Long idRestaurante) throws ServicioException {
        try {
            // Obtiene todas las reservaciones del restaurante especificado
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesTodos(idRestaurante);
            // Convierte la lista de entidades a DTOs antes de devolverla
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesPorPeriodo(Long idRestaurante, LocalDateTime fechaInicio, LocalDateTime fechaFin) throws ServicioException {
        try {
            // Obtiene las reservaciones dentro del periodo especificado
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesPorPeriodo(idRestaurante, fechaInicio, fechaFin);
            // Convierte la lista de entidades a DTOs antes de devolverla
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesCliente(Long idRestaurante, String telefono) throws ServicioException {
        try {
            // Obtiene las reservaciones de un cliente específico basado en su número de teléfono
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesCliente(idRestaurante, telefono);
            // Convierte la lista de entidades a DTOs antes de devolverla
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public ReservacionDTO obtenerReservacionPorID(Long id) throws ServicioException {
        try {
            // Obtiene una reservación por su ID
            Reservacion reservacion = reservacionesDAO.obtenerReservacionPorID(id);
            // Convierte la entidad a DTO antes de devolverla
            return reservacionConvertidor.convertFromEntity(reservacion);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void agregarReservacion(ReservacionDTO reservacion) throws ServicioException {
        try {
            // Convierte el DTO a la entidad correspondiente
            Reservacion entidad = reservacionConvertidor.convertFromDto(reservacion);
            // Agrega la nueva reservación a través del DAO
            reservacionesDAO.agregarReservacion(entidad);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void actualizarReservacion(ReservacionDTO reservacion) throws ServicioException {
        try {
            // Convierte el DTO a la entidad correspondiente
            Reservacion entidad = reservacionConvertidor.convertFromDto(reservacion);
            // Actualiza la reservación existente a través del DAO
            reservacionesDAO.actualizarReservacion(entidad);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void eliminarReservacion(Long id) throws ServicioException {
        try {
            // Elimina la reservación del sistema a través del DAO
            reservacionesDAO.eliminarReservacion(id);
        } catch (DAOException e) {
            // Captura la excepción del DAO y lanza una excepción de servicio
            throw new ServicioException(e.getMessage());
        }
    }
}
