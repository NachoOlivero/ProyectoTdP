package Logica.abstracto;

import Logica.Disparo;
import Visitors.Visitor;

public abstract class Personaje extends ObjetoJuego {
	protected float hp;
	protected float dp;
	protected int rango;
	protected Visitor visitor;
	
	public abstract void recibirDaño(float daño);
	
	public  void AceptarEnemigo(Enemigo e) {
		visitor.visitEnemigo(e);
	}
	public void aceptarAliado(DisparoAbstracto e) {
		visitor.visitAliado(e);
	}
	
	public void aceptarTorre(Torre e) {
		visitor.DetectorTorre(e);
	}
	
	public void AceptarDisparoEnemigo(DisparoAbstracto e) {
		visitor.DisparoEnemigo(e);
	}
	public abstract void turno();
	
	public void aceptarDeteccion(Enemigo e) {
		visitor.DetectarEnemigo(e);
	}
	//System.out.println("si");

}
