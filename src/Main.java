import datos.BaseDatos;
import fabrica.ProductoFactory;
import modelo.Producto;
import java.util.Map;

public class Main {

    // Tipo nuevo agregado sin tocar ninguna clase existente
    static class ProductoServicio extends Producto {
        private final int horas;
        ProductoServicio(String c, String n, double p, String cat, int horas) {
            super(c, n, p, cat);
            this.horas = horas;
        }
        public String detalle() { return "Servicio: " + horas + " horas"; }
    }

    public static void main(String[] args) {
        BaseDatos db = BaseDatos.getInstancia();
        System.out.println("Misma instancia? " + (db == BaseDatos.getInstancia()));
        db.agregarCategoria("Tecnologia");
        db.agregarCategoria("Software");

        ProductoFactory.crear("FISICO", "P-001", "Teclado", 45.5, "Tecnologia",
                Map.of("peso", "0.9", "dimensiones", "4x36x14"));
        ProductoFactory.crear("DIGITAL", "P-002", "Antivirus", 20, "Software",
                Map.of("tamanio", "180", "formato", "EXE"));

        ProductoFactory.registrar("SERVICIO", (cod, nom, pre, cat, extra) ->
                new ProductoServicio(cod, nom, pre, cat, Integer.parseInt(extra.get("horas"))));
        ProductoFactory.crear("SERVICIO", "P-003", "Instalacion", 30, "Software",
                Map.of("horas", "2"));

        db.listar().forEach(System.out::println);
        System.out.println("Precio P-002: $" + db.buscar("P-002").getPrecio());

        try {
            ProductoFactory.crear("OTRO", "P-004", "X", 1, "Software", Map.of());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
