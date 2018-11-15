package tpe.criterio.busqueda;

import tpe.entidad.Pelicula;

public class CGenero implements Criterio{

	private String genero;
	
	public CGenero(String e){
		this.genero=e;
	}
	
	@Override
	public boolean acepta(Pelicula p) {
		return p.tieneGenero(this.genero);
	}

}
