/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaces;

import javax.swing.DefaultListModel;

/**
 *
 * @author ruben
 */
public class PanelAeropuerto extends javax.swing.JPanel {
    private java.awt.Frame parent;
    private DialogHangar hangar;
    private DialogAreaEstacionamiento areaEstacionamiento;
    private DialogTaller taller;
    private DialogAreaRodaje areaRodaje;
    /**
     * Creates new form Aeropuerto
     */
    public PanelAeropuerto() {
        initComponents();
        this.parent = parent;
        DefaultListModel<String> hangarModel = new DefaultListModel<>();
        DefaultListModel<String> areaEstacionamientoModel = new DefaultListModel<>();
        DefaultListModel<String> tallerModel = new DefaultListModel<>();
        DefaultListModel<String> areaRodajeModel = new DefaultListModel<>();
        jListHangar.setModel(hangarModel);
        jListAreaEstacionamiento.setModel(areaEstacionamientoModel);
        jListTaller.setModel(tallerModel);
        jListAreaRodaje.setModel(areaRodajeModel);

    }
    public void actualizarPasajeros(int npasajeros){
        jLabelNPasajeros.setText(Integer.toString(npasajeros));
    }
    public void actualizarTransfersAeropuerto(String text){
        jButtonTransfersAeropuerto.setText(text);
    }
    public void actualizarTransfersCiudad(String text) {
        jButtonTransfersCiudad.setText(text);
    }
    public void actualizarGate1(String text) {
        jTextFieldGate1.setText(text);
    }
    public void actualizarGate2(String text) {
        jTextFieldGate2.setText(text);
    }
    public void actualizarGate3(String text) {
        jTextFieldGate3.setText(text);
    }
    public void actualizarGate4(String text) {
        jTextFieldGate4.setText(text);
    }
    public void actualizarGate5(String text) {
        jTextFieldGate5.setText(text);
    }
    public void actualizarGate6(String text) {
        jTextFieldGate6.setText(text);
    }
    public void actualizarPista1(String text) {
        jTextFieldPista1.setText(text);
    }
    public void actualizarPista2(String text) {
        jTextFieldPista2.setText(text);
    }
    public void actualizarPista3(String text) {
        jTextFieldPista3.setText(text);
    }
    public void actualizarPista4(String text) {
        jTextFieldPista4.setText(text);
    }
    
    public void añadirElemListaHangar(String text){
       DefaultListModel model = (DefaultListModel) jListHangar.getModel();
       model.addElement(text);
       if(hangar != null){
           hangar.actualizarListaHangar(model);
       }
       
    }
    public void eliminarElemListaHangar(String text){
        DefaultListModel model = (DefaultListModel) jListHangar.getModel();
        int index = -1;
        for(int i = 0; i < model.getSize(); i++){
            if(text.equals(model.get(i))){
                index = i;
                break;
            }
        }
        if(index != -1){
            model.remove(index);
            if(hangar != null){
                hangar.actualizarListaHangar(model);
            }
        }
        
    }
    public void añadirElemListaAreaEstacionamiento(String text) {
        DefaultListModel model = (DefaultListModel) jListAreaEstacionamiento.getModel();
        model.addElement(text);
        if(areaEstacionamiento != null){
               areaEstacionamiento.actualizarListaAreaEstacionamiento(model);
        }
    }

    public void eliminarElemListaAreaEstacionamiento(String text) {
        DefaultListModel model = (DefaultListModel) jListAreaEstacionamiento.getModel();
        int index = model.indexOf(text);
        if(index != -1) {
            model.remove(index);
            if(areaEstacionamiento != null){
                areaEstacionamiento.actualizarListaAreaEstacionamiento(model);
            }
        }
    }

    public void añadirElemListaTaller(String text) {
        DefaultListModel model = (DefaultListModel) jListTaller.getModel();
        model.addElement(text);
        if(areaRodaje != null){
               areaRodaje.actualizarListaAreaRodaje(model);
        }
    }

