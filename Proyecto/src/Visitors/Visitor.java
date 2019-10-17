package Visitors;

import Logica.Disparo;
import Logica.abstracto.Enemigo;
import Logica.abstracto.ObjetoJuego;
import Logica.abstracto.Torre;

public abstract class Visitor {
	
	protected ObjetoJuego miEntidad;

	
	public abstract void visitAliado(Disparo a);
	
	public abstract void visitEnemigo(Enemigo e);

}
