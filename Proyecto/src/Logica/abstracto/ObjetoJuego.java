package Logica.abstracto;

import Grafica.ObjetoGrafico;
import Logica.Celda;

public abstract class ObjetoJuego {
	protected ObjetoGrafico grafico;
	protected Celda celda;
	
	public ObjetoGrafico getGrafico() {
		return grafico;
	}
	
public void Eliminar() {
		System.out.println("eliminado el objeto: "+grafico);
		grafico.eliminar();
	}

public abstract void atacar(Personaje e);

public Celda getCelda() {
	return celda;
}
}
