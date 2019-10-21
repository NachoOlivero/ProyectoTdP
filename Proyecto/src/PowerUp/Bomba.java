package PowerUp;

import java.util.LinkedList;
import java.util.List;

import Grafica.GraficoBomba;
import Logica.Celda;
import Logica.Mapa;
import Logica.Singleton;
import Logica.abstracto.Enemigo;

public class Bomba extends PowerUp{
	
	protected int posX;
	protected int posY;
	protected Mapa mapa;
	protected float daño=3000000;
	protected GraficoBomba grafico;

	public Bomba(int x,int y) {
		mapa=Singleton.getMapa();
		grafico=new GraficoBomba(x,y,this);		
	}
	
	public void comenzar() {  //que en este caso seria explotar
		Celda celdaADañar;
		List<Enemigo> listaAuxEnemigos=new LinkedList<Enemigo>();
		
		for(int i=-1;i<2;i++) {
			celdaADañar=mapa.getCelda(posX + i, posY);
				if(celdaADañar!=null) {
					celdaADañar.dañarEstructura(daño);
					List<Enemigo>enemigos=celdaADañar.getEnemigos();
					for(Enemigo ene:enemigos) 
						listaAuxEnemigos.add(ene);
					for(Enemigo ene:listaAuxEnemigos) 
						ene.recibirDaño(daño);
				}
		}
		
		for(int i=-1;i<2;i++) {
			if(i!=0) { //para no dañar dos veces la misma celda
				celdaADañar=mapa.getCelda(posX + i, posY);
				if(celdaADañar!=null) {
					celdaADañar.dañarEstructura(daño);
					List<Enemigo>enemigos=celdaADañar.getEnemigos();
					for(Enemigo ene:enemigos) 
						listaAuxEnemigos.add(ene);
					for(Enemigo ene:listaAuxEnemigos) 
						ene.recibirDaño(daño);
				}
			}
		}
		grafico.eliminar();
		eliminar(); //la bomba se elimina de la lista de bombas del jugador cunado la solicita el hiloGui para colocarla en el mapa
	}
	
	public void ubicar(int x,int y) {
		posX=x;
		posY=y;
		
		comenzar();
	}
	
	public void eliminar() {
		Singleton.getMapa().eliminarPowerUp(this);
	}
	

}
