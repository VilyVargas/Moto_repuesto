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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

public class VentaDAO {
    //Método de VentaDAO
    public int crearVenta(Venta venta) throws SQLException {
        String sql = """
        INSERT INTO Ventas (
            ID_Venta,  
            fecha_venta, 
            ID_Cliente
        ) VALUES (?, ?, ?, ?)""";
        int generatedId = -1;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, venta.getID_Venta());
            stmt.setDate(2, (java.sql.Date) venta.getFecha_Venta());
            stmt.setInt(4, venta.getID_Cliente());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        }
        return generatedId;
    }
    public List<Venta> leerTodasVentas() throws SQLException {
        String sql = "SELECT * FROM Ventas";
        List<Venta> ventas = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setID_Venta(rs.getInt("ID_Venta"));
                venta.setFecha_Venta(rs.getDate("Fecha_Venta"));
                venta.setID_Cliente(rs.getInt("ID_Cliente"));
                ventas.add(venta);
            }
        }
        return ventas;
    }
    public void actualizarVenta(Venta venta) throws SQLException {
        String sql = "UPDATE Ventas SET Fecha_Venta = ?, ID_Cliente = ? WHERE ID_Compra = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(venta.getFecha_Venta().getTime()));
            stmt.setInt(3, venta.getID_Cliente());
            stmt.executeUpdate();
        }
    }

    public void eliminarVenta(int ID_Venta) throws SQLException {
        String sql = "DELETE FROM Ventas WHERE ID_Venta = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Venta);
            stmt.executeUpdate();
        }
    }
}
