/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase estatica que implementa el funcionamiento del Logger
 * 				interno de la aplicacion. Esta clase crea un fichero de log
 *				(por defecto log.txt) y cada vez que se invoca al metodo log()
 *				anade al fichero el mensaje de log deseado
 */

package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	/* declaracion de variables */
	private static boolean initialized;
	private static final String DEFAULT = "log.txt";
	private static String NOMFICH = DEFAULT;

	/* declaracion de metodos y funciones */

	/**
	 * Metodo que inicializa el Logger
	 * 
	 * @throws IOException
	 *             : Si el fichero no pudo ser creado
	 */
	public static void initialize() throws IOException {
		FileWriter log = new FileWriter(NOMFICH, false);
		log.write("Starting log\n");
		log.close();
		initialized = true;
	}

	/**
	 * Metodo que almacena en el fichero de log el mensaje "text"
	 * 
	 * @param text
	 *            : String con el mensaje de log a almacenar
	 */
	public static void log(String text) {
		if (initialized) {
			FileWriter log;
			try {
				log = new FileWriter(NOMFICH, true);
				log.write(obtenerFechaYHora() + text + "\n");
				log.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out
					.println("Error: Es necesario inicializar el logger antes de usarlo");
		}
	}

	/**
	 * Metodo que devuelve la fecha y la hora en formato dd-MM-yyyy HH:mm:ss
	 * 
	 * @return fecha y hora en formato dd-MM-yyyy HH:mm:ss
	 */
	private static String obtenerFechaYHora() {
		SimpleDateFormat simpleDateFecha = new SimpleDateFormat(
				"dd-MM-yyyy HH:mm:ss");
		Date d = new Date();
		String strDate = simpleDateFecha.format(d);
		return "[" + strDate + "]";
	}
}
