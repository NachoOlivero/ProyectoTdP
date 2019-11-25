package Threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import GUI.GUI;
import Logica.Celda;
import Logica.Mapa;
import Logica.Singleton;
import Logica.Tienda;
import Logica.abstracto.Torre;
import PowerUp.Barrera;
import PowerUp.Bomba;
import PowerUp.PowerUp;


public class HiloGui extends Thread {

	private GUI gui;
	private Torre torreActiva;
	private PowerUp puActivo;
	private Torre torreDobleActiva;


	public HiloGui() {
		gui = Singleton.getGui();
		Singleton.getMovEne();
		new FabricaImagenes(); 
		torreActiva=null;
		torreDobleActiva=null;
		puActivo=null;
		
		seteos();
	}
	public void seteos() {
		gui.agregarOyenteBoton(new ComprarDinero(),0);
		gui.agregarOyenteBoton(new ComprarTorre1(),1);
		gui.agregarOyenteBoton(new ComprarTorre3(),3);
		gui.agregarOyenteBoton(new comprarBarricada(),2);
		gui.agregarOyenteBoton(new ComprarTorre2(),4);
		gui.agregarOyenteClick(new Mouse());
		gui.agregarOyenteBoton(new OyenteBomba(), 5);
		gui.agregarOyenteBoton(new ComprarBarrera(), 6);
		gui.agregarOyenteBoton(new ComprarBomba(), 7);
		gui.agregarOyenteBoton(new ComprarKillAll(), 8);
		gui.agregarOyenteBoton(new ComprarSpeedUp(), 9);
		gui.agregarOyenteBoton(new Pause(), 10);
	}
	

	public void run() {
		while(true){
			//Evita que debido a la gran carga del hilo principal, no funcionen los botones
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
		    	else if(puActivo!=null) {
		    			puActivo.ubicar(f,c);
		    			puActivo=null;
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

	private class ComprarTorre1 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreActiva==null && puActivo==null && torreDobleActiva==null)
					torreActiva=Tienda.comprarT1();
			
		}
	}
	
	private class ComprarTorre3 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreActiva==null && puActivo==null && torreDobleActiva==null)
					torreActiva=Tienda.comprarT3();
		}
	}
	private class ComprarTorre2 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreActiva==null && puActivo==null && torreDobleActiva==null)
					torreActiva=Tienda.comprarT2();
			
		}
	}
	
	private class ComprarDinero implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreActiva==null && puActivo==null && torreDobleActiva==null)
					torreActiva=Tienda.comprarDinero();
			
		}
	}
	
	private class comprarBarricada implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (torreActiva==null && puActivo==null && torreDobleActiva==null)
					torreDobleActiva=Tienda.comprarBarricada();
			
		}
	}
	
	private class OyenteBomba implements ActionListener{

		public void actionPerformed(ActionEvent click) {
			if(puActivo==null && torreActiva==null && torreDobleActiva==null) 
				puActivo=Singleton.getJugador().getBomba();
		}
			
	}
	
	private class ComprarBarrera implements ActionListener{
		public void actionPerformed(ActionEvent click) {
			if(puActivo==null && torreActiva==null && torreDobleActiva==null) 
				puActivo=Tienda.comprarBarrera();
		}
			
	}
	
	private class ComprarBomba implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Tienda.comprarBomba();
		}
	}
	
	private class ComprarKillAll implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Tienda.comprarKillAll();
		}
	}
	
	private class ComprarSpeedUp implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Tienda.comprarSpeedUp();
		}
	}
	private class Pause implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Singleton.getMovEne().Pause();
		}
	}
		
}

