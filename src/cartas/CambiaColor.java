package cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class CambiaColor extends CartaEspecial {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String colorElegido;
	/**
	 * M�todo constructor que crea una carta Cambia color
	 */
	public CambiaColor() {
		super("cambiaColor", "NULL");
		this.colorElegido = "";
	}

	public String getColorElegido() {
		return colorElegido;
	}

	public void setColorElegido(String colorElegido) {
		this.colorElegido = colorElegido;
	}
}
