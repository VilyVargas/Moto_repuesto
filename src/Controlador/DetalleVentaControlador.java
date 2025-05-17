package Controlador;

import DAO.DetalleVentaDAO;
import Modelo.DetalleVenta;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleVentaControlador {
    
      private final DetalleVentaDAO detalleventaDAO;

    public DetalleVentaControlador() {
        this.detalleventaDAO = new DetalleVentaDAO();
    }
    // Método para crear un nuevo cliente
    public void crearDetalleVenta(int ID_Detalle_Venta, int ID_Venta, int ID_Producto, int Cantidad_Ven, float Precio_Ven) {
        try {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setID_Detalle_ven(ID_Detalle_Venta);
            detalle.setID_Venta(ID_Venta);
            detalle.setID_Producto(ID_Producto);
            detalle.setCantidad_ven(Cantidad_Ven);
            detalle.setPrecio_Ven(Precio_Ven);
            detalleventaDAO.crearDetalleVenta(detalle);
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para obtener todos los clientes
    public List<DetalleVenta> leerTodosDetalleVentas() {
        try {
            return detalleventaDAO.leerTodoDetalleVenta();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
     // Método para actualizar un cliente existente
    public void actualizarDetalle(int ID_Detalle_Venta, int ID_Venta, int ID_Producto, int Cantidad_Ven, float Precio_Ven) {
        try {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setID_Detalle_ven(ID_Detalle_Venta);
            detalle.setID_Venta(ID_Venta);
            detalle.setID_Producto(ID_Producto);
            detalle.setCantidad_ven(Cantidad_Ven);
            detalle.setPrecio_Ven(Precio_Ven);
            detalleventaDAO.actualizarDetalle(detalle);
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para eliminar un cliente
    public void eliminarCliente(int ID_Detalle_Venta) {
        try {
            detalleventaDAO.eliminarDetalle(ID_Detalle_Venta);
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
}
