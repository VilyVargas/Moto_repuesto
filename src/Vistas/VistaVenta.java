package Vistas;

import Controlador.VentaControlador;
import Controlador.DetalleVentaControlador;
import Controlador.ClienteControlador;
import Controlador.ProductoControlador;
import Modelo.Venta;
import Modelo.DetalleVenta; // Assumed model class for sale details
import Modelo.Producto;
import Modelo.Cliente;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;

public class VistaVenta extends javax.swing.JPanel {
    
    private final VentaControlador VentaControlador;
    private final DetalleVentaControlador DetalleVentaControlador; 
    private final ProductoControlador productoControlador;
    private final ClienteControlador clienteControlador;
    private ArrayList<DetalleVenta> detalles; 
     
    
       private void limpiarCampos() {
        IdProducto.setText("");
        ID_Venta.setText("");
        jDateChooser1.setDate(null);
        textCantidad.setText("");
        textPrecio.setText("");
        detalles.clear();
        ((DefaultTableModel) TableVenta1.getModel()).setRowCount(0);
    }
       public void cargarDatosTabla() {
        //Obtener todas las categorias del controlador
        List<Venta> ventas = VentaControlador.obtenerTodasVentas();
        if (ventas != null) {
            // obtener el modelo existente de la tabla
            DefaultTableModel model = (DefaultTableModel) TableVenta.getModel();
            model.setRowCount(0);
            //llenar las filas con los datos de categorias  
            for (Venta ven : ventas) {
                Object[] row = {
                    ven.getID_Venta(),
                    ven.getFecha_Venta(),
                    ven.getID_Cliente(),
                    ven.getTotalVenta()
                };
                model.addRow(row);
            }
        }
    }
       
       
        private void cargarDetallesTabla(int idVenta) {
        List<DetalleVenta> detallesVenta = DetalleVentaControlador.ObtenerTodosDetalles();
        DefaultTableModel model = (DefaultTableModel) TableVenta1.getModel();
        model.setRowCount(0);
        if (detallesVenta != null) {
            for (DetalleVenta detalle : detallesVenta) {
                Object[] row = {
                    detalle.getID_Detalle_ven(),
                    detalle.getID_Venta(),
                    detalle.getID_Producto(),
                    detalle.getCantidad_ven(),
                    detalle.getPrecio_Ven()
                    
                };
                model.addRow(row);
            }
        }
    }
    
        
         private boolean validarCamposVenta() {
        if (ID_Venta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID de cliente es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "La fecha de venta es obligatoria.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(ID_Venta.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de cliente debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
        private boolean validarCamposDetalle() {
        if (textCantidad.getText().isEmpty() || textPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cantidad y precio son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(textCantidad.getText());
            Float.parseFloat(textPrecio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad y precio deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
        private void cargarProductos(){
            try {
            List <Producto> productos = productoControlador.obtenerTodosProductos();
            comboProductos.removeAllItems();
            for (Producto p : productos) {
                comboProductos.addItem(p.getNombre_P());
            }
            
            
            } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR al cargar los productos" + e.getMessage());
            }
        }
        
         private void cargarCliente(){
            try {
            List <Cliente> clientes = clienteControlador.leerTodosCliente();
            comboClientes.removeAllItems();
            for (Cliente c : clientes) {
                comboClientes.addItem(c.getNombre1() + " " + c.getApellidos1());
            }
            
            
            } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR al cargar los clientes" + e.getMessage());
            }
        }

    /**
     * Creates new form VistaVenta
     */
    public VistaVenta() {
        initComponents();
        this.VentaControlador = new VentaControlador();
        this.DetalleVentaControlador = new DetalleVentaControlador(); // Initialize controller
        this.productoControlador = new ProductoControlador();
        this.clienteControlador = new ClienteControlador();
        this.detalles = new ArrayList<>(); // Initialize detalles list
        cargarDatosTabla();
        
        
                TableVenta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && TableVenta.getSelectedRow() != -1) {
                int idVenta = (int) TableVenta.getValueAt(TableVenta.getSelectedRow(), 0);
                cargarDetallesTabla(idVenta);
                // Populate sale fields
                IdProducto.setText(String.valueOf(idVenta));
                ID_Venta.setText(String.valueOf(TableVenta.getValueAt(TableVenta.getSelectedRow(), 2)));
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    jDateChooser1.setDate(sdf.parse(TableVenta.getValueAt(TableVenta.getSelectedRow(), 1).toString()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        textCantidad1 = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        btnQuitarDetalle = new javax.swing.JButton();
        opciones = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        textBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableVenta1 = new javax.swing.JTable();
        btnQuitarDetalle1 = new javax.swing.JButton();
        BtnAgregar2 = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        textCantidad = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboClientes = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        BtnAgregar1 = new javax.swing.JButton();
        ID_Venta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        IdProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboProductos = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnQuitarDetalle4 = new javax.swing.JButton();

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-contacto (2).png"))); // NOI18N
        jButton7.setText("Agregar");

        textCantidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCantidad1ActionPerformed(evt);
            }
        });

        BtnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-contacto (2).png"))); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregar(evt);
            }
        });

