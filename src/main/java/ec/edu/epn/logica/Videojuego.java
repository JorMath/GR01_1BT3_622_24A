package ec.edu.epn.logica;

import ec.edu.epn.persistencia.VideojuegoJpaController;
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

}
