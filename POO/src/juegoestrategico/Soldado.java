package juegoestrategico;

public class Soldado extends Unidad{

	
	public Soldado(String name) {
		this.name = name;
		this.poder = 10;
		this.salud = 200;
		this.energia = 100;
		this.distanciaMin = 0;
		this.distanciaMax = 1;
	}
	


	@Override
	public void atacar() {
		this.energia -= 10;
	}

	@Override
	public boolean puedeAtacar() {
		if(this.getEnergia()>=10)
			return true;
		return false;
	}

	@Override
	public void recibirAtaque(double golpe) {
		this.setSalud(this.getSalud() - golpe);
		
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



	@Override
	public void tomarPocionAgua() {
		this.energia = 100;
	}
	
	
	
}
