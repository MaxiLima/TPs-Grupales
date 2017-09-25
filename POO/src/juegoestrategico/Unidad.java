package juegoestrategico;

public abstract class Unidad implements Personaje{
	
	protected String name;
	protected double daño;
	protected double salud;
	protected int energia;
	protected int posX;
	protected int posY;
	protected int distanciaMin;
	protected int distanciaMax;
	
	public Unidad(String name,double daño, double salud,int energia, int distanciaMin, int distanciaMax) {
		
		this.name = name;
		this.daño = daño;
		this.salud = salud;
		this.energia = energia;
		this.distanciaMin = distanciaMin;
		this.distanciaMax = distanciaMax;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDaño() {
		return daño;
	}
	public void setDaño(double daño) {
		this.daño = daño;
	}
	public double getSalud() {
		return salud;
	}
	public void setSalud(double salud) {
		this.salud = salud;
	}

	public int getEnergia() {
		return energia;
	}
		
	public void setEnergia(int energia) {
		this.energia = energia;
	}


	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getDistanciaMin() {
		return distanciaMin;
	}

	public void setDistanciaMin(int distanciaMin) {
		this.distanciaMin = distanciaMin;
	}


	public int getDistanciaMax() {
		return distanciaMax;
	}


	public void setDistanciaMax(int distanciaMax) {
		this.distanciaMax = distanciaMax;
	}


	
	public abstract double distanciaConEnemigo(Unidad that);
	public abstract void moverHacia(int x, int y);
	public abstract void atacar();
	public abstract boolean puedeAtacar();
	public abstract void recibirAtaque(double golpe);
	
	//Template de la pelea con otra unidad
	
	public void peleaCon(Unidad enemigo){
		
		if((this.distanciaConEnemigo(enemigo)>=this.getDistanciaMin()
			&& this.distanciaConEnemigo(enemigo)<=this.getDistanciaMax()) && this.puedeAtacar()) {
			
			this.atacar();
			enemigo.recibirAtaque(this.getDaño());
			
		}
		
		if(enemigo.getSalud()<=0)
			System.out.println(this.getName() + " mato a " + enemigo.getName());
	}
	

	
	
}
