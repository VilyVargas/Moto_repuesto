package Controlador;

import DAO.CompraDAO;
import DAO.DetalleCompraDAO;
import Modelo.Compra;
import Modelo.DetalleCompra;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class CompraControlador {
    
    private final CompraDAO compraDAO;
    private final DetalleCompraDAO detalleCompraDAO;

    public CompraControlador() {
        this.compraDAO = new CompraDAO();
        this.detalleCompraDAO = new DetalleCompraDAO();
    }
    
    // Método para crear una nueva compra con sus detalles
    public void crearCompra(int ID_Compra, Date fechaCompra, int ID_Proveedor, List<DetalleCompra> detalles) {
        try {
            Compra compra = new Compra();
            compra.setID_Compra(ID_Compra);
            compra.setFecha_compra(fechaCompra);
            compra.setID_Proveedor(ID_Proveedor);

            if (ID_Compra == -1) {
                throw new SQLException("No se pudo obtener el ID de la compra.");
            }

            // Asignar el id_compra a cada detalle y guardarlos
            for (DetalleCompra detalle : detalles) {
                detalle.setID_Compra(ID_Compra);
                detalleCompraDAO.crearDetalleCompra(detalle);
            }

            JOptionPane.showMessageDialog(null, "Compra y detalles creados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     // Método para obtener todas las compras
    public List<Compra> obtenerTodasCompras() {
        try {
            return compraDAO.leerTodasCompras();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las compras: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    // Método para actualizar una compra existente
    public void actualizarCompra(int ID_Compra, Date fechaCompra, int ID_Proveedor) {
        try {
            Compra compra = new Compra();
            compra.setID_Compra(ID_Compra);
            compra.setFecha_compra(fechaCompra);
            compra.setID_Proveedor(ID_Proveedor);
            compraDAO.actualizarCompra(compra);
            JOptionPane.showMessageDialog(null, "Compra actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para eliminar una compra
    public void eliminarCompra(int ID_Compra) {
        try {
            compraDAO.eliminarCompra(ID_Compra);
            JOptionPane.showMessageDialog(null, "Compra eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
