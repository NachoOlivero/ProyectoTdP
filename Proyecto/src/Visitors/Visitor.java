package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;

public abstract class Visitor {
	
	protected Personaje miEntidad;

	
	public abstract void visitAliado(Disparo a);
	
	public abstract void visitEnemigo(Enemigo e);

}
