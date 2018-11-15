package tpe.entidad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

//	De cada película se almacena: Título, sinopsis, lista de actores protagónicos, lista de
//	directores, duración, lista de categorías y año de estreno (Comedia, Romance, Drama, Crímen,etc).

public class Pelicula {
	
	private final static int PORCENTAJE=100;
	private final static int MAXVALORACION=5;
	private HashMap<Cliente,Valoracion> valoraciones;
	private String titulo;
	private String sinopsis;
	private double duracion;
	private int anio;
	private Vector<String> directores;
	private Vector<String> actores;
	private Vector<String> generos;
	
	public Pelicula(String t, String s, double d, int a ){
		this.titulo=t;
		this.sinopsis=s;
		this.duracion=d;
		this.anio=a;
		this.actores = new Vector<String>();
		this.directores=new Vector<String>();
		this.generos=new Vector<String>();	
		this.valoraciones = new HashMap<Cliente,Valoracion>();
	}
	
	public int sumaValoraciones(){
	//Suma la cantidad de valoraciones recibidas  
		int suma=0;
		Iterator<Cliente> iteradorValoracion = this.valoraciones.keySet().iterator();
		while (iteradorValoracion.hasNext()){
			suma+=this.valoraciones.get(iteradorValoracion.next()).getValor();
		}
		return suma; 
	}

	public double promValoraciones(){
	//Puntaje promedio recibido
		if (cantValoraciones()==0)
			return 0;
		else
			return (sumaValoraciones()/(double)cantValoraciones()*PORCENTAJE)/MAXVALORACION;
	}
		
	public boolean tieneGenero(String e){
		return this.generos.contains(e);
	}
	
	public boolean tieneActor(String e){
		return this.actores.contains(e);
	}
	
	public boolean tieneDirector(String e){
		return this.directores.contains(e);
	}
	
	public int cantValoraciones(){
		return this.valoraciones.size();
	}
	
	public void guardarValoracion(Valoracion v){
		this.valoraciones.put(v.getCliente(), v);
	}
	
	public boolean equals(Object o){
		return (this.getTitulo().equals(((Pelicula) o).getTitulo()));
	}
	
	@Override
	public String toString() {
		return  this.titulo ;
	}
	
	public void addActor(String s){
		this.actores.add(s);
	}	
	
	public void addDirector(String s){
		this.directores.add(s);
	}
	
	public Vector<String> getGeneros(){
		return new Vector<String>(this.generos);
	}
	
	public void addGenero(String e){
		this.generos.add(e);
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getSinopsis() {
		return this.sinopsis;
	}
	
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	public double getDuracion() {
		return this.duracion;
	}
	
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	public int getAnio() {
		return this.anio;
	}
	
	public void setAnio(int a) {
		this.anio = a;
	}
	
}
