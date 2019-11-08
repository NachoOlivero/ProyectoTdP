package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import Juego.Juego;
import Logica.Jugador;
import Logica.Singleton;

public class GUIFinal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanelConFondo Mapa;
	private JPanelConFondo Inicio;
	private JPanelConFondo GameOver;
	private JPanelConFondo Ganastes;
	private JButton[] botonesT;
	private JLabel  pun;
	private JLabel din;
	private JLabel bombas;
	private JButton botonLevel1;
	private JButton botonLevel2;
	private JButton botonInfo;
	
	public GUIFinal(){
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1280, 700);
		setResizable(false);
		
		Inicio = new JPanelConFondo("./mapaV2_4(64x35).jpg");
		Inicio.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Inicio);
		Inicio.setLayout(null);
		Inicio.setVisible(true);
		
		Mapa = new JPanelConFondo("./mapaV2_4(64x35).jpg");
		Mapa.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(Mapa);
		Mapa.setLayout(null);
		Mapa.setVisible(false);
		
		
		GameOver = new JPanelConFondo("./GameOver.png");
		GameOver.setBorder(new EmptyBorder(5, 5, 5, 5));
	//	setContentPane(GameOver);
		GameOver.setLayout(null);
		GameOver.setVisible(false);
	
		Ganastes = new JPanelConFondo("./Victory.png");
		Ganastes.setBorder(new EmptyBorder(5, 5, 5, 5));
	//	setContentPane(Ganastes);
		Ganastes.setLayout(null);
		Ganastes.setVisible(false);
		
		
		botonLevel1= new JButton("Nivel 1");
		botonLevel1.setBounds(550, 200, 200, 80);
		Inicio.add(botonLevel1);
		botonLevel2= new JButton("Nivel 2");
		botonLevel2.setBounds(550, 300, 200, 80);
		Inicio.add(botonLevel2);
		botonInfo= new JButton("Info");
		botonInfo.setBounds(550, 400, 200, 80);
		Inicio.add(botonInfo);
		
		botonLevel1.addActionListener(new boton1());

		botonesT=new JButton[6];
		for(int b=0 ; b<6;  b++) {
		botonesT[b]=new JButton("test:"+b);
		Mapa.add(botonesT[b]);
		botonesT[b].setBounds(40+(b*100), 590 , 70, 70);
		//agregar listener
		}
		//creo zona de puntaje y dinero
		Jugador ju=Singleton.getJugador();
		pun=new JLabel();
		pun.setForeground(Color.WHITE);
		pun.setText("Puntaje: "+ju.getPuntaje());
		pun.setBounds(1100,580,80,80);
		pun.setVisible(true);
		Mapa.add(pun);
		//
		din=new JLabel();
		din.setForeground(Color.YELLOW);
		din.setText("Dinero: "+ju.getDinero());
		din.setBounds(1100,560,80,80);
		din.setVisible(true);
		Mapa.add(din);
		
		bombas=new JLabel();
		bombas.setForeground(Color.RED);
		bombas.setText("Bombas: "+ju.getBombas());
		bombas.setBounds(1100,600,80,80);
		bombas.setVisible(true);
		Mapa.add(bombas);
		
	}
	public void CrearInicial() {
		
	}
	public void EstadoPartida1() {
		//Juego.Start();
		Inicio.setVisible(false);
		Mapa.setVisible(true);
		remove(Inicio);
		setContentPane(Mapa);
	}
	public class boton1 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			EstadoPartida1();
		}
	}
		
	

}
