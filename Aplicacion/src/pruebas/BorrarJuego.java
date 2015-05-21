/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase para las pruebas sobre la eliminacion de juegos en
 * 				la Base de Datos
 */

package pruebas;

import modelo.Sentencias;

public class BorrarJuego {

	/* declaracion de metodos y funciones */

	/**
	 * Clase que lanza las distintas pruebas
	 */
	public static void prueba() {
		System.out.println("Comenzando las pruebas sobre borrar juego:");
		Sentencias sql = new Sentencias();

		System.out.println("Clase de equivalencia 1");
		clase(1, sql);

		System.out.println("Clase de equivalencia 2");
		clase(-5, sql);

		System.out.println("Clase de equivalencia 3");
		clase(2, sql);

		sql.close();
	}

	/**
	 * Realiza una prueba unitaria eliminando un juego.
	 * 
	 * @param id
	 *            : id del juego
	 */
	private static void clase(long id, Sentencias sql) {

		sql.borrarJuego(id);

	}

}
