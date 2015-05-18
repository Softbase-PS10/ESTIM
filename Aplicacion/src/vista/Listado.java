/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que lanza la ventana de listado de juegos
 */

package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import modelo.Juego;
import modelo.Logger;
import modelo.Plataforma;
import controlador.Botones;
import controlador.BotonesCabecera;
import controlador.BotonesCategorias;
import controlador.Imagenes;
import controlador.OrdenacionListener;

public class Listado {

	/* declaracion de variables */
	private JFrame frmPantallaPrincipal;
	private JTextField txtBuscar;
	public static JTextField precioMinimo, precioMaximo, valoracionMinima,
			valoracionMaxima;
	public static JComboBox<String> generoMulti, plataformaMulti, ordenacionMulti;

	@SuppressWarnings("unused")
	private ArrayList<Juego> games; // asi se podra realizar la ordenacion mas
									// adelante
	private ArrayList<Juego> cesta;

	/* declaracion de metodos y funciones */

	/**
	 * @param juegos
	 *            : lista de los juegos a listar
	 * 
	 *            Lanza la ventana de listado de juegos
	 */
	public static void listar(final JFrame fr, final ArrayList<Juego> juegos,
			final ArrayList<Juego> cesta, final int nPagina) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado window = new Listado(fr, juegos, cesta,nPagina);
					window.frmPantallaPrincipal.revalidate();
					window.frmPantallaPrincipal.repaint();
					window.frmPantallaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @param juegos
	 *            : lista de juegos a mostrar
	 * @throws IOException
	 * 
	 *             Crea la aplicacion
	 */
	public Listado(JFrame fr, ArrayList<Juego> juegos, ArrayList<Juego> cesta, int nPagina)
			throws IOException {
		this.games = juegos;
		this.cesta = cesta;
		this.frmPantallaPrincipal = fr;
		frmPantallaPrincipal.getContentPane().removeAll();
		frmPantallaPrincipal.revalidate();
		frmPantallaPrincipal.repaint();
		initialize(juegos,nPagina);
	}

