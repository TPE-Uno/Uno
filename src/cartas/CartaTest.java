package cartas;

import static org.junit.Assert.*;
import org.junit.Test;

public class CartaTest {

	@Test
	public void testComparaColor() {
		assertTrue(Carta.validaColor("azul"));
		assertTrue(Carta.validaColor("verde"));
		assertTrue(Carta.validaColor("amarillo"));
		assertTrue(Carta.validaColor("rojo"));
		assertFalse(Carta.validaColor("perro"));
		assertFalse(Carta.validaColor("1000000000000"));
		assertFalse(Carta.validaColor(null));
		assertFalse(Carta.validaColor("$"));
	}
}
