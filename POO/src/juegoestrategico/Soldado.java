package juegoestrategico;

public class Soldado extends Unidad{

	
	public Soldado(int posX,int posY) {
		super(10,200,100, posX, posY, 0,1);
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

	
	
	
	
}
