package formateo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Descripcion {

	/**
	 * Corta los resumenes hasta 800 caracteres, agregando "..." al final
	 * si se pasa de los caracteres especificados
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String fileOrigen = "./a.csv";
		String fileDestino = "./b.csv";

		File ficheroOri = new File(fileOrigen);
		File ficheroDes = new File(fileDestino);
		
		Scanner ori = new Scanner(ficheroOri);
		BufferedWriter dest = new BufferedWriter(new FileWriter(ficheroDes));
		
		int n = 800;
		
		while (ori.hasNextLine()){
			String aux = ori.nextLine();
			
			if (aux.length() > n){
				StringTokenizer tk = new StringTokenizer(aux);
				String acc = tk.nextToken();
				boolean continuar = true;
				
				while (continuar && tk.hasMoreElements()){
					String aa = tk.nextToken();
					acc = acc + " " + aa;
					if (acc.length() >= n){
						continuar = false;
					}
				}
				acc = acc + "...";
				aux = acc;
			}
			
			dest.write(aux+"\n");
		}
		
		ori.close();
		dest.flush();
		dest.close();

	}

}
