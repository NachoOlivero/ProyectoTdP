package GUI;

import java.net.URL;

import javax.swing.ImageIcon;

public class fabricaT extends abstractFactoriT {
	
	public fabricaT() {}

	@Override
	public ImageIcon Torre1() {
		return new ImageIcon(this.getClass().getResource("./torre1.1.jpg"));
	}

}
