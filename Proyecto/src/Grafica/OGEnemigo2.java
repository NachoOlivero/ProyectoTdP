package Grafica;

import javax.swing.JLabel;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import GUI.Eliminador;
import Logica.Singleton;

public class OGEnemigo2 extends OGMovil {
	
	public OGEnemigo2() {
		AbstractFactoryT f=new fabricaT();
		grafico=new JLabel(f.Enemigo1());
	}
	public void avanzar() {
		grafico.setBounds(grafico.getX()-1, grafico.getY(), 50, 50);
	}

	public JLabel getGrafico() {
		return grafico;
	}
	
	public int ubicacionGrafico() {
		return (grafico.getX()-50)/120;
	}
	
	public void setPosicion(int pos) {
		grafico.setBounds(1220,pos*100, 50, 50);
		Singleton.getGui().add(grafico);
	}
	/*public void eliminar(){
		AbstractFactoryT t=new fabricaT();
		Eliminador ele=new Eliminador();
		ele.eliminar(grafico, t.MuerteEne1());
	}**/
}
