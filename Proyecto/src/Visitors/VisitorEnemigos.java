package Visitors;

import Logica.Disparo;
import Logica.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorEnemigos extends Visitor  {

	public VisitorEnemigos(Enemigo e) {
		miEntidad=e;
	}
	
	@Override
	public void visitAliado(DisparoAbstracto a) {
		a.atacar(miEntidad);
	}

	@Override
	public void visitEnemigo(Enemigo e) {
	}

	@Override
	public void DetectorTorre(Torre e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisparoEnemigo(DisparoAbstracto a) {
		// TODO Auto-generated method stub
		
	}

	
}
