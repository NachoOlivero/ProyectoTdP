package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import Logica.Jugador;
import Logica.Singleton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanelConFondo contentPane;
	private JButton[] botonesT;
	private JLabel  pun;
	private JLabel din;
	private JLabel bombas;

	public GUI() {
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1280, 700);
		setResizable(false);
		
		contentPane = new JPanelConFondo("./mapaV2_4(64x35).jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		botonesT=new JButton[10];
		for(int b=0 ; b<botonesT.length;  b++) {
		botonesT[b]=new JButton();
		contentPane.add(botonesT[b]);
		botonesT[b].setBounds(30+(b*100), 590 , 90, 40);
		//agregar listener
		}
		//creo zona de puntaje y dinero
		Jugador ju=Singleton.getJugador();
		pun=new JLabel();
		pun.setForeground(Color.WHITE);
		pun.setText("Puntaje: "+ju.getPuntaje());
		pun.setBounds(1100,580,80,80);
		pun.setVisible(true);
		add(pun);
		//
		din=new JLabel();
		din.setForeground(Color.YELLOW);
		din.setText("Dinero: "+ju.getDinero());
		din.setBounds(1100,560,80,80);
		din.setVisible(true);
		add(din);
		
		bombas=new JLabel();
		bombas.setForeground(Color.RED);
		bombas.setText("Bombas: "+ju.getBombas());
		bombas.setBounds(1100,600,80,80);
		bombas.setVisible(true);
		contentPane.add(bombas);
		
		//le pongo los verdaderos nombres a los botones
		botonesT[0].setText("Tienda");
		botonesT[1].setText("Torre");
		botonesT[2].setText("Muro");
		botonesT[3].setText("Fire");
		botonesT[4].setText("TPesada");
		botonesT[5].setText("Bomba");
		botonesT[6].setText("C Barrera");
		botonesT[7].setText("C bomba");
		botonesT[8].setText("C Nuke");
		botonesT[9].setText("C Speed");
	}
	
	public void agregarOyenteBoton(ActionListener ac,int boton) {
		botonesT[boton].addActionListener(ac);
	}
	
	public void agregarOyenteClick(MouseListener ac) {
		addMouseListener(ac);
	}
	public void actualizarValores() {
		Jugador ju=Singleton.getJugador();
		pun.setText("Puntaje: "+ju.getPuntaje());
		din.setText("Dinero: "+ju.getDinero());
		bombas.setText("Bombas: "+ju.getBombas());
	}
	
	
}
