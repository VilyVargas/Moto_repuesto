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

/**
 *
 * @author Estudiantes
 */
public class CompraDAO {
    public void crearCompra(Compra categoria) throws SQLException {
        String sql = "INSERT INTO Categorias (nombre_categoria, descripcion_categoria) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getID_Compra());
            stmt.setDate(2, (java.sql.Date) categoria.getFecha_compra());
            stmt.setInt(3, categoria.getID_proveedor());
            stmt.executeUpdate();
        }
    }
}
