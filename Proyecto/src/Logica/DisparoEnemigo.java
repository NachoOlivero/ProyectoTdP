package Logica;


import Factory.AbstractFactoryT;
import Factory.FabricaImagenes;
import Grafica.GraficoDisparoEne;
import Logica.abstracto.DisparoAbstracto;
import Visitors.VisitorDisparo;
import Visitors.VisitorDisparoEnemigo;

public class DisparoEnemigo extends DisparoAbstracto {

	public DisparoEnemigo(int alcance, float d�, Celda celda,int posRel) {
		AbstractFactoryT t=new FabricaImagenes();
		recorrido_restante=alcance;
		da�o=d�;
		posRelativa=posRel;
		this.celda=celda;
		grafico=new GraficoDisparoEne(celda.getColumna(),celda.getFila(),posRel,t.disparo());
		visitor=new VisitorDisparoEnemigo(this);
	
	}
	
	public void avanzar() {
		if(--posRelativa<0) {
			if(--recorrido_restante>0) {
				celda.moverCeldaDisparo(this,-1);
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
