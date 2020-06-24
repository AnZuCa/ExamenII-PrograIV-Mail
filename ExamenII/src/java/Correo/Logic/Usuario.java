/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo.Logic;

/**
 *
 * @author Andres
 */
public class Usuario {
    String correo;
    String Nombre;
    String clave;

    public Usuario(String usuario, String Nombre, String clave) {
        this.correo = usuario;
        this.Nombre = Nombre;
        this.clave = clave;
    }

    public Usuario() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
