package tpe.criterio.busqueda;

import tpe.entidad.Pelicula;

public interface Criterio {

	public boolean acepta(Pelicula p);
}
