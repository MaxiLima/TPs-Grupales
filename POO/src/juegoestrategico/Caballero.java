package juegoestrategico;

public class Caballero extends Unidad{

	private boolean caballoRebelde;
	private int cantAtaques;
	
	public Caballero(int posX,int posY) {
		super(50, 200,100, posX, posY);
		this.caballoRebelde = false;
		this.cantAtaques = 0;
	}
	
	public void tomarPocionAgua(){
		this.caballoRebelde = false;
		this.cantAtaques = 0;
		
	}
	
	

}
