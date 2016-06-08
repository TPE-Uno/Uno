package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControladorDelJuego;

public class MenuPanel extends JPanel {

	private ControladorDelJuego juego;
	
	public MenuPanel(ControladorDelJuego juego) {
		this.juego = juego;
		setLayout(null);			
		JButton btnIntrucciones = new JButton("Intrucciones");
		btnIntrucciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIntrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InstruccionesPanel instrucciones = new InstruccionesPanel();
				juego.getJuegoFrame().setupFrame(instrucciones);
			}
		});
		btnIntrucciones.setBounds(10, 285, 157, 28);
		add(btnIntrucciones);		
		JButton button = new JButton("Juego nuevo");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(10, 207, 157, 28);
		add(button);		
		JButton btnCargarPartida = new JButton("Cargar partida");
		btnCargarPartida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCargarPartida.setBounds(10, 246, 157, 28);
		add(btnCargarPartida);		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBounds(10, 324, 157, 28);
		add(btnSalir);		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MenuPanel.class.getResource("/imagenes/fondo.jpg")));
		lblNewLabel.setBounds(0, -1, 600, 450);
		add(lblNewLabel);	
	}
}