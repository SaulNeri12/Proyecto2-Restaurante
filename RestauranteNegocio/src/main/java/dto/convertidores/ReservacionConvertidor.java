

package dto.convertidores;

import dto.ClienteDTO;
import dto.EstadoReservacionDTO;
import dto.MesaDTO;
import dto.MultaDTO;
import dto.ReservacionDTO;
import entidades.Cliente;
import entidades.EstadoReservacion;
import entidades.Mesa;
import entidades.Multa;
import entidades.Reservacion;

/**
 *
 * @author Saul Neri
 */
public class ReservacionConvertidor extends Converter<ReservacionDTO, Reservacion>{
    
    public ReservacionConvertidor() {
        super(ReservacionConvertidor::convertirAEntidad, ReservacionConvertidor::convertirADTO);
    }
    
    public static Reservacion convertirAEntidad(ReservacionDTO dto) {
        
        Converter<ClienteDTO, Cliente> clienteConvertidor = new ClienteConvertidor();
        Converter<MesaDTO, Mesa> mesaConvertidor = new MesaConvertidor();
        Converter<MultaDTO, Multa> multaConvertidor = new MultaConvertidor();
        
        Reservacion r = new Reservacion();
        r.setId(dto.getId());
        r.setMontoTotal(dto.getMontoTotal());
        r.setFechaHora(dto.getFechaHora());
        r.setCliente(clienteConvertidor.convertFromDto(dto.getCliente()));
        r.setMesa(mesaConvertidor.convertFromDto(dto.getMesa()));
        r.setFechaHoraRegistro(dto.getFechaHoraRegistro());
        
        
        if (dto.getMulta() != null) {
            Multa multa = multaConvertidor.convertFromDto(dto.getMulta());
            r.setMulta(multa);
        }
        
        r.setEstado(EstadoReservacion.valueOf(dto.getEstado().toString()));
        r.setNumeroPersonas(dto.getNumeroPersonas());
        
        return r;
    }
    
    public static ReservacionDTO convertirADTO(Reservacion entidad) {
        
        Converter<ClienteDTO, Cliente> clienteConvertidor = new ClienteConvertidor();
        Converter<MesaDTO, Mesa> mesaConvertidor = new MesaConvertidor();
        Converter<MultaDTO, Multa> multaConvertidor = new MultaConvertidor();
        
        ReservacionDTO r = new ReservacionDTO();
        r.setId(entidad.getId());
        r.setMontoTotal(entidad.getMontoTotal());
        r.setFechaHora(entidad.getFechaHora());
        r.setCliente(clienteConvertidor.convertFromEntity(entidad.getCliente()));
        r.setMesa(mesaConvertidor.convertFromEntity(entidad.getMesa()));
        r.setFechaHoraRegistro(entidad.getFechaHoraRegistro());
        
        if (entidad.getMulta() != null) {
            MultaDTO multa = multaConvertidor.convertFromEntity(entidad.getMulta());
            r.setMulta(multa);
        }
        
        r.setEstado(EstadoReservacionDTO.valueOf(entidad.getEstado().toString()));
        r.setNumeroPersonas(entidad.getNumeroPersonas());
        
        return r;
    }
}
