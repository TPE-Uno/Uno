package cartas;

public class CambiaSentido extends CartaEspecial {
	
	private static final long serialVersionUID = 1L;
	
	private String cambiaColor;
	
	public String getCambiaColor() {
		return cambiaColor;
	}
	
	public void setCambiaColor(String cambiaColor) {
		this.cambiaColor = cambiaColor;
	}
	
	/**
	 * Constructor de la clase CambiaSentido
	 * @param color color de la carta
	 */
	public CambiaSentido(final String color) {
		super("cambiaSentido", color);
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}
}
