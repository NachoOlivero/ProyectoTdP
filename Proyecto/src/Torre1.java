
public class Torre1 extends Torre {
	
	public Torre1(Celda cel) {
		this.hp=500;
		this.dp=500;
		this.celda=cel;
	}

	public void atacar(Personaje p) {
		p.recibirDa�o(dp);
		
	}
	public void recibirDa�o(float da�o) {
		hp-=da�o;
		//if(hp<=0)
			////celda.  eliminar 
		
	}
	
	
}
