package Estructuras;

import java.util.Timer;
import java.util.TimerTask;

import Factory.AbstractFactoryT;
import Grafica.OGTorre;
import Factory.FabricaImagenes;
import Logica.Celda;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Visitors.VisitorPinche;

public class Clavos extends Estructura {
	boolean aux;
	Timer temp;
	
	public Clavos(Celda c) {
		AbstractFactoryT aux= new FabricaImagenes();
		grafico=new OGTorre(c,aux.pinchos(),20);
		celda=c;
		visitor=new VisitorPinche(this);
		temp=new Timer();
		this.aux=false;
	}


	public void recibirDaño(float daño) {
		
	}
	public void turno() {
		if(!aux)
			temp.schedule(new Eliminar(), 10000);
		
	}

	public void atacar(Personaje e) {}
	
	private class Eliminar extends TimerTask {
		public void run() {
			eliminar();
			celda.eliminarEstructura();
		}
	}
		
	
}


