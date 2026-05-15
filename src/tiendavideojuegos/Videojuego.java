package tiendavideojuegos;

/**
 * Clase que representa un videojuego de la tienda.
 */
public class Videojuego extends Item implements Vendible {

    /** Plataforma del juego */
    private String plataforma;

    /** Género del videojuego */
    private String genero;

    /**
     * Crea un nuevo videojuego.
     * 
     * @param nombre nombre del juego
     * @param precio precio del juego
     * @param stock unidades disponibles
     * @param plataforma plataforma del juego
     * @param genero género del videojuego
     */
    public Videojuego(String nombre, double precio, int stock, String plataforma, String genero) {

        super(nombre, precio, stock);

        this.plataforma = plataforma;
        this.genero = genero;
    }

    /**
     * Devuelve la plataforma del juego.
     * 
     * @return plataforma
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Devuelve el género del juego.
     * 
     * @return género
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Realiza la venta de una cantidad concreta.
     * 
     * @param cantidad unidades a vender
     * @throws StockAgotadoException si no hay suficiente stock
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
     * Muestra toda la información del videojuego.
     */
    @Override
    public void mostrarInfo() {

        System.out.println("=== VIDEOJUEGO ===");
        System.out.println("Nombre    : " + nombre);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Genero    : " + genero);
        System.out.println("Precio    : " + calcularPrecioFinal() + "eur");
        System.out.println("Stock     : " + stock);
    }

    /**
     * Devuelve el precio final del videojuego.
     * 
     * @return precio final
     */
    @Override
    public double calcularPrecioFinal() {
        return this.precio * 0.95;
    }
}