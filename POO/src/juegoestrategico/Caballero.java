package juegoestrategico;

public class Caballero extends Unidad{

	private boolean caballoRebelde;
	private int cantAtaques;
	
	public Caballero(String name) {//O(1)
		super(name, 50,200,0,1,2);
		this.caballoRebelde = false;
		this.cantAtaques = 0;
	}
	
	public int getCantAtaques() {//O(1)
		return cantAtaques;
	}

	public void tomarPocionAgua(){//O(1)
		this.caballoRebelde = false;
		System.out.println("Horse chills down");
		this.cantAtaques = 0;
		
	}

	@Override
	public void atacar() {//O(1)
		this.cantAtaques ++;
		if(this.cantAtaques >= 3){
			this.caballoRebelde = true;
			System.out.println("Horse has gone rogue!");
		}
			
	}

	@Override
	public boolean puedeAtacar() {//O(1)
		if(!caballoRebelde)
			return true;
		System.out.println(this.getName() + " no puede atacar!");
		return false;
	}

	@Override
	public void recibirAtaque(double golpe) {//O(1)
		this.setSalud(this.getSalud() - golpe);
		if(this.getSalud()<0)
			this.salud = 0;
	}
	
	@Override
    public double distanciaConEnemigo(Unidad that){//O(NlogN)
		
		return Math.sqrt(Math.pow(this.getPosX() - that.getPosX(), 2) + Math.pow(this.getPosY() - that.getPosY(), 2));
	}
	
	@Override
	public void moverHacia(int x, int y){//O(1)
		this.posX = x;
		this.posY = y;
	}
	

}
