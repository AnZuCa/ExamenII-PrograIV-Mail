/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo.Logic;

import java.util.HashMap;



/**
 *
 * @author Andres
 */
public class Correos {
    HashMap<String,Correo> enviados;
     HashMap<String,Correo> recibidos;

    public Correos(HashMap<String,Correo> enviados, HashMap<String,Correo> recibidos) {
        this.enviados = enviados;
        this.recibidos = recibidos;
    }

    public Correos() {
        enviados = new HashMap();
        recibidos = new HashMap();
    }

    public HashMap<String, Correo> getEnviados() {
        return enviados;
    }

    public void setEnviados(HashMap<String, Correo> enviados) {
        this.enviados = enviados;
    }

    public HashMap<String, Correo> getRecibidos() {
        return recibidos;
    }

    public void setRecibidos(HashMap<String, Correo> recibidos) {
        this.recibidos = recibidos;
    }
    
    
}
