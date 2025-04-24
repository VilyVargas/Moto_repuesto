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
    
}
