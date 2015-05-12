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
import javax.swing.ImageIcon;
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
import controlador.Botones;
import controlador.BotonesCabecera;
import controlador.BotonesCategorias;
import controlador.Imagenes;

public class Carro {

	/* declaracion de variables */
	private JFrame frmPantallaPrincipal;
	private JTextField txtBuscar;
	public static JTextField valoracionMinima, valoracionMaxima;
	public static JComboBox<String> generoMulti, plataformaMulti;

	private ArrayList<Juego> games; // asi se podra realizar la ordenacion mas
									// adelante

	/**
	 * Launch the application.
	 */
	public static void main(final JFrame frame, final ArrayList<Juego> cesta) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carro window = new Carro(frame, cesta);
					window.frmPantallaPrincipal.repaint();
					window.frmPantallaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public Carro(JFrame frame, ArrayList<Juego> cesta) throws IOException {
		frame.getContentPane().removeAll();
		initialize(frame, cesta);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize(JFrame frm, final ArrayList<Juego> cesta)
			throws IOException {
		Logger.log("Inicializando frame carro...");
		games = cesta;
		frmPantallaPrincipal = frm;
		frmPantallaPrincipal.setTitle("Main window - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Principal.class.getResource("/Imagenes/E.png")));
		frmPantallaPrincipal.setResizable(false);
		frmPantallaPrincipal.setBounds(100, 100, 1066, 600);
		frmPantallaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPantallaPrincipal.getContentPane().setLayout(null);
		frmPantallaPrincipal.setTitle("Cart - Estim");
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

		opciones.add(BotonesCabecera.ajustes(2, null, null,
				frmPantallaPrincipal, cesta));

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

		categorias.add(BotonesCategorias.atras());
		categorias.add(BotonesCategorias.ps3(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.vita(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.xone(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.x360(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.pc(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.wiiu(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.wii(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.n3ds(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.ps4(frmPantallaPrincipal, cesta));
		categorias.add(BotonesCategorias.adelante());

		JPanel filtros = new JPanel();
		filtros.setBackground(Color.DARK_GRAY);
		filtros.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		filtros.setBounds(0, 131, 191, 440);
		frmPantallaPrincipal.getContentPane().add(filtros);
		filtros.setLayout(null);

		JFormattedTextField precioFiltros = new JFormattedTextField();
		precioFiltros.setText("Total price:");
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
		tituloFiltros.setText("CART INFO");
		tituloFiltros.setBounds(10, 11, 171, 20);
		filtros.add(tituloFiltros);

		filtros.add(Botones.vaciarCarro(frmPantallaPrincipal));
		filtros.add(Botones.comprarCarro(frmPantallaPrincipal));

		JPanel principal = new JPanel();
		principal.setBounds(190, 131, 870, 440);
		principal.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		frmPantallaPrincipal.getContentPane().add(principal);
		principal.setLayout(new BoxLayout(principal, BoxLayout.X_AXIS));

		/* Panel principal, introducir juegos */

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		scrollPane.setPreferredSize(new Dimension(850, 440));
		principal.add(scrollPane);

		scrollPane.getVerticalScrollBar().setUnitIncrement(20);

		Box box = Box.createVerticalBox();
		scrollPane.setViewportView(box);

		int precioTotal = 0;

		if (games.size() == 0) {
			JPanel res = new JPanel();
			res.setLayout(null);
			res.setPreferredSize(new Dimension(700, 200));
			res.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			res.setBackground(Color.DARK_GRAY);
			box.add(res);

			JFormattedTextField frmtdtxtfldTotal = new JFormattedTextField();
			frmtdtxtfldTotal.setText("No games in your cart at the moment");
			frmtdtxtfldTotal.setOpaque(false);
			frmtdtxtfldTotal.setForeground(Color.WHITE);
			frmtdtxtfldTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			frmtdtxtfldTotal.setEditable(false);
			frmtdtxtfldTotal.setBorder(null);
			frmtdtxtfldTotal.setBounds(10, 10, 700, 60);
			res.add(frmtdtxtfldTotal);
		} else {

			for (int i = 0; i < games.size(); i++) {
				final Juego j = games.get(i);
				final int indiceJuego = i;
				precioTotal = precioTotal + j.getPrecio();

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
				caratula.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				caratula.setBorder(new BevelBorder(BevelBorder.RAISED,
						Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
				caratula.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Logger.log("Cargando información del juego "+j.getTitulo());
						frmPantallaPrincipal.getContentPane().removeAll();
						Logger.log("Información del juego "+j.getTitulo()+" cargada");
						Info.main(frmPantallaPrincipal, j, cesta);
					}
				});
				res.add(caratula);

				JFormattedTextField precio = new JFormattedTextField();
				precio.setSize(144, 60);
				precio.setLocation(530, 60);
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
				titulo.setSize(400, 20);
				titulo.setLocation(162, 31);
				if (j.getTitulo() == null
						|| j.getTitulo().compareTo("null") == 0)
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
				fecha.setBounds(270, 71, 170, 20);
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
				plataformas.setLocation(246, 107);
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
				valoracion.setLocation(234, 144);
				if (j.getRating() == null
						|| j.getRating().compareTo("null") == 0)
					valoracion.setText("N/A");
				else
					valoracion.setText(j.getRating() + " / 10.0");
				valoracion.setOpaque(false);
				valoracion.setForeground(Color.WHITE);
				valoracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				valoracion.setEditable(false);
				valoracion.setBorder(null);
				res.add(valoracion);

				JButton btnNewButton = new JButton("");
				btnNewButton.setBounds(700, 62, 69, 60);
				res.add(btnNewButton);
				btnNewButton.setContentAreaFilled(false);
				btnNewButton.setRolloverIcon(new ImageIcon(Carro.class
						.getResource("/Imagenes/B/botonP.png")));
				btnNewButton.setBorder(null);
				btnNewButton.setOpaque(false);
				btnNewButton.setIcon(new ImageIcon(Carro.class
						.getResource("/Imagenes/B/botonSP.png")));
				btnNewButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String titulo = games.get(indiceJuego).getTitulo();
						Logger.log("Borrando juego "
								+ titulo
								+ " del carro");
						games.remove(indiceJuego);
						Logger.log("Juego "
								+ titulo
								+ " borrado del carro");
						Carro.main(frmPantallaPrincipal, games);
					}
				});

				box.add(res);
			}
		}
		JFormattedTextField textToPrecio = new JFormattedTextField();
		textToPrecio.setText(precioTotal + " \u20AC");
		textToPrecio.setOpaque(false);
		textToPrecio.setForeground(Color.WHITE);
		textToPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		textToPrecio.setEditable(false);
		textToPrecio.setBorder(null);
		textToPrecio.setBounds(81, 73, 50, 20);
		filtros.add(textToPrecio);

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
		txtResultados.setText(games.size() + " games in the cart");
		txtResultados.setBounds(10, 11, 252, 14);
		ordenacion.add(txtResultados);
		Logger.log("Frame carro creado");
	}
}
