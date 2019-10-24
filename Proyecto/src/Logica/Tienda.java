package Logica;

import Logica.abstracto.Torre;
import Logica.Torres.*;
public class  Tienda {

	public static Torre comprarT1() {
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=100) {
			Singleton.getJugador().reducirDinero(100);
			toReturn=new Torre1();
		}
		return toReturn;
	}
	public static Torre comprarDinero() {
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=50) {
			Singleton.getJugador().reducirDinero(50);
			toReturn=new TorreDinero();
		}
		return toReturn;
	}
	
	public static Torre comprarBarricada() {
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=10) {
			Singleton.getJugador().reducirDinero(10);
			toReturn=new Barricada();
		}
		return toReturn;
	}
	
}
