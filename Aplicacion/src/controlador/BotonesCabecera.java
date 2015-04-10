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
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import modelo.Juego;
import modelo.Sentencias;
import vista.Listado;
import vista.Modificar;
import vista.Principal;

public class BotonesCabecera {

	private static JTextField busc;
	private static JFrame frame;

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
				String busqueda = busc.getText();
				Sentencias sql = new Sentencias();
				ArrayList<Juego> juegos = sql.listarJuegosTitulo(busqueda);
				sql.close();
				frame.getContentPane().removeAll();
				Listado.listar(frame, juegos);
			}
		});

		return busqueda;
	}

	/**
	 * @return un boton de ajuste/opciones que redirige a la pantalla de
	 *         opciones de la aplicacion.
	 * 
	 * @param origen
	 *            : 1 representa que el origen de esta llamada es de la pantalla
	 *            principal, 2 para la pantalla de listado, 3 para la pantalla
	 *            de información del juego y 4 para la pantalla de modificar
	 *            juego
	 */
	public static JLabel ajustes(int origen, Juego j, final JFrame fr) {
		final JLabel ajustes = new JLabel();
		final Juego juegoActual = j;
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/settings.png")));
		ajustes.setBounds(0, 0, 70, 70);
		final JPopupMenu pop = new JPopupMenu();
		if (origen == 1 || origen == 2) {
			JMenuItem add = new JMenuItem("Add");
			add.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(java.awt.event.MouseEvent evt) {
					frame.getContentPane().removeAll();
					Modificar m = new Modificar(fr, juegoActual);
					m.mostrarMod();
				}
			});
			pop.add(add);
		} else if (origen == 3) {
			JMenuItem modify = new JMenuItem("Modify");
			modify.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(java.awt.event.MouseEvent evt) {
					frame.getContentPane().removeAll();
					Modificar m = new Modificar(fr, juegoActual);
					m.mostrarMod();
				}
			});
			JMenuItem delete = new JMenuItem("Delete");
			delete.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(java.awt.event.MouseEvent evt) {
					final JOptionPane optionPane = new JOptionPane(
							"Are you sure you want to delete this game?",
							JOptionPane.QUESTION_MESSAGE,
							JOptionPane.YES_NO_OPTION);
					final JDialog dialog = new JDialog(frame, "Confirmation",
							true);
					dialog.setLocationRelativeTo(frame);
					dialog.setBounds(500, 325, 200, 200);
					dialog.setContentPane(optionPane);
					optionPane
							.addPropertyChangeListener(new PropertyChangeListener() {

								@Override
								public void propertyChange(
										PropertyChangeEvent arg0) {
									String prop = arg0.getPropertyName();

									if (dialog.isVisible()
											&& (arg0.getSource() == optionPane)
											&& (prop.equals(JOptionPane.VALUE_PROPERTY))) {
										// If you were going to check something
										// before closing the window, you'd do
										// it here.
										int value = ((Integer) optionPane
												.getValue()).intValue();
										if (value == JOptionPane.YES_OPTION) {
											Sentencias s = new Sentencias();
											s.borrarJuego(juegoActual.getId());
											ArrayList<Juego> juegos = s
													.listarJuegosPlataformaAlias(juegoActual
															.getPlataforma()
															.getAlias());
											s.close();

											frame.getContentPane().removeAll();
											Listado.listar(frame, juegos);
										} else if (value == JOptionPane.NO_OPTION) {
											// Do nothing
										}
										dialog.setVisible(false);
									}

								}

							});
					dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					dialog.pack();
					dialog.setVisible(true);
				}
			});
			pop.add(modify);
			pop.add(delete);
		}

		JMenuItem exit = new JMenuItem("Exit");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent evt) {
//				BotonesCabecera.frame.dispose();
				frame.getContentPane().removeAll();

				Principal.main(frame);
			}
		});
		pop.add(exit);
		ajustes.setComponentPopupMenu(pop);
		ajustes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				ajustes.setIcon(new ImageIcon(Principal.class
						.getResource("/Imagenes/B/ajustesP.png")));
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				ajustes.setIcon(new ImageIcon(Principal.class
						.getResource("/Imagenes/B/settings.png")));
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent evt) {
				pop.show(evt.getComponent(), 0, 70);
			}
		});
		return ajustes;
	}

	/**
	 * @return un boton del carro de la compra que implementa la funcion de
	 *         'carrito de la compra' en la aplicacion.
	 */
	public static JLabel carro() {
		final JLabel carro = new JLabel("");
		carro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		carro.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/carro.png")));
		carro.setBounds(0, 0, 70, 70);
		final JPopupMenu pop = new JPopupMenu();
		JMenuItem show = new JMenuItem("Show cart");
		pop.add(show);
		JMenuItem empty = new JMenuItem("Empty cart");
		pop.add(empty);
		carro.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				carro.setIcon(new ImageIcon(Principal.class
						.getResource("/Imagenes/B/carroP.png")));
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				carro.setIcon(new ImageIcon(Principal.class
						.getResource("/Imagenes/B/carro.png")));
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent evt) {
				pop.show(evt.getComponent(), 0, 70);
			}
		});

		return carro;
	}

	/**
	 * @return un boton con el logo del producto que redirige al usuario a la
	 *         pantalla de inicio de la app.
	 */
	public static JButton logo(JFrame frame) {
		BotonesCabecera.frame = frame;
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
				BotonesCabecera.frame.getContentPane().removeAll();
				Principal.main(BotonesCabecera.frame);
			}
		});

		return logo;
	}
}
