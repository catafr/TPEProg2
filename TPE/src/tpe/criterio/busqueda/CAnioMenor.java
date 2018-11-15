package tpe.criterio.busqueda;

import tpe.entidad.Pelicula;

public class CAnioMenor implements Criterio{

	private int anio;
	
	public CAnioMenor(int x){
		this.anio=x;
	}
	
	@Override
	public boolean acepta(Pelicula p) {
		return (p.getAnio()<this.anio);
	}
}
