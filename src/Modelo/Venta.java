package Modelo;

import java.util.Date;


public class Venta {
    private int ID_Venta;
    private Date Fecha_Venta;
    private int ID_Cliente;

    public Venta() {
    }

    public Venta(int ID_Venta, Date Fecha_Venta, int ID_Cliente) {
        this.ID_Venta = ID_Venta;
        this.Fecha_Venta = Fecha_Venta;
        this.ID_Cliente = ID_Cliente;
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
    
}
