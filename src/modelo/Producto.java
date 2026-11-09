package modelo;

public abstract class Producto {
    private final String codigo, nombre, categoria;
    private final double precio;

    public Producto(String codigo, String nombre, double precio, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public abstract String detalle();

    public String getCodigo() { return codigo; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | $" + precio + " | " + categoria + " | " + detalle();
    }
}
