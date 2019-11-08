package Logica.abstracto;

import Factory.AbstractFactoryT;

public abstract class Estado {
	protected AbstractFactoryT factory;
	protected int aumento;
	
	public AbstractFactoryT getFactory() {
		return factory;
	}
	
	public int getAumento() {
		return aumento;
	}
}
