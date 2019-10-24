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
		control=-1;
		grafico=null;
		visitor=new VisitorEstructurac(this);
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.charco(),20);
		celda=c;
		temp=new Timer();
		
	}

	public void recibirDaño(float daño) {	
		
	}
	
	private void iniciar() {
		temp.schedule(new Eliminar(), 10000);
	}

	
	public void turno() {	
		if (control==-1) {
			iniciar();
			control++;
		}
		if(control<2)
			control++;
		else control=0;
	}

	
	public void atacar(Personaje e) {
	}
	
	public  void AceptarEnemigo(Enemigo e) {
		//System.out.println(control);
		 if (control==0)
			 visitor.visitEnemigo(e);
	}
	
	
	private class Eliminar extends TimerTask {
		public void run() {
			Eliminar();
			celda.eliminarEstructura();
		}
	}
	

}
