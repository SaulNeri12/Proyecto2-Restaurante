/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

/**
 *
 * @author Saul Neri
 */
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase DTO (Data Transfer Object) que representa una reservación en el sistema.
 * Esta clase se utiliza para transferir datos de una reservación entre diferentes capas de la aplicación.
 */
public class ReservacionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime fechaHora;
    private Integer numeroPersonas;
    private EstadoReservacionDTO estado;
    private MesaDTO mesa;
    private ClienteDTO cliente;
    private Float montoTotal;
    private MultaDTO multa;

    /**
     * Constructor por defecto que inicializa una nueva instancia de ReservacionDTO.
     * Se establece el estado por defecto a PENDIENTE.
     */
    public ReservacionDTO() {
        this.estado = EstadoReservacionDTO.PENDIENTE; 
    }

    public ReservacionDTO(Long id, LocalDateTime fechaHora, Integer numeroPersonas, EstadoReservacionDTO estado, MesaDTO mesa, ClienteDTO cliente, Float montoTotal, MultaDTO multa) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.numeroPersonas = numeroPersonas;
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
        this.multa = multa;
    }

    public ReservacionDTO(LocalDateTime fechaHora, Integer numeroPersonas, EstadoReservacionDTO estado, MesaDTO mesa, ClienteDTO cliente, Float montoTotal, MultaDTO multa) {
        this.fechaHora = fechaHora;
        this.numeroPersonas = numeroPersonas;
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
        this.multa = multa;
    }
    
    

    /**
     * Constructor que inicializa una nueva instancia de ReservacionDTO con un identificador específico.
     * 
     * @param id El identificador único de la reservación.
     */
    public ReservacionDTO(Long id) {
        this.id = id;
        this.estado = EstadoReservacionDTO.PENDIENTE; 
    }

    /**
     * Obtiene el identificador único de la reservación.
     * 
     * @return El identificador único de la reservación.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la reservación.
     * 
     * @param id El identificador único de la reservación a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora de la reservación.
     * 
     * @return La fecha y hora de la reservación.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la reservación.
     * 
     * @param fechaHora La fecha y hora de la reservación a establecer.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el número de personas para la reservación.
     * 
     * @return El número de personas de la reservación.
     */
    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    /**
     * Establece el número de personas para la reservación.
     * 
     * @param numeroPersonas El número de personas a establecer.
     */
    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    /**
     * Obtiene el estado de la reservación.
     * 
     * @return El estado de la reservación.
     */
    public EstadoReservacionDTO getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la reservación.
     * 
     * @param estado El estado de la reservación a establecer.
     */
    public void setEstado(EstadoReservacionDTO estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la mesa asociada a la reservación.
     * 
     * @return La mesa de la reservación, representada como un DTO.
     */
    public MesaDTO getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa asociada a la reservación.
     * 
     * @param mesa La mesa a establecer para la reservación, representada como un DTO.
     */
    public void setMesa(MesaDTO mesa) {
        this.mesa = mesa;
    }

    /**
     * Obtiene el cliente asociado a la reservación.
     * 
     * @return El cliente que realizó la reservación, representado como un DTO.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la reservación.
     * 
     * @param cliente El cliente a asignar, representado como un DTO.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el monto total de la reservación.
     * 
     * @return El monto total de la reservación.
     */
    public Float getMontoTotal() {
        return montoTotal;
    }

    /**
     * Establece el monto total de la reservación.
     * 
     * @param montoTotal El monto total a establecer.
     */
    public void setMontoTotal(Float montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * Obtiene la multa asociada a la reservación.
     * 
     * @return La multa asociada, representada como un DTO.
     */
    public MultaDTO getMulta() {
        return multa;
    }

    /**
     * Establece la multa asociada a la reservación.
     * 
     * @param multa La multa a establecer, representada como un DTO.
     */
    public void setMulta(MultaDTO multa) {
        this.multa = multa;
    }
    
    
}
