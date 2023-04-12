package es.ujaen.daw.tiendadeporte;

import jakarta.faces.annotation.FacesConfig;
import jakarta.enterprise.context.ApplicationScoped;
import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;



@EmbeddedIdentityStoreDefinition({
        @Credentials(callerName = "admin", password = "secret1", groups = {"ADMINISTRADORES"}),
        @Credentials(callerName = "user", password = "secret2", groups = {"USUARIOS"})
})
@ApplicationScoped
@FacesConfig
public class AppConfig {
}