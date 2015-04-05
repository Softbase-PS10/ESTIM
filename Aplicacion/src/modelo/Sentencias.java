/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que encapsula las distintas sentencias SQL (Oracle) para
 * 				el acceso a la Base de Datos.
 */

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sentencias {

	/* declaracion de atributos */
	private Connection connection;

	/* declaracion de metodos y funciones */

	/**
	 * Metodo de creacion de la conexion con la Base de Datos Oracle
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
	 *            : fecha de lanzamiento mas antigua
	 * @param max
	 *            : fecha de lanzamiento mas nueva
	 * @return una lista(ArrayList) de los juegos cuya fecha de lanzamiento se
	 *         encuentra entre @param min y @param max
	 */
	public ArrayList<Juego> listarJuegosRangoLanzamiento(String min, String max) {
		return listarJuegos(" AND SUBSTR(LANZAMIENTO, 1, 2) <= '"
				+ max.substring(0, 1) + "' AND SUBSTR(LANZAMIENTO, 1, 2) >= '"
				+ min.substring(0, 1) + "' AND SUBSTR(LANZAMIENTO, 4, 2) <= '" 
				+ max.substring(3, 4) + "' AND SUBSTR(LANZAMIENTO, 4, 2) >= '" 
				+ min.substring(3, 4) + "' AND SUBSTR(LANZAMIENTO, 7, 2) <= '"
				+ max.substring(6, 7) + "' AND SUBSTR(LANZAMIENTO, 7, 2) >= '"
				+ min.substring(6, 7) + "'");
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
		return listarJuegos(" AND JUEGO_GENERO.id = JUEGO.id AND genero = '" + genero + "'");
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
	 *         id
	 */
	public Juego listarJuego(long id) {
		return listarJuegos(" AND JUEGO.id = '" + id + "'").get(0);
	}

	/**
	 * @return una lista (ArrayList) con todos los juegos disponibles en la Base
	 *         de Datos (Oracle)
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
	public Plataforma listarPlataformaId(int id) {
		return listarPlataforma(" WHERE id = '" + id + "'");
	}

	/**
	 * @return una lista (ArrayList) de todas las plataformas existentes en la
	 *         Base de Datos (Oracle)
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
		try {
			String query = "DELETE FROM GENERO WHERE id = " + id + ";";
			Statement st = null;
			try {
				st = connection.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			st.execute(query);
			query = "DELETE FROM JUEGO WHERE id = " + id + ";";
			st.execute(query);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	/**
	 * @param id
	 *            : identificador de la plataforma a eliminar de la Base de
	 *            Datos
	 */
	public void borrarPlataforma(long id) {

		try {
			String query = "DELETE FROM JUEGO_PLATAFORMA WHERE plataforma = "
					+ id + ";";
			Statement st = null;
			try {
				st = connection.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			st.execute(query);
			query = "DELETE FROM PLATAFORMA WHERE id = " + id + ";";
			st.execute(query);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	/**
	 * @param juego
	 *            : informacion del juego a insertar
	 */
	public void insertarJuego(Juego juego) {

		// formateo de la descripcion, si es necesario
		if (juego.getDescripcion().length() > 2500)
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
				System.out.println("Entrada duplicada");

			else
				ex.printStackTrace();
		}

		/* insercion de la informacion en la tabla de generos */
		for(String g:juego.getGenero()){
			queryString = "INSERT INTO GENERO (id,genero) VALUES (?,?)";

			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(queryString);

				preparedStatement.setLong(1, juego.getId());
				preparedStatement.setString(2, g);

				preparedStatement.execute();
			} catch (SQLException ex) {
				if (ex.getSQLState().startsWith("23"))
					System.out.println("Entrada duplicada");
				else
					ex.printStackTrace();
			}
		}
		
		insertarPlataforma(juego.getPlataforma());

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
				System.out.println("Entrada duplicada");

			else
				ex.printStackTrace();
		}

	}

	/**
	 * @param p
	 *            : informacion de la plataforma a insertar
	 */
	public void insertarPlataforma(Plataforma p) {

		String queryString = "INSERT INTO PLATAFORMA (id,nombre,alias) VALUES (?,?,?)";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(queryString);

			preparedStatement.setLong(1, p.getId());
			preparedStatement.setString(2, p.getNombre());
			preparedStatement.setString(3, p.getAlias());

			preparedStatement.execute();
		} catch (SQLException ex) {
			if (ex.getSQLState().startsWith("23"))
				System.out.println("Entrada duplicada");

			else
				ex.printStackTrace();
		}
	}

	/**
	 * @param juego
	 *            : nueva informacion del juego a actualizar
	 */
	public void actualizarJuego(Juego juego) {

		if (juego.getDescripcion().length() > 2500)
			juego.setDescripcion(juego.getDescripcion().substring(0, 2497)
					+ "...");

		String queryString = "UPDATE JUEGO, JUEGO_PLATAFORMA "
				+ "SET titulo = ?,imagen = ?,precio = ?,resumen = ?,lanzamiento = ?,rating = ?, "
				+ "JUEGO_PLATAFORMA.plataforma = ? "
				+ "WHERE JUEGO.id = '"
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
			if (ex.getSQLState().startsWith("23"))
				System.out.println("Entrada duplicada");

			else
				ex.printStackTrace();
		}

		
		for(String g:juego.getGenero()){
			String query = "DELETE FROM JUEGO_GENERO WHERE id = "
					+ juego.getId() + ";";
			try {
			Statement st = connection.createStatement();
			st.execute(query);
			
			queryString = "INSERT INTO GENERO (id,genero) VALUES (?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(queryString);

			preparedStatement.setLong(1, juego.getId());
			preparedStatement.setString(2, g);

			preparedStatement.execute();
			} catch (SQLException ex) {
				if (ex.getSQLState().startsWith("23"))
					System.out.println("Entrada duplicada");
				else
					ex.printStackTrace();
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
			if (ex.getSQLState().startsWith("23"))
				System.out.println("Entrada duplicada");

			else
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
	 * @return el identificador de la ultima plataforma
	 */
	public long obtenerUltimoIdPlataforma() {
		String q = "SELECT MAX(id) AS mid FROM PLATAFORMA";
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
				+ query;//" AND ROWNUM <= 15";
		Statement st, st2;
		ArrayList<Juego> js = new ArrayList<Juego>();
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			Juego j;
			ArrayList<String> gen = new ArrayList<String>();
			ResultSet res;
			while (resul.next()) {
				j = new Juego(resul.getLong("id"));
				j.setTitulo(resul.getString("titulo"));
				j.setDescripcion(resul.getString("resumen"));
				j.setImagen(resul.getString("imagen"));
				j.setLanzamiento(resul.getString("lanzamiento"));
				j.setPrecio(resul.getInt("precio"));
				j.setRating(resul.getString("rating"));
				j.setPlataforma(new Plataforma(resul.getString("nombre"), resul
						.getString("alias")));
						
				q = "SELECT * FROM JUEGO_GENERO WHERE id = '"+j.getId()+"'";
				st2 = connection.createStatement();
				res = st2.executeQuery(q);
				while (res.next()) {
					gen.add(res.getString("genero"));
				}
				j.setGenero(gen);
				
				js.add(j);
				gen = new ArrayList<String>();
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
				p = new Plataforma(resul.getLong("id"));
				p.setAlias(resul.getString("alias"));
				p.setNombre(resul.getString("nombre"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
