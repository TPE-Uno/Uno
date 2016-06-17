package vista;

import controlador.ControladorDelJuego;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CambiaColorPanel extends JFrame {
	
	public CambiaColorPanel(ControladorDelJuego juegoControl, int indexCarta, JuegoFrame juegoFrame) {
		setType(Type.UTILITY);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(178, 176, 233, 206);
		setDefaultCloseOperation(0);
		JButton btnRojo = new JButton("ROJO");
		btnRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juegoControl.setColor("rojo");
				dispose();
				juegoFrame.setEnabled(true);
			}
		});
		btnRojo.setBounds(63, 27, 105, 23);
		getContentPane().add(btnRojo);
		JButton btnVerde = new JButton("VERDE");
		btnVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegoControl.setColor("verde");
				dispose();
				juegoFrame.setEnabled(true);
			}
		});
		btnVerde.setBounds(63, 60, 105, 23);
		getContentPane().add(btnVerde);
		JButton btnAzul = new JButton("AZUL");
		btnAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegoControl.setColor("azul");
				dispose();
				juegoFrame.setEnabled(true);
			}
		});
		btnAzul.setBounds(63, 94, 105, 23);
		getContentPane().add(btnAzul);
		JButton btnAmarillo = new JButton("AMARILLO");
		btnAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegoControl.setColor("amarillo");
				dispose();
				juegoFrame.setEnabled(true);
			}
		});
		btnAmarillo.setBounds(63, 128, 105, 23);
		getContentPane().add(btnAmarillo);
	}
}