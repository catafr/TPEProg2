package tpe.criterio.busqueda;

import tpe.entidad.Pelicula;

public class CCompuestoAND extends CCompuesto{
	
	@Override
	public boolean acepta(Pelicula p) {
		for(Criterio c : this.criterios){
			if (!c.acepta(p))
				return false;
		}
		return true;
	}

}
