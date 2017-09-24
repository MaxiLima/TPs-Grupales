package juegoestrategico;

public class Arquero extends Unidad{
	
	private int flechas;
	
	public Arquero(int posX,int posY){
		
		super(5,20,100, posX, posY);
		this.flechas = 20;
	}
	
	public void cargarFlechas(){
		this.flechas += 6;
	}
	
}
