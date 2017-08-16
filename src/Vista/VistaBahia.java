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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author SYSTEM
 */
public class VistaBahia extends JFrame implements ActionListener{

    private PanelBahia panelB;
    private VistaUsuario ventana;
    private JButton btnEscoger;
    private JLabel lblEscoger;
    private JLabel lblInfo;
    private JTextField txtEscoger;
    private boolean evento;
    private JButton btnVolver;
    
    public VistaBahia(VistaUsuario a) {
        this.setLayout(null);
        this.setSize(840, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        ventana = a;
        evento = true;
        
        panelB = new PanelBahia(this);
        panelB.setBounds(50, 10, 770, 400);
        panelB.setBorder(new TitledBorder("Bahias"));
        add(panelB);
        
        lblEscoger = new JLabel("Escriba la Bahia deseada");
        lblEscoger.setBounds(150, 420, 200, 30);
        add(lblEscoger);
                
        lblInfo = new JLabel("Rojo: Vacio  Amarillo: Ocupado");
        lblInfo.setBounds(460, 420, 300, 30);
        add(lblInfo);
        
        txtEscoger= new JTextField();
        txtEscoger.setBounds(360, 420, 40, 30);
        add(txtEscoger);
        
        btnEscoger = new JButton("Escoger Bahia");
        btnEscoger.setBounds(150, 460, 150, 30);
        btnEscoger.addActionListener(this);
        add(btnEscoger);
        
        btnVolver = new JButton();
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png")));
        btnVolver.setBounds(5, 10, 30, 30);
        btnVolver.addActionListener(this);
        add(btnVolver);
    }

    public PanelBahia getPanelB() {
        return panelB;
    }


    public VistaUsuario getVentana() {
        return ventana;
    }

    public boolean isEvento() {
        return evento;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnEscoger){
            String bahia = txtEscoger.getText();
            int fila = ((int)bahia.charAt(0)-65);
            int columna = Integer.parseInt(bahia.substring(1));
            if(ventana.getVentana().getVentana().getParqueadero().getPlazas()[fila][columna].getEstado()==0){
                int cedula = ventana.getCedula();
                ventana.getVentana().getVentana().getParqueadero().registrarBicicleta(cedula, bahia);
                btnEscoger.setEnabled(false);
                getPanelB().repaint();
            }else{
                JOptionPane.showMessageDialog(null, "Bahia Ocupada, escoja otra");
                getPanelB().repaint();
            }
        }if(btnVolver==e.getSource()){
            this.setVisible(false);
            ventana.getVentana().setVisible(true);
        }
    }
    
}
