/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;


import dao.interfaces.IReservacionesDAO;
import dto.ReservacionDTO;
import dto.convertidores.ReservacionConvertidor;
import entidades.Reservacion;
import excepciones.NoEncontradoException;
import excepciones.ServicioException;
import interfacesBO.IReservacionesBO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementación de la interfaz IReservacionesBO para manejar la lógica de negocio
 * relacionada con las reservaciones.
 * 
 * @author Saul Neri
 */
public class ReservacionesBO implements IReservacionesBO {

    private final IReservacionesDAO reservacionesDAO;
    private final ReservacionConvertidor reservacionConvertidor;

    public ReservacionesBO(IReservacionesDAO reservacionesDAO) {
        this.reservacionesDAO = reservacionesDAO;
        this.reservacionConvertidor = new ReservacionConvertidor();
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesDeMesa(String codigoMesa) throws ServicioException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesDeMesa(codigoMesa);
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (Exception e) {
            throw new ServicioException("Error al obtener reservaciones de la mesa: " + codigoMesa);
        }
    }

    @Override
    public void cancelarReservacion(Long idReservacion) throws ServicioException, NoEncontradoException {
        try {
            reservacionesDAO.cancelarReservacion(idReservacion);
        }catch (Exception e) {
            throw new ServicioException("Error al cancelar la reservación con ID: " + idReservacion);
        }
       
        
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesTodos() throws ServicioException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesTodos();
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (Exception e) {
            throw new ServicioException("Error al obtener todas las reservaciones");
        }
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesPorPeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFin) throws ServicioException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesPorPeriodo(fechaInicio, fechaFin);
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (Exception e) {
            throw new ServicioException("Error al obtener reservaciones por periodo");
        }
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesCliente(String telefono) throws ServicioException {
        try {
            List<Reservacion> reservaciones = reservacionesDAO.obtenerReservacionesCliente(telefono);
            return reservacionConvertidor.createFromEntities(reservaciones);
        } catch (Exception e) {
            throw new ServicioException("Error al obtener reservaciones del cliente con teléfono: " + telefono);
        }
    }

    @Override
    public ReservacionDTO obtenerReservacionPorID(Long id) throws ServicioException {
        try {
            Reservacion reservacion = reservacionesDAO.obtenerReservacionPorID(id);
            return reservacionConvertidor.convertFromEntity(reservacion);
        } catch (Exception e) {
            throw new ServicioException("Error al obtener reservación con ID: " + id);
        }
    }

    @Override
    public void agregarReservacion(ReservacionDTO reservacion) throws ServicioException {
        try {
            Reservacion entidad = reservacionConvertidor.convertFromDto(reservacion);
            reservacionesDAO.agregarReservacion(entidad);
        } catch (Exception e) {
            throw new ServicioException("Error al agregar la reservación");
        }
    }

    @Override
    public void actualizarReservacion(ReservacionDTO reservacion) throws ServicioException, NoEncontradoException {
        try {
            Reservacion entidad = reservacionConvertidor.convertFromDto(reservacion);
            reservacionesDAO.actualizarReservacion(entidad);
        }catch (Exception e) {
            throw new ServicioException("Error al actualizar la reservación");
        }
       
        
    }

    @Override
    public void eliminarReservacion(Long id) throws ServicioException, NoEncontradoException {
        try {
            reservacionesDAO.eliminarReservacion(id);
        }catch (Exception e) {
            throw new ServicioException("Error al eliminar la reservación con ID: " + id);
        }
        
        
    }
}