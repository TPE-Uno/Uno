package cartas;

public abstract class CartaEspecial extends Carta {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase CartaEspecial
	 * @param valor valor de la carta
	 * @param color color de la carta
	 */
	public CartaEspecial(final String valor, final String color) {
		super(valor, color);
	}
}
