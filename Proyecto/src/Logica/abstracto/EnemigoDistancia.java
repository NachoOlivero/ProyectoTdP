package Logica.abstracto;

import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Logica.Disparo;
import Logica.DisparoEnemigo;

public abstract class EnemigoDistancia extends Enemigo {
	protected int rango;
	protected boolean accion;
	
	
	
	public void atacar(Personaje p) {
		if(cooldown==0 && (celda.getColumna()-p.getCelda().getColumna())<=rango) {
			crearDisparo();
			cooldown=cooldownMax;
		}
		
	}
	
	public void turno() {
		if(cooldown != 0)
			cooldown--;
		celda.recibirEnemigo(this);
		AvisarTorres();
	}
	
	private void crearDisparo() {
			//AbstractFactoryT k=new fabricaT();
			DisparoAbstracto disp=new DisparoEnemigo(rango,dp,celda,pos);
			celda.aņadirDisparo(disp);		
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
