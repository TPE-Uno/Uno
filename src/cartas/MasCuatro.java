package cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class MasCuatro extends CartaEspecial {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String colorElegido;
	
	/**
	 * Método constructor que crea la carta +4
	 */
	public MasCuatro() {
		super("+4", "NULL");
		this.colorElegido= "";
	}
	
	public String getColorElegido() {
		return colorElegido;
	}

	public void setColorElegido(String colorElegido) {
		this.colorElegido = colorElegido;
	}
}
