/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que lanza la ventana de modificar un juego
 */

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import modelo.Juego;
import modelo.Logger;
import modelo.Plataforma;
import controlador.Botones;
import controlador.BotonesCabecera;
import controlador.BotonesCategorias;
import controlador.Imagenes;

public class Modificar {

	/* declaracion de variables */
	private static JFrame frmPantallaPrincipal;
	public JTextField txtBuscar;
	public static JTextField titulo;
	public static JTextField precio;
	public static JTextField anyo;
	public static JTextField valoracion;
	public static JTextField url;
	public static JTextArea descripcion;
	public static JComboBox<String> plataforma;
	public static JMenu genero;
	public static JFormattedTextField ePrecio;
	public static JFormattedTextField ePrecioString;
	public static JFormattedTextField ePrecioNegativo;
	public static JFormattedTextField eRating;
	public static JFormattedTextField eTitulo;
	public static JLabel vistaPreviaCaratula;
	private static Juego j;
	private static ArrayList<Juego> cesta;

	/* declaracion de metodos y funciones */

	/**
	 * Constructor
	 * 
	 * @param j
	 *            : juego del cual se extraen datos para mostrarlos en los
	 *            campos correspondientes. Si es =null, los campos quedarán
	 *            vacios.
	 */
	@SuppressWarnings("static-access")
	public Modificar(JFrame fr, Juego j, ArrayList<Juego> cesta) {
		this.cesta = cesta;
		this.j = j;
		this.frmPantallaPrincipal = fr;
		frmPantallaPrincipal.getContentPane().removeAll();
		initialize();
		this.frmPantallaPrincipal.repaint();
	}

