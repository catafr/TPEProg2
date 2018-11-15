package tpe.filtro.pelicula;
import java.util.Vector;

import tpe.entidad.Cliente;
import tpe.entidad.Pelicula;

public class FGenero implements Filtro {

	@Override
	public boolean acepta(Cliente c, Pelicula p) {
	// Devuelve true si la pelicula tiene al menos un genero preferido
		Vector<String> v = c.getGenerosPreferidos();
		for (String e : v){
			if (p.tieneGenero(e))
				return true;
		}
		return false;
	}

}
