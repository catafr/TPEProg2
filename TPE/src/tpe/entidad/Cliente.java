package tpe.entidad;
import java.util.Iterator;
import java.util.Vector;

public abstract class Cliente {
	
	protected String nombre;
	protected Vector<Valoracion> valoraciones;
	
	protected Cliente(String n){
		this.nombre = n;
		this.valoraciones=new Vector<Valoracion>();
	}
	
	public abstract void verPelicula(Pelicula p, int x);
	
	public abstract Vector<String> getGenerosPreferidos();

	public abstract boolean aceptaPelicula(Pelicula p);
	
	public Iterator<Pelicula> getPeliculasVistas(){
	//Devuelve las peliculas que vio el cliente en un iterador
		Vector<Pelicula> salida = new Vector<Pelicula>();
		for(Valoracion v : this.valoraciones){
				salida.add(v.getPelicula());
		}
		return salida.iterator();		
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
