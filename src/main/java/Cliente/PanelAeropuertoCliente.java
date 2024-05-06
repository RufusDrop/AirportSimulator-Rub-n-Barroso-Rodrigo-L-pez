package Cliente;

import Codigo.Servidor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;


public class PanelAeropuertoCliente extends javax.swing.JPanel {

    private int id;
    /**
     * Creates new form PanelAeropuertoCliente
     */
    public PanelAeropuertoCliente() {
        initComponents();
        
    }
    public void setId(int id){
        this.id = id;
    }
    public void actualizarInterfaz(){

        try {
                // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");

                // Usar los métodos remotos
                SwingUtilities.invokeLater(() -> {
                    try {
                        jLabelNPasajeros.setText(Integer.toString(servidor.numPasajeros(id)));
                        jTextFieldHangar.setText(Integer.toString(servidor.numAvionesHangar(id)));
                        jTextFieldTaller.setText(Integer.toString(servidor.numAvionesTaller(id)));
                        jTextFieldAreaEstacionamiento.setText(Integer.toString(servidor.numAvionesAEstacionamiento(id)));
                        jTextFieldAreaRodaje.setText(Integer.toString(servidor.numAvionesAreaRodaje(id)));
                    } catch (RemoteException ex) {
                        Logger.getLogger(PanelAeropuertoCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

                
            } catch (Exception e) {
                System.err.println("Error en el cliente RMI: " + e.getMessage());
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

        jLabelNombreAeropuerto = new javax.swing.JLabel();
        jLabelNPasajeros = new javax.swing.JLabel();
        jLabelPasajeros = new javax.swing.JLabel();
        jLabelPista1 = new javax.swing.JLabel();
        jLabelPista3 = new javax.swing.JLabel();
        jLabelPista2 = new javax.swing.JLabel();
        jLabelPista4 = new javax.swing.JLabel();
        jButtonCerrarPista1 = new javax.swing.JButton();
        jButtonAbrirPista1 = new javax.swing.JButton();
        jButtonAbrirPista2 = new javax.swing.JButton();
        jButtonCerrarPista2 = new javax.swing.JButton();
        jButtonCerrarPista3 = new javax.swing.JButton();
        jButtonAbrirPista3 = new javax.swing.JButton();
        jButtonAbrirPista4 = new javax.swing.JButton();
        jButtonCerrarPista4 = new javax.swing.JButton();
        jLabelAvionesHangar = new javax.swing.JLabel();
        jLabelAvionesTaller = new javax.swing.JLabel();
        jLabelAvionesAreaEstacionamento = new javax.swing.JLabel();
        jLabelAvionesRodaje = new javax.swing.JLabel();
        jTextFieldTaller = new javax.swing.JTextField();
        jTextFieldHangar = new javax.swing.JTextField();
        jTextFieldAreaEstacionamiento = new javax.swing.JTextField();
        jTextFieldAreaRodaje = new javax.swing.JTextField();

        jLabelNombreAeropuerto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelNombreAeropuerto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreAeropuerto.setText("Aeropuerto de Madrid");

        jLabelNPasajeros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNPasajeros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNPasajeros.setText("0");

        jLabelPasajeros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelPasajeros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPasajeros.setText("Pasajeros");

        jLabelPista1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPista1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPista1.setText("Pista 1:");

        jLabelPista3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPista3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPista3.setText("Pista 2:");

        jLabelPista2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPista2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPista2.setText("Pista 3:");

        jLabelPista4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPista4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPista4.setText("Pista 4:");

        jButtonCerrarPista1.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButtonCerrarPista1.setText("CERRAR");
        jButtonCerrarPista1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCerrarPista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarPista1ActionPerformed(evt);
            }
        });

        jButtonAbrirPista1.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButtonAbrirPista1.setText("ABRIR");
        jButtonAbrirPista1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButtonAbrirPista1.setEnabled(false);
        jButtonAbrirPista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirPista1ActionPerformed(evt);
            }
        });

