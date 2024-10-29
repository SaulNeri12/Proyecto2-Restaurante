/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import com.github.lgooddatepicker.components.TimePicker;
import dto.MesaDTO;
import dto.RestauranteDTO;
import dto.UbicacionMesaDTO;
import excepciones.ServicioException;
import implementaciones.MesasBO;
import interfacesBO.IMesasBO;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author caarl
 */
public class frmMenuPrincipal extends javax.swing.JFrame {
    
    private IMesasBO mesasBO = MesasBO.getInstance();
    
    private RestauranteDTO restaurante;
    
    /**
     * Creates new form frmMenuPrincipal
     * @param restaurante
     */
    public frmMenuPrincipal(RestauranteDTO restaurante) {
        initComponents();
        this.restaurante = restaurante;
        this.campoTelefono.setText(this.restaurante.getTelefono());
        this.campoTelefono.setEnabled(false);
        this.campoHoraApertura.setEnabled(false);
        this.campoHoraCierre.setEnabled(false);
        
        this.setLocationRelativeTo(null);
        this.cargarHorario();
        this.cargarEstadisticas();
    }

    /**
     * Carga el horario del restaurante en pantalla
     */
    private void cargarHorario() {
        this.campoHoraApertura.setTime(this.restaurante.getHoraApertura());
        this.campoHoraCierre.setTime(this.restaurante.getHoraCierre());
    }
    
