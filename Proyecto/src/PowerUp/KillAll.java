package PowerUp;

import java.awt.event.MouseListener;

import Grafica.GraficoKillAll;
import Grafica.ObjetoGrafico;
import Logica.Singleton;

public class KillAll extends PowerUp {
	protected MouseListener oyente;
	
	public KillAll(int x,int y) {
		grafico=new GraficoKillAll(x,y,this);
	}


	public void comenzar() {
		Singleton.getMapa().KillAll();
		System.out.println("hola kill all");
		eliminar();
	}
	
	public void ubicar(int x,int y) {}
	
	public static int getCosto() {
		return 1500;
	}
}
