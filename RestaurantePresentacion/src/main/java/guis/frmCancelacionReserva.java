/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import dto.ClienteDTO;
import dto.MesaDTO;
import dto.ReservacionDTO;
import excepciones.ServicioException;
import implementaciones.ClientesBO;
import implementaciones.MesasBO;
import implementaciones.ReservacionesBO;
import interfacesBO.IMesasBO;
import interfacesBO.IReservacionesBO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caarl
 */
public class frmCancelacionReserva extends javax.swing.JFrame {

    private IReservacionesBO reservacionesBO = ReservacionesBO.getInstance();
    private IMesasBO mesasBO = MesasBO.getInstance();

    private Long idReservacionSeleccionada;

    /**
     * Creates new form frmCancelacionReserva
     */
    public frmCancelacionReserva() {
        
        initComponents();
        this.setTitle("Cancelar Reservacion");
        this.setResizable(false);
        this.tblReservaciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblReservaciones.getSelectedRow();
                if (selectedRow != -1) {
                    idReservacionSeleccionada = (Long) tblReservaciones.getValueAt(selectedRow, 0);
                    campoReservacionSeleccionada.setText(idReservacionSeleccionada.toString());
                }
            }
        });
        this.setLocationRelativeTo(null);
        this.cargarReservaciones();
        cargarMesasEnComboBox();
        cargarClientes();
    }

    /**
     * Carga los clientes en el sistema dentro del combobox de clientes
     */
    private void cargarClientes() {
        try {
            cbxClientes.removeAllItems(); // Limpiamos el combobox
            cbxClientes.addItem("<None>"); // Añadimos la opción inicial

            List<ClienteDTO> clientes = ClientesBO.getInstance().obtenerClientesTodos();
            for (ClienteDTO cliente : clientes) {
                cbxClientes.addItem(cliente.getTelefono()); // Agregamos los teléfonos de los clientes
            }
        } catch (ServicioException ex) {
            // Manejo de excepciones
            Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al cargar los clientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carga las mesas en el combobox segun el filtro
     */
    private void cargarMesasEnComboBox() {
        cbxMesas.addItem("<None>");  // Primer elemento como <None>

        try {

            List<MesaDTO> mesas = mesasBO.obtenerMesasTodas();

            for (MesaDTO mesa : mesas) {
                cbxMesas.addItem(mesa.getCodigo());  // Aquí puedes usar `mesa.getCodigo()` o `mesa.getNombre()`, dependiendo de la información que prefieras mostrar
            }
        } catch (ServicioException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar mesas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarReservaciones() {
        try {
            // Obtenemos todas las reservaciones existentes
            List<ReservacionDTO> reservaciones = reservacionesBO.obtenerReservacionesTodos().stream().filter(r -> r.getMulta() == null).collect(Collectors.toList());;
            // Configuramos el modelo de la tabla si aún no lo tiene
            DefaultTableModel modeloTabla = (DefaultTableModel) tblReservaciones.getModel();
            modeloTabla.setRowCount(0); // Limpiamos la tabla

            // Llenamos la tabla con las reservaciones obtenidas
            for (ReservacionDTO reservacion : reservaciones) {
                modeloTabla.addRow(new Object[]{
                    reservacion.getId(),
                    reservacion.getEstado(),
                    reservacion.getFechaHora(),
                    reservacion.getFechaHoraRegistro(),
                    reservacion.getMontoTotal(),
                    reservacion.getNumeroPersonas(),
                    reservacion.getCliente().getTelefono(), // Cambiado a número de teléfono
                    reservacion.getMesa().getCodigo(),
                    (reservacion.getMulta() != null) ? reservacion.getMulta().getPorcentaje() : 0 // Manejo de multa
                });
            }
        } catch (ServicioException ex) {
            // Manejo de excepciones
            Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al cargar las reservaciones: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCancelarReservacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservaciones = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cbxMesas = new javax.swing.JComboBox<>();
        cbxClientes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoReservacionSeleccionada = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel1.setText("Cancelar Reservacion");

        jLabel2.setText("Filtro(s)");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCancelarReservacion.setText("Cancelar Reservacion");
        btnCancelarReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservacionActionPerformed(evt);
            }
        });

        tblReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Estado", "Fecha", "Fecha Registro", "MontoTotal", "Numero de personas ", "Cliente ", "Mesa", "Multa %"
            }
        ));
        jScrollPane1.setViewportView(tblReservaciones);

        cbxMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMesasActionPerformed(evt);
            }
        });

        cbxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClientesActionPerformed(evt);
            }
        });

        jLabel5.setText("Mesas");

        jLabel6.setText("Clientes");

        jLabel3.setText("ID Reservacion Seleccionada:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMesas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoReservacionSeleccionada, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoReservacionSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarReservacion))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(509, 509, 509)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(509, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnCancelarReservacion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(226, 226, 226)
                    .addComponent(jLabel4)
                    .addContainerGap(226, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMesasActionPerformed
        String mesaSeleccionada = (String) cbxMesas.getSelectedItem();

        if ("<None>".equals(mesaSeleccionada)) {
            cargarReservaciones();  // Muestra todas las reservaciones si selecciona "<None>"
        } else {
            try {

                List<ReservacionDTO> reservaciones = reservacionesBO.obtenerReservacionesDeMesa(mesaSeleccionada);

                // Lógica para cargar en la tabla `tblResultado`
                DefaultTableModel modeloTabla = (DefaultTableModel) this.tblReservaciones.getModel();
                modeloTabla.setRowCount(0);  // Limpiamos la tabla

                for (ReservacionDTO reservacion : reservaciones) {
                    modeloTabla.addRow(new Object[]{
                        reservacion.getId(),
                        reservacion.getEstado(),
                        reservacion.getFechaHora(),
                        reservacion.getFechaHoraRegistro(),
                        reservacion.getMontoTotal(),
                        reservacion.getNumeroPersonas(),
                        reservacion.getCliente().getTelefono(), // Cambiado a número de teléfono
                        reservacion.getMesa().getCodigo(),
                        (reservacion.getMulta() != null) ? reservacion.getMulta().getPorcentaje() : 0 // Manejo de multa
                    });
                }
            } catch (ServicioException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener reservaciones: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cbxMesasActionPerformed

    private void cbxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClientesActionPerformed
        String telefonoSeleccionado = (String) cbxClientes.getSelectedItem();

        try {
            List<ReservacionDTO> reservaciones;

            if (telefonoSeleccionado.equals("<None>")) {
                // Si no hay un teléfono seleccionado, cargamos todas las reservaciones
                reservaciones = reservacionesBO.obtenerReservacionesTodos().stream().filter(r -> r.getMulta() == null).collect(Collectors.toList());
            } else {
                // Filtramos las reservaciones por el teléfono del cliente
                reservaciones = reservacionesBO.obtenerReservacionesCliente(telefonoSeleccionado).stream().filter(r -> r.getMulta() == null).collect(Collectors.toList());
            }

            // Limpiar y cargar la tabla con las reservaciones filtradas
            DefaultTableModel modeloTabla = (DefaultTableModel) tblReservaciones.getModel();
            modeloTabla.setRowCount(0); // Limpiamos la tabla

            for (ReservacionDTO reservacion : reservaciones) {
                modeloTabla.addRow(new Object[]{
                    reservacion.getId(),
                    reservacion.getEstado(),
                    reservacion.getFechaHora(),
                    reservacion.getFechaHoraRegistro(),
                    reservacion.getMontoTotal(),
                    reservacion.getNumeroPersonas(),
                    reservacion.getCliente().getTelefono(), // Cambiado a número de teléfono
                    reservacion.getMesa().getCodigo(),
                    (reservacion.getMulta() != null) ? reservacion.getMulta().getPorcentaje() : 0 // Manejo de multa
                });
            }
        } catch (ServicioException ex) {
            // Manejo de excepciones
            Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al filtrar las reservaciones: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cbxClientesActionPerformed

    private void btnCancelarReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservacionActionPerformed

        if (idReservacionSeleccionada == null) {
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this, "Desea cancelar la reservacion[ID: %d]?".formatted(this.idReservacionSeleccionada), "Cancelar Reservacion", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.NO_OPTION || opcion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        try {
            this.reservacionesBO.cancelarReservacion(idReservacionSeleccionada);
        } catch (ServicioException ex) {
            JOptionPane.showMessageDialog(
                    this, 
                    ex.getMessage(), 
                    "Cancelar Reservacion", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnCancelarReservacionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cerrar el frame actual
    this.dispose();
    
    // Abrir el nuevo frame
    frmMenuPrincipal nuevoFrame = new frmMenuPrincipal(); // Reemplaza "NuevoFrame" con el nombre de tu frame de destino
    nuevoFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarReservacion;
    private javax.swing.JLabel campoReservacionSeleccionada;
    private javax.swing.JComboBox<String> cbxClientes;
    private javax.swing.JComboBox<String> cbxMesas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReservaciones;
    // End of variables declaration//GEN-END:variables
}
