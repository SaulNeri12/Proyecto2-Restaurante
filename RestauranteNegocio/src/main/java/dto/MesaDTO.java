/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import java.io.Serializable;

/**
 * Representa una Mesa en el sistema
 * @author Saul Neri
 */
public class MesaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String codigo;
    private TipoMesaDTO tipoMesa;
    private UbicacionMesaDTO ubicacion;

    /**
     * Constructor por defecto que inicializa una nueva instancia de MesaDTO.
     * Este constructor no realiza ninguna acción adicional.
     */
    public MesaDTO() {
        
    }

    /**
     * Constructor que inicializa una nueva instancia de MesaDTO con un identificador específico.
     * 
     * @param id El identificador único de la mesa.
     */
    public MesaDTO(Long id) {
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
     * @return El tipo de mesa asociado a esta instancia de MesaDTO.
     */
    public TipoMesaDTO getTipoMesa() {
        return tipoMesa;
    }

    /**
     * Establece el tipo de mesa.
     * 
     * @param tipoMesa El tipo de mesa a establecer.
     */
    public void setTipoMesa(TipoMesaDTO tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    /**
     * Obtiene la ubicación de la mesa en el restaurante.
     * 
     * @return La ubicación de la mesa.
     */
    public UbicacionMesaDTO getUbicacion() {
        return ubicacion;
    }

    /**
     * Asigna la ubicación de la mesa en el restaurante.
     * 
     * @param ubicacion Ubicación de la mesa a asignar.
     */
    public void setUbicacion(UbicacionMesaDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MesaDTO)) {
            return false;
        }
        MesaDTO other = (MesaDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MesaDTO[ id=" + id + " ]";
    }
}
