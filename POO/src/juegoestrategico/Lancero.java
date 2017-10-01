package juegoestrategico;

public class Lancero extends Unidad{
	
	public Lancero(String name){//O(1)
		super(name, 25, 150, 0, 1, 3);
	}

	@Override
	public void atacar() {//O(1)
		
	}

	@Override
	public boolean puedeAtacar() {//O(1)
		
		return true;
	}

	@Override
	public void recibirAtaque(double golpe) {//O(1)
		this.setSalud(this.getSalud() - golpe);
		if(this.getSalud()<0)
			this.salud = 0;
	}
	
	@Override
    public double distanciaConEnemigo(Unidad that){//O(N)
		
		return Math.sqrt(Math.pow(this.getPosX() - that.getPosX(), 2) + Math.pow(this.getPosY() - that.getPosY(), 2));
	}
	
	@Override
	public void moverHacia(int x, int y){//O(1)
		this.posX = x;
		this.posY = y;
	}

	@Override
	public void tomarPocionAgua() {//O(1)
		this.salud = 150;
		
	}
}
