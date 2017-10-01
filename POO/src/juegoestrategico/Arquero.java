package juegoestrategico;

public class Arquero extends Unidad{
	
	private int flechas;
	
	public Arquero(String name){ //O(1)
		super(name, 5,50,0,2,5);
		this.flechas = 20;
	}
	
	public int getFlechas() { //O(1)
		return flechas;
	}

	public void setFlechas(){ //O(1)
		this.flechas += 6;
	}

	@Override
	public void atacar() {//O(1)
		this.flechas --;
		
	}

	@Override
	public boolean puedeAtacar() {//O(1)
		if(this.getFlechas()>0)
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
		this.salud = 50;
	}
	
	@Override
	public void cargarFlechas(){//O(1)
		this.setFlechas();
	}
	
}
