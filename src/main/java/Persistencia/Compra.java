package Persistencia;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_videojuego", nullable = false)
    private Videojuego idVideojuego;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @NotNull
    @Column(name = "precio_a_pagar", nullable = false)
    private Double precioAPagar;

    public Compra(Videojuego idVideojuego, Usuario idUsuario, Double precioAPagar) {
        this.idVideojuego = idVideojuego;
        this.idUsuario = idUsuario;
        this.precioAPagar = precioAPagar;
    }

    public Compra(int idVideojuego, int idUsuario, double precio) {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Videojuego getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(Videojuego idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getPrecioAPagar() {
        return precioAPagar;
    }

    public void setPrecioAPagar(Double precioAPagar) {
        this.precioAPagar = precioAPagar;
    }

    public void comprar(int idVideojuego, double precioAPagar) {

        System.out.println("El juego con ID: " + idVideojuego + ", se ha cancelado por:" + precioAPagar);
    }
}