/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Modelo.Plaza;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author SYSTEM
 */
public class PanelBahia extends JPanel{
    
    private VistaBahia vista;
    private Plaza matriz[][];
    private int xCuadro=5, yCuadro=20;
    private int xNombre=0, yNombre=0;
    
    public PanelBahia(VistaBahia aThis) {
        vista = aThis;
    }
    
    public void paint(Graphics p){
        super.paint(p);
        if(vista.isEvento()){
            String nombre="";
            int estado=0;
            matriz = vista.getVentana().getVentana().getVentana().getParqueadero().getPlazas();
            for(int i=0; i<matriz.length; i++){
                for(int j=0; j<matriz[0].length; j++){
                    nombre=matriz[i][j].getCodBahia();
                    estado=matriz[i][j].getEstado();
                    if(estado==0){
                        p.setColor(Color.red);
                    }else{
                        p.setColor(Color.yellow);
                    }
                    p.fillRect(xCuadro, yCuadro, 35, 30);
                    p.setColor(Color.BLACK);
                    xNombre=xCuadro+8;
                    yNombre=yCuadro+12;
                    p.drawString(nombre, xNombre, yNombre);
                    xCuadro+=37;
                }
                xCuadro=5;
                yCuadro+=32;
            }
            xCuadro=5;
            yCuadro=20;
        }
    }
}
