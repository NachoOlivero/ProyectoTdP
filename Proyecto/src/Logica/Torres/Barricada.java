package Logica.Torres;

import Factory.AbstractFactoryT;
import Factory.fabricaT;
import Grafica.GraficoDoble;
import Grafica.ObjetoGraficoT;
import Logica.Celda;
import Logica.Singleton;
import Logica.abstracto.Personaje;
import Logica.abstracto.Torre;
import Visitors.VisitorCeldaTorre;

public class Barricada extends Torre {
	protected Celda celdaExtra;

	public Barricada() {
		this.hp=100;
		this.dp=0;
		this.rango=0;
		cooldownOriginal=0;
		cooldownActual=cooldownOriginal;
		cooldown=0;
		grafico=null;
		visitor=new VisitorCeldaTorre(this);
	}
	
	public void setCelda(Celda c) {
		AbstractFactoryT aux= new fabricaT();
		grafico=new GraficoDoble(c,aux.barricada());
		celda=c;
		if(!Singleton.getMapa().insertarEstructura(this, celda.getX()-1, celda.getY())) {
			this.Eliminar();
			Singleton.getJugador().aumentarDinero(140);
		}else {
			celdaExtra=Singleton.getMapa().getCelda(celda.getX()-1, celda.getY());
		}
		
	}
	
	public void Eliminar() {
		grafico.eliminar();
		if(celdaExtra!=null) 
			celdaExtra.eliminarEstructura();
		celda.eliminarEstructura();
		
		
	}

	@Override
	public void setCooldown(int cd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetCooldown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recibirDaño(float daño) {
		hp-=daño;
		if(hp<=0)
			Eliminar();
		
	}

	@Override
	public void atacar(Personaje e) {
		// TODO Auto-generated method stub
		
	}

}
