package utilidades;

import juegoestrategico.Unidad;

public abstract class UnidadDecorator extends Unidad{
	
	protected Unidad unidad;

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	
	

}
