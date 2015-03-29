/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: 
 */

package vista;

import java.awt.Color;
import java.awt.EventQueue;

import modelo.Juego;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.io.IOException;



import javax.swing.ImageIcon;

import controlador.BotonesCabecera;
import controlador.BotonesCategorias;


public class Info {

	private JFrame frmInformacinDelProduc;
	private JTextField txtBuscar;
	private static Juego juego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego p = new Juego(2);
		p.setImagen("http://www.matrallune.com/images/imagen_corporativa.jpg");
		//Listado.main(null);
		main(p);
	}

	public static void main(Juego jue) {
		juego = jue;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info window = new Info(juego);
					window.frmInformacinDelProduc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Info(Juego juego) {
		initialize(juego);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Juego juego) {
		frmInformacinDelProduc = new JFrame();
		frmInformacinDelProduc.setTitle("Informaci\u00F3n del producto - Estim");
		frmInformacinDelProduc.setResizable(false);
		frmInformacinDelProduc.setIconImage(Toolkit.getDefaultToolkit().getImage(Info.class.getResource("/Imagenes/E.png")));
		frmInformacinDelProduc.setBounds(100, 100, 1066, 600);
		frmInformacinDelProduc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformacinDelProduc.getContentPane().setLayout(null);
		
		JPanel cabecera = new JPanel();
		cabecera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cabecera.setBackground(Color.BLACK);
		cabecera.setBounds(0, 0, 1060, 70);
		frmInformacinDelProduc.getContentPane().add(cabecera);
		cabecera.setLayout(null);
		
		cabecera.add(BotonesCabecera.logo(frmInformacinDelProduc));
		
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
		frmInformacinDelProduc.getContentPane().add(categorias);
		categorias.setLayout(null);
		
		categorias.add(BotonesCategorias.atras());
		categorias.add(BotonesCategorias.ps3(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.vita(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.xone(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.x360(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.pc(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.wiiu(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.wii(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.n3ds(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.ps4(frmInformacinDelProduc));
		categorias.add(BotonesCategorias.adelante());

		JPanelMenu m = new JPanelMenu("                ");
		m.setOpaque(false);
		m.add(new JMenuItem("Modify"));
		m.add(new JMenuItem("Delete"));
		m.add(new JMenuItem("Exit"));
		m.setBounds(920, 0, 70, 70);
		frmInformacinDelProduc.getContentPane().add(m);
		
		//Imagen
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(122, 181, 128, 180);
		frmInformacinDelProduc.getContentPane().add(lblNewLabel);
		try {
			lblNewLabel.setIcon(controlador.Imagenes.getIcon(juego.getImagen(), 1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel Titulo = new JLabel();
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		Titulo.setOpaque(false);
		Titulo.setBackground(new Color(255, 255, 255));
		Titulo.setBorder(null);
		Titulo.setForeground(Color.WHITE);
		Titulo.setText("FGJ"
				+ juego.getTitulo() + "\r\n");
		Titulo.setBounds(0, 105, 1066, 31);
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		frmInformacinDelProduc.getContentPane().add(Titulo);
		
		JLabel Precio = new JLabel("Price:");
		Precio.setForeground(Color.WHITE);
		Precio.setFont(new Font("Tahoma", Font.BOLD, 16));
		Precio.setBounds(405, 160, 53, 20);
		frmInformacinDelProduc.getContentPane().add(Precio);
		
		JLabel RespPrecio = new JLabel();
		RespPrecio.setOpaque(false);
		RespPrecio.setForeground(Color.WHITE);
		RespPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RespPrecio.setText(juego.getPrecio() + "\u20AC");
		RespPrecio.setBounds(540, 160, 200, 20);
		frmInformacinDelProduc.getContentPane().add(RespPrecio);
		
		JLabel Anio = new JLabel("Release date:");
		Anio.setFont(new Font("Tahoma", Font.BOLD, 16));
		Anio.setForeground(Color.WHITE);
		Anio.setBounds(405, 200, 133, 20);
		frmInformacinDelProduc.getContentPane().add(Anio);
		
		JLabel RespAnio = new JLabel();
		RespAnio.setForeground(Color.WHITE);
		RespAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RespAnio.setOpaque(false);
		RespAnio.setText("fgj" + juego.getLanzamiento());
		RespAnio.setBounds(540, 200, 282, 20);
		frmInformacinDelProduc.getContentPane().add(RespAnio);
		
		JLabel Plataforma = new JLabel("Platform:");
		Plataforma.setFont(new Font("Tahoma", Font.BOLD, 16));
		Plataforma.setForeground(Color.WHITE);
		Plataforma.setBounds(405, 244, 88, 20);
		frmInformacinDelProduc.getContentPane().add(Plataforma);
		
		JLabel RespPlataforma = new JLabel();
		RespPlataforma.setOpaque(false);
		RespPlataforma.setForeground(Color.WHITE);
		RespPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RespPlataforma.setText("fgj" + juego.getPlataforma().getNombre());
		RespPlataforma.setBounds(540, 244, 254, 20);
		frmInformacinDelProduc.getContentPane().add(RespPlataforma);
		
		JLabel Genero = new JLabel("Gender:");
		Genero.setFont(new Font("Tahoma", Font.BOLD, 16));
		Genero.setForeground(Color.WHITE);
		Genero.setBounds(405, 285, 72, 20);
		frmInformacinDelProduc.getContentPane().add(Genero);
		
		JLabel RespGenero = new JLabel();
		RespGenero.setOpaque(false);
		RespGenero.setText("fgj" + juego.getGenero().toString().substring(1, juego.getGenero().toString().length()-1));
		RespGenero.setForeground(Color.WHITE);
		RespGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RespGenero.setBounds(540, 285, 200, 20);
		frmInformacinDelProduc.getContentPane().add(RespGenero);
		
		JLabel Descripcion = new JLabel("Description:");
		Descripcion.setForeground(Color.WHITE);
		Descripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
		Descripcion.setBounds(405, 325, 110, 20);
		frmInformacinDelProduc.getContentPane().add(Descripcion);
		
		JTextArea RespDescripcion = new JTextArea();
		RespDescripcion.setForeground(Color.WHITE);
		RespDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RespDescripcion.setText(juego.getDescripcion());
		RespDescripcion.setOpaque(false);
		RespDescripcion.setBounds(540, 325, 500, 164);
		RespDescripcion.setLineWrap(true);
		frmInformacinDelProduc.getContentPane().add(RespDescripcion);
		
		JLabel RespValoracion = new JLabel();
		RespValoracion.setOpaque(false);
		RespValoracion.setForeground(Color.WHITE);
		RespValoracion.setFont(new Font("Tahoma", Font.BOLD, 20));
		RespValoracion.setText(juego.getRating()+ "/10.0");
		RespValoracion.setBounds(122, 401, 128, 25);
		RespValoracion.setHorizontalAlignment(SwingConstants.CENTER);
		frmInformacinDelProduc.getContentPane().add(RespValoracion);
		
		JButton Carro = new JButton("Add to cart");
		Carro.setBounds(923, 525, 119, 23);
		frmInformacinDelProduc.getContentPane().add(Carro);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/blizz.jpg")));
		Fondo.setBounds(0, 100, 1065, 472);
		frmInformacinDelProduc.getContentPane().add(Fondo);
		
	}
}
