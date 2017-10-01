package juegoestrategico;

public class Caballero extends Unidad{

	private boolean caballoRebelde;
	private int cantAtaques;
	
	public Caballero(String name) {
		super(name, 50,200,0,1,2);
		this.caballoRebelde = false;
		this.cantAtaques = 0;
	}
	
	public int getCantAtaques() {
		return cantAtaques;
	}

	public void tomarPocionAgua(){
		this.caballoRebelde = false;
		System.out.println("Horse chills down");
		this.cantAtaques = 0;
		
	}

	@Override
	public void atacar() {
		this.cantAtaques ++;
		if(this.cantAtaques >= 3){
			this.caballoRebelde = true;
			System.out.println("Horse has gone rogue!");
		}
			
	}

	@Override
	public boolean puedeAtacar() {
		if(!caballoRebelde && this.getSalud()>0)
			return true;
		if(this.getSalud()<=0)
			System.out.println(this.getName() + " esta muerto!");
		if(caballoRebelde)
			System.out.println(this.getName() + " no puede atacar!");
		return false;
	}

	@Override
	public void recibirAtaque(double golpe) {
		this.setSalud(this.getSalud() - golpe);
		if(this.getSalud()<0)
			this.salud = 0;
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
