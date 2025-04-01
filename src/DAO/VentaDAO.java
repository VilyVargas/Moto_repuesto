/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Venta;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class VentaDAO {
    public void crearVenta(Venta venta) throws SQLException {
        String sql = "INSERT INTO Categorias (nombre_categoria, descripcion_categoria) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, venta.getID_Venta());
            stmt.setDate(2, (java.sql.Date) venta.getFecha_Venta());
            stmt.setInt(3, venta.getID_Cliente());
            stmt.executeUpdate();
        }
    }
}
