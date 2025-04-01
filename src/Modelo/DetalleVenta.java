/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiantes
 */
public class DetalleVenta {
    private int ID_Detalle_ven;
    private int ID_Venta;
    private int ID_Producto;
    private int Cantidad_ven;
    private float Precio_Ven;

    public DetalleVenta() {
    }

    public DetalleVenta(int ID_Detalle_ven, int ID_Venta, int ID_Producto, int Cantidad_ven, float Precio_Ven) {
        this.ID_Detalle_ven = ID_Detalle_ven;
        this.ID_Venta = ID_Venta;
        this.ID_Producto = ID_Producto;
        this.Cantidad_ven = Cantidad_ven;
        this.Precio_Ven = Precio_Ven;
    }

    public int getID_Detalle_ven() {
        return ID_Detalle_ven;
    }

    public void setID_Detalle_ven(int ID_Detalle_ven) {
        this.ID_Detalle_ven = ID_Detalle_ven;
    }

    public int getID_Venta() {
        return ID_Venta;
    }

    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getCantidad_ven() {
        return Cantidad_ven;
    }

    public void setCantidad_ven(int Cantidad_ven) {
        this.Cantidad_ven = Cantidad_ven;
    }

    public float getPrecio_Ven() {
        return Precio_Ven;
    }

    public void setPrecio_Ven(float Precio_Ven) {
        this.Precio_Ven = Precio_Ven;
    }
    
}
