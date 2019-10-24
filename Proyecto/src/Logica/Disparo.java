package Logica;

import javax.swing.ImageIcon;

import Grafica.GraficoDisparo;
import Grafica.OGMovil;
import Logica.abstracto.DisparoAbstracto;
import Logica.abstracto.Enemigo;
import Logica.abstracto.Personaje;
import Visitors.VisitorDisparo;

public class Disparo extends DisparoAbstracto{
	
	public Disparo(int alcance, float dñ,Celda celda,ImageIcon l) {
		recorrido_restante=alcance;
		daño=dñ;
		posRelativa=1;
		this.celda=celda;
		grafico=new GraficoDisparo(celda.getX(),celda.getY(),l);
		visitor=new VisitorDisparo(this);
	}
	
	public void decrementarAlcance() {
		recorrido_restante--;
	}
	
	public void avanzar() {
			if(++posRelativa>120) {
				if(--recorrido_restante>0) {
					celda.moverCeldaDisparo(this,1);
					posRelativa=1;
					grafico.avanzar();
				}
				else 
					eliminar();
			}
			else grafico.avanzar();
		//System.out.println("Disparo :"+posRelativa);
	}

	
	public void turno() {
		celda.recibirDisparo(this);
	}

	
}
