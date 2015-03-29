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
import controlador.Botones;
import controlador.BotonesCabecera;
import controlador.BotonesCategorias;
import controlador.Imagenes;

public class Listado {
	private JFrame frmPantallaPrincipal;
	private JTextField txtBuscar;
	private JTextField precioMinimo;
	private JTextField precioMaximo;
	private JTextField valoracionMinima;
	private JTextField valoracionMaxima;
	
	/**
	 * Launch the application.
	 */
	public static void listar(final ArrayList<Juego> juegos) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado window = new Listado(juegos);
					window.frmPantallaPrincipal.setVisible(true);
					window.frmPantallaPrincipal.validate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Listado(ArrayList<Juego> juegos) throws IOException {
		initialize(juegos);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(ArrayList<Juego> juegos) throws IOException {
		frmPantallaPrincipal = new JFrame();
		frmPantallaPrincipal.setTitle("Listado de juegos - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Listado.class.getResource("/Imagenes/E.png")));
		frmPantallaPrincipal.setResizable(false);
		frmPantallaPrincipal.setBounds(100, 100, 1066, 600);
		frmPantallaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPantallaPrincipal.getContentPane().setLayout(null);
		
		JPanel cabecera = new JPanel();
		cabecera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cabecera.setBackground(Color.BLACK);
		cabecera.setBounds(0, 0, 1060, 70);
		frmPantallaPrincipal.getContentPane().add(cabecera);
		cabecera.setLayout(null);
		
		cabecera.add(BotonesCabecera.logo());
		
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
		lupaBuscar.add(BotonesCabecera.buscar(txtBuscar));
		
		JPanel opciones = new JPanel();
		opciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		opciones.setBounds(920, 0, 70, 70);
		cabecera.add(opciones);
		opciones.setLayout(null);
		
		opciones.add(BotonesCabecera.ajustes());
		
		JPanel carrito = new JPanel();
		carrito.setBorder(new LineBorder(new Color(0, 0, 0)));
		carrito.setBounds(990, 0, 70, 70);
		cabecera.add(carrito);
		carrito.setLayout(null);
		
		carrito.add(BotonesCabecera.carro());
		
		JPanel categorias = new JPanel();
		categorias.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		categorias.setBackground(Color.DARK_GRAY);
		categorias.setBounds(0, 70, 1060, 30);
		frmPantallaPrincipal.getContentPane().add(categorias);
		categorias.setLayout(null);
		
		categorias.add(BotonesCategorias.atras());
		categorias.add(BotonesCategorias.ps3(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.vita(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.xone(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.x360(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.pc(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.wiiu(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.wii(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.n3ds(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.ps4(frmPantallaPrincipal));
		categorias.add(BotonesCategorias.adelante());
		
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
		
		JComboBox generoMulti = new JComboBox();
		generoMulti.setToolTipText("");
		generoMulti.setName("");
		generoMulti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		generoMulti.setBounds(20, 131, 130, 20);
		filtros.add(generoMulti);
		
		JFormattedTextField textPlataforma = new JFormattedTextField();
		textPlataforma.setText("Platforms:");
		textPlataforma.setOpaque(false);
		textPlataforma.setForeground(Color.WHITE);
		textPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPlataforma.setEditable(false);
		textPlataforma.setBorder(null);
		textPlataforma.setBounds(20, 162, 171, 20);
		filtros.add(textPlataforma);
		
		JComboBox plataformaMulti = new JComboBox();
		plataformaMulti.setToolTipText("");
		plataformaMulti.setName("");
		plataformaMulti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		plataformaMulti.setBounds(20, 187, 130, 20);
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
		filtros.add(valoracionMaxima);
		filtros.add(Botones.aplicarFiltros());
		
		JPanel principal = new JPanel();
		principal.setBounds(190, 131, 870, 440);
		frmPantallaPrincipal.getContentPane().add(principal);
		principal.setLayout(new BoxLayout(principal, BoxLayout.X_AXIS));
		
		/* Panel principal, introducir juegos */
		
		JScrollPane scrollPane = new JScrollPane();
		principal.add(scrollPane);
		
		Box box = Box.createVerticalBox();
		scrollPane.setViewportView(box);
		
		for (int i = 0; i < juegos.size(); i++){
			final Juego j = juegos.get(i);
			
			JPanel res = new JPanel();
			res.setLayout(null);
			res.setPreferredSize(new Dimension(850, 200));
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
					frmPantallaPrincipal.dispose();
					Info.main(j);
				}
			});
			res.add(caratula);
			
			JFormattedTextField precio = new JFormattedTextField();
			precio.setSize(144, 60);
			precio.setLocation(514, 60);
			precio.setText(j.getPrecio() + " \u20AC");
			precio.setOpaque(false);
			precio.setForeground(Color.WHITE);
			precio.setFont(new Font("Tahoma", Font.PLAIN, 40));
			precio.setEditable(false);
			precio.setBorder(null);
			res.add(precio);
			
			JFormattedTextField releaseDate = new JFormattedTextField();
			releaseDate.setSize(104, 20);
			releaseDate.setLocation(162, 71);
			releaseDate.setText("Release date:");
			releaseDate.setOpaque(false);
			releaseDate.setForeground(Color.WHITE);
			releaseDate.setFont(new Font("Tahoma", Font.BOLD, 14));
			releaseDate.setEditable(false);
			releaseDate.setBorder(null);
			res.add(releaseDate);
			
			JFormattedTextField platforms = new JFormattedTextField();
			platforms.setSize(81, 20);
			platforms.setLocation(162, 107);
			platforms.setText("Platforms:");
			platforms.setOpaque(false);
			platforms.setForeground(Color.WHITE);
			platforms.setFont(new Font("Tahoma", Font.BOLD, 14));
			platforms.setEditable(false);
			platforms.setBorder(null);
			res.add(platforms);
			
			JFormattedTextField rating = new JFormattedTextField();
			rating.setSize(62, 20);
			rating.setLocation(162, 144);
			rating.setText("Rating:");
			rating.setOpaque(false);
			rating.setForeground(Color.WHITE);
			rating.setFont(new Font("Tahoma", Font.BOLD, 14));
			rating.setEditable(false);
			rating.setBorder(null);
			res.add(rating);
			
			JFormattedTextField titulo = new JFormattedTextField();
			titulo.setSize(329, 20);
			titulo.setLocation(162, 31);
			titulo.setText(j.getTitulo());
			titulo.setOpaque(false);
			titulo.setForeground(Color.WHITE);
			titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
			titulo.setEditable(false);
			titulo.setBorder(null);
			res.add(titulo);
			
			JFormattedTextField fecha = new JFormattedTextField();
			fecha.setBounds(276, 71, 37, 20);
			fecha.setText(j.getLanzamiento());
			fecha.setOpaque(false);
			fecha.setForeground(Color.WHITE);
			fecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			fecha.setEditable(false);
			fecha.setBorder(null);
			res.add(fecha);
			
			JFormattedTextField plataformas = new JFormattedTextField();
			plataformas.setSize(188, 20);
			plataformas.setLocation(246, 107);
			plataformas.setText(j.getPlataforma().getAlias());
			plataformas.setOpaque(false);
			plataformas.setForeground(Color.WHITE);
			plataformas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			plataformas.setEditable(false);
			plataformas.setBorder(null);
			res.add(plataformas);
			
			JFormattedTextField valoracion = new JFormattedTextField();
			valoracion.setSize(37, 20);
			valoracion.setLocation(234, 144);
			valoracion.setText(j.getRating());
			valoracion.setOpaque(false);
			valoracion.setForeground(Color.WHITE);
			valoracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			valoracion.setEditable(false);
			valoracion.setBorder(null);
			res.add(valoracion);
			
			box.add(res);
		}
		
//		JPanel resultado_2 = new JPanel();
//		resultado_2.setBounds(0, 0, 680, 195);
//		resultado_2.setLayout(null);
//		resultado_2.setBackground(Color.DARK_GRAY);
//		box.add(resultado_2);
//		
//		JButton caratula_2 = new JButton("");
//		caratula_2.setBounds(8, 6, 130, 183);
//		resultado_2.add(caratula_2);
//		caratula_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		
//		caratula_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		caratula_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
//				Color.BLACK, Color.BLACK, Color.BLACK));
//		
//		JFormattedTextField precio_1 = new JFormattedTextField();
//		precio_1.setText("59.95 \u20AC");
//		precio_1.setOpaque(false);
//		precio_1.setForeground(Color.WHITE);
//		precio_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
//		precio_1.setEditable(false);
//		precio_1.setBorder(null);
//		precio_1.setBounds(514, 60, 144, 60);
//		resultado_2.add(precio_1);
//		
//		JFormattedTextField releaseDate_1 = new JFormattedTextField();
//		releaseDate_1.setText("Release date:");
//		releaseDate_1.setOpaque(false);
//		releaseDate_1.setForeground(Color.WHITE);
//		releaseDate_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//		releaseDate_1.setEditable(false);
//		releaseDate_1.setBorder(null);
//		releaseDate_1.setBounds(162, 71, 104, 20);
//		resultado_2.add(releaseDate_1);
//		
//		JFormattedTextField platforms_1 = new JFormattedTextField();
//		platforms_1.setText("Platforms:");
//		platforms_1.setOpaque(false);
//		platforms_1.setForeground(Color.WHITE);
//		platforms_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//		platforms_1.setEditable(false);
//		platforms_1.setBorder(null);
//		platforms_1.setBounds(162, 107, 81, 20);
//		resultado_2.add(platforms_1);
//		
//		JFormattedTextField rating_1 = new JFormattedTextField();
//		rating_1.setText("Rating:");
//		rating_1.setOpaque(false);
//		rating_1.setForeground(Color.WHITE);
//		rating_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//		rating_1.setEditable(false);
//		rating_1.setBorder(null);
//		rating_1.setBounds(162, 144, 62, 20);
//		resultado_2.add(rating_1);
//		
//		JFormattedTextField title = new JFormattedTextField();
//		title.setText("Super Smash Bros");
//		title.setOpaque(false);
//		title.setForeground(Color.WHITE);
//		title.setFont(new Font("Tahoma", Font.BOLD, 16));
//		title.setEditable(false);
//		title.setBorder(null);
//		title.setBounds(162, 31, 329, 20);
//		resultado_2.add(title);
//		
//		JFormattedTextField fecha_1 = new JFormattedTextField();
//		fecha_1.setText("2014");
//		fecha_1.setOpaque(false);
//		fecha_1.setForeground(Color.WHITE);
//		fecha_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		fecha_1.setEditable(false);
//		fecha_1.setBorder(null);
//		fecha_1.setBounds(264, 71, 37, 20);
//		resultado_2.add(fecha_1);
//		
//		JFormattedTextField plataformas_1 = new JFormattedTextField();
//		plataformas_1.setText("Wii U");
//		plataformas_1.setOpaque(false);
//		plataformas_1.setForeground(Color.WHITE);
//		plataformas_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		plataformas_1.setEditable(false);
//		plataformas_1.setBorder(null);
//		plataformas_1.setBounds(246, 107, 37, 20);
//		resultado_2.add(plataformas_1);
//		
//		JFormattedTextField valoracion_1 = new JFormattedTextField();
//		valoracion_1.setText("100");
//		valoracion_1.setOpaque(false);
//		valoracion_1.setForeground(Color.WHITE);
//		valoracion_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		valoracion_1.setEditable(false);
//		valoracion_1.setBorder(null);
//		valoracion_1.setBounds(234, 144, 37, 20);
//		resultado_2.add(valoracion_1);
		
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
		
		JComboBox ordenacionMulti = new JComboBox();
		ordenacionMulti.setBounds(909, 11, 118, 17);
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
	}
}
