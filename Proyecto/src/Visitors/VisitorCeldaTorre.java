package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorCeldaTorre extends Visitor {

	public VisitorCeldaTorre(Torre torre) {
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
