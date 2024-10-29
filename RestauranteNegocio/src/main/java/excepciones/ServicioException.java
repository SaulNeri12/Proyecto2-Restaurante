

package excepciones;

/**
 * Excepción utilizada para la capa de negocio.
 * Esta clase extiende la excepción base {@link Exception} para manejar
 * situaciones específicas donde se requiere indicar un error en el
 * servicio de la lógica de negocio.
 * 
 * @author Saul Neri
 */
public class ServicioException extends Exception {

    /**
     * Constructor que crea una nueva instancia de ServicioException
     * con un mensaje específico.
     * 
     * @param message El mensaje que describe la excepción.
     */
    public ServicioException(String message) {
        super(message);
    }
}
