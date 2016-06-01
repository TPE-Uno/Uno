package Cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public abstract class CartaEspecial extends Carta {
	
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
