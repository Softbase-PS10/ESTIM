package modelo;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	private static boolean initialized;
	private static final String NOMFICH = "log.txt";
	
	public static void initialize() throws IOException{
		FileWriter log = new FileWriter(NOMFICH,false);
		log.write("Starting log\n");
		log.close();
		initialized=true;
	}
	
	public static void log(String text){
		if(initialized){
			FileWriter log;
			try {
				log = new FileWriter(NOMFICH,true);
				log.write(text+"\n");
				log.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Error: Es necesario inicializar el logger antes de usarlo");
		}
	}
}
