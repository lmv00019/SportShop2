package es.ujaen.daw.tiendadeporte;

import es.ujaen.daw.tiendadeporte.Usuario;
import es.ujaen.daw.tiendadeporte.UsuarioDAO;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "ctrlUsuarios")
@ViewScoped
public class UsuarioController implements Serializable {
    @Inject
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private UsuarioController request;
    public UsuarioController(){}
    @PostConstruct
    private void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public List<Usuario> getUsuarios(){return usuarioDAO.buscaTodos();}
}