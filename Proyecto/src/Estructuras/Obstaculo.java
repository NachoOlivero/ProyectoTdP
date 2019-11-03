package Estructuras;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
import Logica.Celda;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Visitors.VisitorCeldaEstructura;

public class Obstaculo extends Estructura{
	
	public Obstaculo(Celda c) {
		hp=500;
		visitor=new VisitorCeldaEstructura(this);
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.obstaculo(),20);
		celda=c;
	}


	public void recibirDaño(float daño) {
		hp=-daño;
		if(hp<=0) {
			eliminar();
			celda.eliminarEstructura();
		}
		
	}

	public void turno() {}

	public void atacar(Personaje e) {}
		
	
}
