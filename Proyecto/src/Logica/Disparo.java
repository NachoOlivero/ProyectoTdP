package Logica;

import Logica.abstracto.Enemigo;
import Logica.abstracto.ObjetoGrafico;

public class Disparo {
	protected int recorrido_restante;
	protected float daño;
	protected int posRelativa;
	protected Celda celda;
	protected ObjetoGrafico grafico;
	
	public Disparo(int alcance, float dñ) {
		recorrido_restante=alcance;
		daño=dñ;
		posRelativa=1;
		grafico=new GraficoDisparo(celda.getX(),celda.getY());
	}
	
	public void decrementarAlcance() {
		recorrido_restante--;
	}
	
	public void avanzar() {
		Enemigo ene=celda.getEnemigo(posRelativa);
		System.out.println("posdisparo: "+celda.getX());
		if(ene!=null) {
			ene.recibirDaño(daño);
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
