package Logica.abstracto;

import Factory.FabricaEnemigosMagia;

public class EnemigoMagia extends Estado {
	
	public EnemigoMagia() {
		factory=new FabricaEnemigosMagia();
	}
}
