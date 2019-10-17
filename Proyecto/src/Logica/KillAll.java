package Logica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ObjetosGraficos.GraficoKillAll;
import ObjetosGraficos.ObjetoGrafico;

public class KillAll implements PowerUp {
	protected ObjetoGrafico grafico;
	protected MouseListener oyente;
	
	public KillAll(int x,int y) {
		grafico=new GraficoKillAll(x,y,oyente,this);
	}


	public void comenzar() {
		Singleton.getMapa().KillAll();
	}
	
	public void eliminar() {
		
	}

	public class Oyente extends MouseAdapter{

		public void mouseClicked(MouseEvent arg0) {
			eliminar();  //por ahora asi
			comenzar();
			System.out.println("hola");
		}
	}
	
}
