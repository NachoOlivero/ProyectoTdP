package Logica.abstracto;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Logica.Disparo;
import Logica.DisparoEnemigo;

public abstract class EnemigoDistancia extends Enemigo {
	protected int rango;
	protected boolean accion;
	
	
	
	public void atacar(Personaje p) {
		if(cooldown==0 && (celda.getX()-p.getCelda().getX())<=rango) {
			crearDisparo();
			cooldown=cooldownMax;
		}
		
	}
	
	public void turno() {
		if(cooldown != 0)
			cooldown--;
		celda.recibirEnemigo(this);
	}
	
	private void crearDisparo() {
			//AbstractFactoryT k=new fabricaT();
			DisparoAbstracto disp=new DisparoEnemigo(rango,dp,celda,pos);
			celda.añadirDisparo(disp);		
	}
	
	public void avanzar() {
		if(cooldown<10) {//si le queda accion y no detecto torre
			grafico.avanzar();
			pos-=vel;
			if(pos<min) {
				celda.moverEnemigoCelda(this);
				pos=120;
			}	
		}else accion=true; //si no ejecuto la accion recupera una accion
	}
}
