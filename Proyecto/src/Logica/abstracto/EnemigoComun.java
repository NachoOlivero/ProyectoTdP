package Logica.abstracto;

import Factory.FabricaImagenes;

public class EnemigoComun extends Estado {
	
	public EnemigoComun() {
		factory=new FabricaImagenes();
	}

}
