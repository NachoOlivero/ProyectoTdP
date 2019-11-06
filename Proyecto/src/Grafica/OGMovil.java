package Grafica;

public abstract class OGMovil extends ObjetoGrafico {
	
	public void avanzar() {
		grafico.setBounds(grafico.getX()-1, grafico.getY(), 50, 50);
	}
	
}
