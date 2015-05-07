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

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;

import modelo.Juego;
import modelo.Plataforma;
import modelo.Sentencias;
import vista.Info;
import vista.Listado;
import vista.Modificar;
import vista.Principal;

public class Botones {

	/**
	 * @return el boton de 'Aplicar' filtros, con su comportamiento
	 *         implementado.
	 */
	public static JButton aplicarFiltros(final String origen,
			final JFrame frame, final ArrayList<Juego> cesta) {
		JButton aplicar = new JButton("Apply");
		aplicar.setBounds(84, 293, 66, 20);
		aplicar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Sentencias s = new Sentencias();
				TreeMap<String, String> filtros = Principal.filtrosMap;
				if (origen == "Listado") {
					int pMin, pMax, gMin, gMax;
					String te = Listado.precioMinimo.getText();
					try {
						pMin = Integer.parseInt(te);
						filtros.put("preciomin", pMin + "");
					} catch (NumberFormatException e1) {
					}
					te = Listado.precioMaximo.getText();
					try {
						pMax = Integer.parseInt(te);
						filtros.put("preciomax", pMax + "");
					} catch (NumberFormatException e1) {
					}
					te = Listado.valoracionMinima.getText();
					try {
						gMin = Integer.parseInt(te);
						filtros.put("ratingmin", gMin + "");
					} catch (NumberFormatException e1) {
					}
					te = Listado.valoracionMaxima.getText();
					try {
						gMax = Integer.parseInt(te);
						filtros.put("ratingmax", gMax + "");
					} catch (NumberFormatException e1) {
					}
					if (!Listado.generoMulti.getSelectedItem().equals(""))
						filtros.put("genero",
								(String) Listado.generoMulti.getSelectedItem());
					if (!Listado.plataformaMulti.getSelectedItem().equals(""))
						filtros.put("plataforma",
								(String) Listado.plataformaMulti.getSelectedItem());
				}

				else if (origen == "Principal") {
					int pMin, pMax, gMin, gMax;
					String te = Principal.textField.getText();
					try {
						pMin = Integer.parseInt(te);
						filtros.put("preciomin", pMin + "");
					} catch (NumberFormatException e1) {
					}
					te = Principal.textField_1.getText();
					try {
						pMax = Integer.parseInt(te);
						filtros.put("preciomax", pMax + "");
					} catch (NumberFormatException e1) {
					}
					te = Principal.textField_2.getText();
					try {
						gMin = Integer.parseInt(te);
						filtros.put("ratingmin", gMin + "");
					} catch (NumberFormatException e1) {
					}
					te = Principal.textField_3.getText();
					try {
						gMax = Integer.parseInt(te);
						filtros.put("ratingmax", gMax + "");
					} catch (NumberFormatException e1) {
					}
					if (!Principal.comboBox.getSelectedItem().equals(""))
						filtros.put("genero",
								(String) Principal.comboBox.getSelectedItem());
					if (!Principal.comboBox_1.getSelectedItem().equals(""))
						filtros.put("plataforma",
								(String) Principal.comboBox_1.getSelectedItem());
				}
				if (!filtros.isEmpty()) {
					frame.getContentPane().removeAll();
					Listado.listar(frame,
							s.listarJuegosMultipleFiltros(filtros, 1), cesta);
				}

			}
		});

		return aplicar;
	}

	/**
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
				boolean error = false;
				Sentencias s = new Sentencias();

				String titulo = Modificar.titulo.getText();
				if (titulo.length() == 0) {
					error = true;
					Modificar.eTitulo.setVisible(true);
				} else {
					Modificar.eTitulo.setVisible(false);
				}
				String precio = Modificar.precio.getText();
				int p = 0;
				if (precio.length() == 0) {
					error = true;
					Modificar.ePrecio.setVisible(true);
					Modificar.ePrecioNegativo.setVisible(false);
					Modificar.ePrecioString.setVisible(false);
				} else {
					try {
						p = Integer.parseInt(precio);
						if (p <= 0) {
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
						// Mostrar en el log que se han introducido un string en
						// vez
						// de numero
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
							Modificar.eRating.setVisible(true);
						} else {
							Modificar.eRating.setVisible(false);
						}
					}
				} else {
					error = true;
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
						Info.main(frame, j, cesta);
					} else {
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
}