        jButtonAbrirPista2.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButtonAbrirPista2.setText("ABRIR");
        jButtonAbrirPista2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButtonAbrirPista2.setEnabled(false);
        jButtonAbrirPista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirPista2ActionPerformed(evt);
            }
        });

        jButtonCerrarPista2.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButtonCerrarPista2.setText("CERRAR");
        jButtonCerrarPista2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCerrarPista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarPista2ActionPerformed(evt);
            }
        });

        jButtonCerrarPista3.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButtonCerrarPista3.setText("CERRAR");
        jButtonCerrarPista3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCerrarPista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarPista3ActionPerformed(evt);
            }
        });

        jButtonAbrirPista3.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButtonAbrirPista3.setText("ABRIR");
        jButtonAbrirPista3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButtonAbrirPista3.setEnabled(false);
        jButtonAbrirPista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirPista3ActionPerformed(evt);
            }
        });

        jButtonAbrirPista4.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButtonAbrirPista4.setText("ABRIR");
        jButtonAbrirPista4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButtonAbrirPista4.setEnabled(false);
        jButtonAbrirPista4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirPista4ActionPerformed(evt);
            }
        });

        jButtonCerrarPista4.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButtonCerrarPista4.setText("CERRAR");
        jButtonCerrarPista4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCerrarPista4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarPista4ActionPerformed(evt);
            }
        });

        jLabelAvionesHangar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAvionesHangar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAvionesHangar.setText("Aviones en Hangar:");

        jLabelAvionesTaller.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAvionesTaller.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAvionesTaller.setText("Aviones en Taller:");

        jLabelAvionesAreaEstacionamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAvionesAreaEstacionamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAvionesAreaEstacionamento.setText("Aviones en Área Estacionamiento:");

        jLabelAvionesRodaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAvionesRodaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAvionesRodaje.setText("Aviones en Área Rodaje:");

        jTextFieldTaller.setFocusable(false);
        jTextFieldTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTallerActionPerformed(evt);
            }
        });

        jTextFieldHangar.setFocusable(false);
        jTextFieldHangar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHangarActionPerformed(evt);
            }
        });

        jTextFieldAreaEstacionamiento.setFocusable(false);
        jTextFieldAreaEstacionamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAreaEstacionamientoActionPerformed(evt);
            }
        });

        jTextFieldAreaRodaje.setFocusable(false);
        jTextFieldAreaRodaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAreaRodajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabelNPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPasajeros))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabelNombreAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelAvionesTaller)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelAvionesAreaEstacionamento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldAreaEstacionamiento))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelAvionesRodaje)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldAreaRodaje, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelAvionesHangar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldHangar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelPista1)
                                            .addGap(12, 12, 12)
                                            .addComponent(jButtonCerrarPista1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jButtonAbrirPista1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelPista3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButtonCerrarPista2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jButtonAbrirPista2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelPista2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButtonCerrarPista3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jButtonAbrirPista3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelPista4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButtonCerrarPista4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(jButtonAbrirPista4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(14, 14, 14))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelNombreAeropuerto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPasajeros)
                    .addComponent(jLabelNPasajeros))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAvionesHangar)
                    .addComponent(jTextFieldHangar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAvionesTaller)
                    .addComponent(jTextFieldTaller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAvionesAreaEstacionamento)
                    .addComponent(jTextFieldAreaEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAvionesRodaje)
                    .addComponent(jTextFieldAreaRodaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPista1)
                    .addComponent(jLabelPista2)
                    .addComponent(jButtonAbrirPista1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrarPista1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAbrirPista3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrarPista3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAbrirPista2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrarPista2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPista3)
                    .addComponent(jLabelPista4)
                    .addComponent(jButtonAbrirPista4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrarPista4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarPista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarPista1ActionPerformed
        // TODO add your handling code here:
        // Para establecer el borde
        Border raisedSoftBevel = new SoftBevelBorder(SoftBevelBorder.RAISED);
        jButtonAbrirPista1.setBorder(raisedSoftBevel);
        jButtonAbrirPista1.setEnabled(true);
        Border loweredSoftBevel = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        jButtonCerrarPista1.setBorder(loweredSoftBevel);
        jButtonCerrarPista1.setEnabled(false);
        new Thread(() -> {
        try {
          // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");
            // Usar los métodos remotos
            servidor.cerrarPista(1, id);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
        }).start(); 

    }//GEN-LAST:event_jButtonCerrarPista1ActionPerformed

    private void jButtonAbrirPista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirPista1ActionPerformed
        // TODO add your handling code here:
        // Para establecer el borde
        Border raisedSoftBevel = new SoftBevelBorder(SoftBevelBorder.RAISED);
        jButtonCerrarPista1.setBorder(raisedSoftBevel);
        jButtonCerrarPista1.setEnabled(true);
        Border loweredSoftBevel = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        jButtonAbrirPista1.setBorder(loweredSoftBevel);
        jButtonAbrirPista1.setEnabled(false);
        new Thread(() -> {
        try {
        // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");
            // Usar los métodos remotos
            servidor.abrirPista(1, id);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
        }).start(); 
    }//GEN-LAST:event_jButtonAbrirPista1ActionPerformed

    private void jButtonAbrirPista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirPista2ActionPerformed
        // TODO add your handling code here:
        Border raisedSoftBevel = new SoftBevelBorder(SoftBevelBorder.RAISED);
        jButtonCerrarPista2.setBorder(raisedSoftBevel);
        jButtonCerrarPista2.setEnabled(true);
        Border loweredSoftBevel = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        jButtonAbrirPista2.setBorder(loweredSoftBevel);
        jButtonAbrirPista2.setEnabled(false);
        new Thread(() -> {
        try {
            // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");

            // Usar los métodos remotos
            servidor.abrirPista(2, id);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
        }).start(); 
    }//GEN-LAST:event_jButtonAbrirPista2ActionPerformed

    private void jButtonCerrarPista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarPista2ActionPerformed
        // TODO add your handling code here:
        Border raisedSoftBevel = new SoftBevelBorder(SoftBevelBorder.RAISED);
        jButtonAbrirPista2.setBorder(raisedSoftBevel);
        jButtonAbrirPista2.setEnabled(true);
        Border loweredSoftBevel = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        jButtonCerrarPista2.setBorder(loweredSoftBevel);
        jButtonCerrarPista2.setEnabled(false);
        new Thread(() -> {
        try {
            // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");

            // Usar los métodos remotos
            servidor.cerrarPista(2, id);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
        }).start(); 
        
    }//GEN-LAST:event_jButtonCerrarPista2ActionPerformed

    private void jButtonCerrarPista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarPista3ActionPerformed
        // TODO add your handling code here:
        Border raisedSoftBevel = new SoftBevelBorder(SoftBevelBorder.RAISED);
        jButtonAbrirPista3.setBorder(raisedSoftBevel);
        jButtonAbrirPista3.setEnabled(true);
        Border loweredSoftBevel = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        jButtonCerrarPista3.setBorder(loweredSoftBevel);
        jButtonCerrarPista3.setEnabled(false);
        new Thread(() -> {
        try {
            // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");

            // Usar los métodos remotos
            servidor.cerrarPista(3, id);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
        }).start(); 
    }//GEN-LAST:event_jButtonCerrarPista3ActionPerformed

    private void jButtonAbrirPista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirPista3ActionPerformed
        // TODO add your handling code here:
        Border raisedSoftBevel = new SoftBevelBorder(SoftBevelBorder.RAISED);
        jButtonCerrarPista3.setBorder(raisedSoftBevel);
        jButtonCerrarPista3.setEnabled(true);
        Border loweredSoftBevel = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        jButtonAbrirPista3.setBorder(loweredSoftBevel);
        jButtonAbrirPista3.setEnabled(false);
        new Thread(() -> {
        try {
            // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");

            // Usar los métodos remotos
            servidor.abrirPista(3, id);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
        }).start(); 
    }//GEN-LAST:event_jButtonAbrirPista3ActionPerformed

    private void jButtonAbrirPista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirPista4ActionPerformed
        // TODO add your handling code here:
        Border raisedSoftBevel = new SoftBevelBorder(SoftBevelBorder.RAISED);
        jButtonCerrarPista4.setBorder(raisedSoftBevel);
        jButtonCerrarPista4.setEnabled(true);
        Border loweredSoftBevel = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        jButtonAbrirPista4.setBorder(loweredSoftBevel);
        jButtonAbrirPista4.setEnabled(false);
        new Thread(() -> {
        try {
            // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");
            // Usar los métodos remotos
            servidor.abrirPista(4, id);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
        }).start(); 
    }//GEN-LAST:event_jButtonAbrirPista4ActionPerformed

    private void jButtonCerrarPista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarPista4ActionPerformed
        // TODO add your handling code here:
        Border raisedSoftBevel = new SoftBevelBorder(SoftBevelBorder.RAISED);
        jButtonAbrirPista4.setBorder(raisedSoftBevel);
        jButtonAbrirPista4.setEnabled(true);
        Border loweredSoftBevel = new SoftBevelBorder(SoftBevelBorder.LOWERED);
        jButtonCerrarPista4.setBorder(loweredSoftBevel);
        jButtonCerrarPista4.setEnabled(false);
        new Thread(() -> {
        try {
            // Conectar al registro RMI en el servidor
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);

                // Obtener la referencia remota del objeto del servidor
                Servidor servidor = (Servidor) registry.lookup("Servidor");

            // Usar los métodos remotos
            servidor.cerrarPista(4, id);
        } catch (Exception e) {
            System.err.println("Error en el cliente RMI: " + e.getMessage());
            e.printStackTrace();
        }
        }).start(); 
        
    }//GEN-LAST:event_jButtonCerrarPista4ActionPerformed

    private void jTextFieldTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTallerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTallerActionPerformed

    private void jTextFieldHangarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHangarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHangarActionPerformed

    private void jTextFieldAreaEstacionamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAreaEstacionamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAreaEstacionamientoActionPerformed

    private void jTextFieldAreaRodajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAreaRodajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAreaRodajeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirPista1;
    private javax.swing.JButton jButtonAbrirPista2;
    private javax.swing.JButton jButtonAbrirPista3;
    private javax.swing.JButton jButtonAbrirPista4;
    private javax.swing.JButton jButtonCerrarPista1;
    private javax.swing.JButton jButtonCerrarPista2;
    private javax.swing.JButton jButtonCerrarPista3;
    private javax.swing.JButton jButtonCerrarPista4;
    private javax.swing.JLabel jLabelAvionesAreaEstacionamento;
    private javax.swing.JLabel jLabelAvionesHangar;
    private javax.swing.JLabel jLabelAvionesRodaje;
    private javax.swing.JLabel jLabelAvionesTaller;
    private javax.swing.JLabel jLabelNPasajeros;
    private javax.swing.JLabel jLabelNombreAeropuerto;
    private javax.swing.JLabel jLabelPasajeros;
    private javax.swing.JLabel jLabelPista1;
    private javax.swing.JLabel jLabelPista2;
    private javax.swing.JLabel jLabelPista3;
    private javax.swing.JLabel jLabelPista4;
    private javax.swing.JTextField jTextFieldAreaEstacionamiento;
    private javax.swing.JTextField jTextFieldAreaRodaje;
    private javax.swing.JTextField jTextFieldHangar;
    private javax.swing.JTextField jTextFieldTaller;
    // End of variables declaration//GEN-END:variables
}
