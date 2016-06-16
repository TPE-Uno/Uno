package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import archivos.ResourceManager;
import archivos.SaveData;
import controlador.ControladorDelJuego;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	public MenuPanel(ControladorDelJuego juegoControl) {
		setLayout(null);			
		JButton btnIntrucciones = new JButton("Instrucciones");
		btnIntrucciones.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnIntrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InstruccionesPanel instrucciones = new InstruccionesPanel(juegoControl);
				juegoControl.getJuegoFrame().setupFrame(instrucciones);
			}
		});
		btnIntrucciones.setBounds(10, 396, 218, 56);
		add(btnIntrucciones);		
		JButton button = new JButton("Juego nuevo");
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EleccionJGPanel eleccion = new EleccionJGPanel(juegoControl);
				juegoControl.getJuegoFrame().setupFrame(eleccion);
			}
		});
		button.setBounds(10, 262, 218, 56);
		add(button);		
		JButton btnCargarPartida = new JButton("Cargar partida");
		btnCargarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SaveData data = (SaveData) ResourceManager.load("1.bin");
					PartidaPanel partida = new PartidaPanel(data.getJuegoControl());
					juegoControl.getJuegoFrame().setupFrame(partida);
				}
				catch (Exception e2) {
					System.out.println("No se pudo cargar la partida: " + e2.getMessage());
				}
			}
		});
		btnCargarPartida.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCargarPartida.setBounds(10, 329, 218, 56);
		add(btnCargarPartida);		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSalir.setBounds(10, 463, 218, 56);
		add(btnSalir);		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MenuPanel.class.getResource("/imagenes/fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 1240, 600);
		add(lblNewLabel);	
	}
}
