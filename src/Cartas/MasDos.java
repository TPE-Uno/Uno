package Cartas;

public class MasDos extends CartaEspecial {

	public MasDos(final String valor, final String color) {
		super(valor, color);
		if(!valor.equals("+2")) {
			throw new IllegalArgumentException("Valor no valido");
		}
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}
}
