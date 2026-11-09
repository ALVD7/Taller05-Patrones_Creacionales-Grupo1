package fabrica;

import datos.BaseDatos;
import modelo.Producto;
import java.util.*;

// Decide en tiempo de ejecucion que creador usar segun el tipo.
// Un tipo nuevo se agrega con registrar(), sin modificar esta clase.
public class ProductoFactory {
    private static final Map<String, ProductoCreator> creadores = new HashMap<>();

    static {
        registrar("FISICO", new FisicoCreator());
        registrar("DIGITAL", new DigitalCreator());
    }

    public static void registrar(String tipo, ProductoCreator creador) {
        creadores.put(tipo.toUpperCase(), creador);
    }

    public static Producto crear(String tipo, String codigo, String nombre, double precio,
                                 String categoria, Map<String, String> extra) {
        ProductoCreator c = creadores.get(tipo.toUpperCase());
        if (c == null) throw new IllegalArgumentException("Tipo no soportado: " + tipo);
        Producto p = c.crear(codigo, nombre, precio, categoria, extra);
        BaseDatos.getInstancia().guardar(p);
        return p;
    }
}
