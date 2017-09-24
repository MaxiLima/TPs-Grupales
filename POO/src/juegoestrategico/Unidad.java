package juegoestrategico;

public abstract class Unidad implements Personaje {
	
	protected double daño;
	protected double salud;
	protected int energia;
	protected int posX;
	protected int posY;
	
	public Unidad(double daño, double salud,int energia, int posX, int posY) {
		this.daño = daño;
		this.salud = salud;
		this.energia = energia;
		this.posX = posX;
		this.posY = posY;
	}
	
	
	public double getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	public double getSalud() {
		return salud;
	}
	public void setSalud(int salud) {
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
	
	public double distanciaConEnemigo(Unidad that){
		
		return Math.sqrt(Math.pow(this.getPosX() - that.getPosX(), 2) + Math.pow(this.getPosY() - that.getPosY(), 2));
	}
	
	
	
}
