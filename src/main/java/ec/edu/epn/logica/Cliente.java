package ec.edu.epn.logica;

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
    private String clave;
    @OneToMany
    @JoinColumn(name = "idCompra")
    private List<Compra> compra;

    public Cliente(int idCliente, String nombre, String apellido,String clave, List<Compra> compra) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.nombre = apellido;
        this.clave = clave;
        this.compra = compra;
    }

    public Cliente() {}

    public void agregarCompra(Compra compra) {

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


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
