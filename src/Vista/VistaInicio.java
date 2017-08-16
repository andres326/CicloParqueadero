/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Modelo.Parqueadero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Andres
 */
public class VistaInicio extends JFrame implements ActionListener{

    private VistaRegistro ventanaR;
    private VistaIngreso ventanaI;
    private Parqueadero parqueadero;
    /**
     * Creates new form VistaInicio
     */
    public VistaInicio() {
        initComponents();        
        this.setLocationRelativeTo(null);
        parqueadero = new Parqueadero();
        listenerBotones();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistro = new javax.swing.JButton();
        btnInicioSesion = new javax.swing.JButton();
        lblBienvenida1 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        btnRegistro.setBackground(new java.awt.Color(153, 153, 255));
        btnRegistro.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        btnRegistro.setText("Regístrate");

        btnInicioSesion.setBackground(new java.awt.Color(153, 153, 255));
        btnInicioSesion.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        btnInicioSesion.setText("Inicia Sesión");

        lblBienvenida1.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        lblBienvenida1.setText("Bienvenido a tu ");

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cicloparqueadero.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        jLabel1.setText("Cicloparqueadero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBienvenida1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInicioSesion)
                    .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblBienvenida1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBienvenida1;
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getBtnInicioSesion()){
            ventanaI = new VistaIngreso(this);
            this.setVisible(false);
            ventanaI.setVisible(true);
        }else if(e.getSource()==getBtnRegistro()){
            ventanaR = new VistaRegistro(this);
            this.setVisible(false);
            ventanaR.setVisible(true);
        }
    }
    
    public void listenerBotones(){
        getBtnInicioSesion().addActionListener(this);
        getBtnRegistro().addActionListener(this);
    }
    
    public JButton getBtnInicioSesion() {
        return btnInicioSesion;
    }

    public JButton getBtnRegistro() {
        return btnRegistro;
    }

    public VistaRegistro getVentanaR() {
        return ventanaR;
    }

    public VistaIngreso getVentanaI() {
        return ventanaI;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    
    
}
