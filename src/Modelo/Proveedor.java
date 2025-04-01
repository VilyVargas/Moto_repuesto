/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiantes
 */
public class Proveedor {
    private int ID_Proveedor;
    private String Nombre_Prov;
    private String Contacto;
    private String Email;

    public Proveedor() {
    }

    public Proveedor(int ID_Proveedor, String Nombre_Prov, String Contacto, String Email) {
        this.ID_Proveedor = ID_Proveedor;
        this.Nombre_Prov = Nombre_Prov;
        this.Contacto = Contacto;
        this.Email = Email;
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public String getNombre_Prov() {
        return Nombre_Prov;
    }

    public void setNombre_Prov(String Nombre_Prov) {
        this.Nombre_Prov = Nombre_Prov;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
