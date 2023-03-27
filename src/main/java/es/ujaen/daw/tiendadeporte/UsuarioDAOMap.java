package es.ujaen.daw.tiendadeporte;

import es.ujaen.daw.tiendadeporte.DAOMap;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped      //Elegible for Dependency Injection
@DAOMap
public class UsuarioDAOMap implements UsuarioDAO, Serializable{

    private  Map<Integer, Usuario> usuarios;
    private  Integer idUsuario = 1;

    public UsuarioDAOMap() {
        usuarios = new HashMap<>();

        usuarios.put(idUsuario, new Usuario(idUsuario++, "Paco López", "11111111-A"));
        usuarios.put(idUsuario, new Usuario(idUsuario++, "María Jiménez", "22222222-B"));
        usuarios.put(idUsuario, new Usuario(idUsuario++, "Carlos García", "33333333-C"));
    }

    @Override
    public Usuario buscaId(Integer id) {
        Usuario localizado = usuarios.get(id);
        if (localizado != null) localizado= new Usuario(localizado);
        return localizado;
    }
    @Override
    public List<Usuario> buscaTodos() {
        //return new ArrayList<Cliente>(clientes.values()); JDK<8
        return usuarios.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean crea(Usuario u) {
        Usuario nu=new Usuario(u);
        nu.setId(idUsuario);
        usuarios.put(idUsuario, nu);
        u.setId(idUsuario);
        idUsuario++;
        return true;
    }

    @Override
    public boolean guarda(Usuario u) {
        boolean result=false;
        if (usuarios.containsKey(u.getId())) {
            Usuario nu=new Usuario(u);
            usuarios.replace(u.getId(),nu);
            result=true;
        }
        return result;
    }

    @Override
    public boolean borra(Integer id) {
        boolean result=false;
        if (usuarios.containsKey(id)) {
            usuarios.remove(id);
            result = true;
        }
        return result;
    }

    public int numUsuarios() {
        return usuarios.size();
    }

    @Override
    public Usuario buscaDni(String dni) {
        //return clientes.values().stream().filter( c -> c.getDni().equals(nif)).findAny().orElse(null);
        Usuario localizado = null;
        for (Usuario u: usuarios.values()) {
            if (u.getDni().equals(dni)) {
                localizado=u;
                break;
            }
        }
        if (localizado!=null) localizado=new Usuario(localizado);
        return localizado;
    }

}
