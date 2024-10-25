/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto.convertidores;

import dto.MesaDTO;
import dto.TipoMesaDTO;
import dto.UbicacionMesaDTO;
import entidades.Mesa;
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
        return mesa;
    }
    
    public static MesaDTO convertirADTO(Mesa entidad) {
        Converter<TipoMesaDTO, TipoMesa> tipoMesaConvertidor = new TipoMesaConvertidor();
        MesaDTO mesa = new MesaDTO();
        mesa.setId(entidad.getId());
        mesa.setCodigo(entidad.getCodigo());
        mesa.setTipoMesa(tipoMesaConvertidor.convertFromEntity(entidad.getTipoMesa()));
        mesa.setUbicacion(UbicacionMesaDTO.valueOf(entidad.getUbicacion().toString()));
        return mesa;
    }

}
