package Logica.abstracto;

import Factory.AbstractFactoryT;

public abstract class Estado {
	protected AbstractFactoryT factory;
	
	public AbstractFactoryT getFactory() {
		return factory;
	}
}
