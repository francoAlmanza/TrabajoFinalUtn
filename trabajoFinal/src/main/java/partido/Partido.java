package partido;
import equipo.Equipo;
import resultado.Resultado;

public class Partido {
		 private int numeroFase;
		 int numeroRonda;
		private Equipo equipo1;
		private Equipo equipo2;
		private int golesEquipo1;
		private int golesEquipo2;
		
		 public Partido(int numeroFase , int numeroRonda ,Equipo equipo1,Equipo equipo2){
			 this.setNumeroFase(numeroFase);
			 this.numeroRonda = numeroRonda;
			 this.equipo1 = equipo1;
			 this.equipo2 = equipo2;
			
			 
		 }
		 public Partido(int numeroFase , int numeroRonda ,Equipo equipo1,Equipo equipo2, int golesEquipo1 , int golesEquipo2 ){
			 this.setNumeroFase(numeroFase);
			 this.numeroRonda = numeroRonda;
			 this.equipo1 = equipo1;
			 this.equipo2 = equipo2;
			 this.golesEquipo1 = golesEquipo1;
			 this.golesEquipo2 = golesEquipo2;
			 
		 }
		
		 
		 public int getGolesEquipo1() {
			return golesEquipo1;
		}
		public void setGolesEquipo1(int golesEquipo1) {
			this.golesEquipo1 = golesEquipo1;
		}
		public int getGolesEquipo2() {
			return golesEquipo2;
		}
		public void setGolesEquipo2(int golesEquipo2) {
			this.golesEquipo2 = golesEquipo2;
		}
		public String verequipos() {
			 
			 return this.equipo1.getid()+ "" + this.equipo2.getid();
			 
		 }
		 
		 public String verPartido() {
			 
			 return " " + this.equipo1.getid()+ "" + this.equipo2.getid() + " GOLES " + this.golesEquipo1 + " " + this.golesEquipo2; 
			 
		 }
		 

	     public Resultado resultado(Equipo a) {
	    	 
	    	 if(this.golesEquipo1 == this.golesEquipo2) { return Resultado.EMPATO;}
	    	 
	    	 if((this.golesEquipo1 >= this.golesEquipo2) && this.equipo1 == a){
	    		 return Resultado.GANO;
	    	 }
	    	 else {
	    		   
	    		 if((this.golesEquipo2 >= this.golesEquipo1) && this.equipo2 == a){
	        		 return Resultado.GANO;
	        	 }
	    		 
	    		 else {
	    			 return Resultado.PERDIO;
	    		 
	    		 }
	    		 
	    		 }
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	
	     }
		public int getNumeroFase() {
			return numeroFase;
		}
		public void setNumeroFase(int numeroFase) {
			this.numeroFase = numeroFase;
		}

	}


