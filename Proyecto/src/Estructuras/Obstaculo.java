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
		hp=20;
		visitor=new VisitorCeldaEstructura(this);
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.obstaculo(),20);
		celda=c;
	}


	public void recibirDaño(float daño) {
		hp=-daño;
		if(hp<=0) {
			Eliminar();
			celda.eliminarEstructura();
		}
		
	}

	@Override
	public void turno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar(Personaje e) {
		// TODO Auto-generated method stub
		
	}
		
	
}