    public void eliminarElemListaTaller(String text) {
        DefaultListModel model = (DefaultListModel) jListTaller.getModel();
        int index = model.indexOf(text);
        if(index != -1) {
            model.remove(index);
            if(taller != null){
               taller.actualizarListaTaller(model);
            }
        }
    }

    public void añadirElemListaAreaRodaje(String text) {
        DefaultListModel model = (DefaultListModel) jListAreaRodaje.getModel();
        model.addElement(text);
        if(areaRodaje != null){
               areaRodaje.actualizarListaAreaRodaje(model);
        }
        
    }

    public void eliminarElemListaAreaRodaje(String text) {
        DefaultListModel model = (DefaultListModel) jListAreaRodaje.getModel();
        int index = model.indexOf(text);
        if(index != -1) {
            model.remove(index);
            if(areaRodaje != null){
               areaRodaje.actualizarListaAreaRodaje(model);
            }
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

        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldGate1 = new javax.swing.JTextField();
        jTextFieldPista2 = new javax.swing.JTextField();
        jLabelGate6 = new javax.swing.JLabel();
        jTextFieldPista3 = new javax.swing.JTextField();
        jLabelAreaRodaje = new javax.swing.JLabel();
        jTextFieldPista4 = new javax.swing.JTextField();
        jLabelPista1 = new javax.swing.JLabel();
        jLabelGate1 = new javax.swing.JLabel();
        jLabelPista2 = new javax.swing.JLabel();
        jTextFieldGate2 = new javax.swing.JTextField();
        jLabelPista3 = new javax.swing.JLabel();
        jTextFieldGate3 = new javax.swing.JTextField();
        jLabelPista4 = new javax.swing.JLabel();
        jTextFieldGate4 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelNombreAeropuerto = new javax.swing.JLabel();
        jButtonTransfersAeropuerto = new javax.swing.JButton();
        jTextFieldGate5 = new javax.swing.JTextField();
        jTextFieldGate6 = new javax.swing.JTextField();
        jLabelTaller = new javax.swing.JLabel();
        jScrollAreaRodaje = new javax.swing.JScrollPane();
        jListAreaRodaje = new javax.swing.JList<>();
        jButtonTransfersCiudad = new javax.swing.JButton();
        jButtonHangarExpandir = new javax.swing.JButton();
        jScrollHangar = new javax.swing.JScrollPane();
        jListHangar = new javax.swing.JList<>();
        jTextFieldPista1 = new javax.swing.JTextField();
        jButtonAreaEstacionamientoExpandir = new javax.swing.JButton();
        jLabelGate2 = new javax.swing.JLabel();
        jScrollPaneProductos1 = new javax.swing.JScrollPane();
        jListTaller = new javax.swing.JList<>();
        jButtonTallerExpandir = new javax.swing.JButton();
        jLabelTransfersAeropuerto = new javax.swing.JLabel();
        jLabelGate3 = new javax.swing.JLabel();
        jLabelNPasajeros = new javax.swing.JLabel();
        jLabelTransfersCiudad = new javax.swing.JLabel();
        jLabelAreaEstacionamiento = new javax.swing.JLabel();
        jButtonAreaRodajeExpandir = new javax.swing.JButton();
        jLabelGate4 = new javax.swing.JLabel();
        jScrollAreaEstacionamiento = new javax.swing.JScrollPane();
        jListAreaEstacionamiento = new javax.swing.JList<>();
        jLabelPasajeros = new javax.swing.JLabel();
        jLabelGate5 = new javax.swing.JLabel();
        jLabelHangar = new javax.swing.JLabel();

        jTextFieldGate1.setFocusable(false);
        jTextFieldGate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGate1ActionPerformed(evt);
            }
        });

        jTextFieldPista2.setFocusable(false);
        jTextFieldPista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPista2ActionPerformed(evt);
            }
        });

        jLabelGate6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGate6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelGate6.setText("Gate 6:");

        jTextFieldPista3.setFocusable(false);
        jTextFieldPista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPista3ActionPerformed(evt);
            }
        });

        jLabelAreaRodaje.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelAreaRodaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAreaRodaje.setText("Área Rodaje");

        jTextFieldPista4.setFocusable(false);
        jTextFieldPista4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPista4ActionPerformed(evt);
            }
        });

        jLabelPista1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPista1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPista1.setText("Pista 1:");

        jLabelGate1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGate1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelGate1.setText("Gate 1:");

        jLabelPista2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPista2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPista2.setText("Pista 3:");

        jTextFieldGate2.setFocusable(false);
        jTextFieldGate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGate2ActionPerformed(evt);
            }
        });

        jLabelPista3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPista3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPista3.setText("Pista 2:");

        jTextFieldGate3.setFocusable(false);
        jTextFieldGate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGate3ActionPerformed(evt);
            }
        });

        jLabelPista4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPista4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPista4.setText("Pista 4:");

        jTextFieldGate4.setToolTipText("");
        jTextFieldGate4.setFocusable(false);
        jTextFieldGate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGate4ActionPerformed(evt);
            }
        });

        jLabelNombreAeropuerto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelNombreAeropuerto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreAeropuerto.setText("Aeropuerto de Madrid");

        jButtonTransfersAeropuerto.setBorderPainted(false);
        jButtonTransfersAeropuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransfersAeropuertoActionPerformed(evt);
            }
        });

        jTextFieldGate5.setFocusable(false);
        jTextFieldGate5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGate5ActionPerformed(evt);
            }
        });

        jTextFieldGate6.setFocusable(false);
        jTextFieldGate6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGate6ActionPerformed(evt);
            }
        });

        jLabelTaller.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTaller.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTaller.setText("Taller");

        jListAreaRodaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jListAreaRodaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAreaRodajeMouseClicked(evt);
            }
        });
        jScrollAreaRodaje.setViewportView(jListAreaRodaje);

        jButtonTransfersCiudad.setBorderPainted(false);
        jButtonTransfersCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransfersCiudadActionPerformed(evt);
            }
        });

        jButtonHangarExpandir.setText("Expandir");
        jButtonHangarExpandir.setBorderPainted(false);
        jButtonHangarExpandir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHangarExpandirActionPerformed(evt);
            }
        });

        jListHangar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jListHangar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListHangarMouseClicked(evt);
            }
        });
        jScrollHangar.setViewportView(jListHangar);

        jTextFieldPista1.setToolTipText("");
        jTextFieldPista1.setFocusable(false);
        jTextFieldPista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPista1ActionPerformed(evt);
            }
        });

        jButtonAreaEstacionamientoExpandir.setText("Expandir");
        jButtonAreaEstacionamientoExpandir.setBorderPainted(false);
        jButtonAreaEstacionamientoExpandir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAreaEstacionamientoExpandirActionPerformed(evt);
            }
        });

        jLabelGate2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGate2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelGate2.setText("Gate 2:");

        jListTaller.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jListTaller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListTallerMouseClicked(evt);
            }
        });
        jScrollPaneProductos1.setViewportView(jListTaller);

        jButtonTallerExpandir.setText("Expandir");
        jButtonTallerExpandir.setBorderPainted(false);
        jButtonTallerExpandir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTallerExpandirActionPerformed(evt);
            }
        });

        jLabelTransfersAeropuerto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTransfersAeropuerto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTransfersAeropuerto.setText("Transfers Aeropuerto:");

        jLabelGate3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGate3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelGate3.setText("Gate 3:");

        jLabelNPasajeros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNPasajeros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNPasajeros.setText("6455");

        jLabelTransfersCiudad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTransfersCiudad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTransfersCiudad.setText("Transfers Ciudad:");

        jLabelAreaEstacionamiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelAreaEstacionamiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAreaEstacionamiento.setText("Área Estacionamiento");

        jButtonAreaRodajeExpandir.setText("Expandir");
        jButtonAreaRodajeExpandir.setBorderPainted(false);
        jButtonAreaRodajeExpandir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAreaRodajeExpandirActionPerformed(evt);
            }
        });

        jLabelGate4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGate4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelGate4.setText("Gate 4:");

        jListAreaEstacionamiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jListAreaEstacionamiento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListAreaEstacionamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAreaEstacionamientoMouseClicked(evt);
            }
        });
        jScrollAreaEstacionamiento.setViewportView(jListAreaEstacionamiento);

        jLabelPasajeros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelPasajeros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPasajeros.setText("Pasajeros");

        jLabelGate5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelGate5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelGate5.setText("Gate 5:");

        jLabelHangar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelHangar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHangar.setText("Hangar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelTransfersAeropuerto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonHangarExpandir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(16, 16, 16)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonTransfersAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelTransfersCiudad)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonTransfersCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabelAreaEstacionamiento))
                                            .addComponent(jScrollAreaEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonAreaEstacionamientoExpandir, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabelTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jScrollPaneProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                    .addComponent(jButtonTallerExpandir, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabelHangar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabelAreaRodaje, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButtonAreaRodajeExpandir, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollAreaRodaje, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelPista2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPista3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPista1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelPista4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldPista1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(jTextFieldPista2)
                                    .addComponent(jTextFieldPista3)
                                    .addComponent(jTextFieldPista4)))
                            .addComponent(jScrollHangar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jTextFieldGate6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabelGate1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldGate1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelGate3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldGate3))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelGate5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldGate5)))
                            .addGap(85, 85, 85)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelGate4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldGate4))
                                .addComponent(jLabelGate6)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelGate2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldGate2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabelNombreAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabelNPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPasajeros)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelNombreAeropuerto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPasajeros)
                    .addComponent(jLabelNPasajeros))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTransfersAeropuerto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTransfersCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTransfersAeropuerto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTransfersCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAreaEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelHangar)
                        .addComponent(jLabelTaller)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollAreaEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollHangar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonHangarExpandir)
                    .addComponent(jButtonAreaEstacionamientoExpandir)
                    .addComponent(jButtonTallerExpandir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGate1)
                    .addComponent(jTextFieldGate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGate2)
                    .addComponent(jTextFieldGate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGate4)
                    .addComponent(jLabelGate3)
                    .addComponent(jTextFieldGate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGate5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGate5)
                    .addComponent(jTextFieldGate6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGate6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabelAreaRodaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollAreaRodaje, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButtonAreaRodajeExpandir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPista1)
                            .addComponent(jTextFieldPista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPista3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPista3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPista2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPista4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPista4))))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldGate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGate1ActionPerformed

    private void jTextFieldPista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPista2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPista2ActionPerformed

    private void jTextFieldPista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPista3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPista3ActionPerformed

    private void jTextFieldPista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPista4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPista4ActionPerformed

    private void jTextFieldGate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGate2ActionPerformed

    private void jTextFieldGate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGate3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGate3ActionPerformed

    private void jTextFieldGate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGate4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGate4ActionPerformed

    private void jButtonTransfersAeropuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransfersAeropuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTransfersAeropuertoActionPerformed

    private void jTextFieldGate5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGate5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGate5ActionPerformed

    private void jTextFieldGate6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGate6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGate6ActionPerformed

    private void jListAreaRodajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAreaRodajeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jListAreaRodajeMouseClicked

    private void jButtonTransfersCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransfersCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTransfersCiudadActionPerformed

    private void jButtonHangarExpandirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHangarExpandirActionPerformed
        // TODO add your handling code here:
        hangar = new DialogHangar(parent, false);
        hangar.setVisible(true);
        DefaultListModel model = (DefaultListModel) jListHangar.getModel();
        hangar.actualizarListaHangar(model);
    }//GEN-LAST:event_jButtonHangarExpandirActionPerformed

    private void jListHangarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListHangarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jListHangarMouseClicked

    private void jTextFieldPista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPista1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPista1ActionPerformed

    private void jButtonAreaEstacionamientoExpandirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAreaEstacionamientoExpandirActionPerformed
        // TODO add your handling code here:
        areaEstacionamiento = new DialogAreaEstacionamiento(parent, false);
        areaEstacionamiento.setVisible(true);
        DefaultListModel model = (DefaultListModel) jListAreaEstacionamiento.getModel();
        areaEstacionamiento.actualizarListaAreaEstacionamiento(model);
    }//GEN-LAST:event_jButtonAreaEstacionamientoExpandirActionPerformed

    private void jListTallerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTallerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jListTallerMouseClicked

    private void jButtonTallerExpandirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTallerExpandirActionPerformed
        // TODO add your handling code here:
        taller = new DialogTaller(parent, false);
        taller.setVisible(true);
        DefaultListModel model = (DefaultListModel) jListTaller.getModel();
        taller.actualizarListaTaller(model);
    }//GEN-LAST:event_jButtonTallerExpandirActionPerformed

    private void jButtonAreaRodajeExpandirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAreaRodajeExpandirActionPerformed
        // TODO add your handling code here:
        areaRodaje = new DialogAreaRodaje(parent, false);
        areaRodaje.setVisible(true);
        DefaultListModel model = (DefaultListModel) jListAreaRodaje.getModel();
        areaRodaje.actualizarListaAreaRodaje(model);
    }//GEN-LAST:event_jButtonAreaRodajeExpandirActionPerformed

    private void jListAreaEstacionamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAreaEstacionamientoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jListAreaEstacionamientoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAreaEstacionamientoExpandir;
    private javax.swing.JButton jButtonAreaRodajeExpandir;
    private javax.swing.JButton jButtonHangarExpandir;
    private javax.swing.JButton jButtonTallerExpandir;
    private javax.swing.JButton jButtonTransfersAeropuerto;
    private javax.swing.JButton jButtonTransfersCiudad;
    private javax.swing.JLabel jLabelAreaEstacionamiento;
    private javax.swing.JLabel jLabelAreaRodaje;
    private javax.swing.JLabel jLabelGate1;
    private javax.swing.JLabel jLabelGate2;
    private javax.swing.JLabel jLabelGate3;
    private javax.swing.JLabel jLabelGate4;
    private javax.swing.JLabel jLabelGate5;
    private javax.swing.JLabel jLabelGate6;
    private javax.swing.JLabel jLabelHangar;
    private javax.swing.JLabel jLabelNPasajeros;
    private javax.swing.JLabel jLabelNombreAeropuerto;
    private javax.swing.JLabel jLabelPasajeros;
    private javax.swing.JLabel jLabelPista1;
    private javax.swing.JLabel jLabelPista2;
    private javax.swing.JLabel jLabelPista3;
    private javax.swing.JLabel jLabelPista4;
    private javax.swing.JLabel jLabelTaller;
    private javax.swing.JLabel jLabelTransfersAeropuerto;
    private javax.swing.JLabel jLabelTransfersCiudad;
    private javax.swing.JList<String> jListAreaEstacionamiento;
    private javax.swing.JList<String> jListAreaRodaje;
    private javax.swing.JList<String> jListHangar;
    private javax.swing.JList<String> jListTaller;
    private javax.swing.JScrollPane jScrollAreaEstacionamiento;
    private javax.swing.JScrollPane jScrollAreaRodaje;
    private javax.swing.JScrollPane jScrollHangar;
    private javax.swing.JScrollPane jScrollPaneProductos1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldGate1;
    private javax.swing.JTextField jTextFieldGate2;
    private javax.swing.JTextField jTextFieldGate3;
    private javax.swing.JTextField jTextFieldGate4;
    private javax.swing.JTextField jTextFieldGate5;
    private javax.swing.JTextField jTextFieldGate6;
    private javax.swing.JTextField jTextFieldPista1;
    private javax.swing.JTextField jTextFieldPista2;
    private javax.swing.JTextField jTextFieldPista3;
    private javax.swing.JTextField jTextFieldPista4;
    // End of variables declaration//GEN-END:variables
}
