package ec.edu.epn.logica;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Desarrollador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDesarrollador;
    private String nombre;
    private String apellido;
    private String clave;
    @OneToMany
    @JoinColumn(name = "idCompra")
    private List<Videojuego> videojuegos;

    public Desarrollador(int idDesarrollador, List<Videojuego> videojuegos, String clave, String apellido, String nombre) {
        this.idDesarrollador = idDesarrollador;
        this.videojuegos = videojuegos;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Desarrollador() {

    }

    public int getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(int idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(List<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }
}
