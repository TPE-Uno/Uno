package cartas;

public class MasCuatro extends CartaEspecial {
	
	private static final long serialVersionUID = 1L;
	
	private String colorElegido;
	
	/**
	 * Constructor de la clase MasCuatro
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
