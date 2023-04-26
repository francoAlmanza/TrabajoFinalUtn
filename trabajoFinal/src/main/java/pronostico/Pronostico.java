package pronostico;

import datos.Datos;
import equipo.Equipo;
import partido.Partido;
import resultado.Resultado;

public class Pronostico extends Datos {
		private int faseNro;
		private int rondaNro;
		private Partido partido;
		private Equipo equipo;
		private Resultado resultado;
	    
		
		public Pronostico() {}

		public Pronostico(int fase,int rondaNro,Partido partido, Equipo equipo, Resultado resultado) {
			
			this.partido = partido;
			this.equipo = equipo;
			this.resultado = resultado;
	        this.rondaNro = rondaNro;
		    this.faseNro = fase;
		}

	    public String verEquipPron() {
	    	    	
	    	return "PARTIDO PRONOSTICO " +partido.verequipos()+ " " + this.equipo.getid() + " "+resultado +" PARTIDO RESULTADO " +  partido.verPartido();
	   
	    }

	        
	    public int getRondaNro() {
			
	    	return rondaNro;
		
	    }

	    
	    
		public int getFaseNro() {
			return faseNro;
		}

		public void setFaseNro(int faseNro) {
			this.faseNro = faseNro;
		}

		public int acertado() {
			
			 
			
			if(	this.partido.resultado(this.equipo)  == this.resultado) {
				
				return 1;
				
			}
			else { 
				return 0;
				
			}
			
		}
	   
	    
	    public int puntos() {
	    
			int puntos = 0;
			
			if(	this.partido.resultado(this.equipo)  == this.resultado) {
	    	
				return  Integer.parseInt(this.getPuntosacertado());
	       
			}
			
			else {
	    	
				puntos = 0;
			}		
	    		
			return puntos;	
	   
		}

	}

