/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: objeto que representa la conexion con la base de datos de 
 * 				Oracle
 */

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorDeConexiones {

	/* declaracion de atributos */

//	private static String db_driver = "jdbc:oracle:thin:@hendrix-oracle.cps.unizar.es:1521:vicious";
//	private static String db_username = "a546751";
//	private static String db_password = "Korea11";

	private static String db_driver = "jdbc:mysql://db4free.net:3306/catalogops";
	private static String db_username = "estim";
	private static String db_password = "estim-ps";
	
	/* declaracion de metodos y funciones */
	static {

		try {
//			Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
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
