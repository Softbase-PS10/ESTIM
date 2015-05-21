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
import modelo.Logger;
import modelo.Sentencias;
import vista.Listado;
import vista.Principal;

public class PlatformListener implements ActionListener {

	/* declaracion de variables */
	private String alias;
	private Sentencias sql;
	private JFrame frame;
	private ArrayList<Juego> cesta;

	/* declaracion de metodos y funciones */

	/**
	 * @param alias
	 *            : nombre corto de la plataforma
	 * @param frame
	 *            : frame en el que se encuentra el boton al que dotarle de
	 *            funcionalidad
	 * @param cesta
	 *            : carrito de la compra
	 * 
	 *            Metodo constructor
	 */
	public PlatformListener(String alias, JFrame frame, ArrayList<Juego> cesta) {
		this.alias = alias;
		this.frame = frame;
		this.cesta = cesta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (alias != null) {
			Logger.log("Cargando juegos de la plataforma " + this.alias);
			sql = new Sentencias();
			ArrayList<Juego> juegos = sql
					.listarJuegosPlataformaAlias(this.alias);
			Principal.filtrosMap.put("plataforma", alias);
			frame.getContentPane().removeAll();
			Logger.log("Juegos de la plataforma " + this.alias + " cargados");
			Listado.listar(frame, juegos, cesta, 1);
		} else {
			Logger.log("Cargando todos los juegos");
			sql = new Sentencias();
			ArrayList<Juego> juegos = sql.listarTodosJuegos();
			Principal.filtrosMap.remove("plataforma");
			frame.getContentPane().removeAll();
			Logger.log("Todos los juegos cargados");
			Listado.listar(frame, juegos, cesta, 1);
		}
	}

}
