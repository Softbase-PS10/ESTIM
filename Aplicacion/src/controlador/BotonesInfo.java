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
 * 				de la información del juego
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
import vista.Info;

public class BotonesInfo {

	/**
	 * @return la cabecera de la pantalla
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
	 * @return el cuadro de busqueda
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
	 * @return la lupa de busqueda
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
	 * @return las opciones
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
	 * @return el carrito
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
	 * @return las categorias
	 */
	public static JPanel getCategorias(JFrame frmInformacinDelProduc,
			ArrayList<Juego> cesta) {
		JPanel categorias = new JPanel();
		categorias.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		categorias.setBackground(Color.DARK_GRAY);
		categorias.setBounds(0, 70, 1060, 30);
		categorias.setLayout(null);
		categorias.add(BotonesCategorias.atras());
		categorias.add(BotonesCategorias.ps3(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.vita(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.xone(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.x360(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.pc(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.wiiu(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.wii(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.n3ds(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.ps4(frmInformacinDelProduc, cesta));
		categorias.add(BotonesCategorias.adelante());
		return categorias;
	}

	/**
	 * @return la label de la imagen
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
	 * @return la label del titulo
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
	 * @return la label del precio
	 */
	public static JLabel getPrecioLabel() {
		JLabel Precio = new JLabel("Price:");
		Precio.setForeground(Color.WHITE);
		Precio.setFont(new Font("Tahoma", Font.BOLD, 16));
		Precio.setBounds(405, 160, 53, 20);
		return Precio;
	}

	/**
	 * @return la label del valor del precio
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
	 * @return la label del lanzamiento
	 */
	public static JLabel getLanzamientoLabel() {
		JLabel Anio = new JLabel("Release date:");
		Anio.setFont(new Font("Tahoma", Font.BOLD, 16));
		Anio.setForeground(Color.WHITE);
		Anio.setBounds(405, 200, 133, 20);
		return Anio;
	}

	/**
	 * @return la label del valor del lanzamiento
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
	 * @return la label de la plataforma
	 */
	public static JLabel getPlataformaLabel() {
		JLabel Plataforma = new JLabel("Platform:");
		Plataforma.setFont(new Font("Tahoma", Font.BOLD, 16));
		Plataforma.setForeground(Color.WHITE);
		Plataforma.setBounds(405, 244, 88, 20);
		return Plataforma;
	}

	/**
	 * @return la label del valor de la plataforma
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
	 * @return la label del genero
	 */
	public static JLabel getGeneroLabel() {
		JLabel Genero = new JLabel("Gender:");
		Genero.setFont(new Font("Tahoma", Font.BOLD, 16));
		Genero.setForeground(Color.WHITE);
		Genero.setBounds(405, 285, 72, 20);
		return Genero;
	}

	/**
	 * @return la label del valor del genero
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
	 * @return la label de la descripcion
	 */
	public static JLabel getDescripcionLabel() {
		JLabel Descripcion = new JLabel("Description:");
		Descripcion.setForeground(Color.WHITE);
		Descripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
		Descripcion.setBounds(405, 325, 110, 20);
		return Descripcion;
	}

	/**
	 * @return la label del valor de la descripcion
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
	 * @return la label de la valoracion
	 */
	public static JLabel getValoracionLabel(String value) {
		JLabel RespValoracion = new JLabel();
		RespValoracion.setOpaque(false);
		RespValoracion.setForeground(Color.WHITE);
		RespValoracion.setFont(new Font("Tahoma", Font.BOLD, 20));
		if(!value.equals("null")){
			RespValoracion.setText(value + "/10.0");
		}
		else{
			RespValoracion.setText("NA/10.0");	
		}
		RespValoracion.setBounds(122, 401, 128, 25);
		RespValoracion.setHorizontalAlignment(SwingConstants.CENTER);
		return RespValoracion;
	}
	
	/**
	 * @return el boton del carro
	 */
	public static JButton getBotonCarro(final JFrame frame, final Juego game,
			final ArrayList<Juego> cesta) {
		JButton Carro = new JButton("Add to cart");
		Carro.setBounds(923, 525, 119, 23);
		Carro.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				cesta.add(game);
				JOptionPane.showMessageDialog(frame, "Game added to cart");
			}
		});
		return Carro;
	}

	/**
	 * @return el fondo
	 */
	public static JLabel getFondo() {
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Info.class
				.getResource("/Imagenes/blizz.jpg")));
		Fondo.setBounds(0, 100, 1065, 472);
		return Fondo;
	}

}
