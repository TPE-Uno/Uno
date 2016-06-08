package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControladorDelJuego;

public class JuegoFrame extends JFrame {

	private MenuPanel menu;
	private InstruccionesPanel instrucciones;
	
	public JuegoFrame(ControladorDelJuego juego) {
		setResizable(false);
		menu = new MenuPanel(juego);
		setupFrame(menu);
		this.setLocationRelativeTo(null);
	}
	
	public void setupFrame(JPanel panel) {
		this.setContentPane(panel);
		this.setSize(600, 450);
		this.setVisible(true);
	}
}
