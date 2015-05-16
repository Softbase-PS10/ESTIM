package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class OrdenDePedido {

	private static int total;
	private static ArrayList<Juego> lista;

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static String getCabecera(Date d) {
		SimpleDateFormat simpleDateFecha = new SimpleDateFormat(
				"dd/MM/yyyy - HH:mm");// dd/MM/yyyy
		String strDate = simpleDateFecha.format(d);
		return "==================================================\n"
				+ "INVOICE	- Date: " + strDate + "\n"
				+ "==================================================\n\n";
	}

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
			name = name + " (" + actual.getPlataforma().getAlias() + ")\t- "
					+ actual.getPrecio() + "\t\u20AC\n";
			total = total + actual.getPrecio();
		}
		return name;
	}

	private static String getFin() {
		return "==================================================\n"
				+ "\t\t\t\t\t\t\t\t\tTOTAL: " + total + " \u20AC\n\n"
				+ "Thanks for buying in Estim, hope to see you again!\n"
				+ "==================================================";
	}
}
