package Logica;

import ObjetosGraficos.ObjetoGrafico;

public abstract class PowerUp {
	protected ObjetoGrafico grafico;
	
	public abstract void comenzar();
	
	public void eliminar() {
		Singleton.getMapa().eliminarPowerUp(this);
		grafico.eliminar();
	}
	

}
