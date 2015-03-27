/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: objeto que representa la informacion de un juego (id, titulo,
 * 				imagen, descripcion, lanzamiento, rating, generos, precio y 
 * 				plataforma)
 */

package modelo;

import java.util.ArrayList;

public class Juego {

	/* declaracion de atributos */
	private long id;
	private ArrayList<String> genero;
	private String titulo, imagen, descripcion, lanzamiento, rating;
	private int precio;
	private Plataforma plataforma;

	/* declaracion de metodos y funciones */

	/**
	 * @param titulo
	 *            : titulo del juego
	 * @param imagen
	 *            : url de la imagen
	 * @param descripcion
	 *            : resumen del juego
	 * @param lanzamiento
	 *            : fecha de lanzamiento
	 * @param rating
	 *            : valoracion del juego
	 * @param genero
	 *            : generos a los que pertenece el juego
	 * @param precio
	 *            : precio del juego
	 * @param plataforma
	 *            : plataforma en la que se encuentra disponibles
	 */
	public Juego(String titulo, String imagen, String descripcion,
			String lanzamiento, String rating, ArrayList<String> genero, int precio,
			Plataforma plataforma) {

		this.id = new Sentencias().obtenerUltimoIdJuego() + 1;
		this.titulo = titulo;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.lanzamiento = lanzamiento;
		this.rating = rating;
		this.genero = genero;
		this.precio = precio;
		this.plataforma = plataforma;
	}

	/**
	 * Creacion de un juego con identificador y plataforma autogenerados
	 */
	public Juego() {
		this.id = new Sentencias().obtenerUltimoIdJuego() + 1;
		this.titulo = "";
		this.imagen = "";
		this.descripcion = "";
		this.lanzamiento = "";
		this.rating = "";
		this.genero = new ArrayList<String>();
		this.precio = 0;
		this.plataforma = new Plataforma();
	}

	/**
	 * @param id : identificador del juego
	 * Creacion de un juego con plataforma autogenerada
	 */
	public Juego(long id) {
		this.id = id;
		this.titulo = "";
		this.imagen = "";
		this.descripcion = "";
		this.lanzamiento = "";
		this.rating = "";
		this.genero = new ArrayList<String>();
		this.precio = 0;
		this.plataforma = new Plataforma();
	}

	/**
	 * @return plataforma a la que pertenece el juego
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}

	/**
	 * @param plataforma : nueva plataforma del juego
	 */
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * @return id del juego
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return titulo del juego
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo : nuevo titulo del juego
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return url de la imagen del juego
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen : nueva url de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return descripcion del juego
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion : nueva descripcion del juego
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return fecha de lanzamiento del juego
	 */
	public String getLanzamiento() {
		return lanzamiento;
	}

	/**
	 * @param lanzamiento : nueva fecha de lanzamiento del juego
	 */
	public void setLanzamiento(String lanzamiento) {
		this.lanzamiento = lanzamiento;
	}

	/**
	 * @return rating del juego
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating : nuevo rating del juego
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return los generos del juego
	 */
	public ArrayList<String> getGenero() {
		return genero;
	}

	/**
	 * @param genero : nuevos generos del juego
	 */
	public void setGenero(ArrayList<String> genero) {
		this.genero = genero;
	}

	/**
	 * @return el precio del juego
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio : nuevo precio del juego
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @return la informacion del juego
	 */
	public String mostrarInfo() {
		String info = "Id: " + id + "\nTitulo: " + titulo + "\nImagen: "
				+ imagen + "\nPrecio: " + precio + "\nGenero: " + genero
				+ "\nDescripcion: " + descripcion + "\nLanzamiento: "
				+ lanzamiento + "\nRating: " + rating + "\nPlataforma: "
				+ plataforma.getNombre();
		return info;
	}
}
