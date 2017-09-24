package utilidades;

import juegoestrategico.Unidad;

public class Capa extends Item{
	
	public Capa(Unidad that){
		this.unidad = that;
	}

	public int getEnergia(){
		return this.unidad.getEnergia() * 2;
		
	}
	
	public double getDaño(){
		return this.unidad.getDaño() * 0.9;
	}
}
