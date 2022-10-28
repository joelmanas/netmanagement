package netmanagement.database;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import netmanagement.Main;

public class DbSession extends Main {
	private static Logger LOG = Logger.getLogger(DbSession.class.getName());
	
	private SqlSessionFactory dbSessionFactory;
	private SqlSession dbSession = null;
	
	/**
	 * Esta clase permite hacer uso del objeto {@link Connection} connection con el que ejecutar consultas a base de datos
	 * @throws IOException
	 */
	public DbSession() throws IOException, Exception {
		LOG.info("Abriendo una nueva conexion en base de datos...");
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		if(reader.ready()) {
			this.dbSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}
		this.dbSession = this.dbSessionFactory.openSession();
		LOG.info("Conexion establecida correctamente");
	}
	
	public SqlSession getDbSession() {
		return dbSession;
	}

	public void close() {
		LOG.info("Cerrando conexion con base de datos");
		this.dbSession.close();
		LOG.info("Conexion con base de datos cerrada correctamente");
	}
}
