package jugador;

import cartas.Carta;

public class Jugador implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int puntaje;
	private Mano mano; 
	private boolean uno = false; 
	
	/**
	 * Constructor de la clase Jugador. Inicializa el puntaje en 0 y crea la mano
	 * @param nombre nombre del jugador
	 */
	public Jugador (String nombre) {
		this.nombre = nombre;
		this.puntaje = 0;
		this.mano = new Mano();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public void incrementarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}
	
	public Mano getMano(){
		return this.mano;
	}

	public void actualizarUno() {
		this.uno = false; 
	}
	
	public void decirUno() {
		this.uno = true; 
	}
	
	public boolean getUno() {
		return this.uno;
	}
	
	public void setUno(boolean active) {
		this.uno = active;
	}
	
	/**
	 * Los jugadores son comparados por su mano, su nombre, su puntaje y su "uno"
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mano == null) ? 0 : mano.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + puntaje;
		result = prime * result + (uno ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (mano == null) {
			if (other.mano != null)
				return false;
		} else if (!mano.equals(other.mano))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (puntaje != other.puntaje)
			return false;
		if (uno != other.uno)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Jugador: " + this.nombre + "\nPuntaje: " + this.puntaje;
	}
	
	public void recibirCarta(Carta carta) {
		mano.tomaCarta(carta);
	}
	
	public void vaciarMano() {
		getMano().limpia();
	}
}
