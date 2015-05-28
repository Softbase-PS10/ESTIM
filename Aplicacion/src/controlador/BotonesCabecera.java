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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import modelo.Juego;
import modelo.Logger;
import modelo.Sentencias;
import vista.Carro;
import vista.FramePal;
import vista.Listado;
import vista.Modificar;
import vista.Principal;

public class BotonesCabecera {

	/* declaracion de variables */
	private static JTextField busc;
	private static JFrame frame;

	/* declaracion de metodos y funciones */

	/**
	 * Metodo que devuelve el boton de buscar de la aplicacion
	 * 
	 * @param b
	 *            : JTextField donde se escribira la busqueda
	 * @param cesta
	 *            : ArrayList de juegos con la lista de juegos comprados
	 * @return un boton de busqueda que obtiene lo escrito en un campo, lo
	 *         procesa y redirige a la pantalla de listado de resultados.
	 */
	public static JButton buscar(JTextField b, final ArrayList<Juego> cesta) {
		busc = b;
		busc.setText(Principal.filtrosMap.get("titulo"));
		JButton busqueda = new JButton("");
		busqueda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		busqueda.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/buscar.png")));
		busqueda.setBorder(null);
		busqueda.setBounds(0, 0, 30, 30);
		busqueda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logger.log("Buscando juegos en la base de datos...");
				String busqueda = busc.getText();
				Sentencias sql = new Sentencias();
				Principal.filtrosMap.put("titulo", busqueda);
				ArrayList<Juego> juegos = sql.listarJuegosMultipleFiltros(
						Principal.filtrosMap, 1);
				frame.getContentPane().removeAll();
				Logger.log("Juegos encontrados");
				Listado.listar(frame, juegos, cesta, 1);
			}
		});

		return busqueda;
	}

	/**
	 * Metodo que devuelve el panel de ajustes para el admin
	 * 
	 * @param origen
	 *            : 1 representa que el origen de esta llamada es de la pantalla
	 *            principal, 2 para la pantalla de listado, 3 para la pantalla
	 *            de informacion del juego y 4 para la pantalla de modificar
	 *            juego
	 * @param j
	 *            : Juego actual que se esta visionando ahora en caso de estar
	 *            en la pantalla de edicion de juego
	 * @param juegos
	 *            : Listado de juegos que se esta visionando en el momento
	 * @param fr
	 *            : Frame principal de la aplicacion
	 * @param cesta
	 *            : ArrayList de juegos con la cesta actual del usuario
	 * @return un boton de ajuste/opciones que redirige a la pantalla de
	 *         opciones de la aplicacion.
	 */
	public static JLabel ajustes(final int origen, final Juego j,
			final ArrayList<Juego> juegos, final JFrame fr,
			final ArrayList<Juego> cesta) {

		final JLabel ajustes = new JLabel();
		final Juego juegoActual = j;
		ajustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajustes.setBounds(0, 0, 70, 70);
		// Esta iniciada la sesion de administrador
		if (FramePal.isAdminOn()) {
			ajustes.setIcon(new ImageIcon(Principal.class
					.getResource("/Imagenes/B/settings.png")));
			final JPopupMenu pop = new JPopupMenu();
			if (origen == 1 || origen == 2) {
				JMenuItem add = new JMenuItem("Add");
				add.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(java.awt.event.MouseEvent evt) {
						frame.getContentPane().removeAll();
						Modificar m = new Modificar(fr, juegoActual, cesta);
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
						Modificar m = new Modificar(fr, juegoActual, cesta);
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
						final JDialog dialog = new JDialog(frame,
								"Confirmation", true);
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
											int value = ((Integer) optionPane
													.getValue()).intValue();
											if (value == JOptionPane.YES_OPTION) {
												Sentencias s = new Sentencias();
												s.borrarJuego(juegoActual
														.getId());
												frame.getContentPane()
														.removeAll();
												Principal.main(frame, cesta);
											} else if (value == JOptionPane.NO_OPTION) {
												;
											}
											dialog.setVisible(false);
										}

									}

								});
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
					FramePal.setAdminOn(false);
					frame.getContentPane().removeAll();

					Principal.main(frame, cesta);
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
		}
		// No esta iniciada la sesion de administrador
		else {
			ajustes.setIcon(new ImageIcon(Principal.class
					.getResource("/Imagenes/B/admin.png")));
			ajustes.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					ajustes.setIcon(new ImageIcon(Principal.class
							.getResource("/Imagenes/B/admin2.png")));
				}

				@Override
				public void mouseExited(java.awt.event.MouseEvent evt) {
					ajustes.setIcon(new ImageIcon(Principal.class
							.getResource("/Imagenes/B/admin.png")));
				}

				@Override
				public void mousePressed(java.awt.event.MouseEvent evt) {

					InputStream is = Principal.class
							.getResourceAsStream("/Imagenes/Admin.txt");
					BufferedReader br = new BufferedReader(
							new InputStreamReader(is));
					try {

						final String pass = br.readLine().split(" ")[0];
						br.close();

						final JDialog dialog = new JDialog(frame,
								"Admin password", true);
						final JPasswordField password;
						JPanel panel = new JPanel();
						JButton aceptar = new JButton("Accept");
						JLabel texto = new JLabel(
								"Use your admin password, please");
						final JLabel errorPass = new JLabel(
								"Incorrect password, try again");
						JButton cancelar = new JButton("Cancel");

						panel.setLayout(null);

						panel.setPreferredSize(new Dimension(275, 125));
						frame.getContentPane().add(panel, BorderLayout.CENTER);
						panel.setBounds(500, 325, 400, 300);

						texto.setHorizontalAlignment(SwingConstants.CENTER);
						texto.setBounds(0, 11, 275, 14);
						panel.add(texto);

						errorPass.setHorizontalAlignment(SwingConstants.CENTER);
						errorPass.setForeground(Color.RED);
						errorPass.setBounds(0, 25, 275, 14);
						errorPass.setVisible(false);
						panel.add(errorPass);

						password = new JPasswordField();
						password.setBounds(33, 48, 210, 20);
						panel.add(password);
						password.setPreferredSize(new Dimension(120, 20));
						password.setName("Pass");

						cancelar.setBounds(149, 79, 85, 23);
						cancelar.setHorizontalAlignment(SwingConstants.CENTER);
						cancelar.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								dialog.setVisible(false);
							}
						});
						panel.add(cancelar);

						aceptar.setBounds(45, 79, 85, 23);
						aceptar.setHorizontalAlignment(SwingConstants.CENTER);
						aceptar.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								@SuppressWarnings("deprecation")
								String passwor = password.getText();
								if (passwor.length() != 0) {
									try {
										MessageDigest md = MessageDigest
												.getInstance("MD5");
										md.update(passwor.getBytes());

										byte byteData[] = md.digest();
										StringBuffer hexString = new StringBuffer();
										for (int i = 0; i < byteData.length; i++) {
											String hex = Integer
													.toHexString(0xff & byteData[i]);
											if (hex.length() == 1)
												hexString.append('0');
											hexString.append(hex);
										}

										if (hexString.toString().compareTo(
												pass.toString()) == 0) {
											FramePal.setAdminOn(true);
											dialog.setVisible(false);
											// Pantalla principal
											Principal.main(fr, cesta);
										} else {
											errorPass.setVisible(true);
										}

									} catch (NoSuchAlgorithmException ex) {
										ex.printStackTrace();
									}
								} else {
									errorPass.setVisible(true);
								}
							}
						});
						panel.add(aceptar);

						dialog.add(panel);
						dialog.setBounds(500, 325, 400, 300);
						dialog.setResizable(false);
						dialog.pack();
						dialog.setVisible(true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}

		return ajustes;
	}

	/**
	 * Metodo que devuelve el panel de carro de la aplicacion
	 * 
	 * @param cesta
	 *            : ArrayList de juegos en la cesta
	 * @return un boton del carro de la compra que implementa la funcion de
	 *         'carrito de la compra' en la aplicacion.
	 */
	public static JLabel carro(final ArrayList<Juego> cesta) {
		final JLabel carro = new JLabel("");
		carro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		if (cesta.isEmpty()) {
			carro.setIcon(new ImageIcon(Principal.class
					.getResource("/Imagenes/B/carro.png")));
		} else {
			carro.setIcon(new ImageIcon(Principal.class
					.getResource("/Imagenes/B/carroLleno.png")));
		}
		carro.setBounds(0, 0, 70, 70);
		carro.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				if (cesta.isEmpty()) {
					carro.setIcon(new ImageIcon(Principal.class
							.getResource("/Imagenes/B/carroP.png")));
				} else {
					carro.setIcon(new ImageIcon(Principal.class
							.getResource("/Imagenes/B/carroPLleno.png")));
				}
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (cesta.isEmpty()) {
					carro.setIcon(new ImageIcon(Principal.class
							.getResource("/Imagenes/B/carro.png")));
				} else {
					carro.setIcon(new ImageIcon(Principal.class
							.getResource("/Imagenes/B/carroLleno.png")));
				}
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent evt) {
				Carro.main(frame, cesta);
			}
		});

		return carro;
	}

	/**
	 * Metodo que devuelve el boton de logo de la aplicacion
	 * 
	 * @param frame
	 *            : Frame principal de la aplicacion
	 * @param cesta
	 *            : ArrayList de juegos con los juegos de la cesta del usuario
	 * @return un boton con el logo del producto que redirige al usuario a la
	 *         pantalla de inicio de la app.
	 */
	public static JButton logo(JFrame frame, final ArrayList<Juego> cesta) {
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
				Principal.main(BotonesCabecera.frame, cesta);
			}
		});

		return logo;
	}
}
