/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto.convertidores;

import dto.TipoMesaDTO;
import entidades.TipoMesa;

/**
 * Hace de convertidor para los distintos tipos de mesa en el sistema
 * @author Saul Neri
 */
public class TipoMesaConvertidor extends Converter<TipoMesaDTO, TipoMesa> {
    
    public TipoMesaConvertidor() {
        super(TipoMesaConvertidor::convertirAEntidad, TipoMesaConvertidor::convertirADTO);
    }
    
    public static TipoMesa convertirAEntidad(TipoMesaDTO dto) {
        TipoMesa t = new TipoMesa();
        
        t.setId(dto.getId());
        t.setMaximoPersonas(dto.getMaximoPersonas());
        t.setMinimoPersonas(dto.getMinimoPersonas());
        t.setNombre(dto.getNombre());
        t.setPrecio(dto.getPrecio());
        
        return t;
    }
    
    public static TipoMesaDTO convertirADTO(TipoMesa entidad) {
        TipoMesaDTO t = new TipoMesaDTO();
        
        t.setId(entidad.getId());
        t.setMaximoPersonas(entidad.getMaximoPersonas());
        t.setMinimoPersonas(entidad.getMinimoPersonas());
        t.setNombre(entidad.getNombre());
        t.setPrecio(entidad.getPrecio());
        
        return t;
    }
}