        btnQuitarDetalle.setText("QuitarDetalles");
        btnQuitarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionbtnQuitarDetalles(evt);
            }
        });

        opciones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(248, 8, 8)));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 8, 8)));

        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Venta", "Fecha Venta", "ID Cliente", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableVenta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        textBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarActionPerformed(evt);
            }
        });
        textBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscarKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar (1).png"))); // NOI18N
        jButton1.setText("Buscar");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 8, 8)));

        TableVenta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Detalle Venta", "ID Venta", "ID Producto", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableVenta1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnQuitarDetalle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modelo/eliminar (2).png"))); // NOI18N
        btnQuitarDetalle1.setText("QuitarDetalles");
        btnQuitarDetalle1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 5, 5)));

        BtnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-contacto (2).png"))); // NOI18N
        BtnAgregar2.setText("Guardar");
        BtnAgregar2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BtnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregar2(evt);
            }
        });

        BtnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/retencion (1).png"))); // NOI18N
        BtnActualizar.setText("Actualizar");
        BtnActualizar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizar(evt);
            }
        });

        BtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar-usuario (1).png"))); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar(evt);
            }
        });

        BtnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar-usuario (1).png"))); // NOI18N
        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiar(evt);
            }
        });

        textCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCantidadActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha_Ven");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cantidad");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Precio");

        comboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto 1", "Producto 2", "Producto 3", "Producto 4" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cliente");

        BtnAgregar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modelo/agregar-producto (2).png"))); // NOI18N
        BtnAgregar1.setText("Agregar");
        BtnAgregar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        BtnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregar1(evt);
            }
        });

        ID_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_VentaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID_Venta");

        IdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdProductoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ID_Producto");

        comboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto 1", "Producto 2", "Producto 3", "Producto 4" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Producto");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo bonito.png"))); // NOI18N

        btnQuitarDetalle4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuitarDetalle4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eficiencia (1).png"))); // NOI18N
        btnQuitarDetalle4.setText("Gestion Reportes");
        btnQuitarDetalle4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 5, 5)));
        btnQuitarDetalle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionbtnQuitarDetalle4s(evt);
            }
        });

        javax.swing.GroupLayout opcionesLayout = new javax.swing.GroupLayout(opciones);
        opciones.setLayout(opcionesLayout);
        opcionesLayout.setHorizontalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(opcionesLayout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(opcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(49, 49, 49)
                        .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(opcionesLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(opcionesLayout.createSequentialGroup()
                                .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(44, 44, 44))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(opcionesLayout.createSequentialGroup()
                        .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(opcionesLayout.createSequentialGroup()
                                .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(opcionesLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel8)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(opcionesLayout.createSequentialGroup()
                        .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuitarDetalle4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnQuitarDetalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        opcionesLayout.setVerticalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(3, 3, 3)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarDetalle4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarDetalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(opciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarActionPerformed

    private void textBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_textBuscarKeyTyped

    private void IdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdProductoActionPerformed

    private void ID_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_VentaActionPerformed

    private void textCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCantidadActionPerformed

    private void textCantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCantidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCantidad1ActionPerformed

    private void BtnAgregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregar
        try {
            int indiceSeleccionado = comboProductos.getSelectedIndex();
            if (indiceSeleccionado < 0) {
                JOptionPane.showMessageDialog(this, "Seleccione un producto", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Producto> productos = productoControlador.obtenerTodosProductos();
            Producto productoSeleccionado = productos.get(indiceSeleccionado);
            
            float precioUnitario = productoSeleccionado.getPreciodeven();
            
            String cantidadStr = textCantidad.getText().trim();
            if (cantidadStr.isEmpty()){
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad", "ERROr", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int cantidad;
            try {
                cantidad = Integer.parseInt(cantidadStr);
                if(cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
                }
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad debe de ser un numero entero valido", "ERROr", JOptionPane.ERROR_MESSAGE);
            return;
            }
            
            float subtotal = precioUnitario * cantidad;
            DefaultTableModel model = (DefaultTableModel) TableVenta1.getModel();
            Object[] row = {
                productoSeleccionado.getID_Producto(),
                productoSeleccionado.getNombre_P(),
                precioUnitario,
                cantidad,
                subtotal
            };
            textCantidad.setText("");
            textPrecio.setText("");
            cargarProductos();
                     
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al agregar producto" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_BtnAgregar

    private void BtnAgregar1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregar1
       try {
           int indiceCliente = comboClientes.getSelectedIndex();
           if (indiceCliente < 0) {
           JOptionPane.showMessageDialog(this, "Seleccione un cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
           return;
           }
           
           List <Cliente> clientes = clienteControlador.leerTodosCliente();
           int IDCliente = clientes.get(indiceCliente).getID_Cliente();
           
           Date FechaVenta = jDateChooser1.getDate();
           if (FechaVenta == null) {
           JOptionPane.showMessageDialog(this, "Seleccione una fecha", "ERROR", JOptionPane.ERROR_MESSAGE);
           return;
           }
           
           DefaultTableModel modelDetalles = (DefaultTableModel) TableVenta1.getModel();
           int rowCount = modelDetalles.getRowCount();
           if (rowCount == 0) {
           JOptionPane.showMessageDialog(this, "Agregue al menos un producto", "ERROR", JOptionPane.ERROR_MESSAGE);
           return; 
           }
           
           List<DetalleVenta> detalles = new ArrayList<>();
           float totalVenta = 0;
           for (int i = 0; i <rowCount; i ++) {
           int idProducto = (int) modelDetalles.getValueAt(i, 0);
           int Cantidad = (int) modelDetalles.getValueAt(i, 1);
           float PrecioU = ((Number) modelDetalles.getValueAt(i, 2)).floatValue();
           float Subtotal = ((Number) modelDetalles.getValueAt(i, 3)).floatValue();
           
           DetalleVenta detalle = new DetalleVenta();
           detalle.setID_Producto(idProducto);
           detalle.setCantidad_ven(Cantidad);
           detalle.setPrecio_Ven(PrecioU);
           detalles.add(detalle);
           
           totalVenta += Subtotal;
           }
          
           VentaControlador.crearVenta(FechaVenta, IDCliente, totalVenta, detalles);
           
           limpiarCampos();
           
           cargarDatosTabla();

       }catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Error al guardar venta" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_BtnAgregar1

    private void BtnEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminar
            int selectedRow = TableVenta.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una venta para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            
              }
        int idVenta = (int) TableVenta.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar la venta ID " + idVenta + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            VentaControlador.eliminarVenta(idVenta);
            cargarDatosTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Venta eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnEliminar

    private void BtnLimpiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiar
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_BtnLimpiar

    private void BtnActualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizar
       
    }//GEN-LAST:event_BtnActualizar

    private void BtnAgregar2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregar2
  
    }//GEN-LAST:event_BtnAgregar2

    private void accionbtnQuitarDetalles(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionbtnQuitarDetalles
        // TODO add your handling code here:
        
    }//GEN-LAST:event_accionbtnQuitarDetalles

    private void accionbtnQuitarDetalle4s(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionbtnQuitarDetalle4s
        // TODO add your handling code here:
    }//GEN-LAST:event_accionbtnQuitarDetalle4s


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAgregar1;
    private javax.swing.JButton BtnAgregar2;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JTextField ID_Venta;
    private javax.swing.JTextField IdProducto;
    private javax.swing.JTable TableVenta;
    private javax.swing.JTable TableVenta1;
    private javax.swing.JButton btnQuitarDetalle;
    private javax.swing.JButton btnQuitarDetalle1;
    private javax.swing.JButton btnQuitarDetalle4;
    private javax.swing.JComboBox<String> comboClientes;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel opciones;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textCantidad1;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
}
