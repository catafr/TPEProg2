package tpe.criterio.busqueda;

import tpe.entidad.Pelicula;

public class CActor implements Criterio{

	private String actor;
	
	public CActor(String e){
		this.actor=e;
	}
	
	@Override
	public boolean acepta(Pelicula p) {
		return p.tieneActor(this.actor);
	}

}
