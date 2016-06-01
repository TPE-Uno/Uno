package Mazo;

import java.util.Collections;
import java.util.Stack;

import Cartas.*;

public class Mazo {

	public static final int CANT_ESTANDAR = 10;

	private Stack<Carta> mazo;

	public Mazo() {
		mazo = new Stack<Carta>();
	}
	public void llenarMazo() {
		Carta c1 = new CartaEstandar ("0", "rojo");
		Carta c2 = new CartaEstandar ("0", "verde");
		Carta c3 = new CartaEstandar ("0", "amarillo");
		Carta c4 = new CartaEstandar ("0", "azul");
		mazo.push(c1);
		mazo.push(c2);
		mazo.push(c3);
		mazo.push(c4);
		for(Integer i = 1; i < CANT_ESTANDAR; i++) {
			Carta c5 = new CartaEstandar(i.toString(),"rojo");
			Carta c6 = new CartaEstandar(i.toString(),"verde");
			Carta c7 = new CartaEstandar(i.toString(),"amarillo");
			Carta c8 = new CartaEstandar(i.toString(),"azul");
			mazo.push(c5);
			mazo.push(c5);
			mazo.push(c6);
			mazo.push(c6);
			mazo.push(c7);
			mazo.push(c7);
			mazo.push(c8);
			mazo.push(c8);
		}
		Carta c9 = new MasDos("+2", "rojo");
		Carta c10 = new MasDos("+2", "verde");
		Carta c11 = new MasDos("+2","amarillo");
		Carta c12 = new MasDos("+2","azul");
		for(int i = 0; i < 2; i++) {
			mazo.push(c9);
			mazo.push(c10);
			mazo.push(c11);
			mazo.push(c12);
		}
		Carta c = new MasCuatro("+4","multiColor");
		for(int i = 0; i < 4; i++) {
			mazo.push(c);
		}
		Carta c13 = new Saltea("saltea","rojo");
		Carta c14 = new Saltea("saltea","verde");
		Carta c15 = new Saltea("saltea","amarillo");
		Carta c16 = new Saltea("saltea","azul");
		for(int i = 0; i < 2; i++) {
			mazo.push(c13);
			mazo.push(c14);
			mazo.push(c15);
			mazo.push(c16);
		}

		Carta c17 = new CambiaColor("multiColor","no-color");
		for(int i = 0; i < 4; i++) {
			mazo.push(c17);

		}

		Carta c18 = new CambiaSentido("cambiaSentido","rojo");
		Carta c19 = new CambiaSentido("cambiaSentido","verde");
		Carta c20 = new CambiaSentido("cambiaSentido","amarillo");
		Carta c21 = new CambiaSentido("cambiaSentido","azul");
		for(int i = 0; i < 2; i++) {
			mazo.push(c18);
			mazo.push(c19);
			mazo.push(c20);
			mazo.push(c21);
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
