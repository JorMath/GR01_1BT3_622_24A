package ec.edu.epn.logica;

import jakarta.persistence.*;

@Entity
@Table
public class Videojuego {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idVideojuego;

    private String titulo;
    private String descripcion;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "idDesarrollador")
    private Desarrollador desarrollador;


    public Videojuego(int idVideojuego, String descripcion, String titulo, double precio) {
        this.idVideojuego = idVideojuego;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIdVideojuego(int idVideojuego) {
        this.idVideojuego = idVideojuego;
    }
    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

}
