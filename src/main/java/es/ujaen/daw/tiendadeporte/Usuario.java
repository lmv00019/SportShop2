package es.ujaen.daw.tiendadeporte;


import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity()       //JPA annotations
//@Table(name="Usuario")
public class Usuario implements Serializable {

    @Id         //JPA annotations
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incremental
    private Integer id;

    @Size(min = 4, max = 25, message = "La longitud ${validatedValue} debe estar entre {min} y {max} caracteres")
    private String nombre;
    @Pattern(regexp = "\\d{7,8}(-?[a-zA-Z])?", message = "{Usuario.dni.formato}")
    private String dni;




    public Usuario() {
        id = 0;
        nombre = "";
        dni="";

    }

    public Usuario(Integer id, String nombre, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;

    }

    /**
     * Copy constructor
     */
    public Usuario(Usuario u) {
        this.id = u.id;
        this.nombre = u.nombre;
        this.dni = u.dni;

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }




    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return "Usuario[ id=" + id +"]";
}

}






























































































