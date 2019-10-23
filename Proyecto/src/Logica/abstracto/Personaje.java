package Logica.abstracto;

import Logica.Disparo;
import Visitors.Visitor;

public abstract class Personaje extends ObjetoJuego {
	protected float hp;
	protected float dp;
	protected int rango;
	protected Visitor visitor;
	
	public abstract void recibirDa�o(float da�o);
	
	public  void AceptarEnemigo(Enemigo e) {
		visitor.visitEnemigo(e);
	}
	public void aceptarAliado(Disparo e) {
		visitor.visitAliado(e);
	}
	
	public void aceptarTorre(Torre e) {
		visitor.DetectorTorre(e);
	}
	public abstract void turno();
	
	
	

}
