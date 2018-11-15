package tpe.comparador.pelicula;

import tpe.entidad.Pelicula;

public class CPopulares implements Comparador{

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
	//Compara peliculas segun la popularidad(cantValoraciones)	
		return ((Integer)p1.cantValoraciones()).compareTo((Integer)p2.cantValoraciones());
	}

}
