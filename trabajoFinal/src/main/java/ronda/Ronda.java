package ronda;

import java.util.ArrayList;

import apostador.Apostador;
import datos.Datos;
import partido.Partido;
import pronostico.Pronostico;

public class Ronda extends Datos{
		private int numeroFase;
		private int numeroRonda;
	 
	private String nombreRonda;
	private ArrayList<Partido> partidos ;



	public Ronda(int numeroFase,int numeroRonda,String nombreRonda) {
		
		this.numeroRonda = numeroRonda;
		this.numeroFase = numeroFase;
		this.nombreRonda = nombreRonda;
		this.partidos = new ArrayList<Partido>();
		
	}



	public int getNumeroRonda() {
		
		return numeroRonda;

	}



	public void setNumeroRonda(int numeroRonda) {
		
		this.numeroRonda = numeroRonda;

	}



	public ArrayList<Partido> getPartidos() {

		return partidos;

	}



	public void setPartidos(ArrayList<Partido> partidos) {

		this.partidos = partidos;

	}

	public int totalPartidos(int numeroFase) {
		int cont=0;
		
		for (Partido par : partidos) {
		    if (par.getNumeroFase() == this.numeroFase) {
		
			cont++;
		}

		}
	 return cont;
	}



	public void verPartidos() {
		
		
		for (Partido p : partidos) {
			System.out.println(p.toString());
			
		}
	}



	public void puntos(ArrayList<Apostador> part, int numeroFase) {
		
		
		
	    for (Apostador p : part  ) {
	    	  
	    	int sumaPuntosNro = 0;  
	    	int acertados = 0;
	    	
	    	for (Pronostico pron : p.getPronostico()) {
	    		    		  
	    		  if (pron.getRondaNro() == (this.numeroRonda -1 ) && pron.getFaseNro() == numeroFase){
	    			 // System.out.println(pron.verEquipPron());
	    			  sumaPuntosNro += pron.puntos();
	    			  acertados += pron.acertado();   			  
	    		  }
	    	 	  
	    	}
	    		  
	    	if (this.partidos.size() == acertados)  {
	    		
	    		sumaPuntosNro += Integer.parseInt(this.getPuntosronda());
	    	
	    		System.out.println("RONDA "+ this.nombreRonda + " PARTICIPANTE: " + p.getNombre() + " ACERTADOS: "+ acertados + " SUMA " + this.getPuntosronda() + 
	    				" POR ACERTAR TODOS LOS PARTIDOS DE LA RONDA: "+ this.nombreRonda +" PUNTOS: " + sumaPuntosNro );	   
	        	System.out.println("");
	    		p.guardarPuntosTotal(sumaPuntosNro);
	    	}
	    		
	    	else {
	    		System.out.println("RONDA "+ this.nombreRonda+ " PARTICIPANTE: " + p.getNombre() + " ACERTADOS: "+ acertados +" PUNTOS: " + sumaPuntosNro );	   
	    		System.out.println("");
	    		p.guardarPuntosTotal(sumaPuntosNro);
	    		
	    	}
	    	
	    		
	    	
	    	
	    	
	     }
	      
	      System.out.println("TOTAL PARTIDOS DE LA RONDA: " + this.totalPartidos(0));
	      System.out.println("");
	}	


	}


