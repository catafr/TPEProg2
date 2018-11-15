package tpe.criterio.busqueda;

import tpe.entidad.Pelicula;

public class CDirector implements Criterio{

	private String director;
	
	public CDirector(String e){
		this.director=e;
	}
	
	@Override
	public boolean acepta(Pelicula p) {
		return p.tieneDirector(this.director);
	}

}
