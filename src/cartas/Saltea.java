package cartas;

public class Saltea extends CartaEspecial {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase CartaEspecial
	 * @param color color de la carta
	 */
	public Saltea(final String color) {
		super("saltea", color);
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}
}
