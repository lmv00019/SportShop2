package es.ujaen.daw.tiendadeporte;


import es.ujaen.daw.tiendadeporte.Usuario;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
class UsuarioDAO {
    private Map<Integer,Usuario> usuarios=null;
    public UsuarioDAO() {
        if (usuarios == null) {
            usuarios = new HashMap<>();
            usuarios.put(1,new Usuario(1,"77435696D",
                    "Lorena"));
            usuarios.put(2,new Usuario(2,"1234567891",
                    "Alberto"));
            usuarios.put(3,new Usuario(3,"1234567893",
                    "Maria"));
        }
    }
    public Usuario buscaDni(String dni) {
        return new Usuario( usuarios.get(dni) );
    }
    public List<Usuario> buscaTodos() {
        return usuarios.values().stream().collect(Collectors.toList());
    }
    public int numUsuarios() {
        return usuarios.size();
    }
}