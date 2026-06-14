package Modelo;

public class Pedido {
    private String id;
    private String fecha;
    private String cliente;
    private String productos;
    private double precioTotal;
    private String estado; // "Pendiente", "Aprobado", "Rechazado"

    public Pedido(String id, String fecha, String cliente, String productos, double precioTotal) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;
        this.precioTotal = precioTotal;
        this.estado = "Pendiente"; // Cada pedido inicia en este Estado por defecto
    }


    // Métodos para cambiar el Estado de Pedido
    public void aprobar() {
        this.estado = "Aprobado";
    }

    public void rechazar() {
        this.estado = "Rechazado";
    }


    // Métodos Getters
    public String getId() {return id;}
    public String getFecha() {return fecha;}
    public String getCliente() {return cliente;}
    public String getProductos() {return productos;}
    public double getPrecioTotal() {return precioTotal;}
    public String getEstado() {return estado;}
}
