/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo.Logic;

import java.util.List;

/**
 *
 * @author Andres
 */
public class Envio_correo {
    List<Usuario> usuarios;
    Correo correo;

    public Envio_correo() {
    }

    public Envio_correo(List<Usuario> usuarios, Correo correo) {
        this.usuarios = usuarios;
        this.correo = correo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }
    
}
