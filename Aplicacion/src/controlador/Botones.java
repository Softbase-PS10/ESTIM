/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que contiene la creacion de botones de diverso 
 * 				proposito, centralizando el comportamiento de dichos
 * 				botones, que sera el mismo en todas las pantallas.
 */

package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import modelo.Juego;
import modelo.Logger;
import modelo.OrdenDePedido;
import modelo.Plataforma;
import modelo.Sentencias;
import vista.Carro;
import vista.Info;
import vista.Listado;
import vista.Modificar;
import vista.Principal;

public class Botones {

	/* declaracion de variables */

	/* declaracion de metodos y funciones */

	/**
	 * Metodo que construye el boton de aplicar filtros
	 * 
	 * @param origen
	 *            : String que indica de que ventana proviene la llamada al
	 *            boton
	 * @param frame
	 *            : Frame principal de la aplicacion
	 * @param cesta
	 *            : ArrayList de juegos con los juegos comprados por el usuario
	 * 
	 * @return el boton de 'Aplicar' filtros, con su comportamiento
	 *         implementado.
	 */
	public static JButton aplicarFiltros(final String origen,
			final JFrame frame, final ArrayList<Juego> cesta) {
		JButton aplicar = new JButton("Apply");
		aplicar.setBounds(74, 293, 80, 20);
		aplicar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logger.log("Aplicando filtros...");
				Sentencias s = new Sentencias();
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
				if (!filtros.isEmpty()) {
					Logger.log("Filtros aplicados");
					frame.getContentPane().removeAll();
					Listado.listar(frame,
							s.listarJuegosMultipleFiltros(filtros, 1), cesta, 1);
				} else {
					Logger.log("Sin filtros que aplicar");
				}
			}
		});

		return aplicar;
	}

	/**
	 * Metodo que devuelve el boton de vaciar el carro (cesta)
	 * 
	 * @param frame
	 *            : Frame de la pantalla principal
	 * 
	 * @return el boton de 'Empty cart', con su comportamiento implementado.
	 */
	public static JButton vaciarCarro(final JFrame frame) {
		JButton vaciar = new JButton("Empty cart");
		vaciar.setBounds(20, 120, 150, 20);
		vaciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logger.log("Vaciando carro...");
				Logger.log("Carro vaciado");
				Carro.main(frame, new ArrayList<Juego>());
			}
		});

		return vaciar;
	}

	/**
	 * Metodo que devuelve el boton de comprar el carro actual
	 * 
	 * @param frame
	 *            : Frame principal de la aplicacion
	 * @param games
	 *            : ArrayList con los juegos de la cesta
	 * @return el boton de 'Buy cart', con su comportamiento implementado.
	 */
	public static JButton comprarCarro(final JFrame frame,
			final ArrayList<Juego> games) {
		JButton buy = new JButton("Buy games");
		buy.setBounds(20, 145, 150, 20);
		buy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logger.log("Creando orden de pedido...");
				OrdenDePedido.makeTicket(games);
				Logger.log("Orden de pedido creada");
				Logger.log("Vaciando carro...");
				Logger.log("Carro vaciado");
				JOptionPane.showMessageDialog(frame,
						"Invoice created. Thanks for buying in Estim!");
				Principal.main(frame, new ArrayList<Juego>());
			}
		});

		return buy;
	}

	/**
	 * Metodo que devuelve el boton de guardar los cambios del juego
	 * 
	 * @param j
	 *            : Juego con los datos modificados para guardarlos
	 * @param frame
	 *            : Frame principal de la aplicacion
	 * @param cesta
	 *            : ArrayList de juegos de la cesta
	 * @return el boton de 'Guardar' los cambios al modificar un juego del
	 *         catalogo.
	 */
	public static JButton save(final Juego j, final JFrame frame,
			final ArrayList<Juego> cesta) {
		JButton salvar = new JButton("Save");
		salvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		salvar.setBounds(961, 427, 89, 33);

		salvar.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				Logger.log("Guardando cambios en el juego...");
				boolean error = false;
				Sentencias s = new Sentencias();

				String titulo = Modificar.titulo.getText();
				if (titulo.length() == 0) {
					error = true;
					Logger.log("Error: La longitud del t�tulo es cero");
					Modificar.eTitulo.setVisible(true);
				} else {
					Modificar.eTitulo.setVisible(false);
				}
				String precio = Modificar.precio.getText();
				int p = 0;
				if (precio.length() == 0) {
					error = true;
					Logger.log("Error: La longitud del precio es cero");
					Modificar.ePrecio.setVisible(true);
					Modificar.ePrecioNegativo.setVisible(false);
					Modificar.ePrecioString.setVisible(false);
				} else {
					try {
						p = Integer.parseInt(precio);
						if (p <= 0) {
							Logger.log("Error: El precio es negativo");
							Modificar.ePrecioNegativo.setVisible(true);
							Modificar.ePrecioString.setVisible(false);
							Modificar.ePrecio.setVisible(false);
							error = true;
						}
					} catch (NumberFormatException e2) {
						Modificar.ePrecioString.setVisible(true);
						Modificar.ePrecioNegativo.setVisible(false);
						Modificar.ePrecio.setVisible(false);
						error = true;
						Logger.log("Error: Se ha introducido un String en vez de un numero en el precio");
					}
				}

				String anyo = Modificar.anyo.getText();

				String valoracion = Modificar.valoracion.getText();
				boolean punto = false;
				if (valoracion.length() < 5) {
					for (int i = 0; i < valoracion.length(); i++) {
						int point = valoracion.codePointAt(i);
						if (point == 46) {
							punto = true;
						}
						if (!((point > 47 && point < 58) || point == 46)
								&& !punto) {
							error = true;
							Logger.log("Error: La valoraci�n del juego tiene un formato incorrecto");
							Modificar.eRating.setVisible(true);
						} else {
							Modificar.eRating.setVisible(false);
						}
					}
				} else {
					error = true;
					Logger.log("Error: La valoraci�n del juego tiene un formato incorrecto");
					Modificar.eRating.setVisible(true);
				}

				String url = Modificar.url.getText();

				String descripcion = Modificar.descripcion.getText();

				String plataforma = (String) Modificar.plataforma
						.getSelectedItem();
				Plataforma plat = s.listarPlataformaAlias(plataforma);

				ArrayList<String> genero = new ArrayList<String>();
				Component[] comp = Modificar.genero.getMenuComponents();
				for (int i = 0; i < comp.length; i++) {
					JCheckBoxMenuItem cb = (JCheckBoxMenuItem) comp[i];
					if (cb.isSelected()) {
						genero.add(cb.getText());
					}
				}
				if (!error) {
					if (j == null) {
						if (url.equals(""))
							url = "null";
						Juego j = new Juego(titulo, url, descripcion, anyo,
								valoracion, genero, p, plat);
						s.insertarJuego(j);
						Logger.log("Juego guardado correctamente en la base de datos");
						Info.main(frame, j, cesta);
					} else {
						Logger.log("Juego no guardado en la base de datos debido a la presencia de errores");
						j.setTitulo(titulo);
						j.setDescripcion(descripcion);
						j.setGenero(genero);
						j.setImagen(url);
						j.setLanzamiento(anyo);
						j.setPlataforma(plat);
						j.setPrecio(Integer.parseInt(precio));
						j.setRating(valoracion);
						s.actualizarJuego(j);
						Info.main(frame, j, cesta);
					}
				}
			}
		});

		return salvar;
	}

	/**
	 * Metodo que devuelve el boton de atras de la pantalla de Listado
	 * 
	 * @param frame
	 *            : Frame principal de la aplicacion
	 * @param cesta
	 *            : ArrayList de juegos con la cesta del usuario
	 * @param nPagina
	 *            : Pagina actual del listado
	 * @return el boton de atras de la ventana de Listado con su comportamiento
	 *         implementado
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
				Logger.log("Cambiando de pagina...");
				Sentencias s = new Sentencias();
				HashMap<String, String> filtros = Principal.filtrosMap;
				Logger.log("Pagina cambiada");
				frame.getContentPane().removeAll();
				Listado.listar(frame,
						s.listarJuegosMultipleFiltros(filtros, nPagina - 1),
						cesta, nPagina - 1);
			}
		});

		return atras;
	}

	/**
	 * Metodo que devuelve el boton de adelante de la pantalla de Listado
	 * 
	 * @param frame
	 *            : Frame principal de la aplicacion
	 * @param cesta
	 *            : ArrayList de juegos con la cesta del usuario
	 * @param nPagina
	 *            : Pagina actual del listado
	 * @return el boton de adelante de la ventana de Listado con su
	 *         comportamiento implementado
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
		adelante.setBounds(452, 6, 53, 30);

		adelante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logger.log("Cambiando de pagina...");
				Sentencias s = new Sentencias();
				HashMap<String, String> filtros = Principal.filtrosMap;
				Logger.log("Pagina cambiada");

				frame.getContentPane().removeAll();
				Listado.listar(frame,
						s.listarJuegosMultipleFiltros(filtros, nPagina + 1),
						cesta, nPagina + 1);
			}
		});

		return adelante;
	}
}
