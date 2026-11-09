package modelo;

public class ProductoFisico extends Producto {
    private final double peso;
    private final String dimensiones;

    public ProductoFisico(String codigo, String nombre, double precio, String categoria,
                          double peso, String dimensiones) {
        super(codigo, nombre, precio, categoria);
        this.peso = peso;
        this.dimensiones = dimensiones;
    }

    @Override
    public String detalle() { return "Fisico: " + peso + " kg, " + dimensiones + " cm"; }
}
