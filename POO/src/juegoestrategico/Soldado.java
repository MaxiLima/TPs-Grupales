package juegoestrategico;

public class Soldado extends Unidad{

	
	public Soldado(String name) {
		super(name,10,200,100, 0,1);
	}
	
	public void tomarPocionAgua(){
		this.energia = 100;
	}

	@Override
	public void atacar() {
		
	}

	@Override
	public boolean puedeAtacar() {
		if(this.getEnergia()>=10)
			return true;
		return false;
	}

	@Override
	public void recibirAtaque(double golpe) {
		// TODO Auto-generated method stub
		
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
	
	
	
}
