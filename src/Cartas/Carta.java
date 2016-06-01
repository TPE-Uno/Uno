package Cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public abstract class Carta {

	public static final String[] VALORES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	public static final String[] COLORES = {"rojo", "amarillo", "azul", "verde", "NULL"};

	private String valor;
	private String color;
	
	/**
	 * M�todo constructor que crea la carta
	 * 
	 * @param valor
	 * @param color
	 */
	public Carta(final String valor, final String color) {
		this.valor = valor;
		this.color = color;
	}

	/**
	 * M�todo que devuelve el n�mero de la carta
	 * @return N�mero de la carta
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * M�todo que devuelve el color de la carta
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * M�todo que valida si el color que se pasa por parametro est� dentro
	 * de los colores permitidos por el juego
	 * @param color
	 * @return "true" si el color es v�lido y "false" si no lo es
	 */
	public static boolean validaColor(String color) {
		for(String cl : COLORES) {
			if(cl.equals(color)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * M�todo que retorna el nombre de la carta
	 */
	@Override
	public String toString() {
		if(!tieneColor()) {
			return getValor();
		}
		return getValor()+" de color "+getColor();
	}

	/**
	 * M�todo que retorna "true" si dos cartas son iguales y "false" si no  lo son
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
		CartaEstandar other = (CartaEstandar) o;
		if(!(this.comparaColor(other.getColor()) && this.comparaValor(other.getValor()))) {
			return false;
		}
		return true;
	}

	/**
	 * M�todo que retorna el hashCode de la carta
	 */
	@Override
	public int hashCode() {
		return getColor().hashCode();
	}

	/**
	 * M�todo que retorna "true" si la carta es de alg�n color y "false" en caso contrario
	 */
	private boolean tieneColor() {
		if(color.equals("NULL")) {
			return false;
		}
		return true;
	}

	/**
	 * M�todo que compara si dos cartas son del mismo color
	 * 
	 * @param color
	 * @return "true" si las cartas son del mismo color y "false" si no lo son
	 */
	private boolean comparaColor(final String color) {
		return getColor().equals(color);
	}

	/**
	 * M�todo que compara si dos cartas son del mismo n�mero
	 * 
	 * @param numero
	 * @return "true" si las cartas son del mismo n�mero y "false" si no lo son
	 */
	private boolean comparaValor(final String valor) {
		if(!getValor().equals(valor)) {
			return false;
		}
		return true;
	}

}
