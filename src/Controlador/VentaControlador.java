package Controlador;

import DAO.VentaDAO;
import DAO.DetalleVentaDAO;
import Modelo.Venta;
import Modelo.DetalleVenta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class VentaControlador {
    
    private final VentaDAO ventaDAO;
    private final DetalleVentaDAO detalleVentaDAO;

    public VentaControlador() {
        this.ventaDAO = new VentaDAO();
        this.detalleVentaDAO = new DetalleVentaDAO();
    }
    // Método para crear una nueva venta con sus detalles

    public void crearVenta( Date fechaVenta, int ID_Cliente, List<DetalleVenta> detalles) {
        try {
            Venta venta = new Venta();
            venta.setFecha_Venta(fechaVenta);
            venta.setID_Cliente(ID_Cliente);
            int ID_Venta = ventaDAO.crearVenta(venta);

            if (ID_Venta == -1) {
                throw new SQLException("No se pudo obtener el ID de la venta.");
            }

            // Asignar el id_venta a cada detalle y guardarlos
            for (DetalleVenta detalle : detalles) {
                detalle.setID_Venta(ID_Venta);
                detalleVentaDAO.crearDetalleVenta(detalle);
            }

            JOptionPane.showMessageDialog(null, "Venta y detalles creados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para obtener todas las ventas
    public List<Venta> obtenerTodasVentas() {
        try {
            return ventaDAO.leerTodasVentas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las ventas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    // Método para actualizar una venta existente
    public void actualizarVenta(int ID_Venta,  Date fechaVenta, int ID_Cliente) {
        try {
            Venta venta = new Venta();
            venta.setID_Venta(ID_Venta);
            venta.setFecha_Venta(fechaVenta);
            venta.setID_Cliente(ID_Cliente);
            ventaDAO.actualizarCompra(venta);
            JOptionPane.showMessageDialog(null, "Venta actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para eliminar una venta
    public void eliminarVenta(int ID_Venta) {
        try {
            ventaDAO.eliminarCompra(ID_Venta);
            JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
