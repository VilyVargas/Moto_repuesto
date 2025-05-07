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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiantes
 */
public class DetalleVentaDAO {
     public void crearDetalleVenta(DetalleVenta detalleVenta) throws SQLException {
        String sql = "INSERT INTO Detalle_Ventas (ID_Venta, ID_Producto, Cantidad_ven, Precio_Ven) VALUES (?, ?)";
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
     public List<DetalleVenta> leerTodoDetalleVenta() throws SQLException {
        String sql = "SELECT * FROM Detalle_Ventas";
        List<DetalleVenta> detalleventas = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetalleVenta detalleventa = new DetalleVenta();
                detalleventa.setID_Detalle_ven(rs.getInt("ID_Detalle_ven"));
                detalleventa.setID_Venta(rs.getInt("ID_Venta"));
                detalleventa.setID_Producto(rs.getInt("ID_Producto"));
                detalleventa.setCantidad_ven(rs.getInt("Cantidad_ven"));
                detalleventa.setPrecio_Ven(rs.getFloat("Precio_Ven"));
                detalleventas.add(detalleventa);
            }
        }
        return detalleventas;
    }
}
