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
public class Parqueadero {
    
    private Plaza plazas[][];
    private int capacidad=200;
    private Modelo model;
    private Usuario user;
    private Bicicleta bici;
    private ArrayList<Usuario> listaUsers;
    private ArrayList<Bicicleta> listaBici;
    
    public Parqueadero(){
        listaBici = new ArrayList<Bicicleta>();
        listaUsers = new ArrayList<Usuario>();
        crearPlazas();
        model = new Modelo(this);
    }
    
    public void registrarBicicleta(int cedula, String bahia){
        model.registrarBicicleta(cedula, bahia);
        bici = new Bicicleta();
        bici.setCodBahia(bahia);
        bici.setId(cedula);
        listaBici.add(bici);
    }
    
    public boolean verificarDatos(int cedula, String contrasena){
        return model.verificarDatos(cedula, contrasena);
    }
    
    public boolean isIngresado(int cedula){
        return model.isIngresado(cedula);
    }
    
    public String obtenerNombre(int cedula){
        return model.obtenerNombre(cedula);
    }
    
    public boolean isRegistrado(int cedula){
        return model.isRegistrado(cedula);
    }
    
    public void registrarUsuario(String nombre, int cedula, int codigo,int tarjeta, String email, String descripcion, int telefono, String contrasena){
        model.registrarUsuario(nombre, cedula, codigo, tarjeta, email, descripcion, telefono, contrasena);
        user = new Usuario(nombre, cedula, codigo, tarjeta, descripcion, telefono, email, contrasena);
        listaUsers.add(user);
    }
    
    public void retirarBicicleta(int cedula){
        model.retirarBicicleta(cedula);
    }
    
    private void crearPlazas() {
        plazas = new Plaza[10][capacidad/10];
        for(int i=0;i<plazas.length;i++){
            for(int j=0;j<plazas[0].length;j++){
                plazas[i][j]=new Plaza();
            }
        }
    }

    public Plaza[][] getPlazas() {
        return plazas;
    }

    public Usuario getUser() {
        return user;
    }

    public Bicicleta getBici() {
        return bici;
    }

    public ArrayList<Usuario> getListaUsers() {
        return listaUsers;
    }

    public ArrayList<Bicicleta> getListaBici() {
        return listaBici;
    }

    
    
    
}
