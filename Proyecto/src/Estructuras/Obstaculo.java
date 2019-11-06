package Estructuras;

import Factory.AbstractFactoryT;
import Grafica.OGTorre;
import Factory.FabricaImagenes;
import Logica.Celda;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Visitors.VisitorCeldaEstructura;

public class Obstaculo extends Estructura{
	
	public Obstaculo(Celda c) {
		hp=500;
		visitor=new VisitorCeldaEstructura(this);
		AbstractFactoryT aux= new FabricaImagenes();
		grafico=new OGTorre(c,aux.obstaculo(),20);
		celda=c;
	}


	public void recibirDa�o(float da�o) {
		hp=-da�o;
		if(hp<=0) {
			eliminar();
		}
		
	}

	public void turno() {}

	public void atacar(Personaje e) {}
		
}
