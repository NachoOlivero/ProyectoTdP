package Logica;

import Grafica.GraficoDisparo;
import Grafica.GraficoDisparoEne;
import Visitors.VisitorDisparo;

public class DisparoEnemigo extends DisparoAbstracto {

	public DisparoEnemigo(int alcance, float d�, Celda celda,int posRel) {
		recorrido_restante=alcance;
		da�o=d�;
		posRelativa=posRel;
		this.celda=celda;
		//grafico=new GraficoDisparoEne(celda.getX(),celda.getY(),posRel);
		visitor=new VisitorDisparo(this);
	}
	
	public void avanzar() {
		if(--posRelativa<0) {
			if(--recorrido_restante>0) {
				//celda.moverCeldaDisparo(this);
				posRelativa=120;
				grafico.avanzar();
			}
			else 
				eliminar();
		}
		else grafico.avanzar();
		}
	public void turno() {
		celda.recibirDisparoEnemigo(this);
	}
	

}
