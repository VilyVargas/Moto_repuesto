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
            stmt.setInt(3, categoria.getCantidad());
            stmt.setInt(4, categoria.getID_Producto());
            stmt.setInt(5, categoria.getID_Proveedor());
            stmt.executeUpdate();
        }
    }
    public List<Compra> leerTodasCompras() throws SQLException {
        String sql = "SELECT * FROM Compras";
        List<Compra> compras = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setID_Compra(rs.getInt("ID_Compra"));
                compra.setFecha_compra(rs.getDate("Fecha_compra"));
                compra.setCantidad(rs.getInt("Cantidad"));
                compra.setID_Producto(rs.getInt("ID_Producto"));
                compra.setID_Proveedor(rs.getInt("ID_Proveedor"));
                compras.add(compra);
            }
        }
        return compras;
    }
    public void actualizarCompra(Compra compra) throws SQLException {
        String sql = "UPDATE Compras SET Fecha_compra = ?, ID_proveedor = ? WHERE ID_Compra = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(compra.getFecha_compra().getTime()));
            stmt.setInt(2, compra.getCantidad());
            stmt.setInt(3, compra.getID_Producto());
            stmt.setInt(4, compra.getID_Proveedor());
            stmt.executeUpdate();
        }
    }

    public void eliminarCompra(int ID_Compra) throws SQLException {
        String sql = "DELETE FROM Compras WHERE ID_Compra = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Compra);
            stmt.executeUpdate();
        }
    }
}
