package Cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class MasDos extends CartaEspecial {

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
