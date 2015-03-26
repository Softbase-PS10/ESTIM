package formateo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Rating {

	/**
	 * Modifica los ratings
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String fileOrigen = "./rat.csv";
		String fileDestino = "./rat2.csv";

		File ficheroOri = new File(fileOrigen);
		File ficheroDes = new File(fileDestino);

		Scanner ori = new Scanner(ficheroOri);
		BufferedWriter dest = new BufferedWriter(new FileWriter(ficheroDes));

		dest.write(ori.nextLine() + "\n");
		String insercion = "";

		while (ori.hasNextLine()) {
			String aux = ori.nextLine();
			if (aux.compareTo("null") == 0) {
				insercion = aux;
			} else {
				if (aux.contains(".")) {
					int index = aux.indexOf('.');
					String aa = aux.substring(0, index);
					int i = Integer.parseInt(aa);
					if (i < 10)
						insercion = aux.substring(0, index + 2);
					else
						insercion = aux.substring(0, index);
				} else {
					insercion = aux.substring(0, 1) + "." + aux.substring(1, 2);
				}
			}

			dest.write(insercion + "\n");
		}

		ori.close();
		dest.flush();
		dest.close();

	}

}
