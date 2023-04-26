package conexion;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clasesAux.ClasesAux;

public class Conexion extends ClasesAux {

	private String url;
	private String usuario;
	private String password;
	protected Connection conec = null;

public Conexion() {

	this.url = this.getDriver();
	this.usuario = this.getUser();
	this.password = this.getPass();

	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
  } catch (ClassNotFoundException e) {

		}
	try {

		this.conec = DriverManager.getConnection(url, usuario, password);

   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getPass() {
	// TODO Auto-generated method stub
	return null;
}

	private String getUser() {
	// TODO Auto-generated method stub
	return null;
}

	private String getDriver() {
	// TODO Auto-generated method stub
	return null;
}

	public int guardarDb(String sqlStr) throws SQLException {

		Statement consulta = this.conec.createStatement();
		int cant;
		cant = consulta.executeUpdate(sqlStr);
		return cant;

	}

	public ResultSet consultarDb(String sqlStr) throws SQLException {

		Statement consulta = this.conec.createStatement();
		ResultSet rs = consulta.executeQuery(sqlStr);
		// this.conec.close();
		return rs;

	}

	public void cerrarConexion() {

		try {
			this.conec.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}