/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase para las pruebas de agregacion de juegos en
 * 				la Base de Datos
 */

package pruebas;

import java.util.ArrayList;

import modelo.Juego;
import modelo.Plataforma;
import modelo.Sentencias;

/* Asignado a: Patricia Lazaro */
public class AgregarJuego {

	/**
	 * Clase que lanza las distintas pruebas
	 */
	@SuppressWarnings("null")
	public static void prueba() {
		System.out.println("Comenzando las pruebas sobre insertar juego:");
		Sentencias sql = new Sentencias();

		System.out.println("Clase de equivalencia 1-8");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO,
				Lanzador.PRECIO, Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 9");
		clase(null, Lanzador.URL, Lanzador.DESCRIPCION, Lanzador.LANZAMIENTO,
				Lanzador.RATING, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 10");
		clase(Lanzador.TITULO, null, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO,
				Lanzador.PRECIO, Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 11");
		clase(Lanzador.TITULO, Lanzador.URL, null, Lanzador.LANZAMIENTO,
				Lanzador.RATING, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 12");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION, null,
				Lanzador.RATING, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 13");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, null, Lanzador.GENERO, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 14");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, null, Lanzador.PRECIO,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 15");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO, -25,
				Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 16");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO,
				(Integer) null, Lanzador.PLATAFORMA, sql);

		System.out.println("Clase de equivalencia 17");
		clase(Lanzador.TITULO, Lanzador.URL, Lanzador.DESCRIPCION,
				Lanzador.LANZAMIENTO, Lanzador.RATING, Lanzador.GENERO,
				Lanzador.PRECIO, null, sql);
		
		sql.close();
	}

	/**
	 * Realiza una prueba unitaria insertando un juego.
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

		Plataforma platform = sql.listarPlataformaAlias(plataforma);
		ArrayList<String> generos = new ArrayList<String>();
		generos.add(genero);

		Juego j = new Juego(titulo, img, descripcion, lanzamiento, rating,
				generos, precio, platform);

		sql.insertarJuego(j);
	}

}
