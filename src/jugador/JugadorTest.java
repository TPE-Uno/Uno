package jugador;

import static org.junit.Assert.*;
import org.junit.Test;

public class JugadorTest {
	@Test (expected = IllegalArgumentException.class)
	public void testIncrementarPuntaje() {
		Jugador jugador = new Jugador("Juan");
		int puntaje = jugador.getPuntaje();
		jugador.incrementarPuntaje(2);
		assertEquals("El puntaje debe ser el anterior + 2", puntaje + 2, jugador.getPuntaje());
		jugador.incrementarPuntaje(-600);
		jugador.incrementarPuntaje(700);
		assertEquals("El puntaje debe ser menor igual a 500", 500 , jugador.getPuntaje());
	}
}
