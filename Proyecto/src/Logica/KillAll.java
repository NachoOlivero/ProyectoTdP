package Logica;

import java.awt.event.MouseListener;

import ObjetosGraficos.GraficoKillAll;
import ObjetosGraficos.ObjetoGrafico;

public class KillAll extends PowerUp {
	protected MouseListener oyente;
	
	public KillAll(int x,int y) {
		grafico=new GraficoKillAll(x,y,this);
	}


	public void comenzar() {
		Singleton.getMapa().KillAll();
		eliminar();
	}
	
}
