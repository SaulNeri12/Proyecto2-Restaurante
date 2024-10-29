/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto.convertidores;

import dto.MesaDTO;
import dto.RestauranteDTO;
import entidades.Mesa;
import entidades.Restaurante;

/**
 * Hace de convertidor de objetos restaurante en el sistema
 * @author Saul Neri
 */
public class RestauranteConvertidor extends Converter<RestauranteDTO, Restaurante> {
    
    public RestauranteConvertidor() {
        super(RestauranteConvertidor::convertirAEntidad, RestauranteConvertidor::convertirADTO);
    }
    
    public static Restaurante convertirAEntidad(RestauranteDTO dto) {
        Restaurante r = new Restaurante(
                dto.getId(),
                dto.getNombre(),
                dto.getTelefono(),
                dto.getDireccion(),
                dto.getHoraApertura(),
                dto.getHoraCierre()
        );
        
        if (dto.getMesas() != null) {
            Converter<MesaDTO, Mesa> mesaConvertidor = new MesaConvertidor();
            r.setMesas(mesaConvertidor.createFromDtos(dto.getMesas()));
        }
        
        return r;
    }
    
    public static RestauranteDTO convertirADTO(Restaurante entidad) {
        RestauranteDTO r = new RestauranteDTO(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getTelefono(),
                entidad.getDireccion(),
                entidad.getHoraApertura(),
                entidad.getHoraCierre()
        );
        
        if (entidad.getMesas() != null) {
            Converter<MesaDTO, Mesa> mesaConvertidor = new MesaConvertidor();
            r.setMesas(mesaConvertidor.createFromEntities(entidad.getMesas()));
        }
        
        return r;
    }
    
}
