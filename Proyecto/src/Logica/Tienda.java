package Logica;

import Logica.abstracto.Torre;
import Logica.Torres.*;
public class  Tienda {

	public static Torre comprarT1() {
		Torre toReturn=null;
		if(Singleton.getJugador().getDinero()>=50) {
			Singleton.getJugador().reducirDinero(50);
			toReturn=new Torre1();
		}
		return toReturn;
	}
	
}
