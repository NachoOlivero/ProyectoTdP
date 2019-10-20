package Factory;

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
		return new ImageIcon(this.getClass().getResource("./Proyectiltemp.png"));
	}
	public ImageIcon killAll() {
		return new ImageIcon(this.getClass().getResource("./Proyectiltemp.png"));
	}
	public ImageIcon barrera() {
		return new ImageIcon(this.getClass().getResource("./Proyectiltemp.png"));
	}

}
