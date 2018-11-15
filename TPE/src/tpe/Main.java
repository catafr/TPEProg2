package tpe;
import java.util.Iterator;

import tpe.comparador.pelicula.CPopulares;
import tpe.comparador.pelicula.CPtjePromedio;
import tpe.comparador.pelicula.Comparador;
import tpe.criterio.busqueda.CActor;
import tpe.criterio.busqueda.CAnioMayor;
import tpe.criterio.busqueda.CCompuesto;
import tpe.criterio.busqueda.CCompuestoAND;
import tpe.criterio.busqueda.CCompuestoOR;
import tpe.criterio.busqueda.CDirector;
import tpe.criterio.busqueda.CGenero;
import tpe.criterio.busqueda.Criterio;
import tpe.entidad.Cliente;
import tpe.entidad.Grupo;
import tpe.entidad.Pelicula;
import tpe.entidad.Sistema;
import tpe.entidad.Usuario;
import tpe.filtro.pelicula.FGenero;
import tpe.filtro.pelicula.FGeneros;
import tpe.filtro.pelicula.Filtro;


public class Main {

	public static void peliculaVistaCliente(Cliente c){
		Iterator<Pelicula> iteradorPelicula = c.getPeliculasVistas();
		while (iteradorPelicula.hasNext()){
			System.out.println(iteradorPelicula.next().toString());
		}
	}
	
	@SuppressWarnings("nls")
	public static void recomendarK(Sistema s, Filtro f, Comparador c, int k ){
		s.setFiltro(f);
		s.setComparador(c);
		Iterator<Cliente> iteradorClientes = s.getClientes();	
		while (iteradorClientes.hasNext()){
			Cliente cliente =iteradorClientes.next();
			Iterator<Pelicula> iteradorPelicula=s.recomendar(cliente);
			int contador=0;
			System.out.print("Recomendar a "+cliente.getNombre()+": ");  
			while (iteradorPelicula.hasNext()&&contador<k){
				contador+=1;
				System.out.print(contador+") ");System.out.print(iteradorPelicula.next().toString());System.out.print(" ");  
			}
			System.out.println();
		}
	}
	
