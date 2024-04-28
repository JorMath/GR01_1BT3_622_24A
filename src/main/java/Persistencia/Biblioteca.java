package Persistencia;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biblioteca", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_videojuego", nullable = false)
    private Videojuego idVideojuego;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    public Biblioteca(Integer id, Videojuego idVideojuego, Usuario idUsuario) {
        this.id = id;
        this.idVideojuego = idVideojuego;
        this.idUsuario = idUsuario;
    }
    public Biblioteca() {}

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

}