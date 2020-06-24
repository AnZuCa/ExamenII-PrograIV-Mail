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
public class Correo {
  int codigo;
  Usuario origen;
  Usuario destino;
  String asunto;
  String mensaje;
  String hora;
    public Correo(int codigo,Usuario origen, Usuario destino, String asunto, String mensaje, String hora) {
        this.codigo=codigo;
        this.origen = origen;
        this.destino = destino;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.hora=hora;
    }

    public Correo() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Usuario getOrigen() {
        return origen;
    }

    public void setOrigen(Usuario origen) {
        this.origen = origen;
    }

    public Usuario getDestino() {
        return destino;
    }

    public void setDestino(Usuario destino) {
        this.destino = destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
  
}
