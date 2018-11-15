package tpe.comparador.pelicula;

import tpe.entidad.Pelicula;

public class CPtjePromedio implements Comparador{

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
		return ((Double)p1.promValoraciones()).compareTo((Double)p2.promValoraciones());
	}

}
