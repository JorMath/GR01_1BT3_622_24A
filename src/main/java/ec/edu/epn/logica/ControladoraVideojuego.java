package ec.edu.epn.logica;

import ec.edu.epn.persistencia.ControladoraPersistencia;

import java.util.List;

public class ControladoraVideojuego {
    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
    public void crearVideojuego(Videojuego cliente) {
        controladoraPersistencia.crearVideojuego(cliente);
    }

    public List<Videojuego> listarVideojuegos() {
        return controladoraPersistencia.listarVideojuegos();
    }

    public Videojuego obtenerVideojuego(int idVideojuego) {
        return controladoraPersistencia.obtenerVideojuego(idVideojuego);

    }
}