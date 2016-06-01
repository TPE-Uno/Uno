package Mazo;

import java.util.Collections;

public class Mazo {
	
	public static final int CANT_ESTANDAR = 10;
	
	private Stack<Carta> mazo;
	
	public Mazo() {
		mazo = new Stack<Carta>();
	}
	public void llenarMazo() {
		Carta c1 = new Carta (0, rojo);
		Carta c2 = new Carta (0, verde);
		Carta c3 = new Carta (0, amarillo);
		Carta c4 = new Carta (0, azul);
		mazo.push(c1);
		mazo.push(c2);
		mazo.push(c3);
		mazo.push(c4);
		for(int i = 1; i < CANT_ESTANDAR; i++) {
			Carta c1 = new Carta(i,rojo);
			Carta c2 = new Carta(i,verde);
			Carta c3 = new Carta(i,amarillo);
			Carta c4 = new Carta(i,azul);
			mazo.push(c1);
			mazo.push(c1);
			mazo.push(c2);
			mazo.push(c2);
			mazo.push(c3);
			mazo.push(c3);
			mazo.push(c4);
			mazo.push(c4);
		}
		Carta c1 = new MasDos(rojo);
		Carta c2 = new MasDos(verde);
		Carta c3 = new MasDos(amarillo);
		Carta c4 = new MasDos(azul);
		for(int i = 0; i < 2; i++) {
			mazo.push(c1);
			mazo.push(c2);
			mazo.push(c3);
			mazo.push(c4);
		}
		Carta c = new MasCuatro();
		for(int i = 0; i < 4; i++) {
			mazo.push(c);
		}
		Carta c1 = new Saltea(rojo);
		Carta c2 = new Saltea(verde);
		Carta c3 = new Saltea(amarillo);
		Carta c4 = new Saltea(azul);
		for(int i = 0; i < 2; i++) {
			mazo.push(c1);
			mazo.push(c2);
			mazo.push(c3);
			mazo.push(c4);
		}
		Carta c1 = new MultiColor(rojo);
		Carta c2 = new MultiColor(verde);
		Carta c3 = new MultiColor(amarillo);
		Carta c4 = new MultiColor(azul);
		for(int i = 0; i < 2; i++) {
			mazo.push(c1);
			mazo.push(c2);
			mazo.push(c3);
			mazo.push(c4);
		}
	}
	
	public void mezclar() {
		Collections.shuffle(mazo);
	}
	public boolean isEmpty() {
		return mazo.empty();
	}
	public Carta pop() {
		return mazo.pop();
	}
	public Carta push(Carta c) {
		return mazo.push(c);
	}
}
