package cartas;

public class CartaEstandar extends Carta {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase CartaEstandar
	 * @param numero numero de la carta
	 * @param color color de la carta
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
	 * Valida si el numero que se pasa por parametro esta dentro
	 * de los numeros permitidos por el juego
	 * @param numero, numero de la carta
	 * @return true si el numero es valido
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
