package clasesAux;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import apostador.Apostador;
import conexion.Conexion;
import equipo.Equipo;
import fase.Fase;
import partido.Partido;

public class ClasesAux {
	public static Equipo buscarEquipo(ArrayList<Equipo> aux, String auxStr) {

		// METODO PARA DEVOLVER OBJETO EQUIPO

		Equipo ret = null;
		for (Equipo a : aux) {

			if (a.getid().equals(auxStr)) {

				ret = a;

			}

		}

		return ret;
	}

	public static Partido buscarPartido(ArrayList<Partido> aux, String auxStr) {

		// METODO PARA DEVOLVER OBJETO EQUIPO

		Partido ret = null;
		for (Partido a : aux) {

			if (a.verequipos().equals(auxStr)) {

				ret = a;

			}

		}

		return ret;
	}

	public static ArrayList<Equipo> cargarEquipos() {

		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		Conexion con = new Conexion();
		ResultSet equipoLista;
		// INICIO CARGO ARRAY LIST DE EQUIPOS DESDE LA BASE DE DATOS
		try {

			equipoLista = con.consultarDb("Select * from Equipos");
			while (equipoLista.next()) {

				equipos.add(new Equipo(equipoLista.getString(1), equipoLista.getString(2)));

			}

			return equipos;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		// FIN CARGO ARRAY LIST DE EQUIPOS DESDE LA BASE DE DATOS

	}

	public static ArrayList<Apostador> cargaParticipante() {
		ArrayList<Apostador> participantes = new ArrayList<Apostador>();
		Conexion con = new Conexion();
		ResultSet cargaParticipante;

		try {

			cargaParticipante = con.consultarDb("Select * from Participantes");

			while (cargaParticipante.next()) {

				participantes.add(new Apostador ((cargaParticipante.getInt(1)), cargaParticipante.getString(2)));

			}
			return participantes;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		// FIN CARGO ARRAY LIST DE PARTICIPANTES DESDE LA BASE DE DATOS

	}

	public static ArrayList<Fase> cargaFasesDb(){
		
		ArrayList<Fase> fases = new ArrayList<Fase>();
		Conexion con = new Conexion();
		ResultSet cargaFase;
       
		try {

			cargaFase = con.consultarDb("Select * from fases");
			while (cargaFase.next()) {

				
					fases.add(new Fase(cargaFase.getInt(1),cargaFase.getString(2)));
				
				
			}
			return fases;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
			
	}
 public static void cargaRondasDb(ArrayList<Fase> fases){
		
		Conexion con = new Conexion();
		ResultSet cargaRonda;
       
		try {

			cargaRonda = con.consultarDb("Select * from rondas");
			while (cargaRonda.next()) {

			 fases.get(cargaRonda.getInt(1)-1).getRondas().add(new Ronda(cargaRonda.getInt(1),cargaRonda.getInt(2),cargaRonda.getString(3)));
							
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
			
		}
			
	}

	public static void cargaPartidosDb(ArrayList<Fase> fases, ArrayList<Equipo> equipos) {

		Conexion con = new Conexion();
		ResultSet cargaPartidos;

		try {

			cargaPartidos = con.consultarDb("Select * from Partidos");
			while (cargaPartidos.next()) {

				fases.get(cargaPartidos.getInt(2) - 1).getRondas().get(cargaPartidos.getInt(3) - 1).getPartidos()
						.add(new Partido(cargaPartidos.getInt(2), cargaPartidos.getInt(3),
								buscarEquipo(equipos, cargaPartidos.getString(4)),
								buscarEquipo(equipos, cargaPartidos.getString(5))));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static boolean validaArch(String arch) {

		return (arch != null) && (arch.length() >= 4);

	}	
	public static String validaArgs(String arch[]) {
          if (arch.length== 0) {
        	  return "";
          }
          else return arch[0];

	}
	
	public static void actResultadosArch(ArrayList<Fase> fases, String ubicacion){

		Path resultadosDef = Paths.get("resultado.txt");
		Path resultadoUsuario = Paths.get(ubicacion);
		String parte[];
		if (validaArch(ubicacion) ) {

			try {
				for (String auxSplit : Files.readAllLines(resultadoUsuario)) {
					parte = auxSplit.split(",");

					buscarPartido(fases.get(Integer.parseInt(parte[0])-1).getRondas().get(Integer.parseInt(parte[1])-1).getPartidos(),(parte[2] + parte[3])).setGolesEquipo1(Integer.parseInt(parte[4]));
					buscarPartido(fases.get(Integer.parseInt(parte[0])-1).getRondas().get(Integer.parseInt(parte[1])-1).getPartidos(),(parte[2] + parte[3])).setGolesEquipo2(Integer.parseInt(parte[5]));
				   

				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}

		}
		else { 
			System.out.println("SE UTILIZA ARCHIVO RESULTADOS DEFAULT - ARCHIVO NO ENVIADO O NOMBRE DEMASIDO CORTO");
			try {
				for (String auxSplit : Files.readAllLines(resultadosDef)) {
					parte = auxSplit.split(",");

				
					buscarPartido(fases.get(Integer.parseInt(parte[0])-1).getRondas().get(Integer.parseInt(parte[1])-1).getPartidos(),(parte[2] + parte[3])).setGolesEquipo1(Integer.parseInt(parte[4]));
					buscarPartido(fases.get(Integer.parseInt(parte[0])-1).getRondas().get(Integer.parseInt(parte[1])-1).getPartidos(),(parte[2] + parte[3])).setGolesEquipo2(Integer.parseInt(parte[5]));
				    
				    

				}
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        
	}
	
	public static void cargaPronoPart(ArrayList<Fase> fases,ArrayList<Equipo> equipos,ArrayList<Participante> participantes) {
		
		Conexion con = new Conexion();
		ResultSet cargaParticipante;
		
		//INICIO CARGO ARRAY LIST DE PRONOSTICO DESDE LA BASE DE DATOS
        try {
		
        	cargaParticipante = con.consultarDb("Select * from pronostico");
	    
        	while (cargaParticipante.next()) {
	    	
	     	participantes.get(cargaParticipante.getInt(4)).agregarprono(new Pronostico(cargaParticipante.getInt(2),cargaParticipante.getInt(3) ,buscarPartido(fases.get(cargaParticipante.getInt(2)).getRondas().get(cargaParticipante.getInt(3)).getPartidos(),cargaParticipante.getString(5)),buscarEquipo(equipos,cargaParticipante.getString(6)),ResultadoEnum.valueOf(cargaParticipante.getString(7))));	
	    	          	
	   
        	} 
			
       }catch (SQLException e) {
		
		e.printStackTrace();
	   }
       
      //FIN CARGO ARRAY LIST DE PRONOSTICO DESDE LA BASE DE DATOS
		
	}









}
