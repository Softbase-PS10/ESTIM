package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Principal;

public class Pruebita {

	public static void main(String[] args) throws IOException {
		InputStream is = Principal.class.getResourceAsStream("/Imagenes/Admin.txt");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
		String line;
		
		while((line = bfr.readLine()) != null){
			System.out.println(line);
		}
	}

}
