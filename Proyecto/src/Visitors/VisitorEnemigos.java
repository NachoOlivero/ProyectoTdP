package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorEnemigos extends Visitor  {

	@Override
	public void visitAliado(Disparo a) {
		//miEntidad.atacar(a);
	}

	@Override
	public void visitEnemigo(Enemigo e) {
	}

	
}
