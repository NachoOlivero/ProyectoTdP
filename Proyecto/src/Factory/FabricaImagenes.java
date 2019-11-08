package Factory;

import javax.swing.ImageIcon;


public class FabricaImagenes implements AbstractFactoryT {
	
	public FabricaImagenes() {}

	public ImageIcon Torre1() {
		return new ImageIcon(this.getClass().getResource("./Seige_Tower.png"));
	}
	
	public ImageIcon Torre2() {
		return new ImageIcon(this.getClass().getResource("./Samurai.png"));
	}
	
	public ImageIcon Torre3() {
		return new ImageIcon(this.getClass().getResource("./torreLanzallamas.png"));
	}
	
	public ImageIcon Enemigo1() {
		return new ImageIcon(this.getClass().getResource("./Esqueleto.gif"));
	}
	
	public ImageIcon Enemigo2() {
		return new ImageIcon(this.getClass().getResource("./jefe.gif"));
	}
	
	public ImageIcon Enemigo3() {
		return new ImageIcon(this.getClass().getResource("./boss.gif"));
	}
	
	public ImageIcon Enemigo4() {
		return new ImageIcon(this.getClass().getResource("./Minotaur.gif"));
	}
	
	public ImageIcon Enemigo5() {
		return new ImageIcon(this.getClass().getResource("./Dragon.gif")); //cambiar
	}
	
	public ImageIcon Enemigo6() {
		return new ImageIcon(this.getClass().getResource("./Dragon.gif"));
	}
	
	public ImageIcon disparo() {
		return new ImageIcon(this.getClass().getResource("./Disparo.PNG"));
	}
	
	public ImageIcon disparoFuego() {
		return new ImageIcon(this.getClass().getResource("./fuego.png"));
	}
	
	public ImageIcon killAll() {
		return new ImageIcon(this.getClass().getResource("./Kill.png"));
	}
	
	public ImageIcon barrera() {
		return new ImageIcon(this.getClass().getResource("./shield.png"));
	}
	
	public ImageIcon speedUp() {
		return new ImageIcon(this.getClass().getResource("./speedUp.png"));
	}
	
	public ImageIcon bomba() {
		return new ImageIcon(this.getClass().getResource("./Bomba.png"));
	}

	public ImageIcon MuerteEne1() {
		return new ImageIcon(this.getClass().getResource("./Ene1Muerte.gif"));
	
	}


	public ImageIcon TorreD() {
		return new ImageIcon(this.getClass().getResource("./Tienda.png"));
	}

	@Override
	public ImageIcon charco() {
		return new ImageIcon(this.getClass().getResource("./charco.png"));
	}

	@Override
	public ImageIcon obstaculo() {
		return new ImageIcon(this.getClass().getResource("./Obstaculo.png"));
	}

	@Override
	public ImageIcon pinchos() {
		return new ImageIcon(this.getClass().getResource("./pinches.png"));
	}
	
	public ImageIcon barricada() {
		return new ImageIcon(this.getClass().getResource("./BarricadaV1.png"));
	}

	@Override
	public ImageIcon EsqueletoNegativo() {
		return new ImageIcon(this.getClass().getResource("./EsqueletoNegativo.gif"));
	}
	
	
	

}
