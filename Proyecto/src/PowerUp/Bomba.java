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
	protected float da�o=3000000;
	protected GraficoBomba grafico;

	public Bomba(int x,int y) {
		mapa=Singleton.getMapa();
		grafico=new GraficoBomba(x,y,this);		
	}
	
	public void comenzar() {  //que en este caso seria explotar
		Celda celdaADa�ar;
		List<Enemigo> listaAuxEnemigos=new LinkedList<Enemigo>();
		
		for(int i=-1;i<2;i++) {
			celdaADa�ar=mapa.getCelda(posX + i, posY);
				if(celdaADa�ar!=null) {
					celdaADa�ar.da�arEstructura(da�o);
					List<Enemigo>enemigos=celdaADa�ar.getEnemigos();
					for(Enemigo ene:enemigos) 
						listaAuxEnemigos.add(ene);
					for(Enemigo ene:listaAuxEnemigos) 
						ene.recibirDa�o(da�o);
				}
		}
		
		for(int i=-1;i<2;i++) {
			if(i!=0) { //para no da�ar dos veces la misma celda
				celdaADa�ar=mapa.getCelda(posX + i, posY);
				if(celdaADa�ar!=null) {
					celdaADa�ar.da�arEstructura(da�o);
					List<Enemigo>enemigos=celdaADa�ar.getEnemigos();
					for(Enemigo ene:enemigos) 
						listaAuxEnemigos.add(ene);
					for(Enemigo ene:listaAuxEnemigos) 
						ene.recibirDa�o(da�o);
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
