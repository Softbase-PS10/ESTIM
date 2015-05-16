/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que contiene la creacion de botones de las categorias,
 * 				centralizando el comportamiento de dichos botones, que 
 * 				sera el mismo en todas las pantallas.
 * 				La barra de categorias es igual para todas las pantallas de 
 * 				la app.
 */

package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import modelo.Juego;
import modelo.Logger;
import modelo.Plataforma;
import modelo.Sentencias;
import vista.Listado;
import vista.Principal;

public class BotonesCategorias {

	/**
	 * @return
	 */
	public static JButton atras(final JFrame frame,
			final ArrayList<Juego> cesta, final int nPagina) {
		JButton atras = new JButton("");
		atras.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/atras.png")));
		atras.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/atrasP.png")));
		atras.setBackground(new Color(51, 102, 204));
		atras.setBorder(new LineBorder(new Color(0, 0, 0)));
		atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		atras.setFocusable(false);
		atras.setFocusPainted(false);
		atras.setForeground(Color.WHITE);
		atras.setFont(new Font("Tahoma", Font.BOLD, 14));
		atras.setBounds(350, 6, 53, 30);

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logger.log("Cambiando de p�gina...");
				Sentencias s = new Sentencias();
				String origen = "Listado";
				HashMap<String, String> filtros = Principal.filtrosMap;
				if (origen == "Listado") {
					int pMin, pMax;
					double gMin, gMax;
					String te = Listado.precioMinimo.getText();
					try {
						pMin = Integer.parseInt(te);
						filtros.put("preciomin", pMin + "");
					} catch (NumberFormatException e1) {
						filtros.remove("preciomin");
					}
					te = Listado.precioMaximo.getText();
					try {
						pMax = Integer.parseInt(te);
						filtros.put("preciomax", pMax + "");
					} catch (NumberFormatException e1) {
						filtros.remove("preciomax");
					}
					te = Listado.valoracionMinima.getText();
					if (te.length() > 4)
						te = te.substring(0, 3);
					try {
						gMin = Double.parseDouble(te);
						if (gMin / 10 < 1)
							filtros.put("ratingmin", gMin + "");
					} catch (NumberFormatException e1) {
						filtros.remove("ratingmin");
					}
					te = Listado.valoracionMaxima.getText();
					if (te.length() > 4)
						te = te.substring(0, 3);
					try {
						gMax = Double.parseDouble(te);
						if (gMax / 10 < 1)
							filtros.put("ratingmax", gMax + "");
					} catch (NumberFormatException e1) {
						filtros.remove("ratingmax");
					}
					if (!Listado.generoMulti.getSelectedItem().equals(""))
						filtros.put("genero",
								(String) Listado.generoMulti.getSelectedItem());
					else
						filtros.remove("genero");
					if (!Listado.plataformaMulti.getSelectedItem().equals(""))
						filtros.put("plataforma",
								(String) Listado.plataformaMulti
										.getSelectedItem());
					else
						filtros.remove("plataforma");
				}

				else if (origen == "Principal") {
					int pMin, pMax;
					double gMin, gMax;
					String te = Principal.textField.getText();
					try {
						pMin = Integer.parseInt(te);
						filtros.put("preciomin", pMin + "");
					} catch (NumberFormatException e1) {
						filtros.remove("preciomin");
					}
					te = Principal.textField_1.getText();
					try {
						pMax = Integer.parseInt(te);
						filtros.put("preciomax", pMax + "");
					} catch (NumberFormatException e1) {
						filtros.remove("preciomax");
					}
					te = Principal.textField_2.getText();
					if (te.length() > 4)
						te = te.substring(0, 3);
					try {
						gMin = Double.parseDouble(te);
						if (gMin / 10 < 1)
							filtros.put("ratingmin", gMin + "");
						else
							filtros.remove("ratingmin");
					} catch (NumberFormatException e1) {
						filtros.remove("ratingmin");
					}
					te = Principal.textField_3.getText();
					if (te.length() > 4)
						te = te.substring(0, 3);
					try {
						gMax = Double.parseDouble(te);
						if (gMax / 10 < 1)
							filtros.put("ratingmax", gMax + "");
						else
							filtros.remove("ratingmax");
					} catch (NumberFormatException e1) {
						filtros.remove("ratingmax");
					}
					if (!Principal.comboBox.getSelectedItem().equals(""))
						filtros.put("genero",
								(String) Principal.comboBox.getSelectedItem());
					else
						filtros.remove("genero");
					if (!Principal.comboBox_1.getSelectedItem().equals(""))
						filtros.put("plataforma",
								(String) Principal.comboBox_1.getSelectedItem());
					else
						filtros.remove("plataforma");
				}
				Logger.log("P�gina cambiada");
				if (!filtros.isEmpty()) {
					frame.getContentPane().removeAll();
					Listado.listar(frame,
							s.listarJuegosMultipleFiltros(filtros, nPagina-1), cesta,
							nPagina - 1);
				} else {
					;
				}
			}
		});

		return atras;
	}

	/**
	 * @return
	 */
	public static JButton adelante(final JFrame frame,
			final ArrayList<Juego> cesta, final int nPagina) {
		JButton adelante = new JButton("");
		adelante.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/alante.png")));
		adelante.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/alanteP.png")));
		adelante.setOpaque(false);
		adelante.setForeground(Color.WHITE);
		adelante.setFont(new Font("Tahoma", Font.BOLD, 14));
		adelante.setFocusable(false);
		adelante.setContentAreaFilled(false);
		adelante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adelante.setBorder(new LineBorder(new Color(0, 0, 0)));
		adelante.setBackground(new Color(51, 102, 204));
		adelante.setBounds(450, 6, 53, 30);

		adelante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logger.log("Cambiando de p�gina...");
				Sentencias s = new Sentencias();
				String origen = "Listado";
				HashMap<String, String> filtros = Principal.filtrosMap;
				if (origen == "Listado") {
					int pMin, pMax;
					double gMin, gMax;
					String te = Listado.precioMinimo.getText();
					try {
						pMin = Integer.parseInt(te);
						filtros.put("preciomin", pMin + "");
					} catch (NumberFormatException e1) {
						filtros.remove("preciomin");
					}
					te = Listado.precioMaximo.getText();
					try {
						pMax = Integer.parseInt(te);
						filtros.put("preciomax", pMax + "");
					} catch (NumberFormatException e1) {
						filtros.remove("preciomax");
					}
					te = Listado.valoracionMinima.getText();
					if (te.length() > 4)
						te = te.substring(0, 3);
					try {
						gMin = Double.parseDouble(te);
						if (gMin / 10 < 1)
							filtros.put("ratingmin", gMin + "");
					} catch (NumberFormatException e1) {
						filtros.remove("ratingmin");
					}
					te = Listado.valoracionMaxima.getText();
					if (te.length() > 4)
						te = te.substring(0, 3);
					try {
						gMax = Double.parseDouble(te);
						if (gMax / 10 < 1)
							filtros.put("ratingmax", gMax + "");
					} catch (NumberFormatException e1) {
						filtros.remove("ratingmax");
					}
					if (!Listado.generoMulti.getSelectedItem().equals(""))
						filtros.put("genero",
								(String) Listado.generoMulti.getSelectedItem());
					else
						filtros.remove("genero");
					if (!Listado.plataformaMulti.getSelectedItem().equals(""))
						filtros.put("plataforma",
								(String) Listado.plataformaMulti
										.getSelectedItem());
					else
						filtros.remove("plataforma");
				}

				else if (origen == "Principal") {
					int pMin, pMax;
					double gMin, gMax;
					String te = Principal.textField.getText();
					try {
						pMin = Integer.parseInt(te);
						filtros.put("preciomin", pMin + "");
					} catch (NumberFormatException e1) {
						filtros.remove("preciomin");
					}
					te = Principal.textField_1.getText();
					try {
						pMax = Integer.parseInt(te);
						filtros.put("preciomax", pMax + "");
					} catch (NumberFormatException e1) {
						filtros.remove("preciomax");
					}
					te = Principal.textField_2.getText();
					if (te.length() > 4)
						te = te.substring(0, 3);
					try {
						gMin = Double.parseDouble(te);
						if (gMin / 10 < 1)
							filtros.put("ratingmin", gMin + "");
						else
							filtros.remove("ratingmin");
					} catch (NumberFormatException e1) {
						filtros.remove("ratingmin");
					}
					te = Principal.textField_3.getText();
					if (te.length() > 4)
						te = te.substring(0, 3);
					try {
						gMax = Double.parseDouble(te);
						if (gMax / 10 < 1)
							filtros.put("ratingmax", gMax + "");
						else
							filtros.remove("ratingmax");
					} catch (NumberFormatException e1) {
						filtros.remove("ratingmax");
					}
					if (!Principal.comboBox.getSelectedItem().equals(""))
						filtros.put("genero",
								(String) Principal.comboBox.getSelectedItem());
					else
						filtros.remove("genero");
					if (!Principal.comboBox_1.getSelectedItem().equals(""))
						filtros.put("plataforma",
								(String) Principal.comboBox_1.getSelectedItem());
					else
						filtros.remove("plataforma");
				}
				Logger.log("P�gina cambiada");
				if (!filtros.isEmpty()) {
					frame.getContentPane().removeAll();
					Listado.listar(frame,
							s.listarJuegosMultipleFiltros(filtros, nPagina+1), cesta,
							nPagina + 1);
				} else {
					;
				}
			}
		});

		return adelante;
	}

	/**
	 * @return un boton que redirige a la pantalla de listados de juegos de
	 *         todos los juegos
	 */
	public static JButton allgames(JFrame frame, ArrayList<Juego> cesta) {
		JButton allgames = new JButton("");
		allgames.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/allgamesS.png")));
		allgames.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/allgamesP.png")));
		allgames.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allgames.setForeground(Color.WHITE);
		allgames.setFont(new Font("Tahoma", Font.BOLD, 14));
		allgames.setFocusable(false);
		allgames.setFocusPainted(false);
		allgames.setBorder(new LineBorder(new Color(0, 0, 0)));
		allgames.setBounds(0, 0, 106, 30);
		
		allgames.addActionListener(new PlatformListener(null, frame, cesta));

		return allgames;
	}

	/**
	 * @return un boton que redirige a la pantalla de listados de juegos de
	 *         PlayStation 3
	 */
	public static JButton ps3(JFrame frame, ArrayList<Juego> cesta) {
		JButton ps3 = new JButton("");
		ps3.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PS3.png")));
		ps3.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PS3P.png")));
		ps3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ps3.setForeground(Color.WHITE);
		ps3.setFont(new Font("Tahoma", Font.BOLD, 14));
		ps3.setFocusable(false);
		ps3.setFocusPainted(false);
		ps3.setBorder(new LineBorder(new Color(0, 0, 0)));
		ps3.setBounds(212, 0, 106, 30);

		ps3.addActionListener(new PlatformListener(Plataforma.aliasPS3, frame,
				cesta));

		return ps3;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de
	 *         PlayStation Vita
	 */
	public static JButton vita(JFrame frame, ArrayList<Juego> cesta) {
		JButton vita = new JButton("");
		vita.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PSVITAP.png")));
		vita.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PSVITA.png")));
		vita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vita.setForeground(Color.WHITE);
		vita.setFont(new Font("Tahoma", Font.BOLD, 14));
		vita.setFocusable(false);
		vita.setFocusPainted(false);
		vita.setBorder(new LineBorder(new Color(0, 0, 0)));
		vita.setBounds(318, 0, 106, 30);

		vita.addActionListener(new PlatformListener(Plataforma.aliasPSVita,
				frame, cesta));

		return vita;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de Xbox
	 *         ONE
	 */
	public static JButton xone(JFrame frame, ArrayList<Juego> cesta) {
		JButton xone = new JButton("");
		xone.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/XONE.png")));
		xone.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/XONEP.png")));
		xone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		xone.setForeground(Color.WHITE);
		xone.setFont(new Font("Tahoma", Font.BOLD, 14));
		xone.setFocusable(false);
		xone.setFocusPainted(false);
		xone.setBorder(new LineBorder(new Color(0, 0, 0)));
		xone.setBounds(424, 0, 106, 30);

		xone.addActionListener(new PlatformListener(Plataforma.aliasXONE,
				frame, cesta));

		return xone;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de Xbox
	 *         360
	 */
	public static JButton x360(JFrame frame, ArrayList<Juego> cesta) {
		JButton x360 = new JButton("");
		x360.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/X360P.png")));
		x360.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/X360.png")));
		x360.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x360.setForeground(Color.WHITE);
		x360.setFont(new Font("Tahoma", Font.BOLD, 14));
		x360.setFocusable(false);
		x360.setFocusPainted(false);
		x360.setBorder(new LineBorder(new Color(0, 0, 0)));
		x360.setBounds(530, 0, 106, 30);

		x360.addActionListener(new PlatformListener(Plataforma.aliasX360,
				frame, cesta));

		return x360;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de PC
	 */
	public static JButton pc(JFrame frame, ArrayList<Juego> cesta) {
		JButton pc = new JButton("");
		pc.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PC.png")));
		pc.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PCP.png")));
		pc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pc.setForeground(Color.WHITE);
		pc.setFont(new Font("Tahoma", Font.BOLD, 14));
		pc.setFocusable(false);
		pc.setFocusPainted(false);
		pc.setBorder(new LineBorder(new Color(0, 0, 0)));
		pc.setBounds(636, 0, 106, 30);

		pc.addActionListener(new PlatformListener(Plataforma.aliasPC, frame,
				cesta));

		return pc;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de WiiU
	 */
	public static JButton wiiu(JFrame frame, ArrayList<Juego> cesta) {
		JButton wiiu = new JButton("");
		wiiu.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/WIIUP.png")));
		wiiu.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/WIIU.png")));
		wiiu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wiiu.setForeground(Color.WHITE);
		wiiu.setFont(new Font("Tahoma", Font.BOLD, 14));
		wiiu.setFocusable(false);
		wiiu.setFocusPainted(false);
		wiiu.setBorder(new LineBorder(new Color(0, 0, 0)));
		wiiu.setBounds(742, 0, 106, 30);

		wiiu.addActionListener(new PlatformListener(Plataforma.aliasWiiU,
				frame, cesta));

		return wiiu;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de Wii
	 */
	public static JButton wii(JFrame frame, ArrayList<Juego> cesta) {
		JButton wii = new JButton("");
		wii.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/WII.png")));
		wii.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/WIIP.png")));
		wii.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wii.setForeground(Color.WHITE);
		wii.setFont(new Font("Tahoma", Font.BOLD, 14));
		wii.setFocusable(false);
		wii.setFocusPainted(false);
		wii.setBorder(new LineBorder(new Color(0, 0, 0)));
		wii.setBounds(848, 0, 106, 30);

		wii.addActionListener(new PlatformListener(Plataforma.aliasWii, frame,
				cesta));

		return wii;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de
	 *         Nintendo New 3DS
	 */
	public static JButton n3ds(JFrame frame, ArrayList<Juego> cesta) {
		JButton n3ds = new JButton("");
		n3ds.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/N3DSP.png")));
		n3ds.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/N3DS.png")));
		n3ds.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		n3ds.setForeground(Color.WHITE);
		n3ds.setFont(new Font("Tahoma", Font.BOLD, 14));
		n3ds.setFocusable(false);
		n3ds.setFocusPainted(false);
		n3ds.setBorder(new LineBorder(new Color(0, 0, 0)));
		n3ds.setBounds(954, 0, 106, 30);

		n3ds.addActionListener(new PlatformListener(Plataforma.alias3DS, frame,
				cesta));

		return n3ds;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de
	 *         PlayStation 4
	 */
	public static JButton ps4(JFrame frame, ArrayList<Juego> cesta) {
		JButton ps4 = new JButton("");
		ps4.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PS4P.png")));
		ps4.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PS4.png")));
		ps4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ps4.setBackground(new Color(51, 102, 255));
		ps4.setForeground(Color.WHITE);
		ps4.setFont(new Font("Tahoma", Font.BOLD, 14));
		ps4.setFocusable(false);
		ps4.setFocusPainted(false);
		ps4.setBorder(new LineBorder(new Color(0, 0, 0)));
		ps4.setBounds(106, 0, 106, 30);

		ps4.addActionListener(new PlatformListener(Plataforma.aliasPS4, frame,
				cesta));

		return ps4;
	}
}
