

package dto;

import entidades.Multa;
import java.io.Serializable;

/**
 * Representa una multa de una reservacion en el sistema
 * @author Saul Neri
 */
public class MultaDTO implements Serializable {

    private Long id;
    private String descripcion;
    private Float porcentaje;

    /**
     * Constructor por defecto que inicializa una nueva instancia de MultaDTO.
     * Este constructor no realiza ninguna acción adicional.
     */
    public MultaDTO() {
        
    }

    /**
     * Constructor que inicializa una nueva instancia de MultaDTO con un identificador, descripción y porcentaje específicos.
     * 
     * @param id El identificador único de la multa.
     * @param descripcion La descripción de la multa.
     * @param porcentaje El porcentaje asociado a la multa.
     */
    public MultaDTO(Long id, String descripcion, Float porcentaje) {
        this.id = id;
        this.descripcion = descripcion; 
        this.porcentaje = porcentaje; 
    }

    /**
     * Obtiene el identificador único de la multa.
     * 
     * @return El identificador único de la multa.
     */
    public Long getId() {
        return id; 
    }

    /**
     * Establece el identificador único de la multa.
     * 
     * @param id El identificador único de la multa a establecer.
     */
    public void setId(Long id) {
        this.id = id; 
    }

    /**
     * Obtiene la descripción de la multa.
     * 
     * @return La descripción de la multa.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la multa.
     * 
     * @param descripcion La descripción de la multa a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el porcentaje asociado a la multa.
     * 
     * @return El porcentaje de la multa.
     */
    public Float getPorcentaje() {
        return porcentaje; 
    }

    /**
     * Establece el porcentaje asociado a la multa.
     * 
     * @param porcentaje El porcentaje de la multa a establecer.
     */
    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje; 
    }
}
