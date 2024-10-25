

package excepciones;

/**
 * Excepcion utilizada cuando no se encuentra un elemento en el sistema
 * @author Saul Neri
 */
public class NoEncontradoException extends Exception {
    public NoEncontradoException(String message) {
        super(message);
    }
}
