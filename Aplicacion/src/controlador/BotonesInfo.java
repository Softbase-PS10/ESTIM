/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que contiene la creacion de labels para la capa
 * 				de la informaci√≥n del juego
 */

package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.Juego;
import modelo.Logger;
import vista.Info;

public class BotonesInfo {

	/**
	 * Metodo que devuelve el label con la cabecera del programa
	 * @param framePrincipal
	 *            : Frame completo del programa
	 * @param cesta
	 * 			  : Array de juegos en el carro
	 * @return el label de la cabecera del programa
	 */
	public static JPanel getCabecera(JFrame framePrincipal,
			ArrayList<Juego> cesta) {
		JPanel cabecera = new JPanel();
		cabecera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cabecera.setBackground(Color.BLACK);
		cabecera.setBounds(0, 0, 1060, 70);
		cabecera.setLayout(null);
		cabecera.add(BotonesCabecera.logo(framePrincipal, cesta));
		return cabecera;
	}

	/**
	 * Metodo que devuelve el cuadro de busqueda del programa
	 * @return el campo de texto para buscar de la cabecera del programa
	 */
	public static JTextField getCuadroBusqueda() {
		JTextField txtBuscar = new JTextField();
		txtBuscar.setToolTipText("");
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscar.setBounds(650, 20, 192, 30);
		txtBuscar.setColumns(10);
		return txtBuscar;
	}

	/**
	 * Metodo que devuelve el panel con la lupa de la cabecera del programa
	 * @param txtBuscar
	 *            : Campo de texto donde se va a escribir que buscar
	 * @param cesta
	 * 			  : Array de juegos en el carro
	 * @return el panel de la lupa
	 */
	public static JPanel getLupaBuscar(JTextField txtBuscar,
			ArrayList<Juego> cesta) {
		JPanel lupaBuscar = new JPanel();
		lupaBuscar.setBounds(841, 20, 30, 30);
		lupaBuscar.setLayout(null);
		lupaBuscar.add(BotonesCabecera.buscar(txtBuscar, cesta));
		return lupaBuscar;
	}

	/**
	 * Metodo que devuelve el panel con las opciones del programa
	 * @param juego
	 *            : Juego a mostrar
	 * @param juegos
	 * 			  : Listado de juegos mostrados en la busqueda desde donde se llama
	 * @param fr
	 * 			  : Frame donde se va a mostrar el panel
	 * @param cesta
	 * 			  : Array de juegos en el carro
	 * @return el panel de las opciones del programa
	 */
	public static JPanel getOpciones(Juego juego, ArrayList<Juego> juegos,  JFrame fr,
			ArrayList<Juego> cesta) {
		JPanel opciones = new JPanel();
		opciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		opciones.setBounds(920, 0, 70, 70);
		opciones.setLayout(null);
		opciones.add(BotonesCabecera.ajustes(3,juego, juegos, fr, cesta));
		return opciones;
	}

	/**
	 * Metodo que devuelve el label con el carrito del programa
	 * @param cesta
	 * 			  : Array de juegos en el carro
	 * @return el panel del carrito de la cabecera del programa
	 */
	public static JPanel getCarrito(ArrayList<Juego> cesta) {
		JPanel carrito = new JPanel();
		carrito.setBorder(new LineBorder(new Color(0, 0, 0)));
		carrito.setBounds(990, 0, 70, 70);
		carrito.setLayout(null);
		carrito.add(BotonesCabecera.carro(cesta));
		return carrito;
	}

