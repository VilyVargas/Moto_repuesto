package Controlador;

import DAO.ProductoDAO;
import Modelo.Producto;
import Modelo.Proveedor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoControlador {
    
    private final ProductoDAO productoDAO;

    public ProductoControlador() {
        this.productoDAO = new ProductoDAO();
    }
    // Método para crear un nuevo producto
    public void crearProducto(String Nombre_P, String Descripcion, int Cantidad,
            float Preciodecom, float Preciodeven) {
        try {
            Producto producto = new Producto();
            producto.setNombre_P(Nombre_P);
            producto.setDescripcion(Descripcion);
            producto.setCantidad(Cantidad);
            producto.setPreciodecom(Preciodecom);
            producto.setPreciodeven(Preciodeven);
            productoDAO.crearProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para obtener todos los productos
    public List<Producto> obtenerTodosProductos() {
        try {
            return productoDAO.leerTodosProductos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    // Método para actualizar un producto existente
    public void actualizarProducto(int ID_Producto, String Nombre_P, String Descripcion, int Cantidad,
            float Preciodecom, float Preciodeven) {
        try {
            Producto producto = new Producto();
            producto.setID_Producto(ID_Producto);
          producto.setNombre_P(Nombre_P);
            producto.setDescripcion(Descripcion);
            producto.setCantidad(Cantidad);
            producto.setPreciodecom(Preciodecom);
            producto.setPreciodeven(Preciodeven);
            productoDAO.actualizarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para eliminar un producto
    public void eliminarProducto(int ID_Producto) {
        try {
            productoDAO.eliminarCliente(ID_Producto);
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public Producto obtenerProductoPorId(int ID_Producto) {
        try {
            return productoDAO.obtenerProductoPorId(ID_Producto);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el empleado: " + e.getMessage());
            return null;
        }
    }
    
    
}
