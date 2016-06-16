package vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.ControladorDelJuego;

@SuppressWarnings("serial")
public class JuegoFrame extends JFrame {

	private MenuPanel menu;
	
	public JuegoFrame(ControladorDelJuego juegoControl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		menu = new MenuPanel(juegoControl);
		setupFrame(menu);
		this.setLocationRelativeTo(null);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icon.png"));
        setIconImage(icon);
        setVisible(true);
	}
	
	public void setupFrame(JPanel panel) {
		this.setContentPane(panel);
		this.setSize(1240, 600);
		this.setVisible(true);
	}
	
	public MenuPanel getMenu() {
		return menu;
	}
}
