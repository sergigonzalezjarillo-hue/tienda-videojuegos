package tiendavideojuegos;

/**
 * Interfaz para los artículos que pueden venderse.
 */
public interface Vendible {

    /**
     * Realiza la venta de una cantidad concreta.
     * 
     * @param cantidad unidades a vender
     * @throws StockAgotadoException si no hay suficiente stock
     */
    void vender(int cantidad) throws StockAgotadoException;

    /**
     * Muestra la información del artículo.
     */
    void mostrarInfo();
}