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
import java.io.IOException;

import modelo.Juego;
import modelo.Logger;

import java.util.ArrayList;

import javax.swing.JFrame;

public class FramePal {

	public static void main(String[] args) {
		JFrame frmPantallaPrincipal;
		frmPantallaPrincipal = new JFrame();
		frmPantallaPrincipal.setTitle("Main window - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Principal.class.getResource("/Imagenes/E.png")));
		frmPantallaPrincipal.setResizable(false);
		frmPantallaPrincipal.setBounds(100, 100, 1066, 600);
		frmPantallaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPantallaPrincipal.getContentPane().setLayout(null);
		ArrayList<Juego> cesta = new ArrayList<Juego>();
		try {
			Logger.initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Principal.main(frmPantallaPrincipal,cesta);
	}
}
