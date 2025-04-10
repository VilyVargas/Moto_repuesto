/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Util.ConexionDB;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Compra;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CompraDAO {
    public void crearCompra(Compra categoria) throws SQLException {
        String sql = "INSERT INTO Compras (Fecha_compra, ID_proveedor) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getID_Compra());
            stmt.setDate(2, (java.sql.Date) categoria.getFecha_compra());
            stmt.setInt(3, categoria.getID_proveedor());
            stmt.executeUpdate();
        }
    }
    public List<Compra> leerTodasCategorias() throws SQLException {
        String sql = "SELECT * FROM Compras";
        List<Compra> compras = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setID_Compra(rs.getInt("ID_Compra"));
                compra.setFecha_compra(rs.getDate("Fecha_compra"));
                compra.setID_proveedor(rs.getInt("ID_proveedor"));
                compras.add(compra);
            }
        }
        return compras;
    }
}
