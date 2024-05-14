package ec.edu.epn.logica;

import ec.edu.epn.persistencia.DAOPersistencia;

import java.util.List;

public class VideojuegoDAO {
    DAOPersistencia daoPersistencia = new DAOPersistencia();
    public void crearVideojuego(Videojuego cliente) {
        daoPersistencia.crearVideojuego(cliente);
    }

    public List<Videojuego> listarVideojuegos() {
        return daoPersistencia.listarVideojuegos();
    }

    public Videojuego obtenerVideojuego(int idVideojuego) {
        return daoPersistencia.obtenerVideojuego(idVideojuego);

    }

    public boolean obtenerVideojuegoPorNombre(String tituloABuscar) {
        return daoPersistencia.obtenerVideojuego(tituloABuscar);
    }

    public void eliminarVideojuego(String nombre) {
        daoPersistencia.eliminarJuego(nombre);
    }

    public boolean existeVideojuego(String nombre) {
        return daoPersistencia.obtenerVideojuego(nombre);
    }
}