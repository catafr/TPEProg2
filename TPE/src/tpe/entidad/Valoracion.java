package tpe.entidad;

public class Valoracion {
	//peliculas vistas con un valor y el cliente que la vio
	
	private Cliente cliente;
	private Pelicula pelicula;
	private int valor;
	
	public Valoracion(Cliente c, Pelicula p, int x){
		this.cliente=c;
		this.setPelicula(p);
		this.setValor(x);
	}

	public Pelicula getPelicula() {
		return this.pelicula; 
	}
	
	public Cliente getCliente(){
		return this.cliente;
	}

	public void setPelicula(Pelicula p) {
		this.pelicula = p;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
