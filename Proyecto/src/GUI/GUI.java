package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import Juego.Juego;
import Logica.Jugador;
import Logica.Singleton;
import Logica.Torres.*;
import PowerUp.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanelConFondo contentPane;
	private JButton[] botonesT;
	private JLabel  pun;
	private JLabel din;
	private JLabel bombas;
	private JLabel[] costos;
	private JPanelConFondo Victoria;
	private JPanelConFondo Derrota;
	private JButton restart;
	private JButton siglv;
	private Timer t;
	
	

	public GUI() {
		t=new Timer();
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1280, 700);
		setResizable(false);
		
		contentPane = new JPanelConFondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setImagen("/GUI/mapaV2_4(64x35).jpg");
		
		Victoria = new JPanelConFondo("Victory.png");
		Victoria.setBorder(new EmptyBorder(5, 5, 5, 5));
		Victoria.setLayout(null);
		siglv=new JButton("Siguiente lv");
		siglv.setBounds(550, 580 , 200, 90);
		Victoria.add(siglv);
		siglv.addActionListener(new sigLv());
		
		Derrota = new JPanelConFondo("GameOver.png");
		Derrota.setBorder(new EmptyBorder(5, 5, 5, 5));
		Derrota.setLayout(null);
		restart=new JButton("Try again");
		restart.setBounds(550, 580 , 200, 90);
		Derrota.add(restart);
		restart.addActionListener(new Restart());
		
		botonesT=new JButton[12];
		for(int b=0 ; b<botonesT.length-1;  b++) {
			botonesT[b]=new JButton();
			contentPane.add(botonesT[b]);
			botonesT[b].setBounds(3+(b*100), 590 , 90, 40);
		}
		botonesT[11]=new JButton();
		contentPane.add(botonesT[11]);
		botonesT[11].setBounds(-10, 0 ,50,40);
		
		//puntaje
		Jugador ju=Singleton.getJugador();
		pun=new JLabel();
		pun.setForeground(Color.WHITE);
		pun.setText("Puntaje: "+ju.getPuntaje());
		pun.setBounds(1100,580,80,80);
		pun.setVisible(true);
		contentPane.add(pun);
		
		//Money
		din=new JLabel();
		din.setForeground(Color.YELLOW);
		din.setText("Dinero: "+ju.getDinero());
		din.setBounds(1100,560,80,80);
		din.setVisible(true);
		contentPane.add(din);
		//puntos
		bombas=new JLabel();
		bombas.setForeground(Color.RED);
		bombas.setText("Bombas: "+ju.getBombas());
		bombas.setBounds(1100,600,80,80);
		bombas.setVisible(true);
		contentPane.add(bombas);
		

		Inicializarbotones();
		InicializarLabelsCostos();
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
	
	
	private void Inicializarbotones() {
		
		botonesT[0].setText("Tienda");
		botonesT[1].setText("Torre");
		botonesT[2].setText("Muro");
		botonesT[3].setText("Fire");
		botonesT[4].setText("TPesada"); //si a alguien se le ocurre mejores nombres que los cambie
		botonesT[5].setText("Bomba");
		botonesT[6].setText("C Barrera");
		botonesT[7].setText("C bomba");
		botonesT[8].setText("C Nuke");
		botonesT[9].setText("C Speed");
		botonesT[10].setText("Vender torre");
		botonesT[10].setEnabled(false);
		botonesT[11].setText("P");
	}
	
	private void InicializarLabelsCostos() {
		costos=new JLabel[10];
		for(int b=0 ; b<costos.length;  b++) {
		costos[b]=new JLabel();
		contentPane.add(costos[b]);
		costos[b].setBounds(50+(b*100), 620 , 90, 40);
		}
		costos[0].setText(""+TorreDinero.costo());
		costos[0].setForeground(Color.ORANGE);
		costos[1].setText(""+Torre1.costo());
		costos[1].setForeground(Color.ORANGE);
		costos[2].setText(""+Barricada.costo());
		costos[2].setForeground(Color.ORANGE);
		costos[3].setText(""+Torre3.costo());
		costos[3].setForeground(Color.ORANGE);
		costos[4].setText(""+Torre2.costo());
		costos[4].setForeground(Color.ORANGE);
		costos[5].setText("");
		costos[5].setForeground(Color.RED);
		costos[6].setText(""+Barrera.getCosto());
		costos[6].setForeground(Color.ORANGE);
		costos[7].setText(""+Bomba.getCosto());
		costos[7].setForeground(Color.ORANGE);
		costos[8].setText(""+KillAll.getCosto());
		costos[8].setForeground(Color.ORANGE);
		costos[9].setText(""+SpeedUp.getCosto());
		costos[9].setForeground(Color.ORANGE);
		
	}
	
	public void Victoria() {
		remove(contentPane);
		setContentPane(Victoria);
		setVisible(false);
		setVisible(true);
		
	}
	public void Derrota() {
		remove(contentPane);
		repaint();
		setContentPane(Derrota);
		setVisible(false);
		setVisible(true);
	}
	private void lv2() {
		remove(Victoria);
		contentPane.setImagen("/GUI/mapaV2_5(64x35).jpg");
		setContentPane(contentPane);
	}
	
	private class sigLv implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Singleton.getMovEne().lv2_start();
			lv2();
		}
	}
	private class Restart implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			reset();
		
		}
	}
	private void reset() {
		remove(Derrota);
		contentPane.setImagen("/GUI/mapaV2_4(64x35).jpg");
		setContentPane(contentPane);
		actualizarValores();
		repaint();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setVisible(false); //esto anda mejor que el repaint
		setVisible(true);
		
		t.schedule(new Reset(), 1);
		
	}
		
	private class Reset extends TimerTask {
		public void run() {//si dejabamos todo junto el programa tardaba en volver a poner el mapa y ya habian enemigos
			Juego.reStart();

		}
	}
	public void Victoria2() {
		remove(contentPane);
		siglv.setVisible(false);
		setContentPane(Victoria);
		setVisible(false);
		setVisible(true);
	}
	
	public void setClickable(boolean f,int ind) {
		botonesT[ind].setEnabled(f);
	}
	
	
}
