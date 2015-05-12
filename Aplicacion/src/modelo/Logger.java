package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				log.write(obtenerFechaYHora()+text+"\n");
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
	
	private static String obtenerFechaYHora() {
	    SimpleDateFormat simpleDateFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//dd/MM/yyyy
	    Date d = new Date();
	    String strDate = simpleDateFecha.format(d);
	    return "["+strDate+"]";
	}
}
