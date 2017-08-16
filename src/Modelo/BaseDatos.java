/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class BaseDatos {
    
   Connection conect = null;
   private static BaseDatos base;
   public Connection conexion()
    {
      try {
           Class.forName("org.gjt.mm.mysql.Driver");
           conect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cicloparqueadero","root","");           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
    }
   
   public static BaseDatos getBaseDatos(){
       if(base==null){
           base = new BaseDatos();
       }
       return base;
   }
}
