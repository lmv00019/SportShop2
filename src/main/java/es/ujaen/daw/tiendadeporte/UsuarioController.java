package es.ujaen.daw.tiendadeporte;

import es.ujaen.daw.tiendadeporte.Usuario;
import es.ujaen.daw.tiendadeporte.UsuarioDAO;
import es.ujaen.daw.tiendadeporte.DAOJpa;
import es.ujaen.daw.tiendadeporte.DAOMap;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named(value = "ctrlUsuario")
@ViewScoped
public class UsuarioController implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Logger logger = Logger.getLogger(UsuarioController.class.getName());
    @Inject  @DAOJpa
    private UsuarioDAO usuarioDAO;
    @Inject
    FacesContext fc;
    private Usuario usuario;
    //private UsuarioController request;
    public UsuarioController(){}
    @PostConstruct
    private void init(){
        usuario = new Usuario();
    }
    public List<Usuario> getUsuarios(){return usuarioDAO.buscaTodos();}

    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void recupera() {
        usuario = usuarioDAO.buscaId(usuario.getId());
        if (usuario == null) {
            fc.addMessage(null, new FacesMessage("El usuario indicado no existe"));
        }
    }

    public String crea() {
        usuario.setId(0);
        usuarioDAO.crea(usuario);
        //Post-Redirect-Get
        return "/Index2?faces-redirect=true&id" + usuario.getId();
    }

    public String guarda() {
        usuarioDAO.guarda(usuario);
        return "/Index2?faces-redirect=true&id=" + usuario.getId();
    }

    public String borra() {
        usuarioDAO.borra(usuario.getId());
        return "listadoUsuarios";
    }

    public String borra(Usuario usuario) {
        usuarioDAO.borra(usuario.getId());
        return "listadoUsuarios";
    }



}