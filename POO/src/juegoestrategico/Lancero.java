package juegoestrategico;

public class Lancero extends Unidad{
	
	public Lancero(String name){
		super(name, 25, 150, 0, 1, 3);
	}

	@Override
	public void atacar() {
		
	}

	@Override
	public boolean puedeAtacar() {
		
		return true;
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
		this.salud = 150;
		
	}
}
