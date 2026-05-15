package tiendavideojuegos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar todos los artículos de la tienda.
 * Desde aquí se pueden añadir, buscar, listar y vender productos.
 */
public class Inventario {

    /** Lista donde se guardan todos los artículos. */
    private List<Item> articulos;

    /**
     * Crea un inventario vacío.
     */
    public Inventario() {
        this.articulos = new ArrayList<>();
    }

    /**
     * Añade un nuevo artículo al inventario.
     * 
     * @param item artículo que se quiere añadir
     */
    public void agregarItem(Item item) {

        articulos.add(item);

        System.out.println("Articulo añadido: " + item.getNombre());
    }

    /**
     * Busca un artículo por su nombre.
     * No distingue entre mayúsculas y minúsculas.
     * 
     * @param nombre nombre del artículo
     * @return el artículo encontrado o null si no existe
     */
    public Item buscarItem(String nombre) {

        for (Item item : articulos) {

            if (item.getNombre().equalsIgnoreCase(nombre)) {
                return item;
            }
        }

        return null;
    }

    /**
     * Muestra todos los artículos guardados en el inventario.
     */
    public void listarInventario() {

        if (articulos.isEmpty()) {

            System.out.println("El inventario esta vacio.");
            return;
        }

        System.out.println("\n====== INVENTARIO ======");

        for (Item item : articulos) {
            System.out.println(item);
        }

        System.out.println("========================\n");
    }

    /**
     * Busca un artículo y realiza la venta.
     * 
     * @param nombre nombre del artículo
     * @param cantidad unidades que se quieren vender
     * @throws StockAgotadoException si no hay suficiente stock
     */
    public void venderItem(String nombre, int cantidad) throws StockAgotadoException {

        Item item = buscarItem(nombre);

        if (item == null) {

            throw new IllegalArgumentException(
                "El articulo '" + nombre + "' no existe en el inventario."
            );
        }

        if (item instanceof Vendible) {

            ((Vendible) item).vender(cantidad);

        } else {

            System.out.println("Este articulo no se puede vender.");
        }
    }

    /**
     * Devuelve la lista completa de artículos.
     * 
     * @return lista de artículos
     */
    public List<Item> getArticulos() {
        return articulos;
    }
}