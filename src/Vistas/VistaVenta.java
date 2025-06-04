package Vistas;

import Controlador.VentaControlador;
import Controlador.DetalleVentaControlador;
import Modelo.Venta;
import Modelo.DetalleVenta; // Assumed model class for sale details
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class VistaVenta extends javax.swing.JPanel {
    
    private final VentaControlador VentaControlador;
    private final DetalleVentaControlador DetalleVentaControlador; 
    private ArrayList<DetalleVenta> detalles; 
     
    
       private void limpiarCampos() {
        IdProducto.setText("");
        IdProducto1.setText("");
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
                    ven.getID_Cliente()
                };
                model.addRow(row);
            }
        }
    }
       
       
        private void cargarDetallesTabla(int idVenta) {
        List<DetalleVenta> detallesVenta = DetalleVentaControlador.leerTodosDetalleVentas();
        DefaultTableModel model = (DefaultTableModel) TableVenta1.getModel();
        model.setRowCount(0);
        if (detallesVenta != null) {
            for (DetalleVenta detalle : detallesVenta) {
                Object[] row = {
                    detalle.getID_Detalle_ven(),
                    detalle.getID_Venta(),
                    detalle.getCantidad_ven(),
                    detalle.getPrecio_Ven(),
                    detalle.getID_Producto()
                };
                model.addRow(row);
            }
        }
    }
    
        
         private boolean validarCamposVenta() {
        if (IdProducto1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID de cliente es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "La fecha de venta es obligatoria.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(IdProducto1.getText());
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
            Double.parseDouble(textPrecio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad y precio deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Creates new form VistaVenta
     */
    public VistaVenta() {
        initComponents();
        this.VentaControlador = new VentaControlador();
        this.DetalleVentaControlador = new DetalleVentaControlador(); // Initialize controller
        this.detalles = new ArrayList<>(); // Initialize detalles list
        cargarDatosTabla();
        
        
                TableVenta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && TableVenta.getSelectedRow() != -1) {
                int idVenta = (int) TableVenta.getValueAt(TableVenta.getSelectedRow(), 0);
                cargarDetallesTabla(idVenta);
                // Populate sale fields
                IdProducto.setText(String.valueOf(idVenta));
                IdProducto1.setText(String.valueOf(TableVenta.getValueAt(TableVenta.getSelectedRow(), 2)));
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
        jLabel1 = new javax.swing.JLabel();
        opciones = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        textBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableVenta1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        IdProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IdProducto1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        IdProducto2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        IdProducto3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        textCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        BtnAgregar1 = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnEliminar1 = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnAgregar2 = new javax.swing.JButton();
        btnQuitarDetalle1 = new javax.swing.JButton();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo bonito.png"))); // NOI18N

        opciones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(248, 8, 8)));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(249, 8, 8)));

        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Venta", "Fecha Venta", "ID Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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
                "ID Detalle Venta", "ID Venta", "Cantidad", "Precio", "ID Producto"
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID_Venta");

        IdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdProductoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ID_Cliente");

        IdProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdProducto1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ID_Detalle V");

        IdProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdProducto2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ID_Detalle V");

        IdProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdProducto3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha_Ven");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cantidad");

        textCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCantidadActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Precio");

        BtnAgregar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modelo/agregar-producto (2).png"))); // NOI18N
        BtnAgregar1.setText("Agregar");
        BtnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregar1(evt);
            }
        });

        BtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar-usuario (1).png"))); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar(evt);
            }
        });

        BtnEliminar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar-usuario (1).png"))); // NOI18N
        BtnEliminar1.setText("Limpiar");
        BtnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar1(evt);
            }
        });

        BtnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/retencion (1).png"))); // NOI18N
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizar(evt);
            }
        });

        BtnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-contacto (2).png"))); // NOI18N
        BtnAgregar2.setText("Guardar");
        BtnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregar2(evt);
            }
        });

        btnQuitarDetalle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modelo/eliminar (2).png"))); // NOI18N
        btnQuitarDetalle1.setText("QuitarDetalles");
        btnQuitarDetalle1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 5, 5)));

        javax.swing.GroupLayout opcionesLayout = new javax.swing.GroupLayout(opciones);
        opciones.setLayout(opcionesLayout);
        opcionesLayout.setHorizontalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(opcionesLayout.createSequentialGroup()
                        .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(opcionesLayout.createSequentialGroup()
                                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(IdProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(opcionesLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))
                                    .addGroup(opcionesLayout.createSequentialGroup()
                                        .addComponent(IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IdProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IdProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(opcionesLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(opcionesLayout.createSequentialGroup()
                                        .addComponent(textPrecio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(BtnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addContainerGap())
                    .addGroup(opcionesLayout.createSequentialGroup()
                        .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuitarDetalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnEliminar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        opcionesLayout.setVerticalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(opcionesLayout.createSequentialGroup()
                        .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(14, 14, 14)
                        .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IdProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IdProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IdProducto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(BtnAgregar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(opcionesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnQuitarDetalle1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void IdProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdProducto1ActionPerformed

    private void IdProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdProducto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdProducto2ActionPerformed

    private void IdProducto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdProducto3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdProducto3ActionPerformed

    private void textCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCantidadActionPerformed

    private void textCantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCantidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCantidad1ActionPerformed

    private void BtnAgregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregar
        if (validarCamposDetalle()) {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setID_Detalle_ven(detalles.size() + 1); // Temporary ID
            detalle.setID_Venta(Integer.parseInt(IdProducto.getText().isEmpty() ? "0" : IdProducto.getText()));
            detalle.setCantidad_ven(Integer.parseInt(textCantidad.getText()));
            detalle.setPrecio_Ven(Float.parseFloat(textPrecio.getText()));
            detalles.add(detalle);
            
            // Update TableVenta1
            DefaultTableModel model = (DefaultTableModel) TableVenta1.getModel();
            model.addRow(new Object[]{
                detalle.getID_Detalle_ven(),
                detalle.getID_Venta(),
                detalle.getCantidad_ven(),
                detalle.getPrecio_Ven(),
                detalle.getID_Producto()
            });
            

            textCantidad.setText("");
            textPrecio.setText("");
        }
    }//GEN-LAST:event_BtnAgregar

    private void BtnAgregar1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregar1
       BtnAgregar(evt);
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

    private void BtnEliminar1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminar1
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEliminar1

    private void BtnActualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizar
       
    }//GEN-LAST:event_BtnActualizar

    private void BtnAgregar2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregar2
  
    }//GEN-LAST:event_BtnAgregar2

    private void accionbtnQuitarDetalles(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionbtnQuitarDetalles
        // TODO add your handling code here:
        
    }//GEN-LAST:event_accionbtnQuitarDetalles


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAgregar1;
    private javax.swing.JButton BtnAgregar2;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnEliminar1;
    private javax.swing.JTextField IdProducto;
    private javax.swing.JTextField IdProducto1;
    private javax.swing.JTextField IdProducto2;
    private javax.swing.JTextField IdProducto3;
    private javax.swing.JTable TableVenta;
    private javax.swing.JTable TableVenta1;
    private javax.swing.JButton btnQuitarDetalle;
    private javax.swing.JButton btnQuitarDetalle1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
