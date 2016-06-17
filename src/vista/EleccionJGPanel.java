package vista;

import javax.swing.JPanel;
import controlador.ControladorDelJuego;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class EleccionJGPanel extends JPanel {

	private JTextField nombreJ1;
	private JTextField nombreJ2;
	private JTextField nombreJ3;
	private JTextField nombreJ4;
	private Integer cantJugadores;
	private List<String> nombres;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EleccionJGPanel(ControladorDelJuego juegoControl, JuegoFrame juegoFrame) {
		setBackground(new Color(154, 205, 50));
		this.nombres = new Vector<String>();
		setLayout(null);
		JComboBox JcantJugadores = new JComboBox();
		JcantJugadores.setFont(new Font("Tahoma", Font.PLAIN, 28));
		JcantJugadores.setModel(new DefaultComboBoxModel(new String[] {"", "2", "3", "4"}));
		JcantJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox JcantJugadores = (JComboBox) event.getSource();
				Object selected = JcantJugadores.getSelectedItem();
				ejecutarSeleccion(selected.toString());				
			}
		});
		JcantJugadores.setBounds(876, 128, 195, 48);
		add(JcantJugadores);		
		JLabel lblSelccioneLaCantidad = new JLabel("Selccione la cantidad de jugadores");
		lblSelccioneLaCantidad.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSelccioneLaCantidad.setBounds(768, 39, 462, 31);
		add(lblSelccioneLaCantidad);		
		JLabel lblJugador = new JLabel("Jugador 1");
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblJugador.setBounds(254, 179, 141, 42);
		add(lblJugador);		
		JLabel lblJugador_1 = new JLabel("Jugador 2");
		lblJugador_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblJugador_1.setBounds(254, 244, 141, 42);
		add(lblJugador_1);		
		JLabel lblJugador_2 = new JLabel("Jugador 3");
		lblJugador_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblJugador_2.setBounds(254, 312, 141, 42);
		add(lblJugador_2);		
		JLabel lblJugador_3 = new JLabel("Jugador 4");
		lblJugador_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblJugador_3.setBounds(254, 380, 141, 42);
		add(lblJugador_3);		
		nombreJ1 = new JTextField();
		nombreJ1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nombreJ1.setBounds(453, 179, 258, 57);
		nombreJ1.setEnabled(false);
		nombreJ1.setEditable(false);
		add(nombreJ1);
		nombreJ1.setColumns(10);		
		nombreJ2 = new JTextField();
		nombreJ2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nombreJ2.setBounds(453, 244, 258, 57);
		nombreJ2.setEnabled(false);
		nombreJ2.setEditable(false);
		add(nombreJ2);
		nombreJ2.setColumns(10);		
		nombreJ3 = new JTextField();
		nombreJ3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nombreJ3.setBounds(453, 312, 258, 57);
		nombreJ3.setEnabled(false);
		nombreJ3.setEditable(false);
		add(nombreJ3);
		nombreJ3.setColumns(10);		
		nombreJ4 = new JTextField();
		nombreJ4.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nombreJ4.setBounds(453, 380, 258, 57);
		nombreJ4.setEnabled(false);
		nombreJ4.setEditable(false);
		add(nombreJ4);
		nombreJ4.setColumns(10);		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juegoFrame.setupFrame(juegoFrame.getMenu());
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAtras.setBounds(37, 483, 223, 70);
		add(btnAtras);		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cantidadSeleccionada = JcantJugadores.getSelectedItem().toString();
				rellenaNombres(cantidadSeleccionada);
				if(cantidadSeleccionada.equals("") || faltaNombre(nombres)){
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Complete los nombres");
					nombres.clear();					
				} else {
					cantJugadores = new Integer(cantidadSeleccionada);
					juegoControl.setCantJugadores(cantJugadores);
					juegoControl.setNombres(nombres);
					juegoControl.inicioDelJuego();
					PartidaPanel partida = new PartidaPanel(juegoControl, juegoFrame);
					juegoFrame.setupFrame(partida);
					}
			}
		});
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnJugar.setBounds(983, 483, 223, 70);
		add(btnJugar);
	}
	
	private void rellenaNombres(String eleccion) {
		if(eleccion.equals("")) {
			
		}
		else if(eleccion.equals("2")) {
			nombres.add(nombreJ1.getText());
			nombres.add(nombreJ2.getText());
			
		}
		else if(eleccion.equals("3")) {
			nombres.add(nombreJ1.getText());
			nombres.add(nombreJ2.getText());
			nombres.add(nombreJ3.getText());
		}
		else if(eleccion.equals("4")) {
			nombres.add(nombreJ1.getText());
			nombres.add(nombreJ2.getText());
			nombres.add(nombreJ3.getText());
			nombres.add(nombreJ4.getText());
		}
	}
	
	private void ejecutarSeleccion(String eleccion) {
		if(eleccion.equals("")) {
			nombres.clear();
			nombreJ1.setEnabled(false);
			nombreJ1.setEditable(false);
			nombreJ2.setEnabled(false);
			nombreJ2.setEditable(false);
			nombreJ3.setEnabled(false);
			nombreJ3.setEditable(false);
			nombreJ4.setEnabled(false);
			nombreJ4.setEditable(false);
		}
		else if(eleccion.equals("2")) {
			nombres.clear();
			nombreJ1.setEnabled(true);
			nombreJ1.setEditable(true);
			nombreJ2.setEnabled(true);
			nombreJ2.setEditable(true);
			nombreJ3.setEnabled(false);
			nombreJ3.setEditable(false);
			nombreJ4.setEnabled(false);
			nombreJ4.setEditable(false);
			
		}
		else if(eleccion.equals("3")) {
			nombres.clear();
			nombreJ1.setEnabled(true);
			nombreJ1.setEditable(true);
			nombreJ2.setEnabled(true);
			nombreJ2.setEditable(true);
			nombreJ3.setEnabled(true);
			nombreJ3.setEditable(true);
			nombreJ4.setEnabled(false);
			nombreJ4.setEditable(false);
		}
		else if(eleccion.equals("4")) {
			nombres.clear();
			nombreJ1.setEnabled(true);
			nombreJ1.setEditable(true);
			nombreJ2.setEnabled(true);
			nombreJ2.setEditable(true);
			nombreJ3.setEnabled(true);
			nombreJ3.setEditable(true);
			nombreJ4.setEnabled(true);
			nombreJ4.setEditable(true);
		}
	}
	
	private static boolean faltaNombre(List<String> nombres) {
		for(String nm : nombres) {
			if(nm.equals("")) {
				return true;
			}
		}
		return false;
	}
}