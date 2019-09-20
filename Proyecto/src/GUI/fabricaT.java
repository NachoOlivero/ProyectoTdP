package GUI;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class fabricaT extends abstractFactoriT {
	
	public fabricaT() {}

	@Override
	public ImageIcon Torre1() {
		Image img= new ImageIcon("./Seige_Tower_1.png").getImage();
		Image newimg = img.getScaledInstance(80, 100,  java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(this.getClass().getResource("./Seige_Tower.png"));
	}

}
