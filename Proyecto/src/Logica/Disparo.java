package Logica;

import Logica.abstracto.Enemigo;
import ObjetosGraficos.GraficoDisparo;
import ObjetosGraficos.ObjetoGrafico;

public class Disparo {
	protected int recorrido_restante;
	protected float da�o;
	protected int posRelativa;
	protected Celda celda;
	protected ObjetoGrafico grafico;
	
	public Disparo(int alcance, float d�,Celda celda) {
		recorrido_restante=alcance;
		da�o=d�;
		posRelativa=1;
		this.celda=celda;
		grafico=new GraficoDisparo(celda.getX(),celda.getY());
	}
	
	public void decrementarAlcance() {
		recorrido_restante--;
	}
	
	public void avanzar() {
		Enemigo ene=celda.getEnemigo(posRelativa);
		System.out.println("posdisparo: "+celda.getX());
		if(ene!=null) {
			ene.recibirDa�o(da�o);
			celda.eliminarDisparo(this);
		}
		else {
			posRelativa++;
			if(posRelativa>12) {
				if(--recorrido_restante>0)
					celda.moverCeldaDisparo(this);
				else celda.eliminarDisparo(this);
		    }
	    }
	}
}
