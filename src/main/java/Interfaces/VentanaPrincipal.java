/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.DefaultListModel;

/**
 *
 * @author ruben
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null); //Esta linea se pone para que la ventana salga centrada.
        //Pruebas metodos
    }
    public void actualizarPasajeros(int npasajeros, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarPasajeros(npasajeros);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarPasajeros(npasajeros);
        }
    }

    public void actualizarTransfersAeropuerto(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarTransfersAeropuerto(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarTransfersAeropuerto(text);
        }
    }

    public void actualizarTransfersCiudad(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarTransfersCiudad(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarTransfersCiudad(text);
        }
    }

    public void actualizarGate1(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarGate1(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarGate1(text);
        }
    }

    public void actualizarGate2(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarGate2(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarGate2(text);
        }
    }

    public void actualizarGate3(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarGate3(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarGate3(text);
        }
    }

    public void actualizarGate4(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarGate4(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarGate4(text);
        }
    }

    public void actualizarGate5(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarGate5(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarGate5(text);
        }
    }

    public void actualizarGate6(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarGate6(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarGate6(text);
        }
    }

    public void actualizarPista1(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarPista1(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarPista1(text);
        }
    }

    public void actualizarPista2(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarPista2(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarPista2(text);
        }
    }

    public void actualizarPista3(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarPista3(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarPista3(text);
        }
    }

    public void actualizarPista4(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.actualizarPista4(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.actualizarPista4(text);
        }
    }

    
    public void añadirElemListaHangar(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.añadirElemListaHangar(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.añadirElemListaHangar(text);
        }
    }

    public void eliminarElemListaHangar(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.eliminarElemListaHangar(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.eliminarElemListaHangar(text);
        }
    }

    public void añadirElemListaAreaEstacionamiento(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.añadirElemListaAreaEstacionamiento(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.añadirElemListaAreaEstacionamiento(text);
        }
    }

    public void eliminarElemListaAreaEstacionamiento(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.eliminarElemListaAreaEstacionamiento(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.eliminarElemListaAreaEstacionamiento(text);
        }
    }

    public void añadirElemListaTaller(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.añadirElemListaTaller(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.añadirElemListaTaller(text);
        }
    }

    public void eliminarElemListaTaller(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.eliminarElemListaTaller(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.eliminarElemListaTaller(text);
        }
    }

    public void añadirElemListaAreaRodaje(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.añadirElemListaAreaRodaje(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.añadirElemListaAreaRodaje(text);
        }
    }

    public void eliminarElemListaAreaRodaje(String text, int numeroAeropuerto) {
        if (numeroAeropuerto == 1) {
            panelAeropuerto1.eliminarElemListaAreaRodaje(text);
        } else if (numeroAeropuerto == 2) {
            panelAeropuerto2.eliminarElemListaAreaRodaje(text);
        }
    }

    public void añadirElemListaAeroviaMadridBarcelona(String text){
        panelAerovias.añadirElemListaAeroviaMadridBarcelona(text);
    }
    public void eliminarElemListaAeroviaMadridBarcelona(String text){
        panelAerovias.eliminarElemListaAeroviaMadridBarcelona(text);
    }
    public void añadirElemListaAeroviaBarcelonaMadrid(String text){
        panelAerovias.añadirElemListaAeroviaBarcelonaMadrid(text);
    }
    public void eliminarElemListaAeroviaBarcelonaMadrid(String text){
        panelAerovias.eliminarElemListaAeroviaBarcelonaMadrid(text);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAeropuerto1 = new Interfaces.PanelAeropuerto();
        panelAeropuerto2 = new Interfaces.PanelAeropuerto();
        panelAerovias = new Interfaces.PanelAerovias();
        jToggleButtonPause = new javax.swing.JToggleButton();
        jToggleButtonPlay = new javax.swing.JToggleButton();
        jLabelEstadoPrograma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAeropuerto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelAeropuerto2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButtonPause.setText("PAUSE");
        jToggleButtonPause.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonPauseActionPerformed(evt);
            }
        });

        jToggleButtonPlay.setText("PLAY");
        jToggleButtonPlay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonPlayActionPerformed(evt);
            }
        });

        jLabelEstadoPrograma.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelEstadoPrograma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEstadoPrograma.setText("EN EJECUCIÓN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelAeropuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelAerovias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jToggleButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jToggleButtonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panelAeropuerto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(657, 657, 657)
                .addComponent(jLabelEstadoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelEstadoPrograma)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelAeropuerto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelAeropuerto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButtonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(panelAerovias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonPauseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonPauseActionPerformed

    private void jToggleButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonPlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonPlayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEstadoPrograma;
    private javax.swing.JToggleButton jToggleButtonPause;
    private javax.swing.JToggleButton jToggleButtonPlay;
    private Interfaces.PanelAeropuerto panelAeropuerto1;
    private Interfaces.PanelAeropuerto panelAeropuerto2;
    private Interfaces.PanelAerovias panelAerovias;
    // End of variables declaration//GEN-END:variables
}
