/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;

public class Compra {
    private int ID_Compra;
    private Date Fecha_compra;
    private int ID_proveedor;

    public Compra() {
    }

    public Compra(int ID_Compra, Date Fecha_compra, int ID_proveedor) {
        this.ID_Compra = ID_Compra;
        this.Fecha_compra = Fecha_compra;
        this.ID_proveedor = ID_proveedor;
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

    public int getID_proveedor() {
        return ID_proveedor;
    }

    public void setID_proveedor(int ID_proveedor) {
        this.ID_proveedor = ID_proveedor;
    }
    
}
