package fase;
import java.util.ArrayList;



	public class Fase extends Datos{
	    private int numeroFase;
		private String nombreFase;
	    private ArrayList<Ronda> rondas;


	public Fase(int numeroFase){
		this.rondas = new ArrayList<Ronda>();
		this.numeroFase = numeroFase;
	}
	public Fase(int numeroFase,String nombreFase){
		this.rondas = new ArrayList<Ronda>();
		this.numeroFase = numeroFase;
		this.nombreFase = nombreFase;
	}


	public String getNombreFase() {
		return nombreFase;
	}
	public ArrayList<Ronda> getRondas() {
		return rondas;
	}


	public void setRondas(ArrayList<Ronda> rondas) {
		this.rondas = rondas;
	}


	public void puntosFase(ArrayList<Participante> part) {
		
		int totalPartidosFase = 0;
		System.out.println("");
		System.out.println("FASE " + this.nombreFase);
		System.out.println("");
		
		
		for (Ronda r : this.rondas) {
			
			totalPartidosFase += r.totalPartidos(this.numeroFase);
		}
		
		
		  for (Ronda ron : rondas) {
		        
		        ron.puntos(part, this.numeroFase-1);
		        	
		        
		        }
		
		
		System.out.println("TOTAL PARTIDOS DE LA FASE: " + totalPartidosFase);
		System.out.println("");
		
		for (Participante p : part) {
			
				int acertados = 0;
			   	
				for (Pronostico pron : p.getPronostico()) {
				  if (pron.getFaseNro() == this.numeroFase-1) {
				  acertados += pron.acertado();
				  
				  }
				  
				}
			 
				//System.out.println(acertados);
			   	
				if (acertados == totalPartidosFase) {
				 
					p.guardarPuntosTotal(Integer.parseInt(this.getPuntosfase()));
				 
					System.out.println(p.getNombre() + " SUMA " + this.getPuntosfase() + " POR ACERTAR TODOS LOS PARTIDOS DE LA FASE: " +this.nombreFase + " - " + "PUNTOS TOTALES: " + p.getPuntosTotal() );
				}
				
				else {
					System.out.println(p.getNombre() + " - PUNTOS TOTALES:  " + p.getPuntosTotal() );
				}
			  
		  }
		
		
		
		
		
		
	}


		
	}
}
