package Logica.Enemigos;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Grafica.OGEnemigo;
import Logica.Celda;
import Logica.abstracto.Enemigo;
import Visitors.VisitorEnemigos;

public class Enemigo2 extends Enemigo{

	public Enemigo2(Celda cel) {
		hp=5;
		dp=10;
		celda=cel;
		vel=3;
		AbstractFactoryT ab=new FabricaImagenes();
		grafico=new OGEnemigo(ab.Enemigo2(),celda.getFila());
		visitor=new VisitorEnemigos(this);
	}
}
