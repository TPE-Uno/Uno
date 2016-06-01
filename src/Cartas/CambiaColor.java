package Cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class CambiaColor extends CartaEspecial {

	public CambiaColor(final String valor, final String color) {
		super(valor, color);
		if(!valor.equals("multicolor")) {
			throw new IllegalArgumentException("Valor no valido");
		}
		if(!color.equals("no-color")) {
			throw new IllegalArgumentException("Color no valido");
		}
	}
}
