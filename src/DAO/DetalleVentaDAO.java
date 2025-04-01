/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.DetalleVenta;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Estudiantes
 */
public class DetalleVentaDAO {
     public void crearDetalleVenta(DetalleVenta detalleVenta) throws SQLException {
        String sql = "INSERT INTO Categorias (nombre_categoria, descripcion_categoria) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalleVenta.getID_Detalle_ven());
            stmt.setInt(2, detalleVenta.getID_Venta());
            stmt.setInt(3, detalleVenta.getID_Producto());
            stmt.setInt(4, detalleVenta.getCantidad_ven());
            stmt.setFloat(5, detalleVenta.getPrecio_Ven());
            stmt.executeUpdate();
        }
    }
}
