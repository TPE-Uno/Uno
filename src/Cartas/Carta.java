package Cartas;

public abstract class Carta {

	public static final String[] VALORES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+2", "+4"};
	public static final String[] COLORES = {"rojo", "amarillo", "azul", "verde", "multi"};

	public String getValor();
	public String getColor();
	
}
