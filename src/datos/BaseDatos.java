package datos;

import modelo.Producto;
import java.util.*;

// Singleton: una sola conexion/instancia para todo el sistema
public class BaseDatos {
    private static final BaseDatos INSTANCIA = new BaseDatos();

    private final Map<String, Producto> productos = new LinkedHashMap<>();
    private final Set<String> categorias = new LinkedHashSet<>();

    private BaseDatos() {
        System.out.println("Conectado a la base de datos");
    }

    public static BaseDatos getInstancia() { return INSTANCIA; }

    public void agregarCategoria(String c) { categorias.add(c); }
    public void guardar(Producto p) { productos.put(p.getCodigo(), p); }
    public Producto buscar(String codigo) { return productos.get(codigo); }
    public Collection<Producto> listar() { return productos.values(); }
}
