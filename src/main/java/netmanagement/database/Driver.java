package netmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import netmanagement.Main;

public class Driver extends Main {
	private Connection connection;
	
	/**
	 * Esta clase permite hacer uso del objeto {@link Connection} connection con el que ejecutar consultas a base de datos
	 * @throws SQLException
	 */
	public Driver() throws SQLException, Exception {
		String
			DBUrl = properties.getProperty("DB_URL"),
			DBPort = properties.getProperty("DB_PORT"),
			DBName = properties.getProperty("DB_NAME"),
			DBUsr = properties.getProperty("DB_USR"),
			DBPwd = properties.getProperty("DB_PWD");
		
		if(DBUrl == null || DBUrl.isEmpty()) { throw new Exception("La URL de conexion a la base de datos es nula o esta vacia"); }
		else if(DBPort == null || DBPort.isEmpty()) { throw new Exception("El puerto de conexion a la base de datos es nulo o esta vacio"); }
		else if(DBName == null || DBName.isEmpty()) { throw new Exception("El nombre de la base de datos es nulo o esta vacio"); }
		else if(DBUsr == null || DBUsr.isEmpty()) { throw new Exception("El usuaio de conexion a la base de datos es nulo o esta vacio"); }
		else if(DBPwd == null || DBPwd.isEmpty()) { throw new Exception("La contraseña de conexion a la base de datos es nula o esta vacia"); }
		else this.connection = DriverManager.getConnection("jdbc:mysql://"+DBUrl+":"+DBPort+"/"+DBName,DBUsr,DBPwd);
	}
	
	/**
	 * Ejectua consultas de tipo SELECT
	 * @param query
	 * @return Resultado de la consulta
	 * @throws SQLException
	 */
	public ResultSet select(String query) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.executeQuery(query);
	}
	
	/**
	 * Ejecuta consultas que modifican la BBDD, de tipo INSERT, UPDATE, DELETE, CREATE o ALTER
	 * @param query
	 * @return Numero de filas afectadas
	 * @throws SQLException
	 */
	public int manipulate(String query) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.executeUpdate(query);
	}
	
	/**
	 * Cierra la conexión con BBDD
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		this.connection.close();
	}
}
