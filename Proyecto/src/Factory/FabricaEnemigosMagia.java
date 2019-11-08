package Factory;

import javax.swing.ImageIcon;

public class FabricaEnemigosMagia implements AbstractFactoryT{
	
	public FabricaEnemigosMagia() {}

	@Override
	public ImageIcon Torre1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon Torre2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon Torre3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon TorreD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon Enemigo1() {
		return new ImageIcon(this.getClass().getResource("./EsqueletoNegativo.gif"));
	}

	@Override
	public ImageIcon Enemigo2() {
		return new ImageIcon(this.getClass().getResource("./EnemigoArmaduraDorada.gif"));
	}

	@Override
	public ImageIcon Enemigo3() {
		return new ImageIcon(this.getClass().getResource("EsqueletoGrandeSepia.gif"));
	}

	@Override
	public ImageIcon Enemigo4() {
		return new ImageIcon(this.getClass().getResource("./MinMag.gif"));
	}

	@Override
	public ImageIcon Enemigo5() {
		return new ImageIcon(this.getClass().getResource("./BandidoRojo.gif"));
	}
	
	@Override
	public ImageIcon Enemigo6() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon killAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon barrera() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon disparo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon disparoFuego() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon bomba() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ImageIcon charco() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon obstaculo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon pinchos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon barricada() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon speedUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon EsqueletoNegativo() {
		// TODO Auto-generated method stub
		return null;
	}

}
