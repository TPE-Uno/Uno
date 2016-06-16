package cartas;

public abstract class Carta implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String[] VALORES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	public static final String[] COLORES = {"rojo", "amarillo", "azul", "verde", "NULL"};

	private String valor;
	private String color;
	
	/**
	 * Constructor de la clase Carta
	 * @param valor valor de la carta
	 * @param color color de la carta
	 */
	public Carta(final String valor, final String color) {
		this.valor = valor;
		this.color = color;
	}
	
	public String getValor() {
		return valor;
	}
	
	public String getColor() {
		return color;
	}
	
	/**
	 * Verifica si una carta es CambiaColor
	 * @return true si es la carta
	 */
	public boolean esCambiaColor() {
		if(this.getClass().equals(CambiaColor.class)) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica si una carta es MasCuatro
	 * @return true si es la carta
	 */
	public boolean esMasCuatro() {
		if(this.getClass().equals(MasCuatro.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica si una carta es MasDos
	 * @return true si es la carta
	 */
	public boolean esMasDos() {
		if(this.getClass().equals(MasDos.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica si una carta es CambiaSentido
	 * @return true si es la carta
	 */
	public boolean esCambiaSentido() {
		if(this.getClass().equals(CambiaSentido.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica si una carta es Saltea
	 * @return true si es la carta
	 */
	public boolean esSaltea() {
		if(this.getClass().equals(Saltea.class)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica si una carta es CartaEspecial
	 * @return true si es la carta
	 */
	public boolean esEspecial() {
		if(this instanceof CartaEspecial) {
			return true;
		}
		return false;
	}

	/**
	 * Valida si el color que se pasa por parametro esta dentro
	 * de los colores permitidos por el juego
	 * @param color color de la carta
	 * @return true si el color es valido
	 */
	public static boolean validaColor(String color) {
		for(String cl : COLORES) {
			if(cl.equals(color)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		if(!tieneColor()) {
			return getValor();
		}
		return getValor()+" de color "+getColor();
	}

	/**
	 * Las cartas son comparadas por su color y su valor
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null) {
			return false;
		}
		if(getClass() != o.getClass()) {
			return false;
		}
		Carta other = (Carta) o;
		if(!(this.comparaColor(other.getColor()) && this.comparaValor(other.getValor()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return getColor().hashCode();
	}

	/**
	 * Retorna true si la carta es de algun color
	 */
	private boolean tieneColor() {
		if(color.equals("NULL")) {
			return false;
		}
		return true;
	}

	/**
	 * Compara si dos cartas son del mismo color
	 * @param color color de la carta
	 * @return true si las cartas son del mismo color
	 */
	private boolean comparaColor(final String color) {
		return getColor().equals(color);
	}

	/**
	 * Compara si dos cartas son del mismo numero
	 * @param valor valor de la carta
	 * @return true si las cartas son del mismo numero
	 */
	private boolean comparaValor(final String valor) {
		if(!getValor().equals(valor)) {
			return false;
		}
		return true;
	}
}
