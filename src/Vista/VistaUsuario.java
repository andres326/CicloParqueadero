/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class VistaUsuario extends JFrame implements ActionListener{
    
    private VistaIngreso ventana;
    private VistaBahia ventanaB;
    private int cedula;
    private boolean ingresado;
    /**
     * Creates new form VistaUsuario
     */
    public VistaUsuario(VistaIngreso a, int cedula, boolean e) {
        ventana = a;
        initComponents();
        setLocationRelativeTo(null);
        btnVolver.setBorder(null);
        this.cedula=cedula;
        this.ingresado=e;
        listenerBotones();
        condicional();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenida = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBienvenida.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        lblBienvenida.setText("Bienvenido");

        btnIngresar.setBackground(new java.awt.Color(153, 153, 255));
        btnIngresar.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        btnIngresar.setText("Ingresar Bicicleta");

        btnRetirar.setBackground(new java.awt.Color(153, 153, 255));
        btnRetirar.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        btnRetirar.setText("Retirar bicicleta");

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblBienvenida))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRetirar, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lblBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblBienvenida;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getBtnVolver()){
            this.setVisible(false);
            getVentana().setVisible(true);
        }
        if(e.getSource()==getBtnIngresar()){
            this.setVisible(false);
            ventanaB = new VistaBahia(this);
            ventanaB.setVisible(true);
        }if(e.getSource()==getBtnRetirar()){
            ventana.getVentana().getParqueadero().retirarBicicleta(cedula);
            this.setVisible(false);
            ventana.setVisible(true);
        }
    }
    
    public void listenerBotones(){
        getBtnRetirar().addActionListener(this);
        getBtnIngresar().addActionListener(this);
        getBtnVolver().addActionListener(this);
    }
  
    public VistaIngreso getVentana() {
        return ventana;
    }

    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public JButton getBtnRetirar() {
        return btnRetirar;
    }
    
    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JLabel getLblBienvenida() {
        return lblBienvenida;
    }

    public int getCedula() {
        return cedula;
    }

    public boolean isIngresado() {
        return ingresado;
    }

    private void condicional() {
        if(ingresado==true){
            btnIngresar.setEnabled(false);
        }else{
            btnRetirar.setEnabled(false);
        }
    }

    
    
    
    
}
