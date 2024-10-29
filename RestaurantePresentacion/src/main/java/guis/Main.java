/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guis;

import dto.RestauranteDTO;
import excepciones.ServicioException;
import implementaciones.RestaurantesBO;
import interfacesBO.IRestaurantesBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author caarl
 */
public class Main {

    private static final String TELEFONO_RESTAURANTE = "1122334455";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IRestaurantesBO restaurantesBO = RestaurantesBO.getInstance();
        
        RestauranteDTO este = null;
        
        try {
            este = restaurantesBO.obtenerRestaurantePorNumeroTelefono(TELEFONO_RESTAURANTE);
            
            if (este == null) {
                throw new ServicioException("No se pudo obtener la informacion del restaurante(sucursal) en el sistema, porfavor intente mas tarde");
            }
            
        } catch (ServicioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Obtener Restaurante", JOptionPane.ERROR_MESSAGE);
            return;
            //System.exit(1); // sale con error!!
        }
        
        // Abrir el nuevo frame
        frmMenuPrincipal nuevoFrame = new frmMenuPrincipal(este); // Reemplaza "NuevoFrame" con el nombre de tu frame de destino
        nuevoFrame.setVisible(true);
    }

}
