package tpe.criterio.busqueda;

import java.util.Vector;

public abstract class CCompuesto implements Criterio{

	protected Vector<Criterio> criterios;
	
	protected CCompuesto(){
		this.criterios=new Vector<Criterio>();
	}
	
	public void addCriterio(Criterio c){
		this.criterios.add(c);
	}
	
	public void clearCriterios(){
		this.criterios.clear();
	}

}
