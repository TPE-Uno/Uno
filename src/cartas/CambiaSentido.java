package cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class CambiaSentido extends CartaEspecial {

	private String cambiaColor;
	public String getCambiaColor() {
		return cambiaColor;
	}
	public void setCambiaColor(String cambiaColor) {
		this.cambiaColor = cambiaColor;
	}
	/**
	 * M�todo constructor que crea la carta cambia sentido
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
