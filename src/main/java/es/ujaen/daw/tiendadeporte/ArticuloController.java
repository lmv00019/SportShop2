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


@Named(value = "ctrlArticulo")
@ViewScoped
public class ArticuloController implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Logger logger = Logger.getLogger(ArticuloController.class.getName());
    @Inject  @DAOJpa
    private ArticuloDAO articuloDAO;
    @Inject
    FacesContext fc;
    private Articulo articulo;

    public ArticuloController(){}
    @PostConstruct
    private void init(){
        articulo = new Articulo();
    }
    public List<Articulo> getArticulos(){return articuloDAO.buscaTodos();}

    public Articulo getArticulo(){return articulo;}
    public void setArticulo(Articulo articulo){
        this.articulo = articulo;
    }

    public void recupera() {
        articulo = articuloDAO.buscaId(articulo.getId());
        if (articulo == null) {
            fc.addMessage(null, new FacesMessage("El articulo indicado no existe"));
        }
    }

    public String crea() {
        articulo.setId(0);
        articuloDAO.crea(articulo);
        //Post-Redirect-Get
        return "/Compra?faces-redirect=true&id" + articulo.getId();
    }

    public String guarda() {
        articuloDAO.guarda(articulo);
        return "/Compra?faces-redirect=true&id=" + articulo.getId();
    }

    public String borra() {
        articuloDAO.borra(articulo.getId());
        return "Compra";
    }

    public String borra(Articulo articulo) {
        articuloDAO.borra(articulo.getId());
        return "Compra";
    }

    /*public String modifica(Integer id, String nombre, String dni) {
        Usuario u;
        //u = UsuarioDAOMap.buscaId(id);
        u.setNombre(nombre);
        u.setDni(dni);
        //Post-Redirect-Get
        return "/Index2?faces-redirect=true&id" + u.getId();
    }*/
}