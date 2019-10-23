package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorDisparo extends Visitor {

	public VisitorDisparo(Disparo e) {
		miEntidad=e;
	}
	
	public void visitAliado(Disparo a) {
	
}


	public void visitEnemigo(Enemigo e) {
		miEntidad.atacar(e);
}

	@Override
	public void DetectorTorre(Torre e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisparoEnemigo() {
		// TODO Auto-generated method stub
		
	}



}
