package Visitors;

import Logica.Disparo;
import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.EnemigoDistancia;
import Logica.abstracto.Torre;

public class VisitorEneDistancia extends Visitor {
	
	public VisitorEneDistancia(EnemigoDistancia ene) {
		miEntidad=ene;
	}

	
	public void visitAliado(DisparoAbstracto a) {
		a.atacar(miEntidad);
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {

	}

	@Override
	public void DetectorTorre(Torre e) {
		System.out.println("hola");
		miEntidad.atacar(e);
	}

	@Override
	public void DisparoEnemigo(DisparoAbstracto a) {
	
	}

}
