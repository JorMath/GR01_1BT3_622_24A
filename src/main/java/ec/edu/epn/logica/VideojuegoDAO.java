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
}