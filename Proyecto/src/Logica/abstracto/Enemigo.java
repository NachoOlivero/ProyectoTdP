package Logica.abstracto;

import Grafica.OGMovil;
import Grafica.ObjetoGrafico;
import Logica.Celda;
import Logica.Singleton;
import PowerUp.PowerUp;

public abstract class Enemigo extends Personaje{
	protected int vel;
	protected OGMovil grafico;
	protected final int min=1;
	protected int pos=120;
	protected boolean charco=false;
	protected int tiempoFrenar=0;
	protected int MovD;
	protected int cooldown;
	
	
	public int PosActual() {
		return pos;
	}
	
	public void turno() {
		MovD=vel;
		celda.recibirEnemigo(this);
	}
	
	
	public void avanzar() {
			MovD--;
			if(MovD>=0) {
			grafico.avanzar();
			pos-=1;
			if(pos<min) {
				celda.moverEnemigoCelda(this);
				pos=120;
				}
			if(celda!=null) //solucion temporal
				celda.recibirEnemigo(this);
		
			}
	}

	public void atacar(Personaje p) {
		p.recibirDaño(dp);
	}
	
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0) {
			Eliminar();
			System.out.println("en recivir daño");
		}
	}
	
	public ObjetoGrafico getGrafico() {
		return grafico;
	}
	
	public void Eliminar() {
		celda.eliminarEnemigo(this);
		grafico.eliminar();
		Singleton.getJugador().aumentarPuntaje(20);
		Singleton.getJugador().aumentarDinero(50);
		PowerUp.randonPowerUp(grafico.getGrafico().getX(),grafico.getGrafico().getY());
	}
	
	public void actualizarCelda(Celda c) {
		celda=c;
	}
	
	public boolean estaEnPosicion(int pos) {
		return this.pos==pos;
	}
	
	public boolean tieneMenorPosicion(int pos) {
		return this.pos<pos;
	}
	
	public void setGrafico(int pos) {
		grafico.setPosicion(pos);
	}
	
		
}
