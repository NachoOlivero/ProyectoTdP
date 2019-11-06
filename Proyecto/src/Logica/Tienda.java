package Logica;

import Logica.abstracto.Torre;
import Logica.Torres.*;
public class  Tienda {

	public static Torre comprarT1() {
		int aux;
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=100) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-100);
			toReturn=new Torre1();
		}
		return toReturn;
	}
	
	public static Torre comprarT3() {
		int aux;
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=200) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-200);
			toReturn=new Torre3();
		}
		return toReturn;
	}
	
	public static Torre comprarDinero() {
		int aux;
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=50) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-50);
			toReturn=new TorreDinero();
		}
		return toReturn;
	}
	
	public static Torre comprarBarricada() {
		int aux;
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=140) {
			aux=Singleton.getJugador().getDinero();
			Singleton.getJugador().setDinero(aux-140);
			toReturn=new Barricada();
		}
		return toReturn;
	}
	
}
