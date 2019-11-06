package Logica.Enemigos;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Grafica.OGEnemigo;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Visitors.VisitorEnemigos;


public class Enemigo1 extends Enemigo{

	public Enemigo1(Celda cel) {
		hp=15;
		dp=5;
		celda=cel;
		vel=2;
		AbstractFactoryT ab=new FabricaImagenes();
		grafico=new OGEnemigo(ab.Enemigo1(),celda.getFila());
		visitor=new VisitorEnemigos(this);

	}
	
}
