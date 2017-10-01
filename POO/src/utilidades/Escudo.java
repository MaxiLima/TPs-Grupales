package utilidades;

import juegoestrategico.Unidad;

public class Escudo extends UnidadDecorator{

	public Escudo(Unidad unidad) {//O(1)
		this.unidad = unidad;
	}

	@Override
	public void recibirAtaque(double golpe) {//O(1)
		this.unidad.recibirAtaque(golpe*0.4);
	}

	
}
