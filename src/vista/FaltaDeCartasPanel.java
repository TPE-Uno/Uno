package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FaltaDeCartasPanel extends JPanel {
	public FaltaDeCartasPanel() {
		setLayout(null);
		
		JLabel lblSeHaTerminado = new JLabel("Se ha terminado el juego por falta de cartas");
		lblSeHaTerminado.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSeHaTerminado.setBounds(297, 127, 571, 114);
		add(lblSeHaTerminado);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 42));
		btnSalir.setBounds(350, 335, 323, 141);
		add(btnSalir);
	}

}