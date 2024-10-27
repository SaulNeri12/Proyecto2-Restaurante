/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package horario;

import java.time.LocalTime;

/**
 * Contiene la informacion del horario del restaurante
 * @author Saul Neri
 */
public class HorarioRestaurante {
    private static HorarioRestaurante instance;
    
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    
    private HorarioRestaurante() {
        this.horaApertura = LocalTime.parse("08:00:00");
        this.horaCierre = LocalTime.parse("20:00:00");
    }
    
    public static HorarioRestaurante getInstance() {
        if (instance == null) {
            instance = new HorarioRestaurante();
        }
        
        return instance;
    }

    /**
     * @return the horaApertura
     */
    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    /**
     * @param horaApertura the horaApertura to set
     */
    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * @return the horaCierre
     */
    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    /**
     * @param horaCierre the horaCierre to set
     */
    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }
}
