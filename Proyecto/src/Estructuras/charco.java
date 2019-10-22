package Estructuras;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
import Logica.Celda;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Visitors.VisitorEstructurac;

public class charco extends Estructura{
	
	public charco(Celda c) {
		
		grafico=null;
		visitor=new VisitorEstructurac(this);
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.charco(),20);
		celda=c;
		
	}

	public void recibirDaño(float daño) {	
		
	}

	
	public void turno() {	
		
	}

	
	public void atacar(Personaje e) {
	}
	

}
