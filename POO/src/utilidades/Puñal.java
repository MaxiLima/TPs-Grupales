package utilidades;

public class Puñal extends Item{
	
	public double getDaño(){
		return this.unidad.getDaño() + 3;
	}

}
