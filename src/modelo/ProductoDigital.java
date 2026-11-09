package modelo;

public class ProductoDigital extends Producto {
    private final double tamanioMB;
    private final String formato;

    public ProductoDigital(String codigo, String nombre, double precio, String categoria,
                           double tamanioMB, String formato) {
        super(codigo, nombre, precio, categoria);
        this.tamanioMB = tamanioMB;
        this.formato = formato;
    }

    @Override
    public String detalle() { return "Digital: " + tamanioMB + " MB, " + formato; }
}
