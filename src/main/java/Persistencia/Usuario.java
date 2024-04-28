package Persistencia;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Size(max = 30)
    @NotNull
    @Column(name = "apellido", nullable = false, length = 30)
    private String apellido;
    public Usuario() {}
    public Usuario(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @OneToMany(mappedBy = "idUsuario")
    private Set<Biblioteca> bibliotecas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUsuario")
    private Set<Compra> compras = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(Set<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public Set<Compra> getCompras() {
        return compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }
    public boolean validar(String nombre, String apellido) {
        return true;
    };

}