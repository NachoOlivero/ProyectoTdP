package Logica;

import Logica.abstracto.Enemigo;
import ObjetosGraficos.GraficoDisparo;
import ObjetosGraficos.OGMovil;
import ObjetosGraficos.ObjetoGrafico;

public class Disparo {
	protected int recorrido_restante;
	protected float daño;
	protected int posRelativa;
	protected Celda celda;
	protected OGMovil grafico;
	
	public Disparo(int alcance, float dñ,Celda celda) {
		recorrido_restante=alcance;
		daño=dñ;
		posRelativa=1;
		this.celda=celda;
		grafico=new GraficoDisparo(celda.getX(),celda.getY());
	}
	
	public void decrementarAlcance() {
		recorrido_restante--;
	}
	
	public void avanzar() {
		Enemigo ene=celda.getEnemigo(posRelativa);
		//System.out.println("posRel: "+posRelativa);
		if(ene!=null) {
			ene.recibirDaño(daño);
			eliminar();
		}
		else 
			if(++posRelativa>12) {
				if(--recorrido_restante>0) {
					celda.moverCeldaDisparo(this);
					posRelativa=1;
					grafico.avanzar();
				}
				else 
					eliminar();
			}
			else grafico.avanzar();
		System.out.println("Disparo :"+posRelativa);
	}

	public boolean estaEnPosicion(int vel) {
		
		return vel==posRelativa;
	}
	public void setCelda(Celda c) {
		celda=c;
	}
	
	public void eliminar() {
		celda.eliminarDisparo(this);
		grafico.eliminar();
	}
}
