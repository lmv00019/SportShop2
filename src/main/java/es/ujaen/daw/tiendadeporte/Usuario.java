package es.ujaen.daw.tiendadeporte;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity()
public class Usuario implements Serializable{
    @Id
    private Integer id;
    private String dni;
    private String nombre;


    public Usuario() {
        id = 0;
        dni = "";
        nombre = "";
    }

    public Usuario(Integer id, String dni, String nombre) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
    }

    /**
     * Constructor de copia
     */
    public Usuario(Usuario u) {
        this.id = u.id;
        this.dni = u.dni;
        this.nombre = u.nombre;
    }



    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
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

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}



