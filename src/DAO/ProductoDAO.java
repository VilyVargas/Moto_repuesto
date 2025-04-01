/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Producto;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProductoDAO {
     public void crearProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO Categorias (nombre_categoria, descripcion_categoria) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, producto.getID_Producto());
            stmt.setString(2, producto.getNombre_P());
            stmt.setString(3, producto.getDescripcion());
            stmt.setInt(4, producto.getCantidad());
            stmt.setFloat(5, producto.getPreciodecom());
            stmt.setFloat(6, producto.getPreciodeven());
            stmt.executeUpdate();
        }
    }
}
