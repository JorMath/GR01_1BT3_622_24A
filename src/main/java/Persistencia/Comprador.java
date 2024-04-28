package Persistencia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "comprador")
public class Comprador {
    @Id
    @Size(max = 10)
    @Column(name = "cedula", nullable = false, length = 10)
    private String cedula;

    @Size(max = 30)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Size(max = 30)
    @NotNull
    @Column(name = "apellido", nullable = false, length = 30)
    private String apellido;

    @Size(max = 10)
    @NotNull
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    public Comprador(){

    }
    public Comprador(String cedula, String nombre, String apellido, String telefono){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}