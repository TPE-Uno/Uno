package cartas;

public class CambiaColor extends CartaEspecial {
	
	private static final long serialVersionUID = 1L;
		private String colorElegido;
		
	/**
	* Constructor de la clase CambiaColor
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
