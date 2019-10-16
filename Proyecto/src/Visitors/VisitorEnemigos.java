package Visitors;

import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorEnemigos extends Visitor  {

	@Override
	public void visitAliado(Torre a) {
		miEntidad.atacar(a);
	}

	@Override
	public void visitEnemigo(Enemigo e) {
	}

	
}
