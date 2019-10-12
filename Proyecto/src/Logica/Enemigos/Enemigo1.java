package Logica.Enemigos;

import Logica.Celda;
import Logica.Disparo;
import Logica.Singleton;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;
import ObjetosGraficos.OGEnemigo1;
import ObjetosGraficos.ObjetoGrafico;

public class Enemigo1 extends Enemigo{

	public Enemigo1(Celda cel) {
		hp=100;
		dp=100;
		celda=cel;
		vel=1;
		grafico=new OGEnemigo1();
	}
	
	public void avanzar() {
		Disparo dis=celda.getDisparo(vel);
			if(dis!=null) {
				dis.avanzar();
			}
		if (celda.hayTorre())
			atacar(celda.getTorre());
		else {
			grafico.avanzar();
			if(pos>max) {
				celda.moverEnemigoCelda(this);
				pos=1;
				
			}
			pos+=vel;
			
		}
		System.out.println("enemigo :"+pos);
	}

	public void atacar(Personaje p) {
		p.recibirDaño(dp);
		
	}

	public void recibirDaño(float daño) {
		System.out.println("ouch");
		hp-=daño;
		if(hp<=0) 
			Eliminar();
	}
	
	public ObjetoGrafico getGrafico() {
		return grafico;
	}
	
	public void Eliminar() {
		celda.eliminarEnemigo(this);
		grafico.eliminar();
		Singleton.getJugador().aumentarPuntaje(20);
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

}
