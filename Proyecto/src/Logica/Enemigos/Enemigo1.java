package Logica.Enemigos;

import Logica.Celda;
import Logica.Disparo;
import Logica.PowerUp;
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
		Disparo dis=celda.getDisparo(pos);
		
		if(dis==null) {
			if (celda.hayTorre())
				atacar(celda.getTorre());
			else {
				grafico.avanzar();
				pos-=vel;
				if(pos<min) {
					celda.moverEnemigoCelda(this);
					pos=120;
				 }
		    }
		}
		else {
			recibirDa�o(dis.getDa�o());
			dis.eliminar();
		}
	}

	public void atacar(Personaje p) {
		p.recibirDa�o(dp);
		
	}

	public void recibirDa�o(float da�o) {
		hp-=da�o;
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
		Singleton.getJugador().aumentarDinero(50);
		PowerUp pu=Singleton.powerUp(grafico.getGrafico().getX(),grafico.getGrafico().getY());
		Singleton.getMapa().insertarPowerUp(pu);
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
