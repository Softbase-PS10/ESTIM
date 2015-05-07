/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que encapsula las distintas sentencias SQL (MySQL) para
 * 				el acceso a la Base de Datos.
 */

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Sentencias {

	/* declaracion de atributos */
	private Connection connection;

	/* declaracion de metodos y funciones */

	/**
	 * M�todo que aplica distintas querys en funci�n del contenido del par�metro
	 * filtros. Adem�s devuelve una consulta paginada, es decir, dependiendo del
	 * n�mero de p�gina, devuelve los 5 elementos de dicha p�gina. Se asume la
	 * primera p�gina la n�mero 1.
	 * 
	 * @param filtros
	 *            : TreeMap que contiene los distintos requisitos para la
	 *            consulta (Ej. que la plataforma sea PS3)
	 * @param nPagina
	 *            : N�mero de p�gina que se quiere consultar, la primera es la
	 *            n�mero 1
	 * @return Una lista con los 5 juegos que pertenezcan a la p�gina pasada y
	 *         que cumplan los requisitos especif�cados en el TreeMap
	 */
	public ArrayList<Juego> listarJuegosMultipleFiltros(
			TreeMap<String, String> filtros, int nPagina) {
		String query = "select distinct JUEGO.id, titulo, imagen, resumen, rating, lanzamiento, precio, nombre, alias "
				+ "from JUEGO, JUEGO_GENERO, JUEGO_PLATAFORMA, PLATAFORMA where "
				+ "JUEGO.id = JUEGO_GENERO.id and JUEGO.id = JUEGO_PLATAFORMA.juego and "
				+ "JUEGO_PLATAFORMA.plataforma = PLATAFORMA.id";
		String order = "";
		if (filtros != null) {
			for (Entry<String, String> e : filtros.entrySet()) {
				switch (e.getKey()) {
				case ("titulo"):
					query = query + " and JUEGO.titulo = '" + e.getValue() + "'";
					break;
				case ("preciomin"):
					query = query + " and JUEGO.precio >= " + e.getValue();
					break;
				case ("preciomax"):
					query = query + " and JUEGO.precio <= " + e.getValue();
					break;
				case ("genero"):
					query = query + " and JUEGO_GENERO.genero = '"
							+ e.getValue() + "'";
					break;
				case ("plataforma"):
					query = query + " and PLATAFORMA.alias = '" + e.getValue()
							+ "'";
					break;
				case ("ratingmin"):
					query = query + " and JUEGO.rating >= " + e.getValue();
					break;
				case ("ratingmax"):
					query = query + " and JUEGO.rating <= " + e.getValue();
					break;
				case ("order"):
					order = " ORDER BY " + e.getValue() + ", JUEGO.id ";
					break;
				case ("type"):
					order = order + e.getValue();
					break;
				}
			}
		}
		
		query = query + order + " limit 5 offset " + (5 * (nPagina - 1));
		ArrayList<Juego> js = new ArrayList<Juego>();
		try {		
			Statement st = connection.createStatement(), st2;
			ResultSet resul = st.executeQuery(query);
			Juego j;
			String q;
			ArrayList<String> generos = new ArrayList<String>();
			ResultSet res;
			while (resul.next()) {
				j = new Juego(resul.getLong("id"), resul.getString("titulo"),
						resul.getString("imagen"), resul.getString("resumen"),
						resul.getString("lanzamiento"),
						resul.getString("rating"), generos,
						resul.getInt("precio"), new Plataforma(
								resul.getString("nombre"),
								resul.getString("alias")));

				q = "SELECT * FROM JUEGO_GENERO WHERE id = '" + j.getId() + "'";
				st2 = connection.createStatement();
				res = st2.executeQuery(q);
				while (res.next()) {
					generos.add(res.getString("genero"));
				}
				j.setGenero(generos);
				js.add(j);
				generos = new ArrayList<String>();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return js;
	}
	

	/**
	 * Metodo de creacion de la conexion con la Base de Datos MySql
	 */
	public Sentencias() {
		try {
			connection = GestorDeConexiones.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * M�todo que cierra la actual conexi�n
	 */
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param titulo
	 *            : titulo por el que se desea filtrar
	 * @return una lista (ArrayList) de los juegos cuyo campo <titulo> coincide
	 *         con @param titulo.
	 */
	public ArrayList<Juego> listarJuegosTitulo(String titulo) {
		return listarJuegos(" AND titulo = '" + titulo + "'");
	}

	/**
	 * @param min
	 *            : precio minimo por el que filtrar
	 * @param max
	 *            : precio maximo por el que filtrar
	 * @return una lista (ArrayList) de los juegos cuyo precio se encuentra
	 *         entre @param min y @param max
	 */
	public ArrayList<Juego> listarJuegosRangoPrecios(int min, int max) {
		return listarJuegos(" AND precio <= '" + max + "' AND precio >= '"
				+ min + "'");
	}

	/**
	 * @param min
	 *            : valoracion minima
	 * @param max
	 *            : valoracion maxima
	 * @return una lista (ArrayList) de los juegos cuyo rating se encuentre
	 *         entre @param min y @param max
	 */
	public ArrayList<Juego> listarJuegosRangoRating(String min, String max) {
		return listarJuegos(" AND rating <= '" + max + "' AND rating >= '"
				+ min + "'");
	}

	/**
	 * @param genero
	 *            : genero por el que filtrar
	 * @return una lista (ArrayList) de los juegos cuyo genero coincide con @param
	 *         genero
	 */
	public ArrayList<Juego> listarJuegosGenero(String genero) {
		return listarJuegos(" AND JUEGO_GENERO.id = JUEGO.id AND genero = '"
				+ genero + "'");
	}

	/**
	 * @param nomP
	 *            : nombre de la plataforma
	 * @return una lista (ArrayList) de los juegos cuya plataforma coincide con @param
	 *         nomP
	 */
	public ArrayList<Juego> listarJuegosPlataformaNombre(String nomP) {
		return listarJuegos(" AND PLATAFORMA.nombre = '" + nomP + "'");
	}

	/**
	 * @param alP
	 *            : alias de la plataforma
	 * @return una lista (ArrayList) de los juegos cuya plataforma coincide con @param
	 *         alP
	 */
	public ArrayList<Juego> listarJuegosPlataformaAlias(String alP) {
		return listarJuegos(" AND PLATAFORMA.alias = '" + alP + "'");
	}

	/**
	 * @param id
	 *            : identificador del juego
	 * @return la informacion del juego cuyo identificador coincide con @param
	 *         id, si este no existe, devuelve un juego vacio.
	 */
	public Juego listarJuego(long id) {
		ArrayList<Juego> ar = listarJuegos(" AND JUEGO.id = '" + id + "'");
		if (ar.isEmpty())
			return null;
		else
			return ar.get(0);
	}

	/**
	 * @return una lista (ArrayList) con todos los juegos disponibles en la Base
	 *         de Datos (MySQL)
	 */
	public ArrayList<Juego> listarTodosJuegos() {
		return listarJuegos("");
	}

	/**
	 * @param nombre
	 *            : nombre de la plataforma
	 * @return la informacion asociada a la plataforma cuyo nombre coincida con @param
	 *         nombre
	 */
	public Plataforma listarPlataformaNombre(String nombre) {
		return listarPlataforma(" WHERE nombre = '" + nombre + "'");
	}

	/**
	 * @param alias
	 *            : alias de la plataforma
	 * @return la informacion asociada a la plataforma cuyo alias coincida con @param
	 *         alias
	 */
	public Plataforma listarPlataformaAlias(String alias) {
		return listarPlataforma(" WHERE alias = '" + alias + "'");
	}

	/**
	 * @param id
	 *            : identificador de la plataforma
	 * @return la informacion asociada a la plataforma cuyo identificador con @param
	 *         id
	 */
	public Plataforma listarPlataformaId(long id) {
		return listarPlataforma(" WHERE id = '" + id + "'");
	}

	/**
	 * @return una lista (ArrayList) de todas las plataformas existentes en la
	 *         Base de Datos
	 */
	public ArrayList<Plataforma> listarTodasPlataformas() {
		String q = "SELECT * FROM PLATAFORMA";
		Statement st;
		Plataforma p = null;
		ArrayList<Plataforma> ps = new ArrayList<Plataforma>();
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			while (resul.next()) {
				p = new Plataforma(resul.getLong("id"));
				p.setAlias(resul.getString("alias"));
				p.setNombre(resul.getString("nombre"));
				ps.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * @param id
	 *            : identificador del juego a eliminar de la Base de Datos
	 */
	public void borrarJuego(long id) {
		if (id > 0) {
			if (listarJuego(id) != null) {
				try {
					String query = "DELETE FROM JUEGO_GENERO WHERE id = " + id
							+ ";";
					Statement st = null;
					try {
						st = connection.createStatement();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					st.execute(query);
					query = "DELETE FROM JUEGO_PLATAFORMA WHERE juego = " + id
							+ ";";
					st.execute(query);
					query = "DELETE FROM JUEGO WHERE id = " + id + ";";
					st.execute(query);
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			} else {
				System.out.println("Error de existencia");
				// Mostrar mensaje en el log
			}

		} else {
			System.out.println("Error n�mero negativo");
			// Mostrar mensaje en el log
		}
	}

	/**
	 * @param juego
	 *            : informacion del juego a insertar
	 */
	public void insertarJuego(Juego juego) {

		// Si el titulo no es vacio ni nulo, el precio mayor que cero, la
		// plataforma no se nula ni sus campos vacios,
		// se comienza a a�adir
		if (juego.getTitulo() != null
				&& !juego.getTitulo().equals("")
				&& juego.getPrecio() > 0
				&& juego.getPlataforma() != null
				&& (juego.getPlataforma().getAlias().length() != 0 || juego
						.getPlataforma().getNombre().length() != 0)) {
			// formateo de la descripcion, si es necesario
			if (juego.getDescripcion() != null
					&& juego.getDescripcion().length() > 2500)
				juego.setDescripcion(juego.getDescripcion().substring(0, 2497)
						+ "...");

			/* insercion de la informacion en la tabla de juegos */

			String queryString = "INSERT INTO JUEGO "
					+ "(id,titulo,imagen,precio,resumen,lanzamiento,rating) "
					+ "VALUES (?,?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(queryString);

				preparedStatement.setLong(1, juego.getId());
				preparedStatement.setString(2, juego.getTitulo());
				preparedStatement.setString(3, juego.getImagen());
				preparedStatement.setLong(4, juego.getPrecio());
				preparedStatement.setString(5, juego.getDescripcion());
				preparedStatement.setString(6, juego.getLanzamiento());
				preparedStatement.setString(7, juego.getRating());

				preparedStatement.execute();
			} catch (SQLException ex) {
				if (ex.getSQLState().startsWith("23"))
					System.out.println("Entrada en juego duplicada");

				else
					ex.printStackTrace();
			}

			/* insercion de la informacion en la tabla de generos */
			for (String g : juego.getGenero()) {
				queryString = "INSERT INTO JUEGO_GENERO (id,genero) VALUES (?,?)";

				try {
					PreparedStatement preparedStatement = connection
							.prepareStatement(queryString);

					preparedStatement.setLong(1, juego.getId());
					preparedStatement.setString(2, g);

					preparedStatement.execute();
				} catch (SQLException ex) {
					if (ex.getSQLState().startsWith("23"))
						System.out.println("Entrada en juego_genero duplicada");
					else
						ex.printStackTrace();
				}
			}

			/* insercion de la informacion en la tabla juego_plataforma */

			queryString = "INSERT INTO JUEGO_PLATAFORMA (juego,plataforma) VALUES (?,?)";

			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(queryString);

				preparedStatement.setLong(1, juego.getId());
				preparedStatement.setLong(2, juego.getPlataforma().getId());

				preparedStatement.execute();
			} catch (SQLException ex) {
				if (ex.getSQLState().startsWith("23"))
					System.out.println("Entrada en juego_plataforma duplicada");

				else
					ex.printStackTrace();
			}
		}
	}

	/**
	 * @param juego
	 *            : nueva informacion del juego a actualizar
	 */
	public void actualizarJuego(Juego juego) {

		// Si el titulo no es vacio ni nulo, el precio mayor que cero, la
		// plataforma no se nula ni
		// sus campos vacios, se comienza a a�adir
		if (juego.getTitulo() != null
				&& !juego.getTitulo().equals("")
				&& juego.getPrecio() > 0
				&& juego.getPlataforma() != null
				&& (juego.getPlataforma().getAlias().length() != 0 || juego
						.getPlataforma().getNombre().length() != 0)) {

			if (juego.getDescripcion() != null
					&& juego.getDescripcion().length() > 2500)
				juego.setDescripcion(juego.getDescripcion().substring(0, 2497)
						+ "...");

			String queryString = "UPDATE JUEGO, JUEGO_PLATAFORMA "
					+ "SET titulo = ?,imagen = ?,precio = ?,resumen = ?,lanzamiento = ?,rating = ?, "
					+ "JUEGO_PLATAFORMA.plataforma = ? " + "WHERE JUEGO.id = '"
					+ juego.getId() + "' AND JUEGO.id = JUEGO_PLATAFORMA.juego";
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(queryString);

				preparedStatement.setString(1, juego.getTitulo());
				preparedStatement.setString(2, juego.getImagen());
				preparedStatement.setLong(3, juego.getPrecio());
				preparedStatement.setString(4, juego.getDescripcion());
				preparedStatement.setString(5, juego.getLanzamiento());
				preparedStatement.setString(6, juego.getRating());
				preparedStatement.setLong(7, juego.getPlataforma().getId());
				preparedStatement.execute();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			for (String g : juego.getGenero()) {
				String query = "DELETE FROM JUEGO_GENERO WHERE id = "
						+ juego.getId() + ";";
				try {
					Statement st = connection.createStatement();
					st.execute(query);

					queryString = "INSERT INTO JUEGO_GENERO (id,genero) VALUES (?,?)";

					PreparedStatement preparedStatement = connection
							.prepareStatement(queryString);

					preparedStatement.setLong(1, juego.getId());
					preparedStatement.setString(2, g);

					preparedStatement.execute();
				} catch (SQLException ex) {
					if (ex.getSQLState().startsWith("23"))
						System.out.println("Entrada en juego_genero duplicada");
					else
						ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param p
	 *            : nueva informacion de la plataforma a actualizar
	 */
	public void actualizarPlataforma(Plataforma p) {
		String queryString = "UPDATE PLATAFORMA " + "SET nombre = ?,alias = ? "
				+ "WHERE id = ?";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(queryString);

			preparedStatement.setString(1, p.getNombre());
			preparedStatement.setString(2, p.getAlias());
			preparedStatement.setLong(3, p.getId());

			preparedStatement.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * @return el identificador del ultimo juego
	 */
	public long obtenerUltimoIdJuego() {
		String q = "SELECT MAX(id) AS mid FROM JUEGO";
		Statement st;
		long id = -1;
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			while (resul.next())
				id = resul.getLong("mid");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * @param query
	 *            : datos adicionales para el filtrado de las consultas
	 * @return una lista (ArrayList) de todos los juegos de la Base de Datos que
	 *         coinciden con @param query
	 */
	private ArrayList<Juego> listarJuegos(String query) {
		String q = "SELECT * FROM JUEGO, PLATAFORMA, JUEGO_PLATAFORMA WHERE "
				+ "JUEGO.id = JUEGO_PLATAFORMA.juego AND PLATAFORMA.id = JUEGO_PLATAFORMA.plataforma "
				+ query + " LIMIT 5";
		Statement st, st2;
		ArrayList<Juego> js = new ArrayList<Juego>();
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			Juego j;
			ArrayList<String> generos = new ArrayList<String>();
			ResultSet res;
			while (resul.next()) {
				j = new Juego(resul.getLong("id"), resul.getString("titulo"),
						resul.getString("imagen"), resul.getString("resumen"),
						resul.getString("lanzamiento"),
						resul.getString("rating"), generos,
						resul.getInt("precio"), new Plataforma(
								resul.getString("nombre"),
								resul.getString("alias")));
				q = "SELECT * FROM JUEGO_GENERO WHERE id = '" + j.getId() + "'";
				st2 = connection.createStatement();
				res = st2.executeQuery(q);
				while (res.next()) {
					generos.add(res.getString("genero"));
				}
				j.setGenero(generos);

				js.add(j);
				generos = new ArrayList<String>();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return js;
	}

	/**
	 * @param query
	 *            : datos adicionales para la obtencion de la plataforma
	 * @return la plataforma cuya informacion coincida con @param query
	 */
	private Plataforma listarPlataforma(String query) {
		String q = "SELECT * FROM PLATAFORMA" + query;
		Statement st;
		Plataforma p = null;
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			while (resul.next()) {
				p = new Plataforma(resul.getLong("id"),
						resul.getString("nombre"), resul.getString("alias"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
