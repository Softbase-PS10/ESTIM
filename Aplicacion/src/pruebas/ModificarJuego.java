/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase para las pruebas de la modificacion de juegos
 * 				en la Base de Datos
 */

package pruebas;

import java.util.ArrayList;

import modelo.Juego;
import modelo.Plataforma;
import modelo.Sentencias;

public class ModificarJuego {

	/* declaracion de metodos y funciones */

	/**
	 * Clase que lanza las distintas pruebas
	 */
	public static void prueba() {
		System.out.println("Comenzando las pruebas sobre insertar juego:");
		Sentencias sql = new Sentencias();

		System.out.println("Clase de equivalencia 1-2-3-5-7-9-11-13-14-15-16");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO,
				Lanzador.PRECIO, Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 4");
		clase(Lanzador.TITULO, null, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO,
				Lanzador.PRECIO, Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 6");
		clase(Lanzador.TITULO, Lanzador.URL, null, Lanzador.LANZAMIENTO,
				Lanzador.RATING, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 8");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION, null,
				Lanzador.RATING, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 10");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, null, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 12");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, null, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 17");
		clase(null, Lanzador.URL, Lanzador.DESCRIPCION, Lanzador.LANZAMIENTO,
				Lanzador.RATING, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 18");
		clase("", Lanzador.URL, Lanzador.DESCRIPCION, Lanzador.LANZAMIENTO,
				Lanzador.RATING, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 19");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO, -25,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 20");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO,
				Lanzador.PRECIO, null, sql);

		System.out.println("Clase de equivalencia 21");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO,
				Lanzador.PRECIO, "", sql);

		sql.close();
	}

	/**
	 * Realiza una prueba unitaria modificando el juego con el ultimo id
	 * 
	 * @param titulo
	 *            : titulo del juego
	 * @param img
	 *            : URL de la imagen
	 * @param descripcion
	 *            : descripcion del juego
	 * @param lanzamiento
	 *            : lanzamiento del juego
	 * @param rating
	 *            : rating del juego
	 * @param genero
	 *            : genero del juego
	 * @param precio
	 *            : precio del juego
	 * @param plataforma
	 *            : plataforma del juego
	 * @param sql
	 *            : conexion con la Base de Datos
	 */
	private static void clase(String titulo, String img, String descripcion,
			String lanzamiento, String rating, String genero, int precio,
			String plataforma, Sentencias sql) {

		long id = sql.obtenerUltimoIdJuego();

		Plataforma platform = sql.listarPlataformaAlias(plataforma);
		ArrayList<String> generos = new ArrayList<String>();
		generos.add(genero);

		Juego j = new Juego(id, titulo, img, descripcion, lanzamiento, rating,
				generos, precio, platform);

		sql.actualizarJuego(j);
	}

}
