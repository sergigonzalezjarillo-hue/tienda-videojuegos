package tiendavideojuegos;

/**
 * Clase principal del programa.
 * Desde aquí se prueba el funcionamiento del inventario.
 */
public class Main {

    /**
     * Punto de inicio de la aplicación.
     * 
     * @param args argumentos del programa
     */
    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        // Juegos normales
        Videojuego juego1 = new Videojuego(
            "The Last of Us Part II", 39.99, 10, "PS5", "Aventura"
        );

        Videojuego juego2 = new Videojuego(
            "Halo Infinite", 29.99, 5, "Xbox", "Shooter"
        );

        Videojuego juego3 = new Videojuego(
            "Zelda: Tears of the Kingdom", 59.99, 8, "Switch", "RPG"
        );

        // Juego con descuento
        VideojuegoConDescuento juegoOferta = new VideojuegoConDescuento(
            "God of War Ragnarok", 69.99, 6, "PS5", "Accion", 15.0
        );

        // Consolas
        Consola consola1 = new Consola(
            "PlayStation 5", 549.99, 3, "Sony", "PS5"
        );

        Consola consola2 = new Consola(
            "Xbox Series X", 499.99, 2, "Microsoft", "Xbox Series X"
        );

        // Añadir artículos
        inventario.agregarItem(juego1);
        inventario.agregarItem(juego2);
        inventario.agregarItem(juego3);
        inventario.agregarItem(juegoOferta);
        inventario.agregarItem(consola1);
        inventario.agregarItem(consola2);

        // Mostrar inventario
        inventario.listarInventario();

        // Información detallada
        juego1.mostrarInfo();
        System.out.println();

        juegoOferta.mostrarInfo();
        System.out.println();

        consola1.mostrarInfo();
        System.out.println();

        // Pruebas de venta
        try {

            inventario.venderItem("Halo Infinite", 3);
            inventario.venderItem("PlayStation 5", 1);

            // Fuerza un error de stock
            inventario.venderItem("Xbox Series X", 99);

        } catch (StockAgotadoException e) {

            System.out.println("ERROR DE STOCK: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        // Inventario después de las ventas
        inventario.listarInventario();
    }
}
