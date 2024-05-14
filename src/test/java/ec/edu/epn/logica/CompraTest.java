package ec.edu.epn.logica;

import org.junit.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;

import static org.junit.jupiter.api.Assertions.*;

public class CompraTest {
    Compra compra;
    Videojuego videojuego;
    Videojuego videojuegoDTO;

    @Test
    public void given_un_compra_when_cliente_compra_then_aumenta_iva(){
        System.out.println("Testando la compra con Iva");
        compra = new Compra();
        videojuego = new Videojuego();
        videojuego.setTitulo("GTA V");
        videojuego.setPrecio(10);
        compra.setVideojuego(videojuego);
        assertEquals(11.5, compra.calcularCompraConIva());
    }


    public void given_un_juego_when_cliente_busca_then_aumenta_iva(){

    }



}