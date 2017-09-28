package juegoestrategico;

public class Arquero extends Unidad{
	
	private int flechas;
	
	public Arquero(String name){
		super(name, 5,50,0,2,5);
		this.flechas = 20;
	}
	
	public int getFlechas() {
		return flechas;
	}

	public void setFlechas(){
		this.flechas += 6;
	}

	@Override
	public void atacar() {
		this.flechas --;
		
	}

	@Override
	public boolean puedeAtacar() {
		if(this.getFlechas()>0)
			return true;
		System.out.println(this.getName() + " no puede atacar!");
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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void cargarFlechas(){
		this.setFlechas();
	}
	
}
