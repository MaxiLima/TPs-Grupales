package juegoestrategico;

public class Caballero extends Unidad{

	private boolean caballoRebelde;
	private int cantAtaques;
	
	public Caballero(int posX,int posY) {
		super(50, 200,100, posX, posY,1,2);
		this.caballoRebelde = false;
		this.cantAtaques = 0;
	}
	
	public int getCantAtaques() {
		return cantAtaques;
	}

	public void tomarPocionAgua(){
		this.caballoRebelde = false;
		this.cantAtaques = 0;
		
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean puedeAtacar() {
		if(!caballoRebelde)
			return true;
		return false;
	}
	
	

}
