package Estructuras;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.ObjetoGraficoT;
import Logica.Celda;
import Logica.abstracto.Estructura;
import Logica.abstracto.Personaje;
import Visitors.VisitorCeldaEstructura;

public class Clavos extends Estructura {
	
	public Clavos(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new ObjetoGraficoT(c,aux.pinchos(),20);
		celda=c;
	}


	public void recibirDaño(float daño) {
		hp=-daño;
		if(hp<=0) {
			Eliminar();
			celda.eliminarEstructura();
		}
		
	}

	@Override
	public void turno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar(Personaje e) {
		// TODO Auto-generated method stub
		
	}
		
	
}

}
