/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo.Presentacion.Contacto;



import Correo.Presentacion.Correos.*;
import Correo.Presentacion.Login.*;
import Correo.Logic.Model;
import Correo.Logic.Usuario;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;


/**
 *
 * @author Andres
 */
@Path("/Contactos")
public class Contactos {
    @Context
    HttpServletRequest request;

    @GET
    @Produces({MediaType.APPLICATION_JSON})  
    public List< Correo.Logic.Usuario> getContactos() {
       
        try {
         Usuario user = (Usuario) request.getSession(true).getAttribute("Usuario");
           return Model.instance().Contactosget(user.getCorreo()); 
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
     @POST
    @Produces({MediaType.APPLICATION_JSON})  
    @Consumes(MediaType.APPLICATION_JSON)  
    public void Addcontacto (Usuario contacto) {
        
        try {
          Model.instance().Addcontacto((Usuario) request.getSession(true).getAttribute("Usuario"),contacto);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
  
}
