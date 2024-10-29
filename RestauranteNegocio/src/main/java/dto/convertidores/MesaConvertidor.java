/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto.convertidores;

import dto.MesaDTO;
import dto.RestauranteDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import entidades.Mesa;
import entidades.Restaurante;
import entidades.TipoMesa;
import entidades.UbicacionMesa;


/**
 * Hace de convertidor para objetos Mesa en el sistema
 * @author Saul Neri
 */
public class MesaConvertidor extends Converter<MesaDTO, Mesa>{
  
    public MesaConvertidor() {
        super(MesaConvertidor::convertirAEntidad, MesaConvertidor::convertirADTO);
    }
    
    public static Mesa convertirAEntidad(MesaDTO dto) {
        Converter<TipoMesaDTO, TipoMesa> tipoMesaConvertidor = new TipoMesaConvertidor();
        Mesa mesa = new Mesa();
        mesa.setId(dto.getId());
        mesa.setCodigo(dto.getCodigo());
        mesa.setTipoMesa(tipoMesaConvertidor.convertFromDto(dto.getTipoMesa()));
        mesa.setUbicacion(UbicacionMesa.valueOf(dto.getUbicacion().toString()));
       
        Restaurante r = new Restaurante(
                dto.getRestaurante().getId(),
                dto.getRestaurante().getNombre(),
                dto.getRestaurante().getTelefono(),
                dto.getRestaurante().getDireccion(),
                dto.getRestaurante().getHoraApertura(),
                dto.getRestaurante().getHoraCierre()
        );
        
        mesa.setRestaurante(r);
        
        return mesa;
    }
    
    public static MesaDTO convertirADTO(Mesa entidad) {
        Converter<TipoMesaDTO, TipoMesa> tipoMesaConvertidor = new TipoMesaConvertidor();
        MesaDTO mesa = new MesaDTO();
        mesa.setId(entidad.getId());
        mesa.setCodigo(entidad.getCodigo());
        mesa.setTipoMesa(tipoMesaConvertidor.convertFromEntity(entidad.getTipoMesa()));
        mesa.setUbicacion(UbicacionMesaDTO.valueOf(entidad.getUbicacion().toString()));
        RestauranteDTO r = new RestauranteDTO(
                entidad.getRestaurante().getId(),
                entidad.getRestaurante().getNombre(),
                entidad.getRestaurante().getTelefono(),
                entidad.getRestaurante().getDireccion(),
                entidad.getRestaurante().getHoraApertura(),
                entidad.getRestaurante().getHoraCierre()
        );
        mesa.setRestaurante(r);
        return mesa;
    }

}
