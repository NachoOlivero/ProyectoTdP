package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import Juego.Juego;
import Logica.Mapa;
import Logica.Singleton;
import Logica.Tienda;
import Threads.HiloGui;
import Threads.MovimientoEnemigos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Inicio extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanelConFondo contentPane;
	private JButton botonLevel1;
	private JButton botonLevel2;
	private JButton botonInfo;
	private static MovimientoEnemigos movEnemigos;
	private static HiloGui contador;

	public Inicio() {
		Singleton.getJugador().setDinero(100);
		Singleton.getJugador().setPuntaje(0);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1280, 700);
		setResizable(false);
		contentPane = new JPanelConFondo("./mapaV2_4(64x35).jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		botonLevel1= new JButton("Nivel 1");
		botonLevel1.setBounds(550, 200, 200, 80);
		add(botonLevel1);
		botonLevel2= new JButton("Nivel 2");
		botonLevel2.setBounds(550, 300, 200, 80);
		add(botonLevel2);
		botonInfo= new JButton("Info");
		botonInfo.setBounds(550, 400, 200, 80);
		add(botonInfo);
		
		botonLevel1.addActionListener(new boton1());
	}
	public class boton1 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		Juego.Start();
		}
	}
	}
