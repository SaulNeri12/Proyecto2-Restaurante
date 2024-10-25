/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dao.interfaces.IReservacionesDAO;
import dto.ReservacionDTO;
import dto.convertidores.ReservacionConvertidor;
import entidades.Reservacion;
import excepciones.BOException;
import excepciones.DAOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author caarl
 */
public class ReservacionesBO {

    private static ReservacionesBO instancia;
    private final IReservacionesDAO reservacionesDAO;
    private final ReservacionConvertidor reservacionConvertidor;

    // Constructor privado para evitar la instanciación directa
    private ReservacionesBO(IReservacionesDAO reservacionesDAO) {
        this.reservacionesDAO = reservacionesDAO;
        this.reservacionConvertidor = new ReservacionConvertidor();
    }

    /**
     * Método estático para obtener la única instancia de la clase.
     * @param reservacionesDAO Implementación de IReservacionesDAO que será utilizada en la instancia.
     * @return La instancia única de ReservacionesBO.
     */
    public static ReservacionesBO getInstance(IReservacionesDAO reservacionesDAO) {
        if (instancia == null) {
            instancia = new ReservacionesBO(reservacionesDAO);
        }
        return instancia;
    }

    // Métodos del BO

    public List<ReservacionDTO> obtenerReservacionesTodos() throws BOException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesTodos();
            return reservaciones.stream()
        .map(reservacion -> reservacionConvertidor.convertirADTO(reservacion))
        .collect(Collectors.toList());


        } catch (DAOException e) {
            throw new BOException("Error al obtener todas las reservaciones", e);
        }
    }

    public List<ReservacionDTO> obtenerReservacionesDeMesa(String codigoMesa) throws BOException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesDeMesa(codigoMesa);
           return reservaciones.stream()
        .map(reservacion -> reservacionConvertidor.convertirADTO(reservacion))
        .collect(Collectors.toList());

        } catch (DAOException e) {
            throw new BOException("Error al obtener reservaciones de la mesa", e);
        }
    }

    public List<ReservacionDTO> obtenerReservacionesPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws BOException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesPorPeriodo(fechaInicio, fechaFin);
           return reservaciones.stream()
        .map(reservacion -> reservacionConvertidor.convertirADTO(reservacion))
        .collect(Collectors.toList());

        } catch (DAOException e) {
            throw new BOException("Error al obtener reservaciones por periodo", e);
        }
    }

    public List<ReservacionDTO> obtenerReservacionesCliente(String telefono) throws BOException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesCliente(telefono);
            return reservaciones.stream()
        .map(reservacion -> reservacionConvertidor.convertirADTO(reservacion))
        .collect(Collectors.toList());

        } catch (DAOException e) {
            throw new BOException("Error al obtener reservaciones del cliente", e);
        }
    }

    public void agregarReservacion(ReservacionDTO reservacionDTO) throws BOException {
        try {
            Reservacion reservacion = reservacionConvertidor.convertirAEntidad(reservacionDTO);
            reservacionesDAO.agregarReservacion(reservacion);
        } catch (DAOException e) {
            throw new BOException("Error al agregar la reservación", e);
        }
    }

    public void actualizarReservacion(ReservacionDTO reservacionDTO) throws BOException {
        try {
            Reservacion reservacion = reservacionConvertidor.convertirAEntidad(reservacionDTO);
            reservacionesDAO.actualizarReservacion(reservacion);
        } catch (DAOException e) {
            throw new BOException("Error al actualizar la reservación", e);
        }
    }

    public void eliminarReservacion(Long id) throws BOException {
        try {
            reservacionesDAO.eliminarReservacion(id);
        } catch (DAOException e) {
            throw new BOException("Error al eliminar la reservación", e);
        }
    }

    public void cancelarReservacion(Long idReservacion) throws BOException {
        try {
            reservacionesDAO.cancelarReservacion(idReservacion);
        } catch (DAOException e) {
            throw new BOException("Error al cancelar la reservación", e);
        }
    }
}