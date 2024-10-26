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

    public TipoMesaDTO() {
        
    }
    
    public TipoMesaDTO(Long id, String nombre, Integer maximoPersonas, Integer minimoPersonas, Float precio) {
    this.id = id;
    this.nombre = nombre;
    this.maximoPersonas = maximoPersonas;
    this.minimoPersonas = minimoPersonas;
    this.precio = precio;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaximoPersonas() {
        return maximoPersonas;
    }

    public void setMaximoPersonas(Integer maximoPersonas) {
        this.maximoPersonas = maximoPersonas;
    }

    public Integer getMinimoPersonas() {
        return minimoPersonas;
    }

    public void setMinimoPersonas(Integer minimoPersonas) {
        this.minimoPersonas = minimoPersonas;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

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
        return this.nombre; // Muestra el nombre de la mesa
    }
    
    
}
