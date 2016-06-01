package Cartas;

public class Saltea extends CartaEspecial {

	public Saltea(final String valor, final String color) {
		super(valor, color);
		if(!valor.equalsIgnoreCase("Saltea")) {
			throw new IllegalArgumentException("Valor no valido");
		}
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}
}
