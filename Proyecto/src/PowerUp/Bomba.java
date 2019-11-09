package PowerUp;

import java.util.LinkedList;
import java.util.List;

import Grafica.GraficoBomba;
import Logica.Celda;
import Logica.Mapa;
import Logica.Singleton;
import Logica.abstracto.Enemigo;

public class Bomba extends PowerUp{

	protected Mapa mapa;
	protected float da�o=50;
	protected GraficoBomba grafico;
	protected int posX,posY;

	public Bomba(int x,int y) {
		mapa=Singleton.getMapa();
		grafico=new GraficoBomba(x,y,this);		
	}
	
	public Bomba() {
		mapa=Singleton.getMapa();
	}  //se utiliza si el jugador la compra, no tiene grafico
	
	public void ubicar(int f, int c) {
		posX=f;
		posY=c;
		
		comenzar();
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
				celdaADa�ar=mapa.getCelda(posX, posY + i);
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
		eliminar(); //la bomba se elimina de la lista de bombas del jugador cunado la solicita el hiloGui para colocarla en el mapa
	}
	
	public void eliminar() {
		super.eliminar();
		Singleton.getJugador().eliminarBomba(this);
	}
	public static int getCosto() {
		return 200;
	}
	

}