	/**
	 * Metodo que devuelve el panel con todas las categorias del programa
	 * @param frmInformacinDelProduc
	 *            : Frame de las categorias del programa
	 * @param cesta
	 * 			  : Array de juegos en el carro
	 * @return el panel de todas las categorias del programa
	 */
	public static JPanel getCategorias(JFrame frmInformacinDelProduc,
			ArrayList<Juego> cesta) {
		JPanel categorias = new JPanel();
		categorias.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		categorias.setBackground(Color.DARK_GRAY);
		categorias.setBounds(0, 70, 1060, 30);
		categorias.setLayout(null);
		categorias.add(BotonesCategorias.allgames(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.ps3(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.vita(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.xone(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.x360(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.pc(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.wiiu(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.wii(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.n3ds(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.ps4(frmInformacinDelProduc, cesta));
		return categorias;
	}

	/**
	 * Metodo que devuelve el panel con todas las categorias del programa
	 * @param url
	 *            : Url de la imagen a mostrar
	 * @return el label con la imagen del juego
	 */
	public static JLabel getImagenLabel(String url) {
		JLabel lblNewLabel = new JLabel("");
		if(!url.equals("null")) {
			lblNewLabel.setBounds(122, 181, 128, 180);
			try {
				lblNewLabel.setIcon(controlador.Imagenes.getIcon(url, 1));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			lblNewLabel.setBounds(122, 181, 128, 180);
			try {
				lblNewLabel.setIcon(controlador.Imagenes.getIcon("/Imagenes/not_available.jpg", 1));
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		return lblNewLabel;
	}

	/**
	 * Metodo que devuelve el label con el nombre del juego
	 * @param tituloString
	 * 			  : Titulo del juego
	 * @return el label con el nombre del juego
	 */
	public static JLabel getTituloLabel(String tituloString) {
		JLabel Titulo = new JLabel();
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		Titulo.setOpaque(false);
		Titulo.setBackground(new Color(255, 255, 255));
		Titulo.setBorder(null);
		Titulo.setForeground(Color.WHITE);
		if(!tituloString.equals("null")){
			Titulo.setText(tituloString + "\r\n");
		}
		else{
			Titulo.setText("N/A" + "\r\n");	
		}
		Titulo.setBounds(0, 105, 1066, 31);
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		return Titulo;
	}

	/**
	 * Metodo que devuelve el label que indica el precio del juego
	 * @return el label que pone price:
	 */
	public static JLabel getPrecioLabel() {
		JLabel Precio = new JLabel("Price:");
		Precio.setForeground(Color.WHITE);
		Precio.setFont(new Font("Tahoma", Font.BOLD, 16));
		Precio.setBounds(405, 160, 53, 20);
		return Precio;
	}

	/**
	 * Metodo que devuelve el label con el valor del precio del juego
	 * @param value
	 *            : Precio del juego
	 * @return el label del valor del precio
	 */
	public static JLabel getPrecioValueLabel(int value) {
		JLabel RespPrecio = new JLabel();
		RespPrecio.setOpaque(false);
		RespPrecio.setForeground(Color.WHITE);
		RespPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RespPrecio.setText(value + "\u20AC");
		RespPrecio.setBounds(540, 160, 200, 20);
		return RespPrecio;
	}

	/**
	 * Metodo que devuelve el label que indica la fecha de lanzamiento del juego
	 * @return el label que pone release date:
	 */
	public static JLabel getLanzamientoLabel() {
		JLabel Anio = new JLabel("Release date:");
		Anio.setFont(new Font("Tahoma", Font.BOLD, 16));
		Anio.setForeground(Color.WHITE);
		Anio.setBounds(405, 200, 133, 20);
		return Anio;
	}

	/**
	 * Metodo que devuelve el label con el valor de la fecha de lanzamiento del juego
	 * @param value
	 *            : Fecha del juego en el siguiente formato dd/mm/yy
	 * @return el label del valor de la fecha de lanzamiento
	 */
	public static JLabel getLanzamientoValueLabel(String value) {
		JLabel RespAnio = new JLabel();
		RespAnio.setForeground(Color.WHITE);
		RespAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RespAnio.setOpaque(false);
		if (!value.equals("null")) {
			RespAnio.setText(value);
		} else {
			RespAnio.setText("N/A");
		}
		
		RespAnio.setBounds(540, 200, 282, 20);
		return RespAnio;
	}

	/**
	 * Metodo que devuelve el label que indica la plataforma del juego 
	 * @return el label que pone platform:
	 */
	public static JLabel getPlataformaLabel() {
		JLabel Plataforma = new JLabel("Platform:");
		Plataforma.setFont(new Font("Tahoma", Font.BOLD, 16));
		Plataforma.setForeground(Color.WHITE);
		Plataforma.setBounds(405, 244, 88, 20);
		return Plataforma;
	}

	/**
	 * Metodo que devuelve el label con todas las plataformas del juego
	 * @param value
	 * 			  : Cadena con las plataformas del juego
	 * @return el label de todas las plataformas del juego
	 */
	public static JLabel getPlataformaValueLabel(String value) {
		JLabel RespPlataforma = new JLabel();
		RespPlataforma.setOpaque(false);
		RespPlataforma.setForeground(Color.WHITE);
		RespPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		if(!value.equals("null")){
			RespPlataforma.setText(value);	
		}
		else{
			RespPlataforma.setText("N/A");
		}
		RespPlataforma.setBounds(540, 244, 254, 20);
		return RespPlataforma;
	}

	/**
	 * Metodo que devuelve el label que indica el genero del juego 
	 * @return el label que pone genres:
	 */
	public static JLabel getGeneroLabel() {
		JLabel Genero = new JLabel("Genres:");
		Genero.setFont(new Font("Tahoma", Font.BOLD, 16));
		Genero.setForeground(Color.WHITE);
		Genero.setBounds(405, 285, 72, 20);
		return Genero;
	}

	/**
	 * Metodo que devuelve el label con todos los generos del juego
	 * @param value
	 * 			  : Cadena con los generos del juego
	 * @return el label de todos los generos del programa
	 */
	public static JLabel getGeneroValueLabel(String value) {
		JLabel RespGenero = new JLabel();
		RespGenero.setOpaque(false);
		if(!value.equals("null")){
			RespGenero.setText(value);	
		}
		else{
			RespGenero.setText("N/A");	
		}
		RespGenero.setForeground(Color.WHITE);
		RespGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RespGenero.setBounds(540, 285, 200, 20);
		return RespGenero;
	}

	/**
	 * Metodo que devuelve el label que indica la descripcion del juego 
	 * @return el label que pone description:
	 */
	public static JLabel getDescripcionLabel() {
		JLabel Descripcion = new JLabel("Description:");
		Descripcion.setForeground(Color.WHITE);
		Descripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
		Descripcion.setBounds(405, 325, 110, 20);
		return Descripcion;
	}

	/**
	 * Metodo que devuelve el area de texto con la descripcion del juego
	 * @param value
	 * 			  : Descripcion del juego
	 * @return el area de texto de la descripcion del juego
	 */
	public static JTextArea getDescripcionValueLabel(String value) {
		JTextArea RespDescripcion = new JTextArea();
		RespDescripcion.setForeground(Color.WHITE);
		RespDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		if(!value.equals("null")){
			RespDescripcion.setText(value);	
		}
		else{
			RespDescripcion.setText("");
		}
		RespDescripcion.setOpaque(false);
		RespDescripcion.setBounds(540, 325, 475, 170);
		RespDescripcion.setLineWrap(true);
		RespDescripcion.setWrapStyleWord(true);
		return RespDescripcion;
	}
	
	/**
	 * Metodo que devuelve el label con la valoracion del juego
	 * @param value
	 * 			  : valoracion del juego 
	 * @return el label de la valoracion del juego
	 */
	public static JLabel getValoracionLabel(String value) {
		JLabel RespValoracion = new JLabel();
		RespValoracion.setOpaque(false);
		RespValoracion.setForeground(Color.WHITE);
		RespValoracion.setFont(new Font("Tahoma", Font.BOLD, 20));
		if(!value.equals("null")){
			RespValoracion.setText(value + "/10");
		}
		else{
			RespValoracion.setText("NA/10");	
		}
		RespValoracion.setBounds(122, 401, 128, 25);
		RespValoracion.setHorizontalAlignment(SwingConstants.CENTER);
		return RespValoracion;
	}
	
	/**
	 * Metodo que devuelve el boton del carro del programa
	 * @param frame
	 *            : Frame principal
	 * @param game
	 *            : Juego del que se va a mostrar la informacion 
	 * @param cesta
	 * 			  : Array de juegos en el carro
	 * @return el panel de todas las categorias del programa
	 */
	public static JButton getBotonCarro(final JFrame frame, final Juego game,
			final ArrayList<Juego> cesta) {
		JButton Carro = new JButton("Add to cart");
		Carro.setBounds(923, 525, 119, 23);
		Carro.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				Logger.log("AÒadiendo juego "+game.getTitulo()+" al carro");
				cesta.add(game);
				Logger.log("Juego "+game.getTitulo()+" agregado al carro");
				JOptionPane.showMessageDialog(frame, "Game added to cart");
			}
		});
		return Carro;
	}

	/**
	 * Metodo que devuelve el label con el fondo puesto
	 * @return el label con el fondo 
	 */
	public static JLabel getFondo() {
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Info.class
				.getResource("/Imagenes/blizz.jpg")));
		Fondo.setBounds(0, 100, 1065, 472);
		return Fondo;
	}

}
