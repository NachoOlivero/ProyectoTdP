package Estructuras;

import java.util.Timer;
import java.util.TimerTask;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.OGTorre;
import Logica.Celda;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Visitors.VisitorPinche;

public class Clavos extends Estructura {
	boolean aux;
	Timer temp;
	
	public Clavos(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new OGTorre(c,aux.pinchos(),20);
		celda=c;
		visitor=new VisitorPinche(this);
		temp=new Timer();
		this.aux=false;
	}


	public void recibirDaño(float daño) {
		
	}

	@Override
	public void turno() {
		if(!aux)
			temp.schedule(new Eliminar(), 10000);
		
	}

	@Override
	public void atacar(Personaje e) {
		// TODO Auto-generated method stub
		
	}
	
	private class Eliminar extends TimerTask {
		public void run() {
			eliminar();
			celda.eliminarEstructura();
		}
	}
		
	
}


