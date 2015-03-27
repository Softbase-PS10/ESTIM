/*
 * GRUPO 10 - SOFTBASE
 * 		Alberto Blasco, Diego Galvez, Patricia Lazaro, Alejandro Marquez, 
 * 		Alejandro Royo, Jaime Ruiz-Borau
 * 
 * Summary: objeto que representa la conexion con la base de datos de Oracle
 */

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorDeConexiones {

	/* declaracion de atributos */
	private static String db_driver = "jdbc:oracle:thin:@hendrix-oracle.cps.unizar.es:1521:vicious";
	private static String db_username = "";
	private static String db_password = "";

	/* declaracion de metodos y funciones */

	static {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Oracle driver not found");
			e.printStackTrace();
		}

	}

	private GestorDeConexiones() {
	}

	/**
	 * @return una conexion con la base de datos de oracle
	 * @throws SQLException
	 *             si ocurre un problema durante el establecimiento de la
	 *             conexion con la base de datos
	 */
	public final static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(db_driver, db_username, db_password);
	}

}
