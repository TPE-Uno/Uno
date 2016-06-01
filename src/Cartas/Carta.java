package Cartas;

public abstract class Carta {

	public static final String[] VALORES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+2", "+4", "multiColor", "cambiaSentido", "saltea"};
	public static final String[] COLORES = {"rojo", "amarillo", "azul", "verde", "no-color"};

	private String valor;
	private String color;
	
	public Carta(final String valor, final String color) {
		this.valor = valor;
		this.color = color;
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
	 * M�todo que devuelve el n�mero de la carta
	 * @return N�mero de la carta
	 */
	public String getValor() {
		return valor;
	}
	
	public String getColor() {
		return color;
	}
	
	/**
	 * Retorna "true" si dos cartas son iguales
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
	/**
	 * Retorna el hashCode de la carta
	 */
	@Override
	public int hashCode() {
		return getColor().hashCode();
	}
	
}
