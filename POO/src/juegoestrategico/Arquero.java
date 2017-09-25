package juegoestrategico;

public class Arquero extends Unidad{
	
	private int flechas;
	
	public Arquero(int posX,int posY){
		
		super(5,20,100, posX, posY,2,5);
		this.flechas = 20;
	}
	
	public int getFlechas() {
		return flechas;
	}

	public void cargarFlechas(){
		this.flechas += 6;
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean puedeAtacar() {
		if(this.getFlechas()>0)
			return true;
		return false;
	}
	
}
