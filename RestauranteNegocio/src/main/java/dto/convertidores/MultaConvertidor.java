/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto.convertidores;

import dto.MultaDTO;
import entidades.Multa;

/**
 * Hace de convertidor para las multas de reservaciones en el sistema
 * @author Saul Neri
 */
public class MultaConvertidor extends Converter<MultaDTO, Multa> {
    public MultaConvertidor() {
        super(MultaConvertidor::convertirAEntidad, MultaConvertidor::convertirADTO);
    }
    
    public static Multa convertirAEntidad(MultaDTO dto) {
        Multa m = new Multa();
        m.setId(dto.getId());
        m.setDescripcion(dto.getDescripcion());
        m.setPorcentaje(dto.getPorcentaje());
        return m;
    }
    
    public static MultaDTO convertirADTO(Multa entidad) {
        MultaDTO m = new MultaDTO();
        m.setId(entidad.getId());
        m.setDescripcion(entidad.getDescripcion());
        m.setPorcentaje(entidad.getPorcentaje());
        return m;
    }
}
