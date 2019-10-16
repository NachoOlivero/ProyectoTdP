package Visitors;

import Logica.abstracto.Enemigo;
import Logica.abstracto.ObjetoJuego;
import Logica.abstracto.Torre;

abstract class Visitor {
	
	protected ObjetoJuego miEntidad;

	
	public abstract void visitAliado(Torre a);
	
	public abstract void visitEnemigo(Enemigo e);

}
