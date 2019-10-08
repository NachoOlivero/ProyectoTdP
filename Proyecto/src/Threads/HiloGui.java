package Threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.GUI;
import GUI.abstractFactoriT;
import GUI.fabricaT;


public class HiloGui extends Thread {

	private GUI gui;
	private MovimientoEnemigos movEnemigos;
	private abstractFactoriT torres;
	private JLabel[][] matrizTorres ;


	public HiloGui(GUI g,MovimientoEnemigos movEnem) {
		gui = g;
		movEnemigos=movEnem;
		torres=new fabricaT(); 
		matrizTorres=new JLabel[10][6];
		
		gui.agregarOyenteBoton(new Eliminar(),0);
		gui.agregarOyenteBoton(new EliminarAll(),1);
		gui.agregarOyenteClick(new Mouse());
	}
	

	public void run() {
		while(true){
			//System.out.println("hola");
		}
	}
	
	private void agregarDibujo(int x,int y){
		JLabel dibujo;
		System.out.println(x+" "+y);
		//agrega dibujo solo dentro de las coordenadas posibles
		if(x>50 && x<1150 && y<600) {
		//System.out.println(x+"::::"+y);
			x=(x-50)/110; //compenso el espacio de 50 pixeles que decidimos no utilizar
			y=y/100;
			if(matrizTorres[x][y]==null) {
			    ImageIcon imagen = torres.Torre1();
				//dibujo = new JLabel("");
				dibujo = new JLabel(imagen);
				//dibujo.setIcon(imagen);
				matrizTorres[x][y]=dibujo;
				dibujo.setBounds((x*110)+60, (y*100)-15 , 80, 90);  //75=50 de lo compensado  y 20 extra para centrar (el 10 del y tambien es para centrar)
																	//110 y 100 son el ancho y el alto en px de las celdas
				gui.add(dibujo);
				gui.repaint();
			}
		}
	}
	
	private class Mouse implements MouseListener { 
	          
	        
	    public void mouseClicked(MouseEvent e) { 
	    
	       agregarDibujo(e.getX(),e.getY());
	  
	    }  
	    public void mouseEntered(MouseEvent e) {  
	    }  
	    public void mouseExited(MouseEvent e) {   
	    }  
	    public void mousePressed(MouseEvent e) {  
	    }  
	    public void mouseReleased(MouseEvent e) {  
	    }  
     }


	public class EliminarAll implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			movEnemigos.eliminarEnemigo();
			gui.repaint();
		}
	}
	
	public class Eliminar implements ActionListener{
	
		public void actionPerformed(ActionEvent arg0) {
			movEnemigos.eliminarAll();
			gui.repaint();
		}
	}
		
}

