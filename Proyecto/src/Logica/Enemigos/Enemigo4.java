package Logica.Enemigos;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Grafica.OGEnemigo;
import Logica.Celda;
import Visitors.VisitorEnemigos;
import Logica.abstracto.Enemigo;


public class Enemigo4 extends Enemigo {
	
	public Enemigo4(Celda cel) {
		hp=50;
		dp=2;
		celda=cel;
		vel=1;
		AbstractFactoryT ab=new FabricaImagenes();
		grafico=new OGEnemigo(ab.Enemigo4(),celda.getFila());
		visitor=new VisitorEnemigos(this);
	}
}
