package juego;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RondaTest {

	@Test
	public void testCambiaSentido() {
		List<String> nombres = new ArrayList<String>();
		nombres.add("Pepe");
		nombres.add("Lolo");
		nombres.add("Mario");
		nombres.add("Tata");
		Ronda r = new Ronda(nombres);
		assertTrue(r.getSentidoRonda());
		r.cambiaSentido();
		assertFalse(r.getSentidoRonda());
		r.cambiaSentido();
		assertTrue(r.getSentidoRonda());
	}
	
	@Test
	public void testIndexSiguiente() {
		List<String> nombres = new ArrayList<String>();
		nombres.add("Pepe");
		nombres.add("Lolo");
		nombres.add("Mario");
		nombres.add("Tata");
		Ronda r = new Ronda(nombres);
		
		//sentido antihorario
		assertTrue(r.getSentidoRonda());
		Integer index = r.getIndexActual();
		if(index < r.size()-1) //si no es el ultimo de la ronda
			assertEquals(index+1, r.indexSiguiente());
		else if(index == r.size()) //si es el ultimo vuelve al primero
			assertEquals(0 , r.indexSiguiente());
		assertFalse(r.indexSiguiente() >= r.size());
		assertTrue(r.indexSiguiente() >= 0);
		
		//sentido horario
		r.setSentidoRonda(false);
		if(index > 0) //si no es el primero de la ronda
			assertEquals(index-1, r.indexSiguiente());
		else if(index == 0) //si es el primero vuelve al ultimo
			assertEquals(3 , r.indexSiguiente());
		assertFalse(r.indexSiguiente() >= r.size());
		assertTrue(r.indexSiguiente() >= 0);
	}
		
	@Test
	public void testIndexSiguienteConParam() {
		List<String> nombres = new ArrayList<String>();
		nombres.add("Pepe");
		nombres.add("Lolo");
		nombres.add("Mario");
		nombres.add("Tata");
		Ronda r = new Ronda(nombres);

		//sentido antihorario
		assertTrue(r.getSentidoRonda());
		assertEquals(1, r.indexSiguiente(0));
		assertEquals(2, r.indexSiguiente(1));
		assertEquals(3, r.indexSiguiente(2));
		assertEquals(0 , r.indexSiguiente(3));
		assertFalse(r.indexSiguiente(3) >= r.size());
		assertTrue(r.indexSiguiente(3) >= 0);
		
		//sentido horario
		r.setSentidoRonda(false);
		assertEquals(3, r.indexSiguiente(0));
		assertEquals(0, r.indexSiguiente(1));
		assertEquals(1, r.indexSiguiente(2));
		assertEquals(2 , r.indexSiguiente(3));
		assertFalse(r.indexSiguiente(0) >= r.size());
		assertTrue(r.indexSiguiente(0) >= 0);
	}
}
