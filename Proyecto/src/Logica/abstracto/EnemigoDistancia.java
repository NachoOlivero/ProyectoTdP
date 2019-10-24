package Logica.abstracto;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Logica.Disparo;
import Logica.DisparoEnemigo;

public abstract class EnemigoDistancia extends Enemigo {
	protected int rango;
	protected boolean accion;
	protected boolean torre;
	
	
	public void atacar(Personaje p) {
		if(cooldown==0 && (celda.getX()-p.getCelda().getX())<=rango) {
			//System.out.println(accion);
			torre=true;
			if(accion) {
			crearDisparo();
			accion=false;
			}
		}else torre=false;
		
	}
	
	public void turno() {
		torre=false;
		if(cooldown != 0)
			cooldown--;
		celda.recibirEnemigo(this);
	}
	
	private void crearDisparo() {
		if(cooldown==0) {
			AbstractFactoryT k=new fabricaT();
			DisparoAbstracto disp=new DisparoEnemigo(rango,dp,celda,pos);
			celda.añadirDisparo(disp);
			cooldown=10;
		}
		
	}
	
	public void avanzar() {
		if(accion && !torre) {//si le queda accion y no detecto torre
			grafico.avanzar();
			pos-=vel;
			if(pos<min) {
				celda.moverEnemigoCelda(this);
				pos=120;
			}	
		}else accion=true; //si no ejecuto la accion recupera una accion
	}
}
