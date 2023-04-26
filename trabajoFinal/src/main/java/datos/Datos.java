package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Datos {
 private String driver;
 private String ip;
 private String port;
 private String database;
 private String user;
 private String pass;
 private String puntosacertado;
 private String puntosronda;
 private String puntosfase;
 
 
public Datos() {
	
    Path archivoCfg = Paths.get("config.conf");
    
    try {
		for (String cadena : Files.readAllLines(archivoCfg)) {
			  
			  String separa[] = cadena.split("=");
			  			 
			  switch (separa[0]){
                     
			  case "DRIVER": 
                  this.driver = separa[1];
			  case "IP":
			      this.ip = separa[1];
			  case "PORT": 
                  this.port = separa[1];
			  case "DATABASE":
			      this.database = separa[1];
			  case "USUARIO": 
                  this.user = separa[1];
			  case "PASSWORD":
			      this.pass = separa[1];
			  case "PUNTOSACERTADO":
				  this.puntosacertado = separa[1]; 
			  case "PUNTOSRONDA":
				  this.puntosronda = separa[1];
			  case "PUNTOSFASE":  
				  this.puntosfase = separa[1];
			      
			  
			  }
			  
		}
		
    
    }	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public String getDriver() {
	return this.driver+this.ip+":"+this.port+"/"+this.database;
}


public String getUser() {
	return user;
}



public String getPass() {
	return pass;
}


public String getPuntosacertado() {
	return puntosacertado;
}


public String getPuntosronda() {
	return puntosronda;
}


public String getPuntosfase() {
	return puntosfase;
}






 
}
