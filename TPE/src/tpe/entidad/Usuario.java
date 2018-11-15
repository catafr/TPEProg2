package tpe.entidad;
import java.util.Vector;

//	De los usuarios se almacena su nombre, edad y lista de géneros preferidos.

public class Usuario extends Cliente {

	private int edad;
	private Vector<String> generosPreferidos;
	
	public Usuario(String n) {
		super(n);
		this.generosPreferidos=new Vector<String>();
	}

	@Override
	public void verPelicula(Pelicula p, int x) {
	//Al ver una pelicula se guarda una valoracion en el usuario y en la pelicula;
		Valoracion v = new Valoracion(this,p,x);
		this.valoraciones.add(v);
		p.guardarValoracion(v);
	}
	
	public boolean aceptaPelicula(Pelicula p){
	// retorna 	true si no vio la pelicula
		for (Valoracion v : this.valoraciones){
			if (v.getPelicula().equals(p))
				return false;
		}
		return true;
	}
	
	@Override
	public Vector<String> getGenerosPreferidos() {
		return new Vector<String>(this.generosPreferidos);
	}
	
	public void addGeneroPreferido(String e){
		this.generosPreferidos.add(e);
	}
	
	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
