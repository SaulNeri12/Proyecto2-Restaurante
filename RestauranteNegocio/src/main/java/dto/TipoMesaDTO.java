/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import java.io.Serializable;

/**
 *
 * @author Saul Neri
 */
public class TipoMesaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nombre;
    private Integer maximoPersonas;
    private Integer minimoPersonas;
    private Float precio;

    /**
     * Constructor por defecto que inicializa una nueva instancia de TipoMesaDTO.
     * Este constructor no realiza ninguna acción adicional.
     */
    public TipoMesaDTO() {
        
    }
    
    public TipoMesaDTO(Long id, String nombre, Integer maximoPersonas, Integer minimoPersonas, Float precio) {
    this.id = id;
    this.nombre = nombre;
    this.maximoPersonas = maximoPersonas;
    this.minimoPersonas = minimoPersonas;
    this.precio = precio;
}


    /**
     * Obtiene el identificador único del tipo de mesa.
     * 
     * @return El identificador único del tipo de mesa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del tipo de mesa.
     * 
     * @param id El identificador único del tipo de mesa a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el número máximo de personas que pueden usar la mesa.
     * 
     * @return El número máximo de personas para el tipo de mesa.
     */
    public Integer getMaximoPersonas() {
        return maximoPersonas;
    }

    /**
     * Establece el número máximo de personas que pueden usar la mesa.
     * 
     * @param maximoPersonas El número máximo de personas a establecer.
     */
    public void setMaximoPersonas(Integer maximoPersonas) {
        this.maximoPersonas = maximoPersonas;
    }

    /**
     * Obtiene el número mínimo de personas que pueden usar la mesa.
     * 
     * @return El número mínimo de personas para el tipo de mesa.
     */
    public Integer getMinimoPersonas() {
        return minimoPersonas;
    }

    /**
     * Establece el número mínimo de personas que pueden usar la mesa.
     * 
     * @param minimoPersonas El número mínimo de personas a establecer.
     */
    public void setMinimoPersonas(Integer minimoPersonas) {
        this.minimoPersonas = minimoPersonas;
    }

    /**
     * Obtiene el precio asociado al tipo de mesa.
     * 
     * @return El precio del tipo de mesa.
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio asociado al tipo de mesa.
     * 
     * @param precio El precio a establecer para el tipo de mesa.
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve el nombre descriptivo del tipo de mesa.
     * 
     * @return El nombre de la mesa.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre descriptivo del tipo de mesa.
     * 
     * @param nombre El nombre de la mesa.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoMesaDTO)) {
            return false;
        }
        TipoMesaDTO other = (TipoMesaDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

