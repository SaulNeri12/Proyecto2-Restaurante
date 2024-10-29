

package excepciones;

/**
 * Excepción utilizada cuando no se encuentra un elemento en el sistema.
 * Esta clase extiende la excepción base {@link Exception} para manejar
 * situaciones específicas donde se requiere indicar que un elemento
 * no fue encontrado.
 * 
 * @author Saul Neri
 */
public class NoEncontradoException extends Exception {

    /**
     * Constructor que crea una nueva instancia de NoEncontradoException
     * con un mensaje específico.
     * 
     * @param message El mensaje que describe la excepción.
     */
    public NoEncontradoException(String message) {
        super(message);
    }
}
