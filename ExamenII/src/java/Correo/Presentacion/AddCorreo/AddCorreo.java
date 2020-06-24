/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo.Presentacion.AddCorreo;



import Correo.Presentacion.Correos.*;
import Correo.Logic.Envio_correo;
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
@Path("/AddCorreo")
public class AddCorreo {
    @Context
    HttpServletRequest request;


     @POST
    @Produces({MediaType.APPLICATION_JSON})  
    @Consumes(MediaType.APPLICATION_JSON)  
    public void Addcorreo (Envio_correo correo) {
        
        try {
            correo.getCorreo().setOrigen((Usuario) request.getSession(true).getAttribute("Usuario"));
          Model.instance().AddCorreo(correo);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
       @GET
    @Produces({MediaType.APPLICATION_JSON})  
    public List< Correo.Logic.Correo> getCorreosEnviados() {
       
        try {
         Usuario user = (Usuario) request.getSession(true).getAttribute("Usuario");
           return Model.instance().CorreosEnviadosget(user.getCorreo()); 
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
}
