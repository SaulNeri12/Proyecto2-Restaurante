/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa una mesa de un restaurante
 * @author Saul Neri
 */
@Entity
@Table(name="mesa")
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="codigo", nullable=false, length=10)
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name="tipo_mesa", referencedColumnName = "id")
    private TipoMesa tipoMesa;
    
    @ManyToOne
    @JoinColumn(name="restaurante_id")
    private Restaurante restaurante;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Mesa[ id=" + id + " ]";
    }
    
    /**
     * Constructor por defecto que inicializa una nueva instancia de Mesa.
     * Este constructor no realiza ninguna acción adicional.
     */
    public Mesa() {
        
    }
    
    /**
     * Constructor que inicializa una nueva instancia de Mesa con un identificador específico.
     * 
     * @param id El identificador único de la mesa.
     */
    public Mesa(Long id) {
        this.id = id;
    }
    
    /**
     * Obtiene el identificador único de la mesa.
     * 
     * @return El identificador único de la mesa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la mesa.
     * 
     * @param id El identificador único de la mesa a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el código que representa la mesa.
     * 
     * @return El código de la mesa.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código que representa la mesa.
     * 
     * @param codigo El código de la mesa a establecer.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el tipo de mesa.
     * 
     * @return El tipo de mesa asociado a esta instancia de Mesa.
     */
    public TipoMesa getTipoMesa() {
        return tipoMesa;
    }

    /**
     * Establece el tipo de mesa.
     * 
     * @param tipoMesa El tipo de mesa a establecer.
     */
    public void setTipoMesa(TipoMesa tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    /**
     * Obtiene el restaurante al que pertenece esta mesa.
     * 
     * @return El restaurante asociado a esta mesa.
     */
    public Restaurante getRestaurante() {
        return restaurante;
    }
}