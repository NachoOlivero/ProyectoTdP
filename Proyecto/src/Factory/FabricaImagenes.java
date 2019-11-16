package Factory;

import javax.swing.ImageIcon;


public class FabricaImagenes implements AbstractFactoryT {
	
	public FabricaImagenes() {}

	public ImageIcon Torre1() {
		return new ImageIcon(this.getClass().getResource("/Factory/torre1.png"));
	}
	
	public ImageIcon Torre2() {
		return new ImageIcon(this.getClass().getResource("/Factory/torre2.png"));
	}
	
	public ImageIcon Torre3() {
		return new ImageIcon(this.getClass().getResource("/Factory/torre3.png"));
	}
	
	public ImageIcon Enemigo1() {
		return new ImageIcon(this.getClass().getResource("/Factory/Esqueleto.gif"));
	}
	
	public ImageIcon Enemigo2() {
		return new ImageIcon(this.getClass().getResource("/Factory/EsqueletoArmadura.gif"));
	}
	
	public ImageIcon Enemigo3() {
		return new ImageIcon(this.getClass().getResource("/Factory/EsqueletoGrande.gif"));
	}
	
	public ImageIcon Enemigo4() {
		return new ImageIcon(this.getClass().getResource("/Factory/Minotaur.gif"));
	}
	
	public ImageIcon Enemigo5() {
		return new ImageIcon(this.getClass().getResource("/Factory/Bandido.gif")); //cambiar
	}
	
	public ImageIcon Enemigo6() {
		return new ImageIcon(this.getClass().getResource("/Factory/Dragon.gif"));
	}
	
	public ImageIcon disparo() {
		return new ImageIcon(this.getClass().getResource("/Factory/Disparo.png"));
	}
	
	public ImageIcon disparoFuego() {
		return new ImageIcon(this.getClass().getResource("/Factory/fuego.png"));
	}
	
	public ImageIcon killAll() {
		return new ImageIcon(this.getClass().getResource("/Factory/Kill.png"));
	}
	
	public ImageIcon barrera() {
		return new ImageIcon(this.getClass().getResource("/Factory/shield.png"));
	}
	
	public ImageIcon speedUp() {
		return new ImageIcon(this.getClass().getResource("/Factory/speedUp.png"));
	}
	
	public ImageIcon bomba() {
		return new ImageIcon(this.getClass().getResource("/Factory/Bomba.png"));
	}


	public ImageIcon TorreD() {
		return new ImageIcon(this.getClass().getResource("/Factory/Tienda.png"));
	}

	@Override
	public ImageIcon charco() {
		return new ImageIcon(this.getClass().getResource("/Factory/charco.png"));
	}

	@Override
	public ImageIcon obstaculo() {
		return new ImageIcon(this.getClass().getResource("/Factory/Obstaculo.png"));
	}

	@Override
	public ImageIcon pinchos() {
		return new ImageIcon(this.getClass().getResource("/Factory/pinches.png"));
	}
	
	public ImageIcon barricada() {
		return new ImageIcon(this.getClass().getResource("/Factory/BarricadaV1.png"));
	}

	@Override
	public ImageIcon EsqueletoNegativo() {
		return new ImageIcon(this.getClass().getResource("/Factory/EsqueletoNegativo.gif"));
	}
	
	
	

}
