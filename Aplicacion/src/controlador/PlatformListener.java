/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que contiene la creacion de botones de la cabecera,
 * 				centralizando el comportamiento de dichos botones, que 
 * 				sera el mismo en todas las pantallas.
 * 				La cabecera es igual para todas las pantallas de la app.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.Juego;
import modelo.Sentencias;
import vista.Listado;

public class PlatformListener implements ActionListener {

	private String alias;
	private Sentencias sql;
	private JFrame frame;

	public PlatformListener(String alias, JFrame frame) {
		this.alias = alias;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sql = new Sentencias();
		ArrayList<Juego> juegos = sql.listarJuegosPlataformaAlias(this.alias);
		sql.close();
		
		frame.getContentPane().removeAll();
		Listado.listar(frame, juegos);
	}

}
