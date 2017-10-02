package juegoestrategico;

public class Soldado extends Unidad{

	
	public Soldado(String name) {//O(1)
		super(name, 10, 200,100,0,1);
		
	}
	


	@Override
	public void atacar() {//O(1)
		this.energia -= 10;
	}

	@Override
	public boolean puedeAtacar() {//O(1)
		if(this.getEnergia()>=10)
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



	@Override
	public void tomarPocionAgua() {//O(1)
		this.energia = 100;
	}
	
	
	
}
