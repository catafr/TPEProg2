package tpe.criterio.busqueda;

import tpe.entidad.Pelicula;

public class CAnioMayor implements Criterio{

	private int anio;
	
	public CAnioMayor(int x){
		this.anio=x;
	}
	
	@Override
	public boolean acepta(Pelicula p) {
		return (p.getAnio()>this.anio);
	}
}
