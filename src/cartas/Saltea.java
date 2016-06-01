package Cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class Saltea extends CartaEspecial {

	/**
	 * Método constructor que cre la carta saltea
	 * 
	 * @param color
	 */
	public Saltea(final String color) {
		super("saltea", color);
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}

}
