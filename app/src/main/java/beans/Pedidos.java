package beans;

import java.io.Serializable;

/**
 * Created by antonio on 26/09/2017.
 */

public class Pedidos implements Serializable{
    private String producto;
    private String seccion;
    private double precio;

    public Pedidos(String producto, String seccion, double precio) {
        this.producto = producto;
        this.seccion = seccion;
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
