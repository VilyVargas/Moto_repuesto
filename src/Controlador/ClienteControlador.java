package Controlador;

import DAO.ClienteDAO;
import Modelo.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteControlador {
    
    private final ClienteDAO clienteDAO;

    public ClienteControlador() {
        this.clienteDAO = new ClienteDAO();
    }
    // Método para crear un nuevo cliente
    public void crearCliente(String Nombre1, String Nombre2, String Apellidos1,String Apellidos2, String cedula,  String telefono) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNombre1(Nombre1);
            cliente.setNombre2(Nombre2);
            cliente.setApellidos1(Apellidos1);
            cliente.setApellidos2(Apellidos2);
            cliente.setCedula(cedula);
            cliente.setTelefono(telefono);
            clienteDAO.crearCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para obtener todos los clientes
    public List<Cliente> leerTodosCliente() {
        try {
            return clienteDAO.leerClientes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
     // Método para actualizar un cliente existente
    public void actualizarCliente(int idCliente, String Nombre1, String Nombre2, String Apellidos1,
            String Apellidos2, String cedula, String telefono) {
        try {
            Cliente cliente = new Cliente();
            cliente.setID_Cliente(idCliente);
            cliente.setNombre1(Nombre1);
            cliente.setNombre2(Nombre2);
            cliente.setApellidos1(Apellidos1);
            cliente.setApellidos2(Apellidos2);
            cliente.setCedula(cedula);
            cliente.setTelefono(telefono);
            clienteDAO.actualizarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para eliminar un cliente
    public void eliminarCliente(int idCliente) {
        try {
            clienteDAO.eliminarCliente(idCliente);
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
}
