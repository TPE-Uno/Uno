package Cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class CartaEstandar implements Carta {

	private Integer numero;
	private String color;

	/**
	 * Método constructor que crea una carta estándar
	 * 
	 * @param numero de la carta
	 * @param color de la carta
	 */
	public CartaEstandar(final  int numero, final String color) throws IllegalNumberCardException, IllegalColorCardException {
		if(!validaNumero(numero)) {
			throw new IllegalNumberCardException("No es un numero valido");
		}
		if(!validaColor(color)) {
			throw new IllegalColorCardException("No es un color valido");
		}
		this.numero = numero;
		this.color = color;
	}
	
	/**
	 * Método que devuelve el número de la carta
	 * @return Número de la carta
	 */
	public String getValor() {
		return numero.toString();
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
		if(!(this.comparaColor(other.getColor()) && this.comparaNumero(other.getValor()))) {
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
	
	/**
	 * Método que valida si el número que se pasa por parametro está dentro
	 * de los números permitidos por el juego
	 *
	 * @param numero
	 * @return "true" si el número es válido y "false" si no lo es
	 */
	private static boolean validaNumero(int numero) {
		for(String num : VALORES) {
			if(num.equals(numero)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que valida si el color que se pasa por parametro está dentro
	 * de los colores permitidos por el juego
	 * @param color
	 * @return "true" si el color es válido y "false" si no lo es
	 */
	private static boolean validaColor(String color) {
		for(String cl : COLORES) {
			if(cl.equals(color)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que compara si dos cartas son del mismo color
	 * 
	 * @param color
	 * @return "true" si las cartas son del mismo color y "false" si no lo son
	 */
	private boolean comparaColor(final String color) {
		return getColor().equals(color);
	}
	
	/**
	 * Método que compara si dos cartas son del mismo número
	 * 
	 * @param numero
	 * @return "true" si las cartas son del mismo número y "false" si no lo son
	 */
	private boolean comparaNumero(final String numero) {
		if(!getValor().equals(numero)) {
			return false;
		}
		return true;
	}
}