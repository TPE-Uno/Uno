package Cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class CambiaSentido extends CartaEspecial {

	/**
	 * Método constructor que crea la carta cambia sentido
	 * 
	 * @param color
	 */
	public CambiaSentido(final String color) {
		super("cambiaSentido", color);
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}

}
