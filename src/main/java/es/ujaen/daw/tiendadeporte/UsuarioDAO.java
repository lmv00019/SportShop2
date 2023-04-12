package es.ujaen.daw.tiendadeporte;


import es.ujaen.daw.tiendadeporte.Usuario;


import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import jakarta.enterprise.context.ApplicationScoped;

public interface UsuarioDAO extends GenericDAO<Usuario,Integer>{
    //Declare here specific methods for EntityDAO
    public Usuario buscaDni(String dni);
}


