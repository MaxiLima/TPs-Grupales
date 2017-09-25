package juegoestrategico;

public class Lancero extends Unidad{
	
	public Lancero(int posX,int posY){
		super(25, 150,100,  posX, posY,1,3);
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean puedeAtacar() {
		
		return true;
	}
}
