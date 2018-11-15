package tpe.filtro.pelicula;
import java.util.Vector;

import tpe.entidad.Cliente;
import tpe.entidad.Pelicula;

public class FGeneros implements Filtro{

	@Override
	public boolean acepta(Cliente c, Pelicula p) {
	//Devuelve true si la pelicula tiene todos los generos preferidos
		Vector<String> v = c.getGenerosPreferidos();
		for (String e : v){
			if (!p.tieneGenero(e)){
				return false;
			}
		}
		return true;
	}

}
