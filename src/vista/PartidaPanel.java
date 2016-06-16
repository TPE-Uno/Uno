package vista;

import javax.swing.JPanel;

import archivos.ResourceManager;
import archivos.SaveData;
import controlador.ControladorDelJuego;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class PartidaPanel extends JPanel {

	private JugadorEnEsperaPanel jP1;
	private JugadorEnEsperaPanel jP2;
	private JugadorEnEsperaPanel jP3;
	private ControladorDelJuego juegoControl;
	private CartaPozoLabel cartaPozo;
	private CartaMazoLabel cartaMazo;
	private JugadorPanel jugadorActual;
	private Fondo fondo;
	private BotonPaso paso;
	private PartidaPanel partida;
	
	public PartidaPanel(ControladorDelJuego juegoControl) {
		setBackground(new Color(153, 204, 255));
		this.juegoControl = juegoControl;
		this.partida = this;
		setLayout(null);
		CartaMazoLabel cartaMazo = new CartaMazoLabel(juegoControl,this);
		this.cartaMazo = cartaMazo;
		add(this.cartaMazo);
		CartaPozoLabel cartaPozo = new CartaPozoLabel(valorPozo(), colorPozo(), juegoControl, this);
		this.cartaPozo = cartaPozo;	
		add(this.cartaPozo);
		JugadorPanel jugadorActual = new JugadorPanel(juegoControl, this);
		this.jugadorActual = jugadorActual;
		add(this.jugadorActual);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1240, 21);
		add(menuBar);
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveData data = new SaveData();
				data.setJuegoControl(juegoControl);
				 try {
		                ResourceManager.save(data, "1.bin");
		            }
		            catch (Exception e) {
		                System.out.println("No se pudo grabar: " + e.getMessage());
		            }
			}
		});
		mnArchivo.add(mntmGuardar);
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		mostrarJugadoresEnEspera();
		BotonPaso btnNewButton = new BotonPaso(juegoControl,this);
		this.paso = btnNewButton;
		add(this.paso);
		this.paso.setEnabled(false);
		this.paso.setVisible(false);
	}
	
	public PartidaPanel getSiMismo() {
		return this.partida;
	}
	
	public void setJEEP1(JugadorEnEsperaPanel jP1) {
		this.jP1 = jP1;
	}
	
	public void setJEEP2(JugadorEnEsperaPanel jP2) {
		this.jP2 = jP2;
	}
	
	public void setJEEP3(JugadorEnEsperaPanel jP3) {
		this.jP3 = jP3;
	}
	
	public JugadorEnEsperaPanel getJEEP1() {
		return this.jP1;
	}
	
	public JugadorEnEsperaPanel getJEEP2() {
		return this.jP2;
	}
	
	public JugadorEnEsperaPanel getJEEP3() {
		return this.jP3;
	}
	
	public void removeJEEspera() {
		if(juegoControl.getCantJugadores() == 4) {
			this.remove(jP1);
			this.remove(jP2);
			this.remove(jP3);
		} else if(juegoControl.getCantJugadores() == 3) {
			this.remove(jP1);
			this.remove(jP2);			
		} else if(juegoControl.getCantJugadores() == 2) {
			this.remove(jP1);		
		}
	}
	
	public void mostrarJugadoresEnEspera() {
		if(juegoControl.getCantJugadores() == 4) {
			JugadorEnEsperaPanel jP1 = new JugadorEnEsperaPanel(juegoControl, this, juegoControl.indexSiguiente(juegoControl.indexActual()));
			JugadorEnEsperaPanel jP2 = new JugadorEnEsperaPanel(juegoControl, this, juegoControl.indexSiguiente(juegoControl.indexSiguiente(juegoControl.indexActual())));
			JugadorEnEsperaPanel jP3 = new JugadorEnEsperaPanel(juegoControl, this, juegoControl.indexSiguiente(juegoControl.indexSiguiente(juegoControl.indexSiguiente(juegoControl.indexActual()))));
			this.jP1 = jP1;
			this.jP2 = jP2;
			this.jP3 = jP3;
			jP1.setBounds(1130, 35, 74, 74);
			jP2.setBounds(35, 35, 74, 74);
			jP3.setBounds(580, 36, 74, 74);
			add(this.jP1);
			add(this.jP2);
			add(this.jP3);
		} else if(juegoControl.getCantJugadores() == 3) {
			JugadorEnEsperaPanel jP1 = new JugadorEnEsperaPanel(juegoControl, this, juegoControl.indexSiguiente(juegoControl.indexActual()));
			JugadorEnEsperaPanel jP2 = new JugadorEnEsperaPanel(juegoControl, this, juegoControl.indexSiguiente(juegoControl.indexSiguiente(juegoControl.indexActual())));
			this.jP1 = jP1;
			this.jP2 = jP2;
			jP2.setBounds(35, 35, 74, 74);
			jP1.setBounds(1130, 35, 74, 74);
			add(this.jP1);
			add(this.jP2);			
		} else if(juegoControl.getCantJugadores() == 2) {
			JugadorEnEsperaPanel jP1 = new JugadorEnEsperaPanel(juegoControl, this, juegoControl.indexSiguiente(juegoControl.indexActual()));
			this.jP1 = jP1;
			jP1.setBounds(580, 36, 74, 74);
			add(this.jP1);			
		}
	}
	
	public void pasoOff() {
		this.paso.setEnabled(false);
		this.paso.setVisible(false);
	}
	
	public void pasoOn() {
		this.paso.setEnabled(true);
		this.paso.setVisible(true);
	}
	
	public Fondo getFondo() {
		return this.fondo;
	}
	
	public void setFondo(Fondo fondo) {
		this.fondo = fondo;
	}
	
	public void fondOn() {
		this.fondo.setEnabled(true);
	}
	
	public void fondoOff() {
		this.fondo.setEnabled(false);
	}
	
	public void cartaMazoOn() {
		this.cartaMazo.setEnabled(true);
		this.cartaMazo.setActive(true);
	}
	
	public void cartaMazoOff() {
		this.cartaMazo.setEnabled(false);
		this.cartaMazo.setActive(false);
	}
	
	public void setJugadorActuaLabel(JugadorPanel jugadorActual) {
		this.jugadorActual = jugadorActual;
	}
	
	public JugadorPanel getJugadorActualPanel() {
		return this.jugadorActual;
	}
	
	public void setCartaPozoLabel(CartaPozoLabel cartaPozo) {
		this.cartaPozo = cartaPozo;
	}
	
	public void cartaOff() {
		this.cartaPozo.setVisible(false);
	}
	
	public CartaPozoLabel getCartaPozoLabel() {
		return this.cartaPozo;
	}
	
	private String valorPozo() {
		return juegoControl.getCartaValor(juegoControl.getCartaPozo());
	}
	
	private String colorPozo() {
		return juegoControl.getCartaColor(juegoControl.getCartaPozo());
	}
}
