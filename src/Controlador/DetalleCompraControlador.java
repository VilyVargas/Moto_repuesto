package Controlador;

import DAO.DetalleCompraDAO;
import Modelo.DetalleCompra;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleCompraControlador {
    
    private final DetalleCompraDAO detalleCompraDAO;

    public DetalleCompraControlador() {
        this.detalleCompraDAO = new DetalleCompraDAO();
    }
     // Método para crear un nuevo detalle de compra
    public void crearDetalleCompra(int ID_Producto, int ID_Compra, int Cantidad_com, float Precio_Com) {
        try {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setID_Producto(ID_Producto);
            detalle.setID_Compra(ID_Compra);
            detalle.setCantidad_com(Cantidad_com);
            detalle.setPrecio_Com(Precio_Com);
            detalleCompraDAO.crearDetalleCompra(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de compra creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     // Método para obtener todos los detalles de compra
    public List<DetalleCompra> obtenerTodosDetallesCompra() {
        try {
            return detalleCompraDAO.leerTodasCategorias();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los detalles de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    // Método para actualizar un detalle de compra existente
    public void actualizarDetalleCompra(int idDetalleCompra, int ID_Producto, int ID_Compra, int Cantidad_com, float Precio_Com) {
        try {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setID_Detalle_Com(idDetalleCompra);
              detalle.setID_Producto(ID_Producto);
            detalle.setID_Compra(ID_Compra);
            detalle.setCantidad_com(Cantidad_com);
            detalle.setPrecio_Com(Precio_Com);
            detalleCompraDAO.actualizarDetalleCompra(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de compra actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para eliminar un detalle de compra
    public void eliminarDetalleCompra(int idDetalleCompra) {
        try {
            detalleCompraDAO.eliminarDetalleCompra(idDetalleCompra);
            JOptionPane.showMessageDialog(null, "Detalle de compra eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
