/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Cliente;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ClienteDAO {
     public void crearCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Categorias (nombre_categoria, descripcion_categoria) VALUES (?, ?)";
        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre1());
            stmt.setString(2, cliente.getNombre2());
            stmt.setString(3, cliente.getApellidos1());
            stmt.setString(4, cliente.getApellidos2());
            stmt.setString(5, cliente.getCedula());
            stmt.setString(6, cliente.getTelefono());
            stmt.executeUpdate();
        }
    }
}
