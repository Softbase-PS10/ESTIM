/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase estatica que implementa el funcionamiento de la orden de
 * 				pedido. Dada una cesta de juegos genera un archivo en formato
 * 				.txt con la fecha y hora del pedido y con los datos de los juegos
 * 				adquiridos y el total del precio
 */

package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class OrdenDePedido {

	/* declaracion de variables */
	private static int total;
	private static ArrayList<Juego> lista;

	/* declaracion de metodos y funciones */

	/**
	 * Metodo estatico que construye el fichero .txt del ticket
	 * 
	 * @param games
	 *            : ArrayList de juegos con la cesta actual
	 */
	public static void makeTicket(ArrayList<Juego> games) {
		total = 0;
		lista = games;
		if (lista.size() != 0) {
			SimpleDateFormat simpleDateFecha = new SimpleDateFormat(
					"ddMMyyyyHHmmss");
			Date d = new Date();
			String strDate = simpleDateFecha.format(d);
			String fichero = "FacturaPedido" + strDate + ".txt";
			FileWriter factura;
			try {
				factura = new FileWriter(fichero, false);
				factura.write(getCabecera(d));
				factura.write(getCuerpo());
				factura.write(getFin());
				factura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo estatico que devuelve la cabecera del ticket
	 * 
	 * @param d
	 *            : Objeto Date con la fecha y hora actual
	 * @return un String con la cabecera del ticket
	 */
	private static String getCabecera(Date d) {
		SimpleDateFormat simpleDateFecha = new SimpleDateFormat(
				"dd/MM/yyyy - HH:mm");// dd/MM/yyyy
		String strDate = simpleDateFecha.format(d);
		return "==================================================\n"
				+ "INVOICE	- Date: " + strDate + "\n"
				+ "==================================================\n\n";
	}

	/**
	 * Metodo estatico que devuelve el cuerpo del ticket
	 * 
	 * @return un String con el cuerpo del ticket (conjunto de juegos)
	 */
	private static String getCuerpo() {
		String name = "";
		Iterator<Juego> it = lista.iterator();
		while (it.hasNext()) {
			Juego actual = it.next();
			if (actual.getTitulo().length() > 32) {
				String chop = actual.getTitulo().substring(0, 29) + "...";
				name = name + chop;
			} else {
				String ajustada = actual.getTitulo();
				for (int i = ajustada.length(); i < 32; i++) {
					ajustada = ajustada + " ";
				}
				name = name + ajustada;
			}
			name = name + " (" + actual.getPlataforma().getAlias() + ")\t-\t"
					+ actual.getPrecio() + "\t\u20AC\n";
			total = total + actual.getPrecio();
		}
		return name;
	}

	/**
	 * Metodo estatico que devuelve el fin del ticket
	 * 
	 * @return un String con el acabado del ticket
	 */
	private static String getFin() {
		return "==================================================\n"
				+ "\t\t\t\t\t\t\t\t\tTOTAL:\t" + total + "\t\u20AC\n\n"
				+ "Thanks for buying in Estim, hope to see you again!\n"
				+ "==================================================";
	}
}
