/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: objeto que representa la informacion de una plataforma 
 * 				(identificador, nombre y alias)
 */

package modelo;

public class Plataforma {

	/* declaracion de atributos */

	/* alias de las plataformas */
	public static final String aliasXONE = "XONE";
	public static final String alias3DS = "3DS";
	public static final String aliasWiiU = "Wii U";
	public static final String aliasPC = "PC";
	public static final String aliasPS4 = "PS4";
	public static final String aliasWii = "Wii";
	public static final String aliasPS3 = "PS3";
	public static final String aliasX360 = "X360";
	public static final String aliasPSVita = "PSVita";

	/* nombre de las plataformas */
	public static final String XONE = "Microsoft Xbox One";
	public static final String N3DS = "Nintendo 3DS";
	public static final String WiiU = "Nintendo Wii U";
	public static final String PC = "PC";
	public static final String PS4 = "Sony Playstation 4";
	public static final String Wii = "Nintendo Wii";
	public static final String PS3 = "Sony Playstation 3";
	public static final String X360 = "Microsoft Xbox 360";
	public static final String PSVita = "Sony Playstation Vita";

	private String nombre, alias;
	private long id;

	/* declaracion de metodos y funciones */

	/**
	 * @param nombre
	 *            : nombre de la plataforma
	 * @param alias
	 *            : alias de la plataforma
	 * @param id
	 *            : id de la plataforma Crea una plataforma con identificador
	 *            autogenerado, con nombre @param nombre y alias @param alias
	 */
	public Plataforma(long id, String nombre, String alias) {
		this.nombre = nombre;
		this.alias = alias;
		this.id = id;
	}

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
		this.id = new Sentencias().listarPlataformaAlias(alias).getId();
	}

	/**
	 * 
	 * @param alias
	 *            : alias de la plataforma Crea una plataforma con identificador
	 *            y nombre autogenerado y alias @param alias
	 */
	public Plataforma(String alias) {
		this.alias = alias;
		Plataforma p = new Sentencias().listarPlataformaAlias(alias);
		this.nombre = p.getNombre();
		this.id = p.getId();
	}

	/**
	 * @param id
	 *            : identificador de la plataforma Crea una plataforma sin
	 *            nombre ni alias. Su identificador sera @param id
	 */
	public Plataforma(long id) {
		this.id = id;
		Plataforma p = new Sentencias().listarPlataformaId(id);
		this.nombre = p.getNombre();
		this.alias = p.getAlias();
	}

	/**
	 * @return identificador de la plataforma
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            : nuevo identificador de la plataforma
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return nombre de la plataforma
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            : nuevo nombre de la plataforma
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
	 * @param alias
	 *            : nuevo alias de la plataforma
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

}