	/**
	 * @param juegos
	 *            : lista de juegos a mostrar
	 * @throws IOException
	 * 
	 *             Inicializa la ventana
	 */
	private void initialize(ArrayList<Juego> juegos, int nPagina) throws IOException {
		Logger.log("Inicializando listado de juegos...");
		frmPantallaPrincipal.setTitle("List of games - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Info.class.getResource("/Imagenes/E.png")));

		JPanel cabecera = new JPanel();
		cabecera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cabecera.setBackground(Color.BLACK);
		cabecera.setBounds(0, 0, 1060, 70);
		frmPantallaPrincipal.getContentPane().add(cabecera);
		cabecera.setLayout(null);

		cabecera.add(BotonesCabecera.logo(frmPantallaPrincipal, cesta));

		txtBuscar = new JTextField();
		txtBuscar.setToolTipText("");
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscar.setBounds(650, 20, 192, 30);
		cabecera.add(txtBuscar);
		txtBuscar.setColumns(10);

		JPanel lupaBuscar = new JPanel();
		lupaBuscar.setBounds(841, 20, 30, 30);
		cabecera.add(lupaBuscar);
		lupaBuscar.setLayout(null);
		lupaBuscar.add(BotonesCabecera.buscar(txtBuscar, cesta));

		JPanel opciones = new JPanel();
		opciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		opciones.setBounds(920, 0, 70, 70);
		cabecera.add(opciones);
		opciones.setLayout(null);


		opciones.add(BotonesCabecera.ajustes(2, null, null, frmPantallaPrincipal,
				cesta));

		JPanel carrito = new JPanel();
		carrito.setBorder(new LineBorder(new Color(0, 0, 0)));
		carrito.setBounds(990, 0, 70, 70);
		cabecera.add(carrito);
		carrito.setLayout(null);

		carrito.add(BotonesCabecera.carro(cesta));

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

		JPanel filtros = new JPanel();
		filtros.setBackground(Color.DARK_GRAY);
		filtros.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		filtros.setBounds(0, 131, 191, 440);
		frmPantallaPrincipal.getContentPane().add(filtros);
		filtros.setLayout(null);

		JFormattedTextField precioFiltros = new JFormattedTextField();
		precioFiltros.setText("Price:");
		precioFiltros.setOpaque(false);
		precioFiltros.setForeground(Color.WHITE);
		precioFiltros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		precioFiltros.setEditable(false);
		precioFiltros.setBorder(null);
		precioFiltros.setBounds(20, 42, 171, 20);
		filtros.add(precioFiltros);

		JFormattedTextField tituloFiltros = new JFormattedTextField();
		tituloFiltros.setBorder(null);
		tituloFiltros.setEditable(false);
		tituloFiltros.setForeground(Color.WHITE);
		tituloFiltros.setOpaque(false);
		tituloFiltros.setFont(new Font("Tahoma", Font.BOLD, 14));
		tituloFiltros.setText("FILTERS");
		tituloFiltros.setBounds(10, 11, 171, 20);
		filtros.add(tituloFiltros);

		precioMinimo = new JTextField();
		precioMinimo.setBounds(20, 73, 51, 20);
		if (Principal.filtrosMap.containsKey("preciomin"))
			precioMinimo.setText(Principal.filtrosMap.get("preciomin"));
		filtros.add(precioMinimo);
		precioMinimo.setColumns(10);
		JFormattedTextField textToPrecio = new JFormattedTextField();
		textToPrecio.setText("to");
		textToPrecio.setOpaque(false);
		textToPrecio.setForeground(Color.WHITE);
		textToPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textToPrecio.setEditable(false);
		textToPrecio.setBorder(null);
		textToPrecio.setBounds(81, 73, 19, 20);
		filtros.add(textToPrecio);

		precioMaximo = new JTextField();
		precioMaximo.setColumns(10);
		precioMaximo.setBounds(99, 73, 51, 20);
		if (Principal.filtrosMap.containsKey("preciomax"))
			precioMaximo.setText(Principal.filtrosMap.get("preciomax"));
		filtros.add(precioMaximo);

		JFormattedTextField textGenero = new JFormattedTextField();
		textGenero.setText("Genre:");
		textGenero.setOpaque(false);
		textGenero.setForeground(Color.WHITE);
		textGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textGenero.setEditable(false);
		textGenero.setBorder(null);
		textGenero.setBounds(20, 104, 171, 20);
		filtros.add(textGenero);

		generoMulti = new JComboBox<String>();
		generoMulti.setModel(new DefaultComboBoxModel<String>(new String[] {
				"", "Action", "Adventure",
				"Construction and Management Simulation", "Fighting",
				"Flight Simulator", "Horror", "Life Simulation", "MMO",
				"Music", "Platform", "Puzzle", "Racing", "Role-Playing",
				"Sandbox", "Shooter", "Sports", "Stealth", "Strategy",
				"Vehicle Simulation" }));
		generoMulti.setToolTipText("");
		generoMulti.setName("");
		generoMulti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		generoMulti.setBounds(20, 131, 130, 20);
		if (Principal.filtrosMap.containsKey("genero"))
			generoMulti.setSelectedItem(Principal.filtrosMap.get("genero"));
		filtros.add(generoMulti);

		JFormattedTextField textPlataforma = new JFormattedTextField();
		textPlataforma.setText("Platform:");
		textPlataforma.setOpaque(false);
		textPlataforma.setForeground(Color.WHITE);
		textPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPlataforma.setEditable(false);
		textPlataforma.setBorder(null);
		textPlataforma.setBounds(20, 162, 171, 20);
		filtros.add(textPlataforma);

		plataformaMulti = new JComboBox<String>();
		plataformaMulti.setModel(new DefaultComboBoxModel<String>(new String[] {
				"", "PS4", "PS3", "PSVita", "XONE", "X360", "PC", "Wii U",
				"Wii", "N3DS" }));
		plataformaMulti.setToolTipText("");
		plataformaMulti.setName("");
		plataformaMulti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		plataformaMulti.setBounds(20, 187, 130, 20);
		if (Principal.filtrosMap.containsKey("plataforma"))
			plataformaMulti.setSelectedItem(Principal.filtrosMap.get("plataforma"));
		filtros.add(plataformaMulti);

		JFormattedTextField textValoracion = new JFormattedTextField();
		textValoracion.setText("Rating:");
		textValoracion.setOpaque(false);
		textValoracion.setForeground(Color.WHITE);
		textValoracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textValoracion.setEditable(false);
		textValoracion.setBorder(null);
		textValoracion.setBounds(20, 221, 171, 20);
		filtros.add(textValoracion);

		valoracionMinima = new JTextField();
		valoracionMinima.setColumns(10);
		valoracionMinima.setBounds(20, 252, 51, 20);
		if (Principal.filtrosMap.containsKey("ratingmin"))
			valoracionMinima.setText(Principal.filtrosMap.get("ratingmin"));
		filtros.add(valoracionMinima);

		JFormattedTextField textToValoracion = new JFormattedTextField();
		textToValoracion.setText("to");
		textToValoracion.setOpaque(false);
		textToValoracion.setForeground(Color.WHITE);
		textToValoracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textToValoracion.setEditable(false);
		textToValoracion.setBorder(null);
		textToValoracion.setBounds(81, 252, 19, 20);
		filtros.add(textToValoracion);

		valoracionMaxima = new JTextField();
		valoracionMaxima.setColumns(10);
		valoracionMaxima.setBounds(99, 252, 51, 20);
		if (Principal.filtrosMap.containsKey("ratingmax"))
			valoracionMaxima.setText(Principal.filtrosMap.get("ratingmax"));
		filtros.add(valoracionMaxima);
		filtros.add(Botones.aplicarFiltros("Listado", frmPantallaPrincipal,
				cesta));

		JPanel principal = new JPanel();
		principal.setBounds(190, 131, 870, 400);
		principal.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		frmPantallaPrincipal.getContentPane().add(principal);
		principal.setLayout(new BoxLayout(principal, BoxLayout.X_AXIS));

		/* Panel principal, introducir juegos */

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		scrollPane.setPreferredSize(new Dimension(850, 400));
		principal.add(scrollPane);

		scrollPane.getVerticalScrollBar().setUnitIncrement(20);

		Box box = Box.createVerticalBox();
		scrollPane.setViewportView(box);

		for (int i = 0; i < juegos.size(); i++) {
			final Juego j = juegos.get(i);

			JPanel res = new JPanel();
			res.setLayout(null);
			res.setPreferredSize(new Dimension(700, 200));
			res.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			res.setBackground(Color.DARK_GRAY);

			JButton caratula = new JButton("");
			Icon car = (Icon) Imagenes.getIcon(j.getImagen(), 1);
			caratula.setIcon(car);
			caratula.setSize(128, 180);
			caratula.setLocation(8, 6);
			caratula.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			caratula.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
					Color.BLACK, Color.BLACK, Color.BLACK));
			caratula.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Logger.log("Cargando informaci�n del juego "+j.getTitulo());
					frmPantallaPrincipal.getContentPane().removeAll();
					Logger.log("Informaci�n del juego "+j.getTitulo()+" cargada");
					Info.main(frmPantallaPrincipal, j, cesta);
				}
			});
			res.add(caratula);

			JFormattedTextField precio = new JFormattedTextField();
			precio.setSize(144, 60);
			precio.setLocation(540, 60);
			precio.setText(j.getPrecio() + " \u20AC");
			precio.setOpaque(false);
			precio.setForeground(Color.WHITE);
			precio.setFont(new Font("Tahoma", Font.PLAIN, 40));
			precio.setEditable(false);
			precio.setBorder(null);
			res.add(precio);

			JFormattedTextField releaseDate = new JFormattedTextField();
			releaseDate.setSize(114, 20);
			releaseDate.setLocation(172, 71);
			releaseDate.setText("Release date:");
			releaseDate.setOpaque(false);
			releaseDate.setForeground(Color.WHITE);
			releaseDate.setFont(new Font("Tahoma", Font.BOLD, 14));
			releaseDate.setEditable(false);
			releaseDate.setBorder(null);
			res.add(releaseDate);

			JFormattedTextField platforms = new JFormattedTextField();
			platforms.setSize(81, 20);
			platforms.setLocation(172, 107);
			platforms.setText("Platforms:");
			platforms.setOpaque(false);
			platforms.setForeground(Color.WHITE);
			platforms.setFont(new Font("Tahoma", Font.BOLD, 14));
			platforms.setEditable(false);
			platforms.setBorder(null);
			res.add(platforms);

			JFormattedTextField rating = new JFormattedTextField();
			rating.setSize(62, 20);
			rating.setLocation(172, 144);
			rating.setText("Rating:");
			rating.setOpaque(false);
			rating.setForeground(Color.WHITE);
			rating.setFont(new Font("Tahoma", Font.BOLD, 14));
			rating.setEditable(false);
			rating.setBorder(null);
			res.add(rating);

			JFormattedTextField titulo = new JFormattedTextField();
			titulo.setSize(400, 20);
			titulo.setLocation(172, 31);
			if (j.getTitulo() == null || j.getTitulo().compareTo("null") == 0)
				titulo.setText("N/A");
			else
				titulo.setText(j.getTitulo());
			titulo.setOpaque(false);
			titulo.setForeground(Color.WHITE);
			titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
			titulo.setEditable(false);
			titulo.setBorder(null);
			res.add(titulo);

			JFormattedTextField fecha = new JFormattedTextField();
			fecha.setBounds(290, 71, 170, 20);
			if (j.getLanzamiento() == null
					|| j.getLanzamiento().compareTo("null") == 0)
				fecha.setText("N/A");
			else
				fecha.setText(j.getLanzamiento());
			fecha.setOpaque(false);
			fecha.setForeground(Color.WHITE);
			fecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			fecha.setEditable(false);
			fecha.setBorder(null);
			res.add(fecha);

			JFormattedTextField plataformas = new JFormattedTextField();
			plataformas.setSize(188, 20);
			plataformas.setLocation(256, 107);
			if (j.getPlataforma().getAlias() == null
					|| j.getPlataforma().getAlias().compareTo("null") == 0)
				plataformas.setText("N/A");
			else
				plataformas.setText(j.getPlataforma().getAlias());
			plataformas.setOpaque(false);
			plataformas.setForeground(Color.WHITE);
			plataformas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			plataformas.setEditable(false);
			plataformas.setBorder(null);
			res.add(plataformas);

			JFormattedTextField valoracion = new JFormattedTextField();
			valoracion.setSize(150, 20);
			valoracion.setLocation(244, 144);
			if (j.getRating() == null || j.getRating().compareTo("null") == 0)
				valoracion.setText("N/A");
			else
				valoracion.setText(j.getRating() + " / 10");
			valoracion.setOpaque(false);
			valoracion.setForeground(Color.WHITE);
			valoracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			valoracion.setEditable(false);
			valoracion.setBorder(null);
			res.add(valoracion);

			box.add(res);
		}

		JPanel ordenacion = new JPanel();
		ordenacion.setBackground(Color.DARK_GRAY);
		ordenacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		ordenacion.setBounds(0, 95, 1060, 36);
		frmPantallaPrincipal.getContentPane().add(ordenacion);
		ordenacion.setLayout(null);

		JFormattedTextField txtResultados = new JFormattedTextField();
		txtResultados.setOpaque(false);
		txtResultados.setForeground(Color.WHITE);
		txtResultados.setEditable(false);
		txtResultados.setBorder(null);
		txtResultados.setText(juegos.size() + " games found");
		txtResultados.setBounds(10, 11, 252, 14);
		ordenacion.add(txtResultados);

		ordenacionMulti = new JComboBox<String>();
		ordenacionMulti.setBounds(909, 11, 118, 17);
		ordenacionMulti.setModel(new DefaultComboBoxModel<String>(new String[] {
				"", "Price asc.", "Price desc.", "Rating asc.",
				"Rating desc.", "Title asc.", "Title desc.", "Year asc.", "Year desc." }));
		ordenacionMulti.addActionListener(new OrdenacionListener(frmPantallaPrincipal, cesta));
		ordenacion.add(ordenacionMulti);
		JFormattedTextField txtOrdenar = new JFormattedTextField();
		txtOrdenar.setText("Sort by:");
		txtOrdenar.setOpaque(false);
		txtOrdenar.setForeground(Color.WHITE);
		txtOrdenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOrdenar.setEditable(false);
		txtOrdenar.setBorder(null);
		txtOrdenar.setBounds(842, 7, 57, 20);
		ordenacion.add(txtOrdenar);
		
		/* Panel paginación */
		
		JPanel ordenacion2 = new JPanel();
		ordenacion2.setBackground(Color.DARK_GRAY);
		ordenacion2.setBorder(new LineBorder(new Color(0, 0, 0),3));
		ordenacion2.setBounds(190, 530, 871, 42);
		frmPantallaPrincipal.getContentPane().add(ordenacion2);
		ordenacion2.setLayout(null);
		
		if(nPagina!=1){
			ordenacion2.add(BotonesCategorias.atras(frmPantallaPrincipal,cesta,nPagina));
		}
		
		if(juegos.size()==5){
			ordenacion2.add(BotonesCategorias.adelante(frmPantallaPrincipal,cesta,nPagina));
		}
		
		Logger.log("Listado de juegos inicializado");
	}
}
