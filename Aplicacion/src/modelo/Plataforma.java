/*
 * GRUPO 10 - SOFTBASE
 * 		Alberto Blasco, Diego Galvez, Patricia Lazaro, Alejandro Marquez, 
 * 		Alejandro Royo, Jaime Ruiz-Borau
 * 
 * Summary: objeto que representa la informacion de una plataforma 
 * 			(identificador, nombre y alias)
 */

package modelo;

public class Plataforma {

	/* declaracion de atributos */
	private String nombre, alias;
	private long id;

	/* declaracion de metodos y funciones */

	/**
	 * @param nombre
	 *            : nombre de la plataforma
	 * @param alias
	 *            : alias de la plataforma Crea una plataforma con identificador
	 *            autogenerado, con nombre @param nombre y alias @param alias
	 */
	public Plataforma(String nombre, String alias) {
		this.nombre = nombre;
		this.alias = alias;
		this.id = new Sentencias().obtenerUltimoIdPlataforma() + 1;
	}

	/**
	 * Crea una plataforma con id autogenerado, sin nombre ni alias
	 */
	public Plataforma() {
		this.nombre = "";
		this.alias = "";
		this.id = new Sentencias().obtenerUltimoIdPlataforma() + 1;
	}

	/**
	 * @param id
	 *            : identificador de la plataforma Crea una plataforma sin
	 *            nombre ni alias. Su identificador sera @param id
	 */
	public Plataforma(long id) {
		this.nombre = "";
		this.alias = "";
		this.id = id;
	}

	/**
	 * @return identificador de la plataforma
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id : nuevo identificador de la plataforma
	 */
	public void setId(long id){
		this.id = id;
	}

	/**
	 * @return nombre de la plataforma
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre : nuevo nombre de la plataforma
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return alias de la plataforma
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias : nuevo alias de la plataforma
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

}
