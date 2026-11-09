package fabrica;

import modelo.*;
import java.util.Map;

public class FisicoCreator implements ProductoCreator {
    public Producto crear(String codigo, String nombre, double precio, String categoria,
                          Map<String, String> extra) {
        return new ProductoFisico(codigo, nombre, precio, categoria,
                Double.parseDouble(extra.get("peso")), extra.get("dimensiones"));
    }
}
