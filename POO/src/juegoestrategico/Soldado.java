package juegoestrategico;

public class Soldado extends Unidad{

	
	public Soldado(int posX,int posY) {
		super(10,200,100, posX, posY);
	}
	
	public void tomarPocionAgua(){
		this.energia = 100;
	}
	
	
	
	
}
