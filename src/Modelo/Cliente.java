/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiantes
 */
public class Cliente {
    private int ID_Cliente;
    private String Nombre1;
    private String Nombre2;
    private String Apellidos1;
    private String Apellidos2;
    private String Cedula;
    private String Telefono;

    public Cliente() {
    }

    public Cliente(int ID_Cliente, String Nombre1, String Nombre2, String Apellidos1, String Apellidos2, String Cedula, String Telefono) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre1 = Nombre1;
        this.Nombre2 = Nombre2;
        this.Apellidos1 = Apellidos1;
        this.Apellidos2 = Apellidos2;
        this.Cedula = Cedula;
        this.Telefono = Telefono;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNombre1() {
        return Nombre1;
    }

    public void setNombre1(String Nombre1) {
        this.Nombre1 = Nombre1;
    }

    public String getNombre2() {
        return Nombre2;
    }

    public void setNombre2(String Nombre2) {
        this.Nombre2 = Nombre2;
    }

    public String getApellidos1() {
        return Apellidos1;
    }

    public void setApellidos1(String Apellidos1) {
        this.Apellidos1 = Apellidos1;
    }

    public String getApellidos2() {
        return Apellidos2;
    }

    public void setApellidos2(String Apellidos2) {
        this.Apellidos2 = Apellidos2;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
}
