package Threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import GUI.GUI;
import Logica.Mapa;
import Logica.Singleton;
import Logica.Tienda;
import Logica.abstracto.Torre;


public class HiloGui extends Thread {

	private GUI gui;
	private MovimientoEnemigos movEnemigos;
	private AbstractFactoryT torres;
	private Torre torreactiva;


	public HiloGui(GUI g,MovimientoEnemigos movEnem) {
		gui = g;
		movEnemigos=movEnem;
		torres=new fabricaT(); 
		
		gui.agregarOyenteBoton(new ComprarTorre1(),0);
		gui.agregarOyenteBoton(new Eliminar(),2);
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
		//System.out.println(x+" "+y);
		//agrega dibujo solo dentro de las coordenadas posibles
		if(x>40 && x<1240 && y<600) {
		//System.out.println(x+"::::"+y);
			x=(x-40)/120; //compenso el espacio de 50 pixeles que decidimos no utilizar
			y=y/100;
			
			    ImageIcon imagen = torres.Torre1();
				//dibujo = new JLabel("");
				dibujo = new JLabel(imagen);
				//dibujo.setIcon(imagen);
				
				dibujo.setBounds((x*110)+60, (y*100)-15 , 80, 90);  //75=50 de lo compensado  y 20 extra para centrar (el 10 del y tambien es para centrar)
																	//110 y 100 son el ancho y el alto en px de las celdas
				gui.add(dibujo);
				gui.repaint();
			
		}
	}
	
	private class Mouse implements MouseListener { 
	          
	        
	    public void mouseClicked(MouseEvent e) {
	    	int f=e.getY()/100;
	    	int c=(e.getX()-40)/120;
	    	Mapa mapa=Singleton.getMapa();
	    	boolean control=false;
	    	//System.out.println("mapa "+mapa+"  "+hayTorre);
	    	if(f>=0 && f<6 && c>=0 && c<10 && torreactiva!=null) {  //por ahora numeros, dps vemos como poner atributos para los limites
		    	
		    	torreactiva.setCelda(mapa.getCelda(f, c));
		    	//agregarDibujo(e.getX(),e.getY());
		    	control=mapa.insertarTorre(torreactiva,f,c);
		    	//System.out.println("Fila: "+f+" Columna: "+c);
		    	if(control)
		    		torreactiva=null;
	    	}
	    	//System.out.println("las gui's son iguales"+ (gui==Singleton.getGui()));
	  
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
	public class ComprarTorre1 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreactiva==null)
					torreactiva=Tienda.comprarT1();
			
		}
	}
		
}

