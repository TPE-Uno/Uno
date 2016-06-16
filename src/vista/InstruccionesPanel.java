package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import controlador.ControladorDelJuego;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class InstruccionesPanel extends JPanel {
	
	public InstruccionesPanel(ControladorDelJuego juegoControl) {
		setLayout(null);
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juegoControl.getJuegoFrame().setupFrame(juegoControl.getJuegoFrame().getMenu());
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAtras.setBounds(25, 530, 157, 28);
		add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InstruccionesPanel.class.getResource("/imagenes/Instrucciones.jpg")));
		lblNewLabel.setBounds(0, 0, 1240, 600);
		add(lblNewLabel);
	}
}
