package fabrica;

import modelo.*;
import java.util.Map;

public class DigitalCreator implements ProductoCreator {
    public Producto crear(String codigo, String nombre, double precio, String categoria,
                          Map<String, String> extra) {
        return new ProductoDigital(codigo, nombre, precio, categoria,
                Double.parseDouble(extra.get("tamanio")), extra.get("formato"));
    }
}
