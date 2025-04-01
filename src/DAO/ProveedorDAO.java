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


public class ProveedorDAO {
    public void crearProveedor(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO Categorias (nombre_categoria, descripcion_categoria) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, proveedor.getID_Proveedor());
            stmt.setString(2, proveedor.getNombre_Prov());
            stmt.setString(3, proveedor.getContacto());
            stmt.setString(4, proveedor.getEmail());
            stmt.executeUpdate();
        }
    }
}
