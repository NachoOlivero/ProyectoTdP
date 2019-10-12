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
		System.out.println("posRel: "+posRelativa);
		if(ene!=null) {
			ene.recibirDaño(daño);
			celda.eliminarDisparo(this);
		}
		else {
			posRelativa++;
			if(posRelativa>12) {
				if(--recorrido_restante>0) {
					celda.moverCeldaDisparo(this);
					posRelativa=1;
				}
				else celda.eliminarDisparo(this);
		    }

	    }
		grafico.avanzar();
	}
}
