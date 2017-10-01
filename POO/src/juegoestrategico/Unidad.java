package juegoestrategico;

public abstract class Unidad{
	
	protected String name;
	protected double poder;
	protected double salud;
	protected int energia;
	protected int posX;
	protected int posY;
	protected int distanciaMin;
	protected int distanciaMax;
	
	//GETTERS
	
	public String getName() {//O(1)
		return name;
	}
	
	public double getPoder() {//O(1)
		return poder;
	}

	public double getSalud() {//O(1)
		return salud;
	}
	
	public int getEnergia() {//O(1)
		return energia;
	}
	

	public int getPosX() {//O(1)
		return posX;
	}
	
	public int getPosY() {//O(1)
		return posY;
	}
	
	public int getDistanciaMin() {//O(1)
		return distanciaMin;
	}
	
	public int getDistanciaMax() {//O(1)
		return distanciaMax;
	}

	//SETTERS
	
	public void setName(String name) {//O(1)
		this.name = name;
	}

	public void setPoder(double poder) {//O(1)
		this.poder = poder;
	}

	public void setSalud(double salud) {//O(1)
		this.salud = salud;
	}
		
	public void setEnergia(int energia) {//O(1)
		this.energia = energia;
	}

	public void setPosX(int posX) {//O(1)
		this.posX = posX;
	}

	public void setPosY(int posY) {//O(1)
		this.posY = posY;
	}

	public void setDistanciaMin(int distanciaMin) {//O(1)
		this.distanciaMin = distanciaMin;
	}
	
	public void setDistanciaMax(int distanciaMax) {//O(1)
		this.distanciaMax = distanciaMax;
	}
	
	public Unidad(){};
	
	public Unidad(String name, double poder, double salud, int energia, int distmin, int distmax){//O(1)
		
		this.name = name;
		this.poder = poder;
		this.salud = salud;
		this.energia = energia;
		this.distanciaMin = distmin;
		this.distanciaMax = distmax;
	}
	
	public abstract double distanciaConEnemigo(Unidad that);
	public abstract void moverHacia(int x, int y);
	public abstract void atacar();
	public abstract boolean puedeAtacar();
	public abstract void recibirAtaque(double golpe);
	public abstract void tomarPocionAgua();
	public void cargarFlechas(){};
	
	//Template de la pelea con otra unidad
	
	public void peleaCon(Unidad enemigo){//O(1)
		
		if((this.distanciaConEnemigo(enemigo)>=this.getDistanciaMin()
			&& this.distanciaConEnemigo(enemigo)<=this.getDistanciaMax()) && this.puedeAtacar()) {
			
			this.atacar();
			enemigo.recibirAtaque(this.getPoder());			
		}
		
		if(enemigo.getSalud()<=0)
			System.out.println(this.getName() + " mato a " + enemigo.getName());
	}
	

	
	
}
