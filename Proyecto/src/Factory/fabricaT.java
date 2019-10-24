package Factory;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class fabricaT extends AbstractFactoryT {
	
	public fabricaT() {}

	public ImageIcon Torre1() {
		return new ImageIcon(this.getClass().getResource("./Seige_Tower.png"));
	}
	
	public ImageIcon Enemigo1() {
		return new ImageIcon(this.getClass().getResource("./Esqueleto.gif"));
	}
	public ImageIcon disparo() {
		return new ImageIcon(this.getClass().getResource("./Disparo.PNG"));
	}
	public ImageIcon killAll() {
		return new ImageIcon(this.getClass().getResource("./Kill.png"));
	}
	public ImageIcon barrera() {
		return new ImageIcon(this.getClass().getResource("./shield.png"));
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
	
	
	

}
