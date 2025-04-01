/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.DetalleCompra;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DetalleCompraDAO {
    public void crearDetalleCompra(DetalleCompra detalleCompra) throws SQLException {
        String sql = "INSERT INTO Categorias (nombre_categoria, descripcion_categoria) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalleCompra.getID_Detalle_Com());
            stmt.setInt(2, detalleCompra.getID_Producto());
            stmt.setInt(3, detalleCompra.getID_Compra());
            stmt.setInt(4, detalleCompra.getCantidad_com());
            stmt.setFloat(5, detalleCompra.getPrecio_Com());
            stmt.executeUpdate();
        }
    }
}
