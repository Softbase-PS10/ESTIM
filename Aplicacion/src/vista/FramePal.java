/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase para lanzar el frame principal
 */

package vista;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.JFrame;
import modelo.Juego;
import modelo.Logger;
import modelo.Sentencias;

public class FramePal {

	/* declaracion de variables */
	private static boolean adminOn = false;

	/* declaracion de metodos y funciones */

	/**
	 * Metodo principal que lanza la aplicacion
	 * 
	 * @param args
	 *            : Argumentos del programa (No usados)
	 */
	public static void main(String[] args) {
		// cifrarPass();
		JFrame frmPantallaPrincipal;
		frmPantallaPrincipal = new JFrame();
		frmPantallaPrincipal.setTitle("Main window - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Principal.class.getResource("/Imagenes/E.png")));
		frmPantallaPrincipal.setResizable(false);
		frmPantallaPrincipal.setBounds(100, 100, 1066, 600);
		frmPantallaPrincipal.getContentPane().setLayout(null);
		frmPantallaPrincipal.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new Sentencias().close();
				System.exit(0);
			}
		});
		ArrayList<Juego> cesta = new ArrayList<Juego>();
		try {
			Logger.initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Principal.main(frmPantallaPrincipal, cesta);
	}

	/**
	 * Metodo para cifrar la password del administrador, La password solamente
	 * puede tener una palabra y va a estar contenida en Admin.txt Password:
	 * caballocampestre
	 */
	@SuppressWarnings("unused")
	private static void cifrarPass() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"/Imagenes/Admin.txt"));
			String pass = br.readLine().split(" ")[0];
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());

			byte byteData[] = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			PrintWriter pw = new PrintWriter(new FileWriter(
					"/Imagenes/Admin.txt"));
			pw.print(hexString.toString());
			br.close();
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Falta el fichero de admin.");
		}

		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que comprueba si el admin esta activo
	 * 
	 * @return true si el admin esta activo
	 */
	public static boolean isAdminOn() {
		return adminOn;
	}

	/**
	 * Metodo que establece activo o inactivo el admin
	 * 
	 * @param adminOn
	 *            : booleano con true si el admin esta activo y false si no lo
	 *            esta
	 */
	public static void setAdminOn(boolean adminOn) {
		FramePal.adminOn = adminOn;
	}
}
