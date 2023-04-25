package conexion;
import java.sql.*;
public class Conexion {
	
	class MysqlCon{ 
	public void main(String args[]){ 
	try{ 
	   Class.forName("com.mysql.jdbc.Driver"); 
	
	   String url     ="jdbc:mysql://localhost:3306/qtar";
	   String user    ="root";
	   String password= " "; 
	   //crear objeto de conexion
	Connection con=DriverManager.getConnection(url,user,password); 
	
	Statement stmt=con.createStatement();// crea sentencia
	ResultSet rs= stmt.executeQuery("seltec * from equipo"); // ejecuta consulta
	while(rs.next())
	System.out.println(rs.getInt(1)+" "+rs.getInt(2));
	con.close(); //cerrar conexion
	} catch(Exception e){ System.out.println(e);} 
	} 
	}
}
	