	public static void buscar(Sistema s, Criterio c){
		s.setCriterio(c);
		Iterator<Pelicula> iteradorPelicula= s.buscar();
		while (iteradorPelicula.hasNext()){
			System.out.println(iteradorPelicula.next().toString());
		}
	}
	
@SuppressWarnings("nls")
public static void main (String[] args){
	
		final int CANT_RECOMENDACION1=2;
		final int CANT_RECOMENDACION2=5;
		Sistema sistema = new Sistema();
		
		//Peliculas
		Pelicula up = new Pelicula("Up : una aventura de altura", 
				"Carl Fredricksen es un vendedor de globos de 78 anios de edad...", 
				2.00,2009);
		up.addGenero("Infantil"); 
		up.addGenero("Acción"); 
		up.addGenero("Drama"); 
		up.addDirector("Pete Docter"); 
		up.addDirector("Bob Peterson"); 
		up.addActor("Pete Docter");
		up.addActor("Ed Asner");
		up.addActor("Bob Peterson");
		up.addActor("Jordan Nagai");
		sistema.addPelicula(up);
		
		Pelicula losSimpsons = new Pelicula("Los Simpson: la película", 
				"La combinación de Homero (Dan Castellaneta), su nuevo puerco mascota, y un silo...", 
				1.00,2007);
		losSimpsons.addGenero("Romantico");
		losSimpsons.addGenero("Musical");
		losSimpsons.addGenero("Infantil");
		losSimpsons.addGenero("Aventura");
		losSimpsons.addGenero("Comedia");
		losSimpsons.addDirector("David Silverman");
		losSimpsons.addActor("Dan Castellaneta");
		losSimpsons.addActor("Harry Shearer");
		losSimpsons.addActor("Julie Kavner");
		sistema.addPelicula(losSimpsons);
		
		Pelicula losIncreibles = new Pelicula("Los Increibles", 
				"Un súper héroe retirado lucha contra el aburrimiento en un suburbio y junto con su...", 
				1.30,2004);
		losIncreibles.addGenero("Acción");
		losIncreibles.addGenero("Musical");
		losIncreibles.addGenero("Infantil");
		losIncreibles.addGenero("Aventura");
		losIncreibles.addDirector("Brad Bird");
		losIncreibles.addActor("Brad Bird");
		losIncreibles.addActor("Craig T. Nelson");
		losIncreibles.addActor("Holly Hunter");
		sistema.addPelicula(losIncreibles);
		
		Pelicula losIncreibles2 = new Pelicula("Los Increibles 2", 
				"Helen entra en acción y debe luchar contra un cibercriminal que planea hipnotizar el...", 
				1.45,2018);
		losIncreibles2.addGenero("Acción");
		losIncreibles2.addGenero("Musical");
		losIncreibles2.addGenero("Infantil");
		losIncreibles2.addGenero("Aventura");
		losIncreibles2.addDirector("Brad Bird");
		losIncreibles2.addActor("Brad Bird");
		losIncreibles2.addActor("Craig T. Nelson");
		losIncreibles2.addActor("Holly Hunter");
		sistema.addPelicula(losIncreibles2);
		
		Pelicula toyStory = new Pelicula ("Toy Story", 
				"Lo mejor de la animación computarizada produce esta historia sobre juguetes que...", 
				1.15,1995);
		toyStory.addGenero("Acción");
		toyStory.addGenero("Infantil");
		toyStory.addGenero("Aventura");
		toyStory.addDirector("John Lasseter");
		toyStory.addActor("Tim Allen");
		toyStory.addActor("Tom Hanks");
		toyStory.addActor("Don Rickles");
		toyStory.addActor("Wallace Shawn");
		sistema.addPelicula(toyStory);
		
		Pelicula monsterInc = new Pelicula("Monsters Inc.", 
				"Monsters, Incorporated es la fábrica de sustos más grande en el mundo de los...", 
				1.45,2001);
		monsterInc.addGenero("Acción");
		monsterInc.addGenero("Infantil");
		monsterInc.addGenero("Aventura");
		monsterInc.addDirector("Pete Docter");
		monsterInc.addActor("John Goodman");
		monsterInc.addActor("Billy Crystal");
		monsterInc.addActor("John Ratzenberger");	
		sistema.addPelicula(monsterInc);
		
		//Usuarios y sus generos
		Cliente lisa = new Usuario("Lisa"); 
		((Usuario) lisa).addGeneroPreferido("Romántico"); 
		((Usuario) lisa).addGeneroPreferido("Musical"); 
		((Usuario) lisa).addGeneroPreferido("Infantil"); 
		((Usuario) lisa).addGeneroPreferido("Aventura"); 
		Cliente bart = new Usuario("Bart"); 
		((Usuario) bart).addGeneroPreferido("Musical"); 
		((Usuario) bart).addGeneroPreferido("Infantil"); 
		((Usuario) bart).addGeneroPreferido("Aventura"); 
		((Usuario) bart).addGeneroPreferido("Acción"); 
		Cliente maggie = new Usuario("Maggie"); 
		((Usuario) maggie).addGeneroPreferido("Musical"); 
		((Usuario) maggie).addGeneroPreferido("Infantil"); 
		((Usuario) maggie).addGeneroPreferido("Aventura"); 
		Cliente marge = new Usuario("Marge"); 
		((Usuario) marge).addGeneroPreferido("Romántico"); 
		((Usuario) marge).addGeneroPreferido("Musical"); 
		((Usuario) marge).addGeneroPreferido("Infantil"); 
		((Usuario) marge).addGeneroPreferido("Aventura"); 
		Cliente homero = new Usuario("Homero"); 
		((Usuario) homero).addGeneroPreferido("Musical"); 
		((Usuario) homero).addGeneroPreferido("Infantil"); 
		((Usuario) homero).addGeneroPreferido("Acción"); 
		sistema.addCliente(lisa);
		sistema.addCliente(bart);
		sistema.addCliente(maggie);
		sistema.addCliente(marge);
		sistema.addCliente(homero);
		Cliente hermanosSimpson = new Grupo("Hermanos Simpson"); 
		Cliente hombresSimpson = new Grupo("Hombres Simpson"); 
		Cliente familiaSimpson = new Grupo("Familia Simpson"); 
		((Grupo) hermanosSimpson).addCliente(bart);
		((Grupo) hermanosSimpson).addCliente(lisa);
		((Grupo) hermanosSimpson).addCliente(maggie);
		((Grupo) hombresSimpson).addCliente(bart);
		((Grupo) hombresSimpson).addCliente(homero);
		((Grupo) familiaSimpson).addCliente(hermanosSimpson);
		((Grupo) familiaSimpson).addCliente(marge);
		((Grupo) familiaSimpson).addCliente(homero);
		sistema.addCliente(hermanosSimpson);
		sistema.addCliente(hombresSimpson);
		sistema.addCliente(familiaSimpson);
	
		//Valoraciones
		marge.verPelicula(losIncreibles, 2);
		homero.verPelicula(losIncreibles,4);
		bart.verPelicula(losIncreibles,2);
		lisa.verPelicula(losIncreibles,5);
		marge.verPelicula(losIncreibles2,5);
		maggie.verPelicula(toyStory,1);	
		
		//1. Listar las películas vistas por Marge
		System.out.println("Peliculas vistas Marge:"); 
		peliculaVistaCliente(marge);
		
		//2. Listar las películas vistas por Bart
		System.out.println();
		System.out.println("Peliculas vistas Bart:");
		peliculaVistaCliente(bart);
		
		//3.
		System.out.println();
		System.out.println("Dos peliculas con todos los generos preferidos, ordenadas descedentemente por popularidad"); 
		System.out.println();
		Filtro filtro = new FGeneros();
		Comparador comparador = new CPopulares();
		recomendarK(sistema, filtro, comparador, CANT_RECOMENDACION1);
		
		//4.
		System.out.println();
		System.out.println("Cinco peliculas con algun genero preferido, ordenadas descendetemente por puntaje promedio"); 
		System.out.println();		
		recomendarK(sistema, filtro= new FGenero(), comparador= new CPtjePromedio(), CANT_RECOMENDACION2);
		
		//5. Incorporar al sistema la información relativa a que los hermanos Simpson vieron la película Up
		//	 y la valoraron grupalmente con 4 granos de café.
		hermanosSimpson.verPelicula(up, 4);
		
		//6. Repetir 2, 3 y 4		
		System.out.println();
		System.out.println("Peliculas vistas Bart:"); 
		peliculaVistaCliente(bart);
		
		System.out.println();
		System.out.println("Dos peliculas con todos los generos preferidos, ordenadas descedentemente por popularidad"); 
		System.out.println();
		recomendarK(sistema, filtro= new FGeneros(), comparador=new CPopulares(), CANT_RECOMENDACION1);
		
		System.out.println();
		System.out.println("Cinco peliculas con algun genero preferido, ordenadas descendetemente por puntaje promedio"); 
		System.out.println();	
		recomendarK(sistema, filtro= new FGenero(), comparador= new CPtjePromedio(), CANT_RECOMENDACION2);
		
		//7. Realizar búsquedas
		
		System.out.println();
		System.out.println("Películas en las que Pete Docter haya actuado y sido director al mismo tiempo:"); 
		CCompuesto ccompuesto= new CCompuestoAND();
		Criterio criterio1= new CActor("Pete Docter"); 
		Criterio criterio2= new CDirector("Pete Docter"); 
		ccompuesto.addCriterio( criterio1);
		ccompuesto.addCriterio(criterio2);
		buscar(sistema,ccompuesto);
		
		System.out.println();
		System.out.println("Películas en las que haya actuado Tom Hanks: "); 
		ccompuesto.clearCriterios(); 
		ccompuesto.addCriterio(criterio1=new CActor("Tom Hanks"));
		buscar(sistema,ccompuesto);
		
		System.out.println();
		System.out.println("Películas estrenadas a partir del anio 2000: "); 
		ccompuesto.clearCriterios();
		ccompuesto.addCriterio(criterio1=new CAnioMayor(2000));
		buscar(sistema,ccompuesto);
		
		System.out.println();
		System.out.println("Películas con género romántico, comedia, o drama: "); 
		ccompuesto=new CCompuestoOR();	
		Criterio criterio3=new CGenero("Comedia"); 
		ccompuesto.addCriterio(criterio1=new CGenero("Romántico"));
		ccompuesto.addCriterio(criterio2=new CGenero("Drama"));
		ccompuesto.addCriterio(criterio3);
		buscar(sistema,ccompuesto);	
	}		
}
