/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author SYSTEM
 */
public class Usuario {
    
    private String nombre;
    private int cedula;
    private int codigo;
    private int tarjetaPropiedad;
    private String descripcion;
    private int telefono;
    private String email;
    private String contrasena;

    public Usuario(String nombre, int cedula, int codigo, int tarjetaPropiedad, String descripcion, int telefono, String email, String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.codigo = codigo;
        this.tarjetaPropiedad = tarjetaPropiedad;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTarjetaPropiedad() {
        return tarjetaPropiedad;
    }

    public void setTarjetaPropiedad(int tarjetaPropiedad) {
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
