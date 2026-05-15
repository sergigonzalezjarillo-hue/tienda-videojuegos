package tiendavideojuegos;

/**
 * Clase base para todos los artículos de la tienda.
 * 
 * Los distintos productos heredan de aquí los datos comunes.
 */
public abstract class Item {

    /** Nombre del artículo */
    protected String nombre;

    /** Precio del artículo */
    protected double precio;

    /** Cantidad disponible */
    protected int stock;

    /**
     * Crea un nuevo artículo.
     * 
     * @param nombre nombre del artículo
     * @param precio precio del producto
     * @param stock cantidad disponible
     */
    public Item(String nombre, double precio, int stock) {

        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Devuelve el nombre del artículo.
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el precio actual.
     * 
     * @return precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve el stock disponible.
     * 
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Cambia el precio del artículo.
     * 
     * @param precio nuevo precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Calcula el precio final.
     * Las clases hijas pueden modificar este comportamiento.
     * 
     * @return precio final
     */
    public double calcularPrecioFinal() {
        return this.precio;
    }

    /**
     * Devuelve la información básica del artículo.
     */
    @Override
    public String toString() {

        return nombre + " | Precio: " + precio + "eur | Stock: " + stock;
    }
}