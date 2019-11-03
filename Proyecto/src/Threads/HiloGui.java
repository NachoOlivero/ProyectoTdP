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
import Logica.Celda;
import Logica.Mapa;
import Logica.Singleton;
import Logica.Tienda;
import Logica.abstracto.Torre;
import PowerUp.Bomba;


public class HiloGui extends Thread {

	private GUI gui;
	private MovimientoEnemigos movEnemigos;
	private AbstractFactoryT torres;
	private Torre torreActiva;
	private Bomba bombaActiva;
	private Torre torreDobleActiva;


	public HiloGui(GUI g,MovimientoEnemigos movEnem) {
		gui = g;
		movEnemigos=movEnem;
		torres=new fabricaT(); 
		torreActiva=null;
		torreDobleActiva=null;
		bombaActiva=null;
		
		gui.agregarOyenteBoton(new ComprarDinero(),0);
		gui.agregarOyenteBoton(new ComprarTorre1(),1);
		gui.agregarOyenteBoton(new ComprarTorre3(),3);
		gui.agregarOyenteBoton(new comprarBarricada(),2);
		gui.agregarOyenteBoton(new EliminarAll(),4);
		gui.agregarOyenteClick(new Mouse());
		gui.agregarOyenteBoton(new OyenteBomba(), 5);
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
	    	Celda celda=mapa.getCelda(f,c);
	    	boolean hayEstructura=false;
	  
	    	if(f>=0 && f<6 && c>=0 && c<10 ) {  //por ahora numeros, dps vemos como poner atributos para los limites
		    	if(torreActiva!=null) {
			    	hayEstructura=celda.hayEstructura();
			    	if(!hayEstructura) { 
			    		torreActiva.setCelda(celda);
			    		mapa.insertarTorre(torreActiva,f,c);
			    		torreActiva=null;
		    	    }
			    }
		    	else if(bombaActiva!=null) {
		    			bombaActiva.ubicar(f,c);
		    			bombaActiva=null;
		    		 }
		    		else if(torreDobleActiva!=null) {
		    				hayEstructura=celda.hayEstructura();
		    				hayEstructura=( hayEstructura || mapa.getCelda(f,c-1)==null || mapa.getCelda(f,c-1).hayEstructura() );
		    				if(!hayEstructura) {
		    					torreDobleActiva.setCelda(celda);
		    					mapa.insertarTorre(torreDobleActiva, f, c-1);
		    					mapa.insertarTorre(torreDobleActiva,f,c);
					    		torreDobleActiva=null;
		    				}
		    			 }
		    }
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
			if (torreActiva==null && bombaActiva==null && torreDobleActiva==null)
					torreActiva=Tienda.comprarT1();
			
		}
	}
	
	public class ComprarTorre3 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreActiva==null && bombaActiva==null && torreDobleActiva==null)
					torreActiva=Tienda.comprarT3();
			
		}
	}
	
	public class ComprarDinero implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreActiva==null && bombaActiva==null && torreDobleActiva==null)
					torreActiva=Tienda.comprarDinero();
			
		}
	}
	
	public class comprarBarricada implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreActiva==null && bombaActiva==null && torreDobleActiva==null)
					torreDobleActiva=Tienda.comprarBarricada();
			
		}
	}
	
	private class OyenteBomba implements ActionListener{

		public void actionPerformed(ActionEvent click) {
			if(bombaActiva==null && torreActiva==null && torreDobleActiva==null) 
				bombaActiva=Singleton.getJugador().getBomba();
		}
			
		}
		
}