    /**
     * Muestra el numero de mesas disponibles por tipo y ubicacion de la misma
     */
    private void cargarEstadisticas() {
        List<MesaDTO> mesasDisponibles = null;
        
        try {
            mesasDisponibles = this.mesasBO.obtenerMesasDisponibles(this.restaurante.getId());
        } catch (ServicioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Cargar Mesas Disponibles", JOptionPane.ERROR_MESSAGE);
        }
        
        List<MesaDTO> mesasPequeniasDisponibles = mesasDisponibles.stream().filter(m -> m.getTipoMesa().getNombre().equalsIgnoreCase("pequenia")).collect(Collectors.toList());
        List<MesaDTO> mesasMedianasDisponibles = mesasDisponibles.stream().filter(m -> m.getTipoMesa().getNombre().equalsIgnoreCase("mediana")).collect(Collectors.toList());
        List<MesaDTO> mesasGrandesDisponibles = mesasDisponibles.stream().filter(m -> m.getTipoMesa().getNombre().equalsIgnoreCase("grande")).collect(Collectors.toList());
        
        // labels principales
        this.lblCantidadMesasPequenias.setText(String.valueOf(mesasPequeniasDisponibles.size()));
        this.lblCantidadMesasMedianas.setText(String.valueOf(mesasMedianasDisponibles.size()));
        this.lblCantidadMesasGrandes.setText(String.valueOf(mesasGrandesDisponibles.size()));
        
        // labels ubicaciones mesa pequenia
        Long cantidadPeqGen = mesasPequeniasDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.GENERAL)).count();
        this.lblMesasPequeniasGeneral.setText(cantidadPeqGen.toString());
        Long cantidadPeqTerr = mesasPequeniasDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.TERRAZA)).count();
        this.lblMesasPequeniasTerraza.setText(cantidadPeqTerr.toString());
        Long cantidadPeqVen = mesasPequeniasDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.VENTANA)).count();
        this.lblMesasPequeniasVentana.setText(cantidadPeqVen.toString());
        
        // labels ubicaciones mesa pequenia
        Long cantidadMedGen = mesasMedianasDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.GENERAL)).count();
        this.lblMesasMedianasGeneral.setText(cantidadMedGen.toString());
        Long cantidadMedTerr = mesasMedianasDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.TERRAZA)).count();
        this.lblMesasMedianasTerraza.setText(cantidadMedTerr.toString());
        Long cantidadMedVen = mesasMedianasDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.VENTANA)).count();
        this.lblMesasMedianasVentana.setText(cantidadMedVen.toString());
        
        // labels ubicaciones mesa pequenia
        Long cantidadGraGen = mesasGrandesDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.GENERAL)).count();
        this.lblMesasGrandesGeneral.setText(cantidadGraGen.toString());
        Long cantidadGraTerr = mesasGrandesDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.TERRAZA)).count();
        this.lblMesasGrandesTerraza.setText(cantidadGraTerr.toString());
        Long cantidadGraVen = mesasGrandesDisponibles.stream().filter(m->m.getUbicacion().equals(UbicacionMesaDTO.VENTANA)).count();
        this.lblMesasGrandesVentana.setText(cantidadGraVen.toString());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblCantidadMesasMedianas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMesasPequeniasTerraza = new javax.swing.JLabel();
        lblCantidadMesasGrandes = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblMesasGrandesGeneral = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblMesasGrandesTerraza = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblMesasGrandesVentana = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblMesasPequeniasGeneral = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblMesasPequeniasVentana = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblMesasMedianasGeneral = new javax.swing.JLabel();
        lblMesasMedianasTerraza = new javax.swing.JLabel();
        lblMesasMedianasVentana = new javax.swing.JLabel();
        lblCantidadMesasPequenias = new javax.swing.JLabel();
        campoHoraApertura = new com.github.lgooddatepicker.components.TimePicker();
        campoHoraCierre = new com.github.lgooddatepicker.components.TimePicker();
        jLabel11 = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miAdministrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Horario");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setText("Apertura:");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setText("Cierre:");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setText("Mesas Disponibles");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setText("Pequeñas");

        lblCantidadMesasMedianas.setText("$$");

        jLabel7.setText("Medianas");

        jLabel8.setText("Grandes");

        lblMesasPequeniasTerraza.setText("$$");

        lblCantidadMesasGrandes.setText("$$");

        jLabel9.setText("Disponibles: ");

        jLabel10.setText("Disponibles: ");

        jLabel12.setText("Disponibles: ");

        lblMesasGrandesGeneral.setText("$$");

        jLabel14.setText("General:");

        jLabel15.setText("Terraza:");

        lblMesasGrandesTerraza.setText("$$");

        jLabel16.setText("Ventana");

        lblMesasGrandesVentana.setText("$$");

        jLabel17.setText("General:");

        lblMesasPequeniasGeneral.setText("$$");

        jLabel18.setText("Terraza:");

        jLabel19.setText("Ventana:");

        lblMesasPequeniasVentana.setText("$$");

        jLabel20.setText("General:");

        jLabel21.setText("Terraza:");

        jLabel22.setText("Ventana:");

        lblMesasMedianasGeneral.setText("$$");

        lblMesasMedianasTerraza.setText("$$");

        lblMesasMedianasVentana.setText("$$");

        lblCantidadMesasPequenias.setText("$$");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCantidadMesasPequenias, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCantidadMesasMedianas, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCantidadMesasGrandes, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMesasPequeniasTerraza, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMesasPequeniasGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMesasPequeniasVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMesasGrandesVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMesasGrandesGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMesasGrandesTerraza, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMesasMedianasGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMesasMedianasTerraza, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMesasMedianasVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(73, 73, 73)))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblCantidadMesasPequenias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblMesasPequeniasGeneral))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblMesasPequeniasTerraza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblMesasPequeniasVentana))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblCantidadMesasMedianas))
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblMesasMedianasGeneral))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblMesasMedianasTerraza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblMesasMedianasVentana))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblCantidadMesasGrandes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblMesasGrandesGeneral))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblMesasGrandesTerraza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblMesasGrandesVentana))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Telefono:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(campoHoraApertura, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoHoraCierre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTelefono))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoHoraApertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoHoraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("Mesas");

        miAdministrar.setText("Administrar");
        miAdministrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAdministrarActionPerformed(evt);
            }
        });
        jMenu1.add(miAdministrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reservaciones");

        jMenuItem3.setText("Crear Reservacion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Cancelar Reservacion");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Historial");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Clientes");

        jMenuItem7.setText("Insercion Masiva");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Acerca De");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAdministrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAdministrarActionPerformed
       // Cerrar el frame actual
    this.dispose();
    
    // Abrir el nuevo frame
    frmAdminMesas nuevoFrame = new frmAdminMesas(this.restaurante); // Reemplaza "NuevoFrame" con el nombre de tu frame de destino
    nuevoFrame.setVisible(true);
    }//GEN-LAST:event_miAdministrarActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       // Cerrar el frame actual
    this.dispose();
    
    // Abrir el nuevo frame
    frmGenerarReportes nuevoFrame = new frmGenerarReportes(this.restaurante); // Reemplaza "NuevoFrame" con el nombre de tu frame de destino
    nuevoFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         // Cerrar el frame actual
    this.dispose();
    
    // Abrir el nuevo frame
    frmCrearReservacion nuevoFrame = new frmCrearReservacion(this.restaurante); // Reemplaza "NuevoFrame" con el nombre de tu frame de destino
    nuevoFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         // Cerrar el frame actual
    this.dispose();
    
    // Abrir el nuevo frame
    frmCancelacionReserva nuevoFrame = new frmCancelacionReserva(this.restaurante); // Reemplaza "NuevoFrame" con el nombre de tu frame de destino
    nuevoFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
         
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.TimePicker campoHoraApertura;
    private com.github.lgooddatepicker.components.TimePicker campoHoraCierre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCantidadMesasGrandes;
    private javax.swing.JLabel lblCantidadMesasMedianas;
    private javax.swing.JLabel lblCantidadMesasPequenias;
    private javax.swing.JLabel lblMesasGrandesGeneral;
    private javax.swing.JLabel lblMesasGrandesTerraza;
    private javax.swing.JLabel lblMesasGrandesVentana;
    private javax.swing.JLabel lblMesasMedianasGeneral;
    private javax.swing.JLabel lblMesasMedianasTerraza;
    private javax.swing.JLabel lblMesasMedianasVentana;
    private javax.swing.JLabel lblMesasPequeniasGeneral;
    private javax.swing.JLabel lblMesasPequeniasTerraza;
    private javax.swing.JLabel lblMesasPequeniasVentana;
    private javax.swing.JMenuItem miAdministrar;
    // End of variables declaration//GEN-END:variables
}
