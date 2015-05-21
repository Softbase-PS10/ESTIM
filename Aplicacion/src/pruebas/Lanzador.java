/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que lanza las distintas pruebas del sistema
 */

package pruebas;

import java.util.HashMap;

import modelo.Plataforma;

public class Lanzador {

	/* variables que usar en las pruebas */
	public final static String TITULO = "Halo";
	public final static String URL = "img.com";
	public final static String DESCRIPCION = "bonito";
	public final static String LANZAMIENTO = "05/05/2005";
	public final static String RATING = "8.0";
	public final static String GENERO = "Shooter";
	public final static int PRECIO = 51;
	public final static String PLATAFORMA = Plataforma.aliasPC;
	public final static HashMap<String, String> filtros = new HashMap<String, String>();

	/* declaracion de metodos y funciones */

	/**
	 * Metodo que llama a las distintas funciones para realizar las
	 * correspondientes pruebas a los requisitos de agregar, modificar, eliminar
	 * y filtrar juegos de la Base de Datos
	 */
	public static void main(String[] args) {

		System.out
				.println("Comenzando las pruebas sobre insercion de juegos...");
		AgregarJuego.prueba();
		System.out.println("Pruebas sobre insercion de juegos terminadas.");

		System.out
				.println("Comenzando las pruebas sobre modificacion de juegos...");
		ModificarJuego.prueba();
		System.out.println("Pruebas sobre modificacion de juegos terminadas.");

		System.out
				.println("Comenzando las pruebas sobre eliminacion de juegos...");
		BorrarJuego.prueba();
		System.out.println("Pruebas sobre eliminacion de juegos terminadas.");

		System.out
				.println("Comenzando las pruebas sobre filtrado y ordenacion de juegos...");
		FiltrarJuego.prueba();
		System.out
				.println("Pruebas sobre filtrado y ordenacion de juegos terminadas.");

	}

}
