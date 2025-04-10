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
import java.util.List;

public class VentaDAO {
    public void crearVenta(Venta venta) throws SQLException {
        String sql = "INSERT INTO Ventas (Fecha_Venta, ID_Cliente) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, venta.getID_Venta());
            stmt.setDate(2, (java.sql.Date) venta.getFecha_Venta());
            stmt.setInt(3, venta.getID_Cliente());
            stmt.executeUpdate();
        }
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
    public void actualizarCompra(Venta venta) throws SQLException {
        String sql = "UPDATE Ventas SET Fecha_Venta = ?, ID_Cliente = ? WHERE ID_Compra = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(venta.getFecha_Venta().getTime()));
            stmt.setInt(3, venta.getID_Cliente());
            stmt.executeUpdate();
        }
    }

    public void eliminarCompra(int ID_Venta) throws SQLException {
        String sql = "DELETE FROM Ventas WHERE ID_Venta = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Venta);
            stmt.executeUpdate();
        }
    }
    public static void main(String[] args) {
        try {
            VentaDAO dao = new VentaDAO();


            // Leer y mostrar todas las ventas para verificar
            List<Venta> ventas = dao.leerTodasVentas();
            System.out.println("Lista de ventas:");
            for (Venta ven : ventas) {
                System.out.println("ID: " + ven.getID_Venta()
                        + ", Fecha: " + ven.getFecha_Venta()
                        + ", Cliente: " + ven.getID_Cliente());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
