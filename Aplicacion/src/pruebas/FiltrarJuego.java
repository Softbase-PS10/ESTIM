/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase para las pruebas de filtrado y ordenacion de
 * 				juegos en la Base de Datos
 */

package pruebas;

import java.util.HashMap;

import modelo.Sentencias;

/* Asignado a: Alejandro Royo */
public class FiltrarJuego {

	/**
	 * Clase que lanza las distintas pruebas
	 */
	public static void prueba() {
		System.out.println("Comenzando las pruebas sobre filtrado de juegos:");
		Sentencias sql = new Sentencias();

		System.out.println("Clase de equivalencia 1-2-3-4-5");
		Lanzador.filtros.put("titulo", "The Witcher");
		clase(Lanzador.filtros, sql);

		sql.close();
	}

	/**
	 * Realiza una prueba de filtrado de juegos.
	 * 
	 * @param filtros
	 * 			  : filtros de busqueda
	 * @param sql
	 *            : conexion con la Base de Datos
	 */
	private static void clase(HashMap<String, String> filtros, Sentencias sql) {
		sql.cantidadMultiples(filtros);
	}

}
