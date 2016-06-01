package Cartas;

public class CambiaSentido extends CartaEspecial {

	public CambiaSentido(final String valor, final String color) {
		super(valor, color);
		if(!valor.equals("cambiaSentido")) {
			throw new IllegalArgumentException("Valor no valido");
		}
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}
}
