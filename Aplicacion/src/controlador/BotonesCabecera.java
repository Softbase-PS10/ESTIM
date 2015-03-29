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

import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Juego;
import modelo.Sentencias;
import vista.Listado;
import vista.Principal;

public class BotonesCabecera {
	
	private static JTextField busc;

	/**
	 * @return un boton de busqueda que obtiene lo escrito en un campo, lo
	 *         procesa y redirige a la pantalla de listado de resultados.
	 */
	public static JButton buscar(JTextField b) {
		busc = b;
		JButton busqueda = new JButton("");
		busqueda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		busqueda.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/buscar.png")));
		busqueda.setBorder(null);
		busqueda.setBounds(0, 0, 30, 30);
		busqueda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String busqueda = busc.getText();
				Sentencias sql = new Sentencias();
				ArrayList<Juego> juegos = sql.listarJuegosTitulo(busqueda);
				sql.close();
				Listado.listar(juegos);
			}
		});

		return busqueda;
	}

	/**
	 * @return un boton de ajuste/opciones que redirige a la pantalla de
	 *         opciones de la aplicacion.
	 */
	public static JLabel ajustes() {
		JLabel ajustes = new JLabel();
		ajustes.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/ajustesP.png")));
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/settings.png")));
		ajustes.setBounds(0, 0, 70, 70);

		return ajustes;
	}

	/**
	 * @return un boton del carro de la compra que implementa la funcion de
	 *         'carrito de la compra' en la aplicacion.
	 */
	public static JButton carro() {
		JButton carro = new JButton("");
		carro.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/carroP.png")));
		carro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		carro.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/carro.png")));
		carro.setBounds(0, 0, 70, 70);

		carro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return carro;
	}

	/**
	 * @return un boton con el logo del producto que redirige al usuario a la
	 *         pantalla de inicio de la app.
	 */
	public static JButton logo() {
		JButton logo = new JButton("");
		logo.setFocusPainted(false);
		logo.setContentAreaFilled(false);
		logo.setBorder(null);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/logoP.png")));
		logo.setBorderPainted(false);
		logo.setOpaque(false);
		logo.setMargin(new Insets(0, 0, 0, 0));
		logo.setBounds(33, 11, 97, 48);
		logo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Principal.main(null);
				}});

		return logo;
	}
}
