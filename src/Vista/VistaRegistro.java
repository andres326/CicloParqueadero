/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class VistaRegistro extends JFrame implements ActionListener {
    private final VistaInicio ventana;
    /**
     * Creates new form VistaRegistro
     */
    public VistaRegistro(VistaInicio vista) {
        ventana = vista;
        initComponents();
        setLocationRelativeTo(null);
        btnVolver.setBorder(null);
        listenerBotones();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblTarjetaPropiedad = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblNombre.setText("Nombre*");

        lblCedula.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblCedula.setText("Cedula*");

        lblCodigo.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblCodigo.setText("Codigo");

        lblContrasena.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblContrasena.setText("Contraseña*");

        jLabel1.setFont(new java.awt.Font("Consolas", 3, 24)); // NOI18N
        jLabel1.setText("Registrate es gratis!");

        btnEnviar.setBackground(new java.awt.Color(153, 153, 255));
        btnEnviar.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        btnEnviar.setText("Enviar Datos");

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N

        lblTarjetaPropiedad.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        lblTarjetaPropiedad.setText("Tarjeta Propiedad");

        lblEmail.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        lblEmail.setText("Email*");

        lblTelefono.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        lblTelefono.setText("Telefono*");

        txtTelefono.setToolTipText("");

        lblDescripcion.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        lblDescripcion.setText("Descripcion bicicleta");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setToolTipText("Maximo 100 caracteres");
        jScrollPane1.setViewportView(txtDescripcion);

        lblInfo.setFont(new java.awt.Font("Consolas", 3, 11)); // NOI18N
        lblInfo.setText("Items marcados en asterisco(*) son obligatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                    .addComponent(lblTarjetaPropiedad)
                                    .addComponent(lblEmail)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblDescripcion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtTarjeta)
                                    .addComponent(txtEmail)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtNombre)
                                    .addComponent(txtCedula)
                                    .addComponent(txtCodigo)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInfo, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTarjetaPropiedad)
                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDescripcion)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTarjetaPropiedad;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTarjeta;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getBtnVolver()){
            this.setVisible(false);
            getVentana().setVisible(true);
        }if(e.getSource()==getBtnEnviar()){
                validarRegistro();
                setTextField();
        }
        
    }

    public void setTextField(){
        getTxtContrasena().setText("");
        getTxtNombre().setText("");
        getTxtCedula().setText("");
        getTxtCodigo().setText("");
        getTxtDescripcion().setText("");
        getTxtEmail().setText("");
        getTxtTarjeta().setText("");
        getTxtTelefono().setText("");
    }
    public void listenerBotones(){
        getBtnEnviar().addActionListener(this);
        getBtnVolver().addActionListener(this);
    }
    private void validarRegistro() {
        String nombre = getTxtNombre().getText();
        String email = getTxtEmail().getText();
        String descripcion = getTxtDescripcion().getText();
        String contrasena = new String(getTxtContrasena().getPassword());
        int cedula, tarjeta, telefono, codigo;
        if(nombre.equals("") || getTxtCedula().getText().equals("") || email.equals("") || getTxtTelefono().getText().equals("") || contrasena.equals("")){
            JOptionPane.showMessageDialog(null, "Hacen falta campos obligatorios");
        }else{
            cedula = Integer.parseInt(getTxtCedula().getText());
            if(!ventana.getParqueadero().isRegistrado(cedula)){
                tarjeta=comprobarNulidad(getTxtTarjeta().getText());
                telefono =comprobarNulidad(getTxtTelefono().getText());
                codigo = comprobarNulidad(getTxtCodigo().getText());
                setTextField();
                ventana.getParqueadero().registrarUsuario(nombre, cedula, codigo, tarjeta, email, descripcion, telefono, contrasena);
            }
        }
        
    }

    
    public VistaInicio getVentana() {
        return ventana;
    }

    public JButton getBtnEnviar() {
        return btnEnviar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }

    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtTarjeta() {
        return txtTarjeta;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    private int comprobarNulidad(String text) {
        int num=0;
        if(!text.equals("")){
            num = Integer.parseInt(text);
        }
        return num;
    }

    
    
    
}
