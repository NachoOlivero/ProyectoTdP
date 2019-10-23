package Estructuras;

import java.util.Timer;
import java.util.TimerTask;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Visitors.VisitorEstructurac;

public class Charco extends Estructura{
	private Timer temp;
	private int control;

	public Charco(Celda c) {
		control=0;
		grafico=null;
		visitor=new VisitorEstructurac(this);
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.charco(),20);
		celda=c;
		temp=new Timer();
		
	}

	public void recibirDaño(float daño) {	
		
	}
	
	public void iniciar() {
		temp.schedule(new Eliminar(), 10000);
		celda.setCharco(true);
	}

	
	public void turno() {	
		if(control==0)
			control++;
	else control--;
	}

	
	public void atacar(Personaje e) {
	}
	
	public void aceptarEnemigo(Enemigo ene) {
		 if (control==0)
			 visitor.visitEnemigo(ene);
	}
	
	
	private class Eliminar extends TimerTask {
		public void run() {
			celda.setCharco(false);
			Eliminar();
			celda.eliminarEstructura();
		}
	}
	

}
