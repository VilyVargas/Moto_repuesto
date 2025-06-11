/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProveedorDAO {
    public void crearProveedor(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO Proveedores (Nombre_Prov, Contacto, Email) VALUES (?,?,?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre_Prov());
            stmt.setString(2, proveedor.getContacto());
            stmt.setString(3, proveedor.getEmail());
            stmt.executeUpdate();
        }
    }
    public List<Proveedor> leerTodosProveedor() throws SQLException {
        String sql = "SELECT * FROM Proveedores";
        List<Proveedor> proveedores = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setID_Proveedor(rs.getInt("ID_Proveedor"));
                proveedor.setNombre_Prov(rs.getString("Nombre_Prov"));
                proveedor.setContacto(rs.getString("Contacto"));
                proveedor.setEmail(rs.getString("Email"));
                proveedores.add(proveedor);
            }
        }
        return proveedores;
    }
    public void actualizarProveedor(Proveedor proveedor) throws SQLException {
        String sql = "UPDATE Proveedores SET Nombre_Prov = ?, Contacto = ?, Email = ? WHERE ID_Proveedor = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre_Prov());
            stmt.setString(2, proveedor.getContacto());
            stmt.setString(3, proveedor.getEmail()); 
            stmt.setInt(4,  proveedor.getID_Proveedor());
            stmt.executeUpdate();
        }
    }

    public void eliminarProveedor(int ID_Proveedor) throws SQLException {
        String sql = "DELETE FROM Proveedores WHERE ID_Proveedor = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Proveedor);
            stmt.executeUpdate();
        }
    }
}
