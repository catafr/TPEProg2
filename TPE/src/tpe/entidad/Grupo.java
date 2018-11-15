package tpe.entidad;
import java.util.HashSet;
import java.util.Vector;

public class Grupo extends Cliente {
	
	private Vector<Cliente> clientes;

	public Grupo(String n) {
		super(n);
		this.clientes=new Vector<Cliente>();
	}
	
	public void addCliente(Cliente c){
		this.clientes.add(c);
	}

	@Override
	public void verPelicula(Pelicula p, int x) {
		Valoracion v = new Valoracion(this,p,x);
		p.guardarValoracion(v);
		this.valoraciones.add(v);
		for(Cliente c : this.clientes){
			c.verPelicula(p,x);
		}
	}
	
	@Override
	public Vector<String> getGenerosPreferidos() {
	//Los géneros preferidos de un grupo se calculan cómo la unión de todos los géneros de sus integrantes (sin repetidos).
		HashSet<String> salida = new HashSet<String>();
		for (Cliente c : this.clientes){
			salida.addAll(c.getGenerosPreferidos());
		}
		return new Vector<String>(salida);
	}
	
	public Vector<Cliente> getClientes() {
		return new Vector<Cliente>(this.clientes);
	}

	public void setClientes(Vector<Cliente> v) {
		this.clientes = new Vector<Cliente>(v);
	}

	@Override
	public boolean aceptaPelicula(Pelicula p) {
	// retorna true si todos los usuarios del grupo no vieron la pelicula	
		for (Cliente c : this.clientes){
			if (!c.aceptaPelicula(p))
				return false;
		}
		return true;	
	}

}