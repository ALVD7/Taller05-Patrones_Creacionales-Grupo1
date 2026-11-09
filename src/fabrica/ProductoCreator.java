package fabrica;

import modelo.Producto;
import java.util.Map;

// Cada tipo de producto implementa su propio creador
public interface ProductoCreator {
    Producto crear(String codigo, String nombre, double precio, String categoria,
                   Map<String, String> extra);
}
