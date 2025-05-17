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
        String sql = "INSERT INTO Detalle_Compras  (ID_Detalle_Com, ID_Producto, ID_Compra, Cantidad_com, Precio_Com) VALUES (?,?,?,?,?)";
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
    public List<DetalleCompra> leerTodoDetallesCompra() throws SQLException {
        String sql = "SELECT * FROM Detalle_Compras";
        List<DetalleCompra> detalleCompras = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetalleCompra detallescompra = new DetalleCompra();
                detallescompra.setID_Detalle_Com(rs.getInt("ID_Detalle_Com"));
                detallescompra.setID_Producto(rs.getInt("ID_Producto"));
                detallescompra.setID_Compra(rs.getInt("ID_Compra"));
                detallescompra.setCantidad_com(rs.getInt("Cantidad_com"));
                detallescompra.setPrecio_Com(rs.getFloat("Precio_Com"));
                detalleCompras.add(detallescompra);
            }
        }
        return detalleCompras;
    }
    public void actualizarDetalleCompra(DetalleCompra detallecompra) throws SQLException {
        String sql = "UPDATE Detalle_Compras SET ID_Detalle_Com = ?, ID_Compra = ?, Cantidad_com = ?, Precio_Com = ? WHERE ID_Detalle_Com = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detallecompra.getID_Producto());
            stmt.setInt(2, detallecompra.getID_Compra());
            stmt.setInt(3, detallecompra.getCantidad_com());
            stmt.setFloat(4, detallecompra.getPrecio_Com());
            stmt.executeUpdate();
        }
    }

    public void eliminarDetalleCompra(int ID_Detalle_Com) throws SQLException {
        String sql = "DELETE FROM Detalle_Compras WHERE ID_Detalle_Com = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Detalle_Com);
            stmt.executeUpdate();
        }
    }
}
