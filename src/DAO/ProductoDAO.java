/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Producto;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
     public void crearProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO Productos (Nombre_P, Descripcion, Cantidad, Preciodecom, Preciodeven) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, producto.getID_Producto());
            stmt.setString(2, producto.getNombre_P());
            stmt.setString(3, producto.getDescripcion());
            stmt.setInt(4, producto.getCantidad());
            stmt.setFloat(5, producto.getPreciodecom());
            stmt.setFloat(6, producto.getPreciodeven());
            stmt.executeUpdate();
        }
    }
     public List<Producto> leerTodosProductos() throws SQLException {
        String sql = "SELECT * FROM Productos";
        List<Producto> productos = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setID_Producto(rs.getInt("ID_Producto"));
                producto.setNombre_P(rs.getString("Nombre_P"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setCantidad(rs.getInt("Cantidad"));
                producto.setPreciodecom(rs.getFloat("Preciodecom"));
                producto.setPreciodeven(rs.getFloat("Preciodeven"));
                productos.add(producto);
            }
        }
        return productos;
    }
     public void actualizarCliente(Producto producto) throws SQLException {
    String sql = "UPDATE Productos SET Nombre_P = ?, Descripcion = ?, Cantidad = ?, Preciodecom = ?, Preciodeven = ? WHERE ID_Producto = ?";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, producto.getNombre_P());
        stmt.setString(2, producto.getDescripcion());
        stmt.setInt(3, producto.getCantidad());
        stmt.setFloat(4, producto.getPreciodecom());
        stmt.setFloat(5, producto.getPreciodeven());
        stmt.executeUpdate();
    }
}
     public void eliminarCategoria(int ID_Producto) throws SQLException {
        String sql = "DELETE FROM Productos WHERE ID_Producto = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, ID_Producto);
            stmt.executeUpdate();
        }
    }
     public static void main(String[] args) {
        try {
            ProductoDAO dao = new ProductoDAO();

            // Leer y mostrar todos los productos para verificar
            List<Producto> productos = dao.leerTodosProductos();
            System.out.println("Lista de productos:");
            for (Producto prod : productos) {
                System.out.println("ID: " + prod.getID_Producto()
                        + ", Nombre: " + prod.getNombre_P()
                        + ", Descripción: " + prod.getDescripcion()
                        + ", Cantida: " + prod.getCantidad()
                        + ", Precio de venta: " + prod.getPreciodecom()
                        + ", Precio de compra: " + prod.getPreciodeven());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
