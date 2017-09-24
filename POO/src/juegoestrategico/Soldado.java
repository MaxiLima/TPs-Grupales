package juegoestrategico;

public class Soldado extends Unidad{

	private int energia;
	
	public Soldado(int posX,int posY) {
		super(10,200, posX, posY);
		this.energia = 100;
	}
	
	
	
}
