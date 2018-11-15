package tpe.filtro.pelicula;

import tpe.entidad.Cliente;
import tpe.entidad.Pelicula;

public interface Filtro {

	public boolean acepta(Cliente c, Pelicula p);

}
