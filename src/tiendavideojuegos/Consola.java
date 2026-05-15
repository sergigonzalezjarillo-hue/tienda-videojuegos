package tiendavideojuegos;

/**
 * Clase que representa una consola dentro de la tienda.
 * Guarda información básica como el fabricante y el modelo.
 * 
 * Hereda de Item e implementa la interfaz Vendible.
 */
public class Consola extends Item implements Vendible {

    /** Marca o empresa que fabrica la consola. */
    private String fabricante;

    /** Modelo concreto de la consola. */
    private String modelo;

    /**
     * Crea una nueva consola con sus datos principales.
     * 
     * @param nombre Nombre de la consola.
     * @param precio Precio de venta.
     * @param stock Unidades disponibles.
     * @param fabricante Marca de la consola.
     * @param modelo Modelo específico.
     */
    public Consola(String nombre, double precio, int stock, String fabricante, String modelo) {
        super(nombre, precio, stock);
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    /**
     * Devuelve el fabricante de la consola.
     * 
     * @return fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Devuelve el modelo de la consola.
     * 
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Reduce el stock según la cantidad vendida.
     * Si no hay suficientes unidades, lanza una excepción.
     * 
     * @param cantidad cantidad que se quiere vender
     * @throws StockAgotadoException cuando no queda stock suficiente
     */
    @Override
    public void vender(int cantidad) throws StockAgotadoException {

        if (cantidad > this.stock) {
            throw new StockAgotadoException(
                "No hay suficiente stock de '" + nombre + "'. Stock actual: " + stock
            );
        }

        this.stock -= cantidad;

        System.out.println("Vendidas " + cantidad + " unidades de '" + nombre + "'.");
    }

    /**
     * Muestra todos los datos de la consola por pantalla.
     */
    @Override
    public void mostrarInfo() {

        System.out.println("=== CONSOLA ===");
        System.out.println("Nombre    : " + nombre);
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Modelo    : " + modelo);
        System.out.println("Precio    : " + calcularPrecioFinal() + "eur");
        System.out.println("Stock     : " + stock);
    }

    /**
     * Calcula el precio final de la consola.
     * En este caso devuelve el precio base.
     * 
     * @return precio final
     */
    @Override
    public double calcularPrecioFinal() {
        return this.precio;
    }
}