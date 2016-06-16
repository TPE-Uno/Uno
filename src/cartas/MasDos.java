package cartas;

public class MasDos extends CartaEspecial {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase MasDos
	 * @param color color de la carta
	 */
	public MasDos(final String color) {
		super("+2", color);
		if(!validaColor(color)) {
			throw new IllegalArgumentException("Color no valido");
		}
	}
}
