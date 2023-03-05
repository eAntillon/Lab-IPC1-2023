package Modelos;

public class Pedido {

    private String producto;
    private String total;
    private String color;


    public Pedido(String producto, String color, String total) {
        this.producto = producto;
        this.total = total;
        this.color = color;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "producto='" + producto + '\'' +
                ", total='" + total + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
