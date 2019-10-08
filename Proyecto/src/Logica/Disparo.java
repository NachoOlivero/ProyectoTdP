package Logica;

import Logica.abstracto.ObjetoGrafico;

public class Disparo {
	protected int recorrido_restante;
	protected float da�o;
	protected int posRelativa;
	protected Celda celda;
	protected ObjetoGrafico grafico;
	
	public Disparo(int alcance, float d�) {
		recorrido_restante=alcance;
		da�o=d�;
		posRelativa=1;
		grafico=new GraficoDisparo();
	}
	
	public void decrementarAlcance() {
		recorrido_restante--;
	}
	
	public void avanzar() {
		posRelativa++;
		if(posRelativa>12)
			recorrido_restante--;
		if(recorrido_restante>0)
			celda.moverCeldaDisparo(this);
		else celda.eliminarDisparo(this);
	}
}
