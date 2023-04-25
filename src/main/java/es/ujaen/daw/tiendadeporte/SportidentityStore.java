package es.ujaen.daw.tiendadeporte;
import java.util.Set;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import jakarta.security.enterprise.identitystore.IdentityStore;
import java.util.logging.Logger;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class SportidentityStore implements IdentityStore {
    private static final Logger logger = Logger.getLogger(SportidentityStore.class.getName());

    private Map<String,String> credenciales; //ejemplo de almacén de credenciales
    public SportidentityStore() {
        credenciales = new HashMap<>();
        credenciales.put("Lorena", "clave1");
        credenciales.put("Alberto", "clave2");
    }


    public CredentialValidationResult validate (UsernamePasswordCredential usernamePasswordCredential ) {


        //Recuperar credenciales proporcionadas por el servidor
        String username = usernamePasswordCredential.getCaller();

        String password = usernamePasswordCredential.getPasswordAsString();

        //Ejemplo simple de verificación de credenciales
        String validPassword = credenciales.get(username);

        if (validPassword != null && validPassword.equals(password)) {

        //Autenticación completada, obtener los roles del usuario...
            Set<String> roles = new HashSet<>(Arrays.asList("ADMINISTRADORES"));
        //Pasar datos del usuario al servidor
            return new CredentialValidationResult(username, roles);
        }

        return INVALID_RESULT; //Autenticación inválida
    }


}