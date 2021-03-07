package Data;

import java.sql.*;

public class FactoryConexion {
	
	private static FactoryConexion instancia;
	
	private String driver   = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private int conectados=0;
	private Connection conn= null;
	
	private FactoryConexion() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FactoryConexion getInstancia() {
		if (instancia == null) {
			instancia = new FactoryConexion();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:sqlserver://den1.mssql8.gear.host;databaseName=academia7;user=academia7;password=Bp6M7~rP?J5G;socketTimeout=120");
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
