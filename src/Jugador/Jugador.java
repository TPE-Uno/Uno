package Jugador;

public class Jugador {

	private String nombre;
	private int puntaje;
	private Mano mano; 
	
	public Jugador (String nombre){
		this.nombre = nombre;
		this.puntaje = 0;
		this.mano = new Mano();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public void setPuntaje(int puntaje){
		this.puntaje = puntaje;
	}
	
	public void incrementarPuntaje(int puntaje){
		this.puntaje+=puntaje; //setPuntaje(this.puntaje + puntaje); 
	}
		
}

