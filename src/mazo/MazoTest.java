package mazo;

import static org.junit.Assert.*;
import org.junit.Test;

public class MazoTest {
	@Test
	public void testLlenarMazo() {
		Mazo m = new Mazo();
		m.llenarMazo();
		assertNotNull(m);
		assertEquals("El mazo debe tener 108 cartas", 108, m.tamanoMazo());
		m.llenarMazo();
		assertEquals("El mazo debe tener 108 cartas", 108, m.tamanoMazo());
	}
}
