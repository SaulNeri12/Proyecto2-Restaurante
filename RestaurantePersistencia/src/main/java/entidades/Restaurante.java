

package entidades;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representa un restaurante en el sistema
 * @author Saul Neri
 */
@Entity
@Table(name="restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="direccion", nullable=false, length=100)
    private String direccion;
    
    @Column(name="telefono", nullable=false, length=15)
    private String telefono;
    
    @Column(name="hora_apertura", nullable=false, columnDefinition="TIME")
    private LocalTime horaApertura;
    
    @Column(name="hora_cierre", nullable=false, columnDefinition="TIME")
    private LocalTime horaCierre;
   
    /*
    @OneToMany(
            mappedBy="restaurante", 
            cascade={
                CascadeType.REMOVE,
                CascadeType.PERSIST
            }, 
            orphanRemoval=true
    )
    private List<Mesa> mesas;
*/
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurante)) {
            return false;
        }
        Restaurante other = (Restaurante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Restaurante[ id=" + id + " ]";
    }
    
    /**
     * Constructor por defecto que inicializa una nueva instancia de Restaurante.
     * Este constructor no realiza ninguna acción adicional.
     */
    public Restaurante() {
        
    }
    
    /**
     * Constructor que inicializa una nueva instancia de Restaurante con un identificador específico.
     * 
     * @param id El identificador único del restaurante.
     */
    public Restaurante(Long id) {
        this.id = id;
    }
    
    /**
     * Obtiene el identificador único del restaurante.
     * 
     * @return El identificador único del restaurante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del restaurante.
     * 
     * @param id El identificador único del restaurante a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la dirección del restaurante.
     * 
     * @return La dirección del restaurante.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del restaurante.
     * 
     * @param direccion La dirección a establecer para el restaurante.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de teléfono del restaurante.
     * 
     * @return El número de teléfono del restaurante.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del restaurante.
     * 
     * @param telefono El número de teléfono a establecer para el restaurante.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la hora de apertura del restaurante.
     * 
     * @return La hora de apertura del restaurante.
     */
    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    /**
     * Establece la hora de apertura del restaurante.
     * 
     * @param horaApertura La hora de apertura a establecer.
     */
    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Obtiene la hora de cierre del restaurante.
     * 
     * @return La hora de cierre del restaurante.
     */
    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre del restaurante.
     * 
     * @param horaCierre La hora de cierre a establecer.
     */
    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    
    /**
     * Obtiene la lista de mesas del restaurante.
     * 
     * @return La lista de mesas en el restaurante.
     
    public List<Mesa> getMesas() {
        return mesas;
    }

    /**
     * Establece la lista de mesas del restaurante.
     * 
     * @param mesas La lista de mesas a establecer.
     
    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }*/
}
