package cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public abstract class CartaEspecial extends Carta {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Método constructor que crea la carta especial
	 * 
	 * @param valor
	 * @param color
	 */
	public CartaEspecial(final String valor, final String color) {
		super(valor, color);
	}
}
