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
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.IReservacionesBO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementación de la interfaz IReservacionesBO para manejar la lógica de negocio
 * relacionada con las reservaciones. Implementa el patrón Singleton.
 * 
 * @author caarl
 */
public class ReservacionesBO implements IReservacionesBO {

    private final IReservacionesDAO reservacionesDAO;
    private final ReservacionConvertidor reservacionConvertidor;
    
    // Instancia única de la clase
    private static ReservacionesBO instance;
    
    /**
     * Constructor privado para implementar Singleton.
     */
    private ReservacionesBO() {
        this.reservacionesDAO = ReservacionesDAO.getInstance();
        this.reservacionConvertidor = new ReservacionConvertidor();
    }
    
    /**
     * Método para obtener la instancia única de ReservacionesBO.
     * @return instancia única de ReservacionesBO
     */
    public static synchronized ReservacionesBO getInstance() {
        if (instance == null) {
            instance = new ReservacionesBO();
        }
        return instance;
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesDeMesa(String codigoMesa) throws ServicioException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesDeMesa(codigoMesa);
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void cancelarReservacion(Long idReservacion) throws ServicioException {
        try {
            reservacionesDAO.cancelarReservacion(idReservacion);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesTodos(Long idReservacion) throws ServicioException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesTodos();
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws ServicioException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesPorPeriodo(fechaInicio, fechaFin);
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesCliente(String telefono) throws ServicioException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesCliente(telefono);
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public ReservacionDTO obtenerReservacionPorID(Long id) throws ServicioException {
        try {
            Reservacion reservacion = reservacionesDAO.obtenerReservacionPorID(id);
            return reservacionConvertidor.convertFromEntity(reservacion);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void agregarReservacion(ReservacionDTO reservacion) throws ServicioException {
        try {
            Reservacion entidad = reservacionConvertidor.convertFromDto(reservacion);
            // TODO: aqui tambien puedes evaluar si la reservacion se sale del horario del restaurante
            reservacionesDAO.agregarReservacion(entidad);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void actualizarReservacion(ReservacionDTO reservacion) throws ServicioException, NoEncontradoException {
        try {
            Reservacion entidad = reservacionConvertidor.convertFromDto(reservacion);
            reservacionesDAO.actualizarReservacion(entidad);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }

    @Override
    public void eliminarReservacion(Long id) throws ServicioException, NoEncontradoException {
        try {
            reservacionesDAO.eliminarReservacion(id);
        } catch (DAOException e) {
            throw new ServicioException(e.getMessage());
        }
    }
}