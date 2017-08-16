/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SYSTEM
 */
public class Modelo {
    
    private Connection conectar = BaseDatos.getBaseDatos().conexion();
    private String sql="";
    private String horaEntrada;
    private static final int TARIFA=60;
    private int costo=0;
    private int capacidad;
    private Parqueadero parqueo; 

    public Modelo(Parqueadero p) {
        parqueo = p;
        inicializar();
    }
    
    
    public void registrarUsuario(String nom, int cedula, int codigo, int tarjeta, String email, String descripcion, int telefono, String contrasena){
        sql = "INSERT INTO usuario(cedula,nombre,codigo,tarjetaPropiedad,email,telefono,descripcion,contrasena) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conectar.prepareStatement(sql);
            ps.setInt(1, cedula);
            ps.setString(2, nom);
            ps.setInt(3, codigo);
            ps.setInt(4, tarjeta);
            ps.setString(5, email);
            ps.setInt(6, telefono);
            ps.setString(7, descripcion);
            ps.setString(8, contrasena);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registrado con exito!");
        } catch (SQLException ex) {
            Logger.getLogger(Parqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean verificarDatos(int cedula, String contrasena){
        sql = "SELECT * FROM usuario WHERE cedula='"+cedula+"' AND contrasena='"+contrasena+"'";
        try {
            Statement st = conectar.createStatement();
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Datos Correctos");
                JOptionPane.showMessageDialog(null, "Bienvenido");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean isRegistrado(int cedula){
        boolean unico=false;
        sql = "SELECT cedula FROM usuario WHERE cedula='"+cedula+"'";
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                unico=true;
                JOptionPane.showMessageDialog(null,"Usted ya esta registrado!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unico;
    }
    
    public String obtenerNombre(int cedula){
        String nombre="";
        sql = "SELECT nombre FROM usuario WHERE cedula='"+cedula+"'";
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                nombre = rs.getString("nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Parqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
    public void retirarBicicleta(int cedula){
        int dinero;
        String bahia;
        sql="SELECT * FROM bicicleta WHERE cedula='"+cedula+"'";
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                bahia=rs.getString("codBahia");
                horaEntrada=rs.getString("horaEntrada");
                comparacionHoras(horaEntrada);
                JOptionPane.showMessageDialog(null, "Su tarifa es: "+costo+" pesos");
                dinero=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dinero"));
                if(pagoTarifa(dinero)){
                    String sql1="DELETE FROM bicicleta WHERE cedula='"+cedula+"'";
                    st.executeUpdate(sql1);
                    registrarTPlaza(bahia, 0);
                    JOptionPane.showMessageDialog(null, "Puede retirar la bicicleta");
                }                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Parqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean isIngresado(int cedula){
        boolean entro=false;
        sql="SELECT * FROM bicicleta WHERE cedula='"+cedula+"'";
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                entro=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Parqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entro;
    }
    public void registrarBicicleta(int cedula, String codBahia){
        registrarTBici(cedula, codBahia);
        registrarTPlaza(codBahia, 1);
    }
    private void inicializar() {
        contarCapacidad();
        llenarPlazas();
        llenarListaUsuarios(parqueo.getListaUsers(), parqueo.getUser());
        llenarListaBicicletas(parqueo.getListaBici(), parqueo.getBici());
    }

    private void contarCapacidad() {
        sql = "SELECT COUNT(*) AS count FROM plaza";
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                capacidad = rs.getInt("count");System.out.println("cap "+capacidad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Parqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   

    private void llenarPlazas() {
        String bahia;
        int estado, fila, columna;
        sql="SELECT * FROM plaza";
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                bahia=rs.getString("codBahia");
                estado=rs.getInt("estado");
                fila=((int)bahia.charAt(0)-65);System.out.println("fila "+fila);
                columna=Integer.parseInt(bahia.substring(1));System.out.println("col "+columna);
                parqueo.getPlazas()[fila][columna].setCodBahia(bahia);
                parqueo.getPlazas()[fila][columna].setEstado(estado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Parqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void registrarTPlaza(String codBahia, int estado) {
        sql="UPDATE plaza SET estado='"+estado+"' WHERE codBahia='"+codBahia+"'";
        try {
            Statement st = conectar.createStatement();
            st.executeUpdate(sql);
            cambiarEstado(codBahia, estado);
        } catch (SQLException ex) {
            Logger.getLogger(Parqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registrarTBici(int cedula, String codBahia) {
        Calendar cal1=Calendar.getInstance();
        String minuto;
        sql="INSERT INTO bicicleta(codBahia, cedula, horaEntrada) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conectar.prepareStatement(sql);
            ps.setString(1, codBahia);
            ps.setInt(2, cedula);
            minuto=""+cal1.get(Calendar.MINUTE);
            if(minuto.length()==1)minuto="0"+minuto;
            ps.setString(3, cal1.get(Calendar.HOUR)+":"+minuto);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ha registrado su bicleta en la bahia "+ codBahia);
        } catch (SQLException ex) {
            Logger.getLogger(Parqueadero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cambiarEstado(String codBahia, int estado) {
        int fila=0, columna=0;
        fila = ((int)codBahia.charAt(0)-65);
        columna = Integer.parseInt(codBahia.substring(1));
        parqueo.getPlazas()[fila][columna].setEstado(estado);
    }

    private void comparacionHoras(String hEntrada) {
        Calendar cal1=Calendar.getInstance();
        String horaE, minutoE, horaS, minutoS;
        int min1, difHora, minTotal;
        horaS = ""+cal1.get(Calendar.HOUR);
        minutoS=""+cal1.get(Calendar.MINUTE);
        if(hEntrada.length()==5 ){
            System.out.println("entro1");
            horaE=hEntrada.substring(0, 2);
            minutoE=hEntrada.substring(3);
        }else{
            System.out.println("entro2");
            horaE=hEntrada.substring(0, 1);
            minutoE=hEntrada.substring(2);
        }
        difHora=Integer.parseInt(horaS)-Integer.parseInt(horaE);System.out.println("dif "+difHora);
        if(difHora<1){
            minTotal=Integer.parseInt(minutoS)-Integer.parseInt(minutoE);
        }else{
            if(difHora==1){
                min1=60-Integer.parseInt(minutoE);
                minTotal=min1+Integer.parseInt(minutoS);
            }else{
                if(Integer.parseInt(minutoS)>Integer.parseInt(minutoE)){
                    min1=Integer.parseInt(minutoS)-Integer.parseInt(minutoE);
                    minTotal=(60*difHora)+min1;
                }else{
                    min1=(60-(Integer.parseInt(minutoS)-Integer.parseInt(minutoE)));
                    difHora-=1;
                    minTotal=(difHora*60)+min1;
                }
            }
        }
        //;System.out.println("minT "+minTotal);
        costo=Modelo.TARIFA*minTotal;
    }

    private boolean pagoTarifa(int dinero) {
        boolean pago=false;
        if(dinero<costo){
            JOptionPane.showMessageDialog(null, "Debe ingresar mas dinero");
        }else{
            pago=true;
            if(dinero>costo){
                dinero-=costo;
                JOptionPane.showMessageDialog(null, "Sus vueltas son: "+ dinero);
            }else{
                JOptionPane.showMessageDialog(null, "Pago Exacto");
            }
        }
        return pago;
    }

    private void llenarListaUsuarios(ArrayList<Usuario> lista, Usuario user) {
        String nombre, email, descripcion, contrasena;
        int cedula, codigo, telefono,tarjeta; 
        sql="SELECT * FROM usuario";
        try {
            Statement st=conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nombre = rs.getString("nombre");
                email = rs.getString("email");
                descripcion = rs.getString("descripcion");
                contrasena = rs.getString("contrasena");
                cedula = rs.getInt("cedula");
                codigo = rs.getInt("codigo");
                telefono = rs.getInt("telefono");
                tarjeta = rs.getInt("tarjetaPropiedad");
                user = new Usuario(nombre, cedula, codigo, tarjeta, descripcion, telefono, email, contrasena);
                lista.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarListaBicicletas(ArrayList<Bicicleta> listaBici, Bicicleta bici) {
        String codBahia, horaEntrada;
        int cedula;
        sql="SELECT * FROM bicicleta";
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                codBahia=rs.getString("codBahia");
                horaEntrada=rs.getString("horaEntrada");
                cedula = rs.getInt("cedula");
                bici = new Bicicleta();
                bici.setCodBahia(codBahia);
                bici.setHoraEntrada(horaEntrada);
                bici.setId(cedula);
                listaBici.add(bici);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCapacidad() {
        return capacidad;
    }
    
}
