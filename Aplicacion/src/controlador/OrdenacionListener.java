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
import vista.Principal;

public class OrdenacionListener implements ActionListener {

	private Sentencias sql;
	private JFrame frame;
	private ArrayList<Juego> cesta;

	public OrdenacionListener(JFrame frame, ArrayList<Juego> cesta) {
		this.frame = frame;
		this.cesta = cesta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sql = new Sentencias();
		String option = (String) Listado.ordenacionMulti.getSelectedItem();
		switch (option) {
		case ("Title asc."):
			Principal.filtrosMap.put("order", "titulo");
			Principal.filtrosMap.put("type", "asc");
			Principal.filtrosMap.put("optionS", "Title asc.");
			break;
		case ("Title desc."):
			Principal.filtrosMap.put("order", "titulo");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Title desc.");
			break;
		case ("Price asc."):
			Principal.filtrosMap.put("order", "precio");
			Principal.filtrosMap.put("type", "asc");
			Principal.filtrosMap.put("optionS", "Price asc.");
			break;
		case ("Price desc."):
			Principal.filtrosMap.put("order", "precio");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Price desc.");
			break;
		case ("Year asc."):
			Principal.filtrosMap.put("order", "lanzamiento");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Year asc.");
			break;
		case ("Year desc."):
			Principal.filtrosMap.put("order", "lanzamiento");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Year desc.");
			break;
		case ("Rating asc."):
			Principal.filtrosMap.put("order", "valoracion");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Rating asc.");
			break;
		case ("Rating desc."):
			Principal.filtrosMap.put("order", "valoracion");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Rating desc.");
			break;
		default:
			Principal.filtrosMap.remove("order");
			Principal.filtrosMap.remove("type");
			Principal.filtrosMap.remove("optionS");
			break;
		}
		ArrayList<Juego> juegos = sql.listarJuegosMultipleFiltros(
				Principal.filtrosMap, 1);
		frame.getContentPane().removeAll();
		Listado.listar(frame, juegos, cesta);
	}

}
