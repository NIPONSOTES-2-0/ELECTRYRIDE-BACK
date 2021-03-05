package edu.escuelaing.eci.ieti.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String nombre;
    private String universidad;

    public User(){}
    public User(String ID, String nombre, String universidad) {
        this.id = ID;
        this.nombre = nombre;
        this.universidad = universidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    @Override
    public String toString() {
        return "User{" +
                "ID=" + id +
                ", nombre='" + nombre + '\'' +
                ", universidad='" + universidad + '\'' +
                '}';
    }
}