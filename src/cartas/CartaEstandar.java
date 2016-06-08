package cartas;

/**
 * 
 * @author Team - UNO
 *
 */
public class CartaEstandar extends Carta {

	/**
	 * Método constructor que crea una carta estándar
	 * 
	 * @param numero de la carta
	 * @param color de la carta
	 */
	public CartaEstandar(final  String numero, final String color) {
		super(numero, color);
		if(!validaNumero(numero)) {
			throw new IllegalArgumentException("No es un numero valido");
		}
		if(!validaColor(color)) {
			throw new IllegalArgumentException("No es un color valido");
		}
	}	

	/**
	 * Método que valida si el número que se pasa por parametro está dentro
	 * de los números permitidos por el juego
	 *
	 * @param numero
	 * @return "true" si el número es válido y "false" si no lo es
	 */
	private static boolean validaNumero(String numero) {
		for(String valor : VALORES) {
			if(valor.equals(numero)) {
				return true;
			}
		}
		return false;
	}
}