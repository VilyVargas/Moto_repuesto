/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiantes
 */
public class Producto {
    private int ID_Producto;
    private String Nombre_P;
    private String Descripcion;
    private int Cantidad;
    private float Preciodecom;
    private float Preciodeven;

    public Producto() {
    }

    public Producto(int ID_Producto, String Nombre_P, String Descripcion, int Cantidad, float Preciodecom, float preciodeven) {
        this.ID_Producto = ID_Producto;
        this.Nombre_P = Nombre_P;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.Preciodecom = Preciodecom;
        this.Preciodeven = preciodeven;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public String getNombre_P() {
        return Nombre_P;
    }

    public void setNombre_P(String Nombre_P) {
        this.Nombre_P = Nombre_P;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPreciodecom() {
        return Preciodecom;
    }

    public void setPreciodecom(float Preciodecom) {
        this.Preciodecom = Preciodecom;
    }

    public float getPreciodeven() {
        return Preciodeven;
    }

    public void setPreciodeven(float preciodeven) {
        this.Preciodeven = preciodeven;
    }
    
}
