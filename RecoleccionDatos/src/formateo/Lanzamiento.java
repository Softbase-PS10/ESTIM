package formateo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lanzamiento {

	/**
	 * Formatea la fecha de lanzamiento (aunque se deja una fecha rara)
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String fileOrigen = "./lanz.csv";
		String fileDestino = "./lanzb.csv";

		File ficheroOri = new File(fileOrigen);
		File ficheroDes = new File(fileDestino);

		Scanner ori = new Scanner(ficheroOri);
		BufferedWriter dest = new BufferedWriter(new FileWriter(ficheroDes));

		while (ori.hasNextLine()) {
			String aux = ori.nextLine();
			
			if(aux.compareTo("null") == 0){
				;
			}
			else{
				String [] aa = aux.split("/");
				String a = aa[aa.length-1];
				if (a.length() == 2){
					int i = Integer.parseInt(a);
					if (i > 15){
						i = 1900+i;
					}
					else{
						i = 2000+i;
					}
					aux = aa[0] + "/" + aa[1] + "/" + i;
				}
				else{
					;
				}
			}

			dest.write(aux + "\n");
		}

		ori.close();
		dest.flush();
		dest.close();

	}

}
