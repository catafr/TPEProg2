package tpe.comparador.pelicula;
import java.util.Comparator;

import tpe.entidad.Pelicula;


public interface Comparador extends Comparator<Pelicula>{

	public int compare(Pelicula p1, Pelicula p2);
	
}
