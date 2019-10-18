package Visitors;

import Logica.Disparo;
import Logica.Torres.Torre1;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorCeldaTorre1 extends Visitor {

	public VisitorCeldaTorre1(Torre1 torre) {
		miEntidad=torre;
	}
	
	@Override
	public void visitAliado(Disparo a) {
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		System.out.println("si");
		e.atacar(miEntidad);
	}

}
