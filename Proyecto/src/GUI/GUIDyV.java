package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import Juego.Juego;

	public class GUIDyV extends JFrame {
		private static final long serialVersionUID = 1L;
		private JPanelConFondo contentPane;
		private JButton boton;
	
		public GUIDyV(String nombre) {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0, 1280, 700);
			setResizable(false);
			contentPane = new JPanelConFondo(nombre);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setVisible(true);
			boton= new JButton("restart");
			//contentPane.add(boton);
			boton.setBounds(600,600,100,80);
			boton.addActionListener(new reset());
		}
		
		private class reset implements ActionListener {


			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Juego.Start();
				
			}
			
		}
	}

