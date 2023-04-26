package apostador;

import java.util.ArrayList;

import pronostico.Pronostico;

public class Apostador {
	
	private int id;
	private String nombre;
	private ArrayList<Pronostico> pronostico;
	private int puntosTotal;
	
	public Apostador(int id,String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.pronostico = new ArrayList<Pronostico>();	
	    this.puntosTotal = 0;
	}


	public int getId() {
		return this.id;
	}


	public String getNombre() {
		return this.nombre;
	}
	
		
	public ArrayList<Pronostico> getPronostico() {
		return pronostico;
	}


	public void agregarprono(Pronostico a) {
		
		pronostico.add(a);
		
	}
	

	
	public int getPuntosTotal() {
		return puntosTotal;
	}


	public void guardarPuntosTotal(int puntosTotal) {
		this.puntosTotal += puntosTotal;
	}


	public int puntos() {
		
		 int puntaje = 0;
	    
		 for (Pronostico ju : this.pronostico) {
	        
						 
			 puntaje += ju.puntos();
			     	
	      }
	     
	     return  puntaje;
	  	    
	    }
	
	public void todosPartidos() {
		
		
		    
			 for (Pronostico ju : this.pronostico) {
		        
				
				 System.out.println(ju.verEquipPron());
		     	
		      }
		     
		   
		     
		    
		    }


	public void setId(int id) {
		this.id = id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setPronostico(ArrayList<Pronostico> pronostico) {
		this.pronostico = pronostico;
	}


	public void setPuntosTotal(int puntosTotal) {
		this.puntosTotal = puntosTotal;
	}
	}