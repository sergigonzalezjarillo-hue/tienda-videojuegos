package tiendavideojuegos; // v1.0.0

/**
 * Videojuego al que se le aplica un descuento sobre el precio original.
 */
public class VideojuegoConDescuento extends Videojuego {

    /** Descuento aplicado al juego */
    private double descuento;

    /**
     * Crea un videojuego con descuento.
     * 
     * @param nombre nombre del juego
     * @param precio precio original
     * @param stock unidades disponibles
     * @param plataforma plataforma del juego
     * @param genero género del juego
     * @param descuento porcentaje de descuento
     */
    public VideojuegoConDescuento(
        String nombre,
        double precio,
        int stock,
        String plataforma,
        String genero,
        double descuento
    ) {

        super(nombre, precio, stock, plataforma, genero);

        this.descuento = descuento;
    }

    /**
     * Devuelve el descuento aplicado.
     * 
     * @return descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Calcula el precio final aplicando el descuento.
     * 
     * @return precio final
     */
    @Override
    public double calcularPrecioFinal() {

        return this.precio - (this.precio * descuento / 100);
    }

    /**
     * Muestra toda la información del videojuego.
     */
    @Override
    public void mostrarInfo() {

        System.out.println("=== VIDEOJUEGO CON DESCUENTO ===");
        System.out.println("Nombre        : " + nombre);
        System.out.println("Plataforma    : " + getPlataforma());
        System.out.println("Genero        : " + getGenero());
        System.out.println("Precio base   : " + precio + "eur");
        System.out.println("Descuento     : " + descuento + "%");
        System.out.println("Precio final  : " + calcularPrecioFinal() + "eur");
        System.out.println("Stock         : " + stock);
    }
}