package utilidades;

import juegoestrategico.Unidad;

public abstract class UnidadDecorator extends Unidad{
	
	protected Unidad unidad;

	public Unidad getUnidad() {//O(1)
		return unidad;
	}

	public void setUnidad(Unidad unidad) {//O(1)
		this.unidad = unidad;
	}
	
	@Override
	public double distanciaConEnemigo(Unidad that) {//O(1)
		return this.unidad.distanciaConEnemigo(that);
	}

	@Override
	public void moverHacia(int x, int y) {//O(1)
		this.unidad.moverHacia(x, y);
	}

	@Override
	public void atacar() {//O(1)
		this.unidad.atacar();
	}

	@Override
	public boolean puedeAtacar() {//O(1)
		return this.unidad.puedeAtacar();
	}

	@Override
	public void recibirAtaque(double golpe) {//O(1)
		this.unidad.recibirAtaque(golpe);
	}
	
	@Override
	public void tomarPocionAgua(){//O(1)
		this.unidad.tomarPocionAgua();
	}
	
	//OVERRIDING GETTERS
	
		@Override
		public String getName() {//O(1)
			return unidad.getName();
		}
		
		@Override
		public double getPoder() {//O(1)
			return unidad.getPoder();
		}

		@Override
		public double getSalud() {//O(1)
			return unidad.getSalud();
		}
		
		@Override
		public int getEnergia() {//O(1)
			return unidad.getEnergia();
		}
		
		@Override
		public int getPosX() {//O(1)
			return unidad.getPosX();
		}
		
		@Override
		public int getPosY() {//O(1)
			return unidad.getPosY();
		}
		
		@Override
		public int getDistanciaMin() {//O(1)
			return unidad.getDistanciaMin();
		}
		
		@Override
		public int getDistanciaMax() {//O(1)
			return unidad.getDistanciaMax();
		}

}
