package juegoestrategico;

public class Caballero extends Unidad{

	private boolean caballoRebelde;
	private int cantAtaques;
	
	public Caballero(String name) {
		super(name,50, 200,100,1,2);
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

	@Override
		public void recibirAtaque(double golpe) {
		
		this.setSalud(this.getSalud() - golpe);
	}
	
	@Override
    public double distanciaConEnemigo(Unidad that){
		
		return Math.sqrt(Math.pow(this.getPosX() - that.getPosX(), 2) + Math.pow(this.getPosY() - that.getPosY(), 2));
	}
	
	@Override
	public void moverHacia(int x, int y){
		this.posX = x;
		this.posY = y;
	}
	

}
