package tpe.entidad;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import tpe.comparador.pelicula.Comparador;
import tpe.criterio.busqueda.Criterio;
import tpe.filtro.pelicula.Filtro;

// El sistema permite gestionar las películas que vio un usuario, y los datos particulares de los usuarios.

public class Sistema {
	
	private Vector<Cliente> clientes;
	private Vector<Pelicula> peliculas;
	private Filtro filtro;
	private Comparador comparador;
	private Criterio criterio;
	
	public Sistema(){
		this.clientes=new Vector<Cliente>();
		this.peliculas=new Vector<Pelicula>();
	}

	public void setFiltro(Filtro f){
		this.filtro=f;
	}
	
	public void setCriterio(Criterio c) {
		this.criterio = c;
	}
	
	public void setComparador(Comparador c){
		this.comparador=c;
	}
	
	public void addCliente(Cliente c){
		this.clientes.add(c);
	}
	
	public void addPelicula(Pelicula p){
		this.peliculas.add(p);
	}
	
	public Iterator<Pelicula> buscar(){
	//El sistema permite realizar búsquedas de películas que satisfagan un determinado criterio
		Vector<Pelicula> v = new Vector<Pelicula>();
		for(Pelicula p : this.peliculas){
			if (this.criterio.acepta(p))
				v.add(p);
		}
		return v.iterator();
	}
	
	public Iterator<Cliente> getClientes(){
		return this.clientes.iterator();
	}
	
	public Iterator<Pelicula> recomendar(Cliente c){
	//Obtener una recomendación para un usuario individual o un grupo de usuarios.
		Vector<Pelicula> salida = new Vector<Pelicula>();
		for (Pelicula p : this.peliculas){
			if((c.aceptaPelicula(p))
					&&(this.filtro.acepta(c,p)))
				salida.add(p);
		}
		Collections.sort(salida, this.comparador.reversed());
		return salida.iterator();
	}
	
}


