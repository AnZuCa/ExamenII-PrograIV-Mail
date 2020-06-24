/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo.Logic;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author Andres
 */
public class Model {
    private static Model uniqueInstance;
    HashMap<String,Usuario> usuarios;
    HashMap<String,Correos> UsuarioCorreos;
    HashMap<String,HashMap<String,Usuario>> UsuariosContactos;
         public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }

    public Model() {
        usuarios=new HashMap();
        usuarios.put("andres@hotmail.com",new Usuario("andres@hotmail.com","Andres","12"));
        usuarios.put("eduardo@hotmail.com",new Usuario("eduardo@hotmail.com","Eduardo","123"));
        UsuarioCorreos= new HashMap();
        UsuariosContactos = new HashMap();
        Correos list=new Correos();
        HashMap<String,Correo> correos = new HashMap();
        
        correos.put("1",new Correo(1,usuarios.get("andres@hotmail.com"),usuarios.get("andres@hotmail.com"),"hola","Bienvenidos a Costa Rica","12:38"));
         correos.put("2",new Correo(2,usuarios.get("andres@hotmail.com"),usuarios.get("andres@hotmail.com"),"BCR","Gracias por el pago de su deuda es un placer atenderlo","12:39"));
          correos.put("3",new Correo(3,usuarios.get("eduardo@hotmail.com"),usuarios.get("andres@hotmail.com"),"BCR","Gracias por el pago de su tarjeta es un placer atenderlo ","12:50"));
        list.setRecibidos(correos);
        UsuarioCorreos.put("andres@hotmail.com",list);
        
    }
    public Usuario UserGet(Usuario user)
    {
      Usuario usuario=usuarios.get(user.getCorreo());
      if(usuario!=null)
      {
         if(usuario.getClave().equals(user.getClave()))
         {
             return usuario;
         }
      }
      return null;
    }
    public List<Correo> Deletecorreo(List<Correo> correos,Usuario user)
    {
     for(Correo c:correos)
     {
      UsuarioCorreos.get(user.getCorreo()).getRecibidos().remove(Integer.toString(c.getCodigo()));
     }
     return Correosget(user.getCorreo());
    }
 public List<Correo> Correosget(String user)
 {
     if(UsuarioCorreos.get(user)!=null)
     {Collection<Correo> values = UsuarioCorreos.get(user).getRecibidos().values(); 
    return new ArrayList(values);}
     return new ArrayList();
 }
  public List<Correo> CorreosEnviadosget(String user)
 {
     if(UsuarioCorreos.get(user)!=null)
     {Collection<Correo> values = UsuarioCorreos.get(user).getEnviados().values(); 
    return new ArrayList(values);}
     return new ArrayList();
 }
  public List<Usuario> Contactosget(String user)
 {
    if(UsuariosContactos.get(user)!=null)
    {Collection<Usuario> values = UsuariosContactos.get(user).values(); 
 return new ArrayList(values);}
    return new ArrayList();
 }
 public void Addcontacto(Usuario user,Usuario contacto)
 {
     if(UsuariosContactos.get(user.getCorreo())!=null)
     {
     UsuariosContactos.get(user.getCorreo()).put(contacto.getCorreo(), contacto);
     }
     else
     {
     HashMap<String,Usuario> contactos = new HashMap();
     contactos.put(contacto.getCorreo(), contacto);
     UsuariosContactos.put(user.getCorreo(), contactos);
     }
 
 }
 public Usuario IsUsuario(String correo)
 {
 
    return usuarios.get(correo);
 }
 public void AddCorreo(Envio_correo correo)
 {
  for(Usuario user:correo.getUsuarios())
  {
      Format formatter = new SimpleDateFormat("HH:mm");
      if(UsuarioCorreos.get(user.getCorreo())!=null)
      { 
       Collection<String> llaves =  UsuarioCorreos.get(user.getCorreo()).getRecibidos().keySet();
      List<String> keys = new ArrayList(llaves);
      String tamano="1";
      if(!keys.isEmpty())
      tamano = Integer.toString(Integer.parseInt(keys.get(keys.size()-1))+1);
      
      UsuarioCorreos.get(user.getCorreo()).getRecibidos().put( tamano, new Correo(Integer.parseInt(tamano),correo.getCorreo().getOrigen(),usuarios.get(user.getCorreo()),correo.getCorreo().getAsunto(),correo.getCorreo().getMensaje(),formatter.format(new Date())));
      }
      else
      {
       Correos list=new Correos();
        HashMap<String,Correo> correos = new HashMap();
        
        correos.put("1",new Correo(1,correo.getCorreo().getOrigen(),usuarios.get(user.getCorreo()),correo.getCorreo().getAsunto(),correo.getCorreo().getMensaje(),formatter.format(new Date())));
         
        list.setRecibidos(correos);
        UsuarioCorreos.put(user.getCorreo(),list);
      }
      if(UsuarioCorreos.get(correo.getCorreo().getOrigen().getCorreo())!=null)
      {
       String tamano = Integer.toString(UsuarioCorreos.get(correo.getCorreo().getOrigen().getCorreo()).getEnviados().size()+1);
      UsuarioCorreos.get(correo.getCorreo().getOrigen().getCorreo()).getEnviados().put( tamano, new Correo(Integer.parseInt(tamano),correo.getCorreo().getOrigen(),usuarios.get(user.getCorreo()),correo.getCorreo().getAsunto(),correo.getCorreo().getMensaje(),formatter.format(new Date())));
      }
      else
      {
      Correos list=new Correos();
        HashMap<String,Correo> correos = new HashMap();
        
        correos.put("1",new Correo(1,correo.getCorreo().getOrigen(),usuarios.get(user.getCorreo()),correo.getCorreo().getAsunto(),correo.getCorreo().getMensaje(),formatter.format(new Date())));
         
        list.setEnviados(correos);
        UsuarioCorreos.put(user.getCorreo(),list);
      }    
        
  }
 }
 
}
