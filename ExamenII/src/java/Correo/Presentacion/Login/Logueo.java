/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo.Presentacion.Login;



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
@Path("/Logueo")
public class Logueo {
    @Context
    HttpServletRequest request;
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})  
    @Consumes(MediaType.APPLICATION_JSON)  
    public Usuario get(Usuario user) {
        Usuario client=null;
        try {
          client= Model.instance().UserGet(user);
          request.getSession(true).setAttribute("Usuario", client);
           return (Usuario) request.getSession(true).getAttribute("Usuario"); 
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    

    @GET
    @Produces({MediaType.APPLICATION_JSON})  
    public Usuario getUser() {
       
        try {
         
           return (Usuario) request.getSession(true).getAttribute("Usuario"); 
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @DELETE
    public void Logout()
    {
    HttpSession session = request.getSession(true);
    session.removeAttribute("usuario");
    session.invalidate();
    }
    
  

}
