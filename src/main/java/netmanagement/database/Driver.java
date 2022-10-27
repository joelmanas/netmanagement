package netmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	private Connection connection;
	
	/**
	 * Esta clase permite hacer uso del objeto {@link Connection} connection con el que ejecutar consultas a BBDD
	 * @throws SQLException
	 */
	public Driver() throws SQLException {
		this.connection =
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/netmanagement","joelm","admin1234");
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
