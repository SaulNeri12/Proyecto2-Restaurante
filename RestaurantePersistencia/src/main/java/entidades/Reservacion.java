

package entidades;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa una reservacion para una mesa de un restaurante
 * @author Saul Neri
 */
@Entity
@Table(name="reservacion")
public class Reservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="fecha_hora", nullable=false, columnDefinition="TIME")
    private Instant fechaHora;
    
    @Column(name="numero_personas", nullable=false)
    private Integer numeroPersonas;
    
    @Enumerated(EnumType.STRING)
    @Column(name="estado", nullable=false)
    private EstadoReservacion estado;
    
    @OneToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="mesa_id", nullable=false, referencedColumnName = "id")
    private Mesa mesa;
    
    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reservacion[ id=" + id + " ]";
    }
    
    /**
     * Constructor por defecto que inicializa una nueva instancia de Reservacion.
     * Este constructor no realiza ninguna acción adicional.
     */
    public Reservacion() {
        
    }
    
    /**
     * Constructor que inicializa una nueva instancia de Reservacion con un identificador específico.
     * 
     * @param id El identificador único de la reservación.
     */
    public Reservacion(Long id) {
        this.id = id;
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
    public Instant getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la reservación.
     * 
     * @param fechaHora La fecha y hora de la reservación a establecer.
     */
    public void setFechaHora(Instant fechaHora) {
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
    public EstadoReservacion getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la reservación.
     * 
     * @param estado El estado de la reservación a establecer.
     */
    public void setEstado(EstadoReservacion estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la mesa asociada a la reservación.
     * 
     * @return La mesa de la reservación.
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa asociada a la reservación.
     * 
     * @param mesa La mesa a establecer para la reservación.
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * Devuelve el cliente asociado a la reservacion
     * @return El cliente que pidio la reservacion
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * ASigna el cliente a asociar con la reservacion
     * @param cliente El cliente a asignar
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
