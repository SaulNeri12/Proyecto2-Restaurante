

package excepciones;

/**
 * Excepcion utilizada para la capa de negocio
 * @author Saul Neri
 */
public class ServicioException extends Exception {
    public ServicioException(String message) {
        super(message);
    }
}
