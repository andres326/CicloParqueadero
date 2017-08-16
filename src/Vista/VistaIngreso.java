/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class VistaIngreso extends JFrame implements ActionListener{
    
    private final VistaInicio ventana;
    private VistaUsuario vista;
    private int nick=0;
    /**
     * Creates new form VistaIngreso
     */
    public VistaIngreso(VistaInicio vista) {
        ventana = vista;
        initComponents();
        setLocationRelativeTo(null);
        btnVolver.setBorder(null);
        listenerBotones();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInicio = new javax.swing.JLabel();
        lblNickname = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txtNick = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        btnIngreso = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lblInicio.setText("Inicia Sesión");

        lblNickname.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblNickname.setText("Cedula");

        lblContrasena.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblContrasena.setText("Contraseña");

        btnIngreso.setBackground(new java.awt.Color(153, 153, 255));
        btnIngreso.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        btnIngreso.setText("Ingresa");

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContrasena)
                    .addComponent(lblNickname))
                .addGap(4, 4, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInicio)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblInicio)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNickname)
                    .addComponent(txtNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtNick;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getBtnVolver()){
            this.setVisible(false);
            getVentana().setVisible(true);
        }if(e.getSource()==getBtnIngreso()){
            nick = Integer.parseInt(getTxtNick().getText());
            String contrasena = new String(getTxtContrasena().getPassword());
            if(ventana.getParqueadero().verificarDatos(nick, contrasena)){
                setTextField();
                boolean entro = ventana.getParqueadero().isIngresado(nick);
                this.setVisible(false);
                vista = new VistaUsuario(this, nick, entro);
                String s = vista.getLblBienvenida().getText();
                vista.getLblBienvenida().setText(s+" "+ventana.getParqueadero().obtenerNombre(nick));
                vista.setVisible(true);
            }
        }
    }
    
    public void listenerBotones(){
        getBtnIngreso().addActionListener(this);
        getBtnVolver().addActionListener(this);
    }
    
    public void setTextField(){
        getTxtContrasena().setText("");
        getTxtNick().setText("");
    }
    public VistaInicio getVentana() {
        return ventana;
    }

    public int getNick() {
        return nick;
    }

    public JButton getBtnIngreso() {
        return btnIngreso;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }

    public JTextField getTxtNick() {
        return txtNick;
    }

    public VistaUsuario getVista() {
        return vista;
    }
    
    
}
