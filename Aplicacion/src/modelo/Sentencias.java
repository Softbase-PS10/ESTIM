/*
 * GRUPO 10 - SOFTBASE
 * 		Alberto Blasco, Diego Galvez, Patricia Lazaro, Alejandro Marquez, 
 * 		Alejandro Royo, Jaime Ruiz-Borau
 * 
 * Summary: clase que encapsula las distintas sentencias SQL (Oracle) para
 * 			el acceso a la Base de Datos.
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
	 * @param titulo
	 *            : titulo por el que se desea filtrar
	 * @return una lista (ArrayList) de los juegos cuyo campo <titulo> coincide
	 *         con @param titulo.
	 */
	public ArrayList<Juego> listarJuegosTitulo(String titulo) {
		return listarJuegos(" AND TITULO = '" + titulo + "'");
	}

	/**
	 * @param min
	 *            : precio minimo por el que filtrar
	 * @param max
	 *            : precio maximo por el que filtrar
	 * @return una lista (ArrayList) de los juegos cuyo precio se encuentra
	 *         entre @param min y @param max
	 */
	public ArrayList<Juego> listarJuegosRangoPrecios(double min, double max) {
		return listarJuegos(" AND PRECIO <= '" + max + "' AND PRECIO >= '"
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
	public ArrayList<Juego> listarJuegosRangoLanzamiento(double min, double max) {
		return listarJuegos(" AND LANZAMIENTO <= '" + max
				+ "' AND LANZAMIENTO >= '" + min + "'");
	}

	/**
	 * @param min
	 *            : valoracion minima
	 * @param max
	 *            : valoracion maxima
	 * @return una lista (ArrayList) de los juegos cuyo rating se encuentre
	 *         entre @param min y @param max
	 */
	public ArrayList<Juego> listarJuegosRangoRating(double min, double max) {
		return listarJuegos(" AND RATING <= '" + max + "' AND RATING >= '"
				+ min + "'");
	}

	/**
	 * @param genero
	 *            : genero por el que filtrar
	 * @return una lista (ArrayList) de los juegos cuyo genero coincide con @param
	 *         genero
	 */
	public ArrayList<Juego> listarJuegosGenero(String genero) {
		return listarJuegos(" AND GENERO = '" + genero + "'");
	} 

	/**
	 * @param nomP
	 *            : nombre de la plataforma
	 * @return una lista (ArrayList) de los juegos cuya plataforma coincide con @param
	 *         nomP
	 */
	public ArrayList<Juego> listarJuegosPlataformaNombre(String nomP) {
		return listarJuegos(" AND PLATAFORMA.NOMBRE = '" + nomP + "'");
	}

	/**
	 * @param alP
	 *            : alias de la plataforma
	 * @return una lista (ArrayList) de los juegos cuya plataforma coincide con @param
	 *         alP
	 */
	public ArrayList<Juego> listarJuegosPlataformaAlias(String alP) {
		return listarJuegos(" AND PLATAFORMA.ALIAS = '" + alP + "'");
	}

	/**
	 * @param id
	 *            : identificador del juego
	 * @return la informacion del juego cuyo identificador coincide con @param
	 *         id
	 */
	public Juego listarJuego(long id) {
		return listarJuegos(" AND JUEGO.ID = '" + id + "'").get(0);
	}

	/**
	 * @return una lista (ArrayList) con todos los juegos disponibles en la Base
	 *         de Datos (Oracle)
	 */
	public ArrayList<Juego> listarTodosJuegos() {
		return listarJuegos("");
	}

	/**
	 * @param query
	 *            : datos adicionales para el filtrado de las consultas
	 * @return una lista (ArrayList) de todos los juegos de la Base de Datos que
	 *         coinciden con @param query
	 */
	private ArrayList<Juego> listarJuegos(String query) {
		String q = "SELECT * FROM JUEGO, PLATAFORMA, JUEGO_PLATAFORMA, JUEGO_GENERO WHERE "
				+ "JUEGO.ID = JUEGO_PLATAFORMA.JUEGO AND PLATAFORMA.ID = JUEGO_PLATAFORMA.PLATAFORMA"
				+ query;
		Statement st;
		ArrayList<Juego> js = new ArrayList<Juego>();
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			Juego j;
			ArrayList<String> gen = new ArrayList<String>();
			ResultSet res;
			while (!resul.isClosed() && resul.next()) {
				j = new Juego(resul.getLong("id"));
				j.setTitulo(resul.getString("titulo"));
				j.setDescripcion(resul.getString("resumen"));
				j.setImagen(resul.getString("imagen"));
				j.setLanzamiento(resul.getString("lanzamiento"));
				j.setPrecio(resul.getInt("precio"));
				j.setRating(resul.getString("rating"));
				
				q = "SELECT * FROM JUEGO_GENERO WHERE ID = '"+j.getId()+"'";
				res = st.executeQuery(q);
				while (!res.isClosed() && res.next()) {
					gen.add(res.getString("genero"));
				}
				j.setGenero(gen);
				
				
				j.setPlataforma(new Plataforma(resul.getString("nombre"), resul
						.getString("alias")));
				js.add(j);
				gen = new ArrayList<String>();
			}
		} catch (SQLException ex) {
			if (ex.getSQLState().startsWith("23"))
				System.out.println("Entrada duplicada");

			else
				ex.printStackTrace();
		}
		return js;
	}

	/**
	 * @param nombre
	 *            : nombre de la plataforma
	 * @return la informacion asociada a la plataforma cuyo nombre coincida con @param
	 *         nombre
	 */
	public Plataforma listarPlataformaNombre(String nombre) {
		return listarPlataforma(" WHERE NOMBRE = '" + nombre + "'");
	}

	/**
	 * @param alias
	 *            : alias de la plataforma
	 * @return la informacion asociada a la plataforma cuyo alias coincida con @param
	 *         alias
	 */
	public Plataforma listarPlataformaAlias(String alias) {
		return listarPlataforma(" WHERE ALIAS = '" + alias + "'");
	}

	/**
	 * @param id
	 *            : identificador de la plataforma
	 * @return la informacion asociada a la plataforma cuyo identificador con @param
	 *         id
	 */
	public Plataforma listarPlataformaId(Long id) {
		return listarPlataforma(" WHERE ID = '" + id + "'");
	}

	/**
	 * @param query
	 *            : datos adicionales para la obtencion de la plataforma
	 * @return la plataforma cuya informacion coincida con @param query
	 */
	private Plataforma listarPlataforma(String query) {
		String q = "SELECT * FROM plataforma" + query;
		Statement st;
		Plataforma p = null;
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			while (!resul.isClosed() && resul.next()) {
				p = new Plataforma(resul.getLong("id"));
				p.setAlias(resul.getString("alias"));
				p.setNombre(resul.getString("nombre"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * @return una lista (ArrayList) de todas las plataformas existentes en la
	 *         Base de Datos (Oracle)
	 */
	public ArrayList<Plataforma> listarTodasPlataformas() {
		String q = "SELECT * FROM plataforma";
		Statement st;
		Plataforma p = null;
		ArrayList<Plataforma> ps = new ArrayList<Plataforma>();
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			while (!resul.isClosed() && resul.next()) {
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
			String query = "DELETE from GENERO WHERE ID=" + id + ";";
			Statement st = null;
			try {
				st = connection.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			st.execute(query);
			query = "DELETE from JUEGO WHERE ID = " + id + ";";
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
			String query = "DELETE FROM juego_plataforma WHERE PLATAFORMA="
					+ id + ";";
			Statement st = null;
			try {
				st = connection.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			st.execute(query);
			query = "DELETE FROM plataforma WHERE ID = " + id + ";";
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

		String queryString = "INSERT INTO juego "
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
			queryString = "INSERT INTO genero (id,genero) VALUES (?,?)";

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

		queryString = "INSERT INTO juego_plataforma (juego,plataforma) VALUES (?,?)";

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

		String queryString = "INSERT INTO plataforma (id,nombre,alias) VALUES (?,?,?)";
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

		String queryString = "UPDATE juego, juego_plataforma "
				+ "SET titulo = ?,imagen = ?,precio = ?,resumen = ?,lanzamiento = ?,rating = ?, "
				+ "JUEGO_PLATAFORMA.PLATAFORMA = ? "
				+ "WHERE JUEGO.ID = '"
				+ juego.getId() + "' AND JUEGO.ID = JUEGO_PLATAFORMA.JUEGO";
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
			String query = "DELETE FROM juego_genero WHERE ID="
					+ juego.getId() + ";";
			try {
			Statement st = connection.createStatement();
			st.execute(query);
			
			queryString = "INSERT INTO genero (id,genero) VALUES (?,?)";

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
		String queryString = "UPDATE plataforma " + "SET nombre = ?,alias = ? "
				+ "WHERE ID = ?";
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
		String q = "SELECT ID FROM JUEGO WHERE ROWNUM = 1 ORDER BY ID DESC";
		Statement st;
		long id = -1;
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			while (!resul.isClosed() && resul.next())
				id = resul.getLong("id");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * @return el identificador de la ultima plataforma
	 */
	public long obtenerUltimoIdPlataforma() {
		String q = "SELECT ID FROM PLATAFORMA WHERE ROWNUM = 1 ORDER BY ID DESC";
		Statement st;
		long id = -1;
		try {
			st = connection.createStatement();
			ResultSet resul = st.executeQuery(q);
			while (!resul.isClosed() && resul.next())
				id = resul.getLong("id");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
