package GUI;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class fabricaT extends abstractFactoriT {
	
	public fabricaT() {}

	@Override
	public ImageIcon Torre1() {
		return new ImageIcon(this.getClass().getResource("./Seige_Tower.png"));
	}
	
	public ImageIcon Enemigo1() {
		return new ImageIcon(this.getClass().getResource("./ezgif.com-rotate.gif"));
	}

}
