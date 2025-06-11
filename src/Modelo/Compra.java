package Modelo;

import java.util.Date;

public class Compra {
    private int ID_Compra;
    private Date Fecha_compra;
    private int Cantidad;
    private int ID_Producto;
    private int ID_Proveedor;

    public Compra() {
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public Date getFecha_compra() {
        return Fecha_compra;
    }

    public void setFecha_compra(Date Fecha_compra) {
        this.Fecha_compra = Fecha_compra;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public Compra(int ID_Compra, Date Fecha_compra, int Cantidad, int ID_Producto, int ID_Proveedor) {
        this.ID_Compra = ID_Compra;
        this.Fecha_compra = Fecha_compra;
        this.Cantidad = Cantidad;
        this.ID_Producto = ID_Producto;
        this.ID_Proveedor = ID_Proveedor;
    }

  
}
