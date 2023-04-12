package es.ujaen.daw.tiendadeporte;


import jakarta.enterprise.context.SessionScoped;
        import jakarta.inject.Named;
        import java.io.Serializable;

@Named(value="prefs")
@SessionScoped
public class Preferencias implements Serializable {

    private String ultimoArticulo = "";

    public Preferencias() {};

    public String getUltimoArticulo(){
        return ultimoArticulo;
    }

    public void setUltimoArticulo(String ultimoArticulo) {
        this.ultimoArticulo = ultimoArticulo;
    }
}