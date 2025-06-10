package Modelo;

import java.util.Date;
import java.util.List;


public class Venta {
    private int ID_Venta;
    private Date Fecha_Venta;
    private int ID_Cliente;
    private float totalVenta;
    private List<DetalleVenta> detalles;

    public Venta() {
    }

    public Venta(int ID_Venta, Date Fecha_Venta, int ID_Cliente, float totalVenta, List<DetalleVenta> detalles) {
        this.ID_Venta = ID_Venta;
        this.Fecha_Venta = Fecha_Venta;
        this.ID_Cliente = ID_Cliente;
        this.totalVenta = totalVenta;
        this.detalles = detalles;
    }

    public int getID_Venta() {
        return ID_Venta;
    }

    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }

    public Date getFecha_Venta() {
        return Fecha_Venta;
    }

    public void setFecha_Venta(Date Fecha_Venta) {
        this.Fecha_Venta = Fecha_Venta;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    
    
}
