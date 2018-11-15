package tpe.criterio.busqueda;

import tpe.entidad.Pelicula;

public class CAnioIgual implements Criterio{

	private int anio;
	
	public CAnioIgual(int x){
		this.anio=x;
	}
	
	@Override
	public boolean acepta(Pelicula p) {
		return (p.getAnio()==this.anio);
	}

}
