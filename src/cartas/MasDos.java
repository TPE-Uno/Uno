package cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class MasDos extends CartaEspecial {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Método constructor que crea la carta +2
	 * 
	 * @param color
	 */
	public MasDos(final String color) {
		super("+2", color);
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}
}
