package logica;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nombre;
    private String apellido;
    @OneToMany
    @JoinColumn(name = "idCompra")
    private List<Compra> compra;

    public Cliente(int idCliente, String nombre, String apellido, List<Compra> compra) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.compra = compra;
    }

    public Cliente() {

    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Compra> getCompra() {
        return compra;
    }

    public void setCompra(List<Compra> compra) {
        this.compra = compra;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}