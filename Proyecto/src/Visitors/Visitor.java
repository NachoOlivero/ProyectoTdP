package Visitors;

import Logica.Disparo;
import Logica.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;

public abstract class Visitor {
	
	protected Personaje miEntidad;

	
	public abstract void visitAliado(DisparoAbstracto a);
	
	public abstract void visitEnemigo(Enemigo e);
	
	public abstract void DetectorTorre(Torre e);
	
	public abstract void DisparoEnemigo(DisparoAbstracto a);
	
	

}
