package logica;

import jakarta.persistence.*;

@Entity
@Table
public class Videojuego {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idVideojuego;
    private String titulo;
    private String descripcion;

    public Videojuego(int idVideojuego, String descripcion, String titulo) {
        this.idVideojuego = idVideojuego;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    public Videojuego() {
    }

    public int getIdVideojuego() {
        return idVideojuego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
