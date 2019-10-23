package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;

public class VisitorPinche extends Visitor{

	@Override
	public void visitAliado(Disparo a) {
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		e.recibirDa�o(2);
		e.avanzar();
	}

}
