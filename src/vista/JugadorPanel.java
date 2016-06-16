package vista;

import java.awt.Point;
import javax.swing.*;
import controlador.ControladorDelJuego;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class JugadorPanel extends JPanel {

	private ControladorDelJuego juegoControl;
	private boolean unoActivado;
	
	public JugadorPanel(ControladorDelJuego juegoControl, PartidaPanel partida) {
		setBackground(new Color(153, 204, 255));
		this.juegoControl = juegoControl;
		setLayout(null);
		setBounds(23, 222, 1240, 351);
		JLabel nombreJugador = new JLabel(juegoControl.getJugadorIndexNombre(juegoControl.indexActual()));
		nombreJugador.setBounds(0, 152, 259, 14);
		add(nombreJugador);
		JLabel puntos = new JLabel("Puntos: "+juegoControl.getJugadorIndexPuntaje(juegoControl.indexActual()));
		puntos.setBounds(0, 166, 138, 14);
		add(puntos);
		JLayeredPane mano = new JLayeredPane();
		Point origin = new Point(10, 20);
		mano.setBounds(36, 210, 1152, 153);
		for(int i = 0; i < juegoControl.getJugadorIndexManoSize(juegoControl.indexActual()); i++) {
			CartaJugadorLabel carta = new CartaJugadorLabel(juegoControl.valorCartaJActualIndex(i),juegoControl.colorCartaJActualIndex(i), juegoControl, i, partida);
			carta.setBounds(origin.x, origin.y, 40, 62);
			mano.add(carta, new Integer(0));
			origin.x += 35;
		}
		add(mano);
		mano.setVisible(false);
		JLabel cantidadCartas = new JLabel("#Cartas: "+juegoControl.getJugadorIndexManoSize(juegoControl.indexActual()));
		cantidadCartas.setBounds(0, 185, 115, 14);
		add(cantidadCartas);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 230, 40, 62);
		add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setVisible(false);
				mano.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(JugadorPanel.class.getResource("/imagenes/TraseraUNO.jpg")));
		JButton btnUno = new JButton("UNO");
		btnUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(unoActivado) {
					juegoControl.getJugadorActual().decirUno();
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "UNO!");
					setUnoActivado(false);
				} 
			}
		});
		btnUno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUno.setBounds(283, 58, 89, 42);
		add(btnUno);
		checkUno();
	}
	
	private void checkUno() {
		if(juegoControl.tieneDosCartas()) {
			this.unoActivado = true;
		} else {
			this.unoActivado = false;
		}
	}
	
	private void setUnoActivado(boolean activado) {
		this.unoActivado = activado;
	}
}
