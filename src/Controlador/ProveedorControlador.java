package Controlador;

import DAO.ProveedorDAO;
import Modelo.Proveedor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ProveedorControlador {
    
    private final ProveedorDAO proveedorDAO;
    
    public ProveedorControlador() {
        this.proveedorDAO = new ProveedorDAO();
    }
    
    
        public void crearProveedor(String Nombre_Prov, String Contacto, String Email) {
        try {
            Proveedor proveedor = new Proveedor();
            proveedor.setNombre_Prov(Nombre_Prov);
            proveedor.setContacto(Contacto);
            proveedor.setEmail(Email);
            proveedorDAO.crearProveedor(proveedor);
            JOptionPane.showMessageDialog(null, "Producto creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
            public List<Proveedor> obtenerTodosProveedores() {
        try {
            return proveedorDAO.leerTodosProveedor();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los Proveedores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
                public void actualizarProveedor(String Nombre_Prov, String Contacto, String Email) {
        try {
            Proveedor proveedor = new Proveedor();
            proveedor.setNombre_Prov(Nombre_Prov);
            proveedor.setContacto(Contacto);
            proveedor.setEmail(Email);
            proveedorDAO.actualizarProveedor(proveedor);
            JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la Proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
      public void eliminarProveedor(int id) {
        try {
            proveedorDAO.eliminarProveedor(id);
            JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
