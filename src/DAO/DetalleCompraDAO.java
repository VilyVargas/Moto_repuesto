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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DetalleCompraDAO {
    public void crearDetalleCompra(DetalleCompra detalleCompra) throws SQLException {
        String sql = "INSERT INTO Detalle_Compras (ID_Producto, ID_Compra, Cantidad_com, Precio_Com) VALUES (?, ?)";
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
    public List<DetalleCompra> leerTodasCategorias() throws SQLException {
        String sql = "SELECT * FROM Detalle_Compras";
        List<DetalleCompra> detalleCompras = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetalleCompra detallescompra = new DetalleCompra();
                detallescompra.setID_Detalle_Com(rs.getInt("ID_Venta"));
                detallescompra.setID_Producto(rs.getInt("ID_Producto"));
                detallescompra.setID_Compra(rs.getInt("ID_Compra"));
                detallescompra.setCantidad_com(rs.getInt("Cantidad_com"));
                detallescompra.setPrecio_Com(rs.getFloat("Precio_Com"));
                detalleCompras.add(detallescompra);
            }
        }
        return detalleCompras;
    }
}
