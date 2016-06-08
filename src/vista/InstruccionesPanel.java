package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstruccionesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InstruccionesPanel() {
		setLayout(null);
		JLabel lblHola = new JLabel("Soy las instrucciones");
		lblHola.setBounds(167, 53, 144, 161);
		add(lblHola);
	}
}