	/**
	 * Muestra la interfaz y rellena los campos conforme el juego que hay en las
	 * variables globales.
	 */
	@SuppressWarnings("static-access")
	public void mostrarMod() {

		this.frmPantallaPrincipal.setVisible(true);

		if (j != null) {
			if (j.getTitulo() != null && !j.getTitulo().equals("null")) {
				titulo.setText(j.getTitulo());
			}

			precio.setText(j.getPrecio() + "");

			if (j.getLanzamiento() != null
					&& !j.getLanzamiento().equals("null")) {
				anyo.setText(j.getLanzamiento());
			}
			if (j.getRating() != null && !j.getRating().equals("null")) {
				valoracion.setText(j.getRating());
			}
			if (j.getImagen() != null && !j.getImagen().equals("null")) {
				url.setText(j.getImagen());
				try {
					ImageIcon caratula = Imagenes.getIcon(j.getImagen(), 1.35);
					vistaPreviaCaratula.setIcon(caratula);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (j.getDescripcion() != null
					&& !j.getDescripcion().equals("null")) {
				descripcion.setText(j.getDescripcion());
			}
			if (j.getPlataforma() != null) {
				String[] listaP = Plataforma.listaAlias();
				boolean encontrado = false;
				int i = 0;
				while (i < listaP.length && !encontrado) {
					if (listaP[i]
							.equalsIgnoreCase(j.getPlataforma().getAlias())) {
						encontrado = true;
					} else {
						i++;
					}
				}
				plataforma.setSelectedIndex(i);
			}
			String[] generos = new String[] { "Action", "Adventure",
					"Construction and Management Simulation", "Fighting",
					"Flight Simulator", "Horror", "Life Simulation", "MMO",
					"Music", "Platform", "Puzzle", "Racing", "Role-Playing",
					"Sandbox", "Shooter", "Sports", "Stealth", "Strategy",
					"Vehicle Simulation" };

			for (int i = 0; i < generos.length; i++) {
				if (j != null) {
					for (String g : j.getGenero()) {
						if (g.equalsIgnoreCase(generos[i])) {
							genero.getItem(i).setSelected(true);
						}
					}
				}
			}
		}
	}

	/**
	 * Inicializa el frame de modificar juego
	 */
	private void initialize() {
		Logger.log("Inicializando crear/modificar juego...");
		frmPantallaPrincipal.setTitle("Add/Modify - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Modificar.class.getResource("/Imagenes/E.png")));

		JPanel cabecera = new JPanel();
		cabecera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cabecera.setBackground(Color.BLACK);
		cabecera.setBounds(0, 0, 1060, 70);
		frmPantallaPrincipal.getContentPane().add(cabecera);
		cabecera.setLayout(null);

		cabecera.add(BotonesCabecera.logo(frmPantallaPrincipal, cesta));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(990, 0, 70, 70);
		cabecera.add(panel);
		panel.setLayout(null);

		panel.add(BotonesCabecera.carro(cesta));

		txtBuscar = new JTextField();
		txtBuscar.setToolTipText("");
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscar.setBounds(650, 20, 192, 30);
		cabecera.add(txtBuscar);
		txtBuscar.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(841, 20, 30, 30);
		cabecera.add(panel_2);
		panel_2.setLayout(null);

		panel_2.add(BotonesCabecera.buscar(txtBuscar, cesta));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(920, 0, 70, 70);
		cabecera.add(panel_1);
		panel_1.setLayout(null);

		panel_1.add(BotonesCabecera.ajustes(4, null, null,
				frmPantallaPrincipal, cesta));

		JPanel categorias = new JPanel();
		categorias.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		categorias.setBackground(Color.DARK_GRAY);
		categorias.setBounds(0, 70, 1060, 30);
		frmPantallaPrincipal.getContentPane().add(categorias);
		categorias.setLayout(null);

		categorias.add(BotonesCategorias.allgames(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.ps3(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.vita(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.xone(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.x360(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.pc(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.wiiu(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.wii(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.n3ds(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.ps4(frmPantallaPrincipal, cesta));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 100, 1060, 471);
		frmPantallaPrincipal.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JFormattedTextField nTitulo = new JFormattedTextField();
		nTitulo.setBounds(53, 52, 140, 20);
		nTitulo.setText("TITLE:");
		nTitulo.setOpaque(false);
		nTitulo.setForeground(Color.WHITE);
		nTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		nTitulo.setEditable(false);
		nTitulo.setBorder(null);
		panel_3.add(nTitulo);

		JFormattedTextField nPrecio = new JFormattedTextField();
		nPrecio.setBounds(53, 83, 140, 20);
		nPrecio.setText("PRICE:");
		nPrecio.setOpaque(false);
		nPrecio.setForeground(Color.WHITE);
		nPrecio.setFont(new Font("Tahoma", Font.BOLD, 16));
		nPrecio.setEditable(false);
		nPrecio.setBorder(null);
		panel_3.add(nPrecio);

		JFormattedTextField nAnyo = new JFormattedTextField();
		nAnyo.setBounds(53, 114, 140, 20);
		nAnyo.setText("YEAR:");
		nAnyo.setOpaque(false);
		nAnyo.setForeground(Color.WHITE);
		nAnyo.setFont(new Font("Tahoma", Font.BOLD, 16));
		nAnyo.setEditable(false);
		nAnyo.setBorder(null);
		panel_3.add(nAnyo);

		JFormattedTextField nPlataformas = new JFormattedTextField();
		nPlataformas.setBounds(53, 145, 140, 20);
		nPlataformas.setText("PLATFORM:");
		nPlataformas.setOpaque(false);
		nPlataformas.setForeground(Color.WHITE);
		nPlataformas.setFont(new Font("Tahoma", Font.BOLD, 16));
		nPlataformas.setEditable(false);
		nPlataformas.setBorder(null);
		panel_3.add(nPlataformas);

		JFormattedTextField nGeneros = new JFormattedTextField();
		nGeneros.setBounds(53, 176, 140, 20);
		nGeneros.setText("GENRES:");
		nGeneros.setOpaque(false);
		nGeneros.setForeground(Color.WHITE);
		nGeneros.setFont(new Font("Tahoma", Font.BOLD, 16));
		nGeneros.setEditable(false);
		nGeneros.setBorder(null);
		panel_3.add(nGeneros);

		JFormattedTextField nValoracion = new JFormattedTextField();
		nValoracion.setBounds(53, 207, 140, 20);
		nValoracion.setText("RATING:");
		nValoracion.setOpaque(false);
		nValoracion.setForeground(Color.WHITE);
		nValoracion.setFont(new Font("Tahoma", Font.BOLD, 16));
		nValoracion.setEditable(false);
		nValoracion.setBorder(null);
		panel_3.add(nValoracion);

		JFormattedTextField nDescripcion = new JFormattedTextField();
		nDescripcion.setBounds(53, 238, 140, 20);
		nDescripcion.setText("DESCRIPTION:");
		nDescripcion.setOpaque(false);
		nDescripcion.setForeground(Color.WHITE);
		nDescripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
		nDescripcion.setEditable(false);
		nDescripcion.setBorder(null);
		panel_3.add(nDescripcion);

		JFormattedTextField nCaratula = new JFormattedTextField();
		nCaratula.setBounds(53, 399, 140, 20);
		nCaratula.setText("COVER URL:");
		nCaratula.setOpaque(false);
		nCaratula.setForeground(Color.WHITE);
		nCaratula.setFont(new Font("Tahoma", Font.BOLD, 16));
		nCaratula.setEditable(false);
		nCaratula.setBorder(null);
		panel_3.add(nCaratula);

		titulo = new JTextField();
		titulo.setBounds(214, 52, 300, 20);
		panel_3.add(titulo);
		titulo.setColumns(10);

		precio = new JTextField();
		precio.setBounds(214, 85, 60, 20);
		precio.setColumns(10);
		panel_3.add(precio);

		anyo = new JTextField();
		anyo.setBounds(214, 116, 60, 20);
		anyo.setColumns(10);
		panel_3.add(anyo);

		valoracion = new JTextField();
		valoracion.setBounds(214, 209, 60, 20);
		valoracion.setColumns(10);
		panel_3.add(valoracion);

		url = new JTextField();
		url.setBounds(214, 401, 300, 20);
		url.setColumns(10);
		panel_3.add(url);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(214, 238, 300, 152);
		panel_3.add(scrollPane);

		descripcion = new JTextArea();
		descripcion.setWrapStyleWord(true);
		descripcion.setLineWrap(true);
		scrollPane.setViewportView(descripcion);

		vistaPreviaCaratula = new JLabel("");
		vistaPreviaCaratula.setHorizontalAlignment(SwingConstants.CENTER);
		vistaPreviaCaratula.setHorizontalTextPosition(SwingConstants.CENTER);
		vistaPreviaCaratula.setOpaque(true);
		vistaPreviaCaratula.setBackground(Color.LIGHT_GRAY);
		vistaPreviaCaratula.setBounds(706, 114, 170, 240);
		panel_3.add(vistaPreviaCaratula);

		panel_3.add(Botones.save(j, frmPantallaPrincipal, cesta));

		plataforma = new JComboBox<String>();
		String[] listaP = Plataforma.listaAlias();
		plataforma.setModel(new DefaultComboBoxModel<String>(listaP));
		plataforma.setBounds(214, 145, 300, 20);
		panel_3.add(plataforma);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(214, 175, 100, 20);
		panel_3.add(menuBar);

		genero = new JMenu();
		genero.setText("Select genres...");
		genero.setBounds(214, 175, 50, 20);
		menuBar.add(genero);

		String[] generos = new String[] { "Action", "Adventure",
				"Construction and Management Simulation", "Fighting",
				"Flight Simulator", "Horror", "Life Simulation", "MMO",
				"Music", "Platform", "Puzzle", "Racing", "Role-Playing",
				"Sandbox", "Shooter", "Sports", "Stealth", "Strategy",
				"Vehicle Simulation" };

		for (int i = 0; i < generos.length; i++) {
			JCheckBoxMenuItem cb = new JCheckBoxMenuItem(generos[i]);
			genero.add(cb);
		}

		ePrecio = new JFormattedTextField();
		ePrecio.setVisible(false);
		ePrecio.setText("Campo obligatorio");
		ePrecio.setOpaque(false);
		ePrecio.setForeground(Color.RED);
		ePrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ePrecio.setEditable(false);
		ePrecio.setBorder(null);
		ePrecio.setBounds(284, 84, 140, 20);
		ePrecioString = new JFormattedTextField();
		ePrecioString.setVisible(false);
		ePrecioString.setText("Solo se admiten números");
		ePrecioString.setOpaque(false);
		ePrecioString.setForeground(Color.RED);
		ePrecioString.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ePrecioString.setEditable(false);
		ePrecioString.setBorder(null);
		ePrecioString.setBounds(284, 84, 250, 20);
		ePrecioNegativo = new JFormattedTextField();
		ePrecioNegativo.setVisible(false);
		ePrecioNegativo.setText("Solo se admiten números positivos");
		ePrecioNegativo.setOpaque(false);
		ePrecioNegativo.setForeground(Color.RED);
		ePrecioNegativo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ePrecioNegativo.setEditable(false);
		ePrecioNegativo.setBorder(null);
		ePrecioNegativo.setBounds(284, 84, 250, 20);
		panel_3.add(ePrecio);
		panel_3.add(ePrecioString);
		panel_3.add(ePrecioNegativo);

		eRating = new JFormattedTextField();
		eRating.setVisible(false);
		eRating.setText("Formato incorrecto, número decimal entre 0 y 10 con separador .");
		eRating.setOpaque(false);
		eRating.setForeground(Color.RED);
		eRating.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eRating.setEditable(false);
		eRating.setBorder(null);
		eRating.setBounds(284, 209, 410, 20);
		panel_3.add(eRating);

		eTitulo = new JFormattedTextField();
		eTitulo.setVisible(false);
		eTitulo.setText("Campo obligatorio");
		eTitulo.setOpaque(false);
		eTitulo.setForeground(Color.RED);
		eTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eTitulo.setEditable(false);
		eTitulo.setBorder(null);
		eTitulo.setBounds(524, 54, 140, 20);
		panel_3.add(eTitulo);

		JFormattedTextField previa = new JFormattedTextField();
		previa.setBorder(null);
		previa.setOpaque(false);
		previa.setForeground(Color.WHITE);
		previa.setHorizontalAlignment(SwingConstants.CENTER);
		previa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		previa.setText("Cover preview");
		previa.setBounds(706, 365, 170, 20);
		panel_3.add(previa);

		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1060, 471);
		fondo.setIcon(new ImageIcon(Modificar.class
				.getResource("/Imagenes/blizz.jpg")));
		panel_3.add(fondo);
		Logger.log("Crear/Modificar juego inicializado");
	}
}
