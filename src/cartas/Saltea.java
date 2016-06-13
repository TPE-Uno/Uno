package cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class Saltea extends CartaEspecial {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
