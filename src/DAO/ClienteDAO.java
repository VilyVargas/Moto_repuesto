/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cliente;

import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO {
     public void crearCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Clientes (Nombre1, Nombre2, Apellidos1, Apellidos2, Cedula, Telefono) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre1());
            stmt.setString(2, cliente.getNombre2());
            stmt.setString(3, cliente.getApellidos1());
            stmt.setString(4, cliente.getApellidos2());
            stmt.setString(5, cliente.getCedula());
            stmt.setString(6, cliente.getTelefono());
            stmt.executeUpdate();
        }
    }
     public List<Cliente> leerTodasCategorias() throws SQLException {
        String sql = "SELECT * FROM Clientes";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID_Cliente(rs.getInt("ID_Venta"));
                cliente.setNombre1(rs.getString("Nombre1"));
                cliente.setNombre2(rs.getString("Nombre2"));
                cliente.setApellidos1(rs.getString("Apellidos1"));
                cliente.setApellidos2(rs.getString("Apellidos2"));
                cliente.setCedula(rs.getString("Cedula"));
                cliente.setTelefono(rs.getString("Telefono"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}
