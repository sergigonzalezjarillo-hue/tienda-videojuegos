package tiendavideojuegos; // v1.0.0

/**
 * Excepción que se usa cuando no hay stock suficiente.
 */
public class StockAgotadoException extends Exception {

    /**
     * Crea la excepción con un mensaje personalizado.
     * 
     * @param mensaje descripción del error
     */
    public StockAgotadoException(String mensaje) {
        super(mensaje);
    }
}
