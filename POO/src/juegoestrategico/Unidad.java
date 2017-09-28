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
	
	public String getName() {
		return name;
	}
	
	public double getPoder() {
		return poder;
	}

	public double getSalud() {
		return salud;
	}
	
	public int getEnergia() {
		return energia;
	}
	

	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getDistanciaMin() {
		return distanciaMin;
	}
	
	public int getDistanciaMax() {
		return distanciaMax;
	}

	//SETTERS
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPoder(double poder) {
		this.poder = poder;
	}

	public void setSalud(double salud) {
		this.salud = salud;
	}
		
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setDistanciaMin(int distanciaMin) {
		this.distanciaMin = distanciaMin;
	}
	
	public void setDistanciaMax(int distanciaMax) {
		this.distanciaMax = distanciaMax;
	}

	
	

	
	public abstract double distanciaConEnemigo(Unidad that);
	public abstract void moverHacia(int x, int y);
	public abstract void atacar();
	public abstract boolean puedeAtacar();
	public abstract void recibirAtaque(double golpe);
	public abstract void tomarPocionAgua();
	public void cargarFlechas(){};
	
	//Template de la pelea con otra unidad
	
	public void peleaCon(Unidad enemigo){
		
		if((this.distanciaConEnemigo(enemigo)>=this.getDistanciaMin()
			&& this.distanciaConEnemigo(enemigo)<=this.getDistanciaMax()) && this.puedeAtacar()) {
			
			this.atacar();
			enemigo.recibirAtaque(this.getPoder());			
		}
		
		
		
		if(enemigo.getSalud()<=0)
			System.out.println(this.getName() + " mato a " + enemigo.getName());
	}
	

	
	
}
