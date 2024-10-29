/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto.convertidores;

import dto.MultaDTO;
import entidades.Multa;

/**
 * Clase de conversión para objetos Multa en el sistema.
 * Permite la transformación bidireccional entre MultaDTO (Data Transfer Object)
 * y Multa (entidad de base de datos).
 * 
 * @author Saul Neri
 */
public class MultaConvertidor extends Converter<MultaDTO, Multa> {
    
    /**
     * Constructor de MultaConvertidor.
     * Inicializa el convertidor especificando los métodos de conversión
     * a través de referencias a métodos estáticos.
     */
    public MultaConvertidor() {
        super(MultaConvertidor::convertirAEntidad, MultaConvertidor::convertirADTO);
    }
    
    /**
     * Convierte un objeto MultaDTO en un objeto Multa.
     * 
     * @param dto el objeto MultaDTO a convertir
     * @return un objeto Multa con los datos de dto
     */
    public static Multa convertirAEntidad(MultaDTO dto) {
        Multa m = new Multa();
        m.setId(dto.getId());
        m.setDescripcion(dto.getDescripcion());
        m.setPorcentaje(dto.getPorcentaje());
        return m;
    }
    
    /**
     * Convierte un objeto Multa en un objeto MultaDTO.
     * 
     * @param entidad el objeto Multa a convertir
     * @return un objeto MultaDTO con los datos de la entidad
     */
    public static MultaDTO convertirADTO(Multa entidad) {
        MultaDTO m = new MultaDTO();
        m.setId(entidad.getId());
        m.setDescripcion(entidad.getDescripcion());
        m.setPorcentaje(entidad.getPorcentaje());
        return m;
    }
}
