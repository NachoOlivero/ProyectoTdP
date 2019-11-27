package Visitors;

import Estructuras.Charco;
import Logica.Disparo;
import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Estructura;
import Logica.abstracto.Torre;

public class VisitorEstructurac extends Visitor {
	
	
	public VisitorEstructurac(Charco h){
		miEntidad=h;	
	}


	public void visitAliado(DisparoAbstracto a) {
		
		
	}

	public void visitEnemigo(Enemigo e) {
			e.avanzar();
		
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean venta(Torre t) {
		return false;
		// TODO Auto-generated method stub
		
	}


public void DetectarEnemigo(Enemigo e) {
		
	}

}
