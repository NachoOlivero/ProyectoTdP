package Visitors;

import Logica.Singleton;
import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Torre;

public class VisitorVenta extends Visitor {

	@Override
	public void visitAliado(DisparoAbstracto a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitEnemigo(Enemigo e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DetectorTorre(Torre e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DisparoEnemigo(DisparoAbstracto a) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean venta(Estructura est) {
		return false;
	}

	@Override
	public boolean venta(Torre t) {
		int costo=t.getCosto();
		boolean maxVida=t.maxVida();
		
		if(!maxVida)
			costo/=2;
		
		t.eliminar();
		Singleton.getJugador().setDinero(Singleton.getJugador().getDinero()+costo);
		
		return true;
	}

	@Override
	public void DetectarEnemigo(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

}
