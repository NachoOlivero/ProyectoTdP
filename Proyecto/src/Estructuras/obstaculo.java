package Estructuras;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
import Logica.Celda;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Visitors.VisitorCeldaEstructura;

public class obstaculo extends Estructura{
	
	public obstaculo(Celda c) {
		hp=200;
		visitor=new VisitorCeldaEstructura(this);
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.obstaculo(),20);
		celda=c;
	}


	public void recibirDaño(float daño) {
		hp=hp-daño;
		
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
