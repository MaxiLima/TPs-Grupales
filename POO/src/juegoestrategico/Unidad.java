package juegoestrategico;

public abstract class Unidad {
	
	protected int daño;
	protected int salud;
	protected int posX;
	protected int posY;
	
	public Unidad(int daño, int salud, int posX, int posY) {
		this.daño = daño;
		this.salud = salud;
		this.posX = posX;
		this.posY = posY;
	}
	
	
	public int getDaño() {
		return daño;
	}
	public void setDaño(int daño) {
		this.daño = daño;
	}
	public int getSalud() {
		return salud;
	}
	public void setSalud(int salud) {
		this.salud = salud;
	}
	
	
}
