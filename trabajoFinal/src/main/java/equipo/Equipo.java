package equipo;
import java.sql.SQLException;

import conexion.Conexion;

import java.sql.SQLException;


public class Equipo extends Conexion{
		
	private String id;
	private String nombre;
	private String descripcion;

	    

public Equipo(String id ,String nombre) {
	this.id = id;
    this.nombre = nombre;	
		
		}	

public Equipo(String nombre) {

	this.nombre = nombre;

		
		}	

public String getid() {

	return this.id;
		}
		
		
public void guardarEquipo(String sqlStr) throws SQLException {
			
	
 this.guardarDb(sqlStr);
			
		}
		
		
		
	}
	
}
