/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que implementa la funcionalidad de la ordenacion de 
 * 				juegos
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

	/* declaracion de variables */
	private Sentencias sql;
	private JFrame frame;
	private ArrayList<Juego> cesta;

	/* declaracion de metodos y funciones */

	/**
	 * Metodo constructor
	 * @param frame
	 *            : frame en el que se encuentra el boton al que dotar de
	 *            funcionalidad
	 * @param cesta
	 *            : carrito de la compra
	 */
	public OrdenacionListener(JFrame frame, ArrayList<Juego> cesta) {
		this.frame = frame;
		this.cesta = cesta;
	}

	/**
	 * Realiza la ordenacion de los juegos por titulo, precio, fecha de
	 * lanzamiento o rating
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		sql = new Sentencias();
		String option = (String) Listado.ordenacionMulti.getSelectedItem();
		switch (option) {
		case ("Title asc."):	//titulo ascendente
			Principal.filtrosMap.put("order", "titulo");
			Principal.filtrosMap.put("type", "asc");
			Principal.filtrosMap.put("optionS", "Title asc.");
			break;
		case ("Title desc."):	//titulo descendente
			Principal.filtrosMap.put("order", "titulo");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Title desc.");
			break;
		case ("Price asc."):	//precio ascendente
			Principal.filtrosMap.put("order", "precio");
			Principal.filtrosMap.put("type", "asc");
			Principal.filtrosMap.put("optionS", "Price asc.");
			break;
		case ("Price desc."):	//precio descendente
			Principal.filtrosMap.put("order", "precio");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Price desc.");
			break;
		case ("Year asc."):		//fecha ascendente
			Principal.filtrosMap.put("order", "lanzamiento");
			Principal.filtrosMap.put("type", "asc");
			Principal.filtrosMap.put("optionS", "Year asc.");
			break;
		case ("Year desc."):	//fecha descendente
			Principal.filtrosMap.put("order", "lanzamiento");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Year desc.");
			break;
		case ("Rating asc."):	//rating ascendente
			Principal.filtrosMap.put("order", "rating");
			Principal.filtrosMap.put("type", "asc");
			Principal.filtrosMap.put("optionS", "Rating asc.");
			break;
		case ("Rating desc."):	//rating descendente
			Principal.filtrosMap.put("order", "rating");
			Principal.filtrosMap.put("type", "desc");
			Principal.filtrosMap.put("optionS", "Rating desc.");
			break;
		default:	//sin ordenacion
			Principal.filtrosMap.remove("order");
			Principal.filtrosMap.remove("type");
			Principal.filtrosMap.remove("optionS");
			break;
		}
		ArrayList<Juego> juegos = sql.listarJuegosMultipleFiltros(
				Principal.filtrosMap, 1);
		frame.getContentPane().removeAll();
		Listado.listar(frame, juegos, cesta, 1);
	}

}
