package Logica.abstracto;

import Logica.Celda;

public abstract class ObjetoJuego {
	protected ObjetoGrafico grafico;
	protected Celda celda;
	
	public ObjetoGrafico getGrafico() {
		return grafico;
	}
	
public void Eliminar() {
		System.out.println(grafico);
		grafico.eliminar();
	}
}
