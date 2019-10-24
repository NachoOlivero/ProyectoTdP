package Visitors;

import Logica.Disparo;
import Logica.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Torre;

public class VisitorDisparo extends Visitor {

	public VisitorDisparo(DisparoAbstracto e) {
		miEntidad=e;
	}
	
	public void visitAliado(DisparoAbstracto a) {
	
}


	public void visitEnemigo(Enemigo e) {
		miEntidad.atacar(e);
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
