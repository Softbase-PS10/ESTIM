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
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;

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
import controlador.Botones;
import controlador.BotonesCabecera;
import controlador.BotonesCategorias;
import controlador.Imagenes;


public class Modificar {

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
	public static JFormattedTextField eTitulo;
	public static JLabel vistaPreviaCaratula;
	private static Juego j;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					Modificar window = new Modificar(null);
					window.frmPantallaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param j: juego del cual se extraen datos para mostrarlos en los campos
	 * correspondientes. Si es =null, los campos quedarán vacios.
	 */
	@SuppressWarnings("static-access")
	public Modificar(Juego j) {
		this.j = j;
		initialize();
	}
	
	public static void ocultarMod(){
		frmPantallaPrincipal.dispose();
	}
	
	/**
	 * Muestra la interfaz y rellena los campos conforme el juego que hay 
	 * en las variables globales.
	 */
	@SuppressWarnings("static-access")
	public void mostrarMod(){

		this.frmPantallaPrincipal.setVisible(true);
		
		if(j != null){
			titulo.setText(j.getTitulo());
		}
		if(j != null){
			precio.setText(j.getPrecio() + "");
		}
		if(j != null){
			anyo.setText(j.getLanzamiento());
		}
		if(j != null){
			valoracion.setText(j.getRating());
		}
		if(j != null){
			url.setText(j.getImagen());
		}
		if(j != null){
			descripcion.setText(j.getDescripcion());
		}
		if(j!=null){
			try {
				ImageIcon caratula = Imagenes.getIcon(j.getImagen(),1);
				vistaPreviaCaratula.setIcon(caratula);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(j != null){
			String[] listaP = new String[] {"PS4", "PS3",
					"PSVITA", "XONE", "X360", "PC", "WII U", "WII", "N3DS"};
			boolean encontrado = false;
			int i = 0;
			while(i<listaP.length && !encontrado){
				if(listaP[i].equalsIgnoreCase(j.getPlataforma().getAlias())){
					encontrado = true;
				}
				else{
					i++;
				}
			}
			plataforma.setSelectedIndex(i);
		}
		String[] generos = new String[] {"Action", "Adventure",
				"Construction and Management Simulation", "Fighting",
				"Flight Simulator", "Horror", "Life Simulation", "MMO",
				"Music", "Platform", "Puzzle", "Racing", "Role-Playing",
				"Sandbox", "Shooter", "Sports", "Stealth", "Strategy",
				"Vehicle Simulation"};

		for(int i = 0; i < generos.length; i++){
			if(j != null){
				for(String g:j.getGenero()){
					if(g.equalsIgnoreCase(generos[i])){
						genero.getItem(i).setSelected(true);
					}
				}
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaPrincipal = new JFrame();
		frmPantallaPrincipal.setTitle("Add/Modify - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().
				getImage(Modificar.class.getResource("/Imagenes/E.png")));
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
		
		cabecera.add(BotonesCabecera.logo(frmPantallaPrincipal));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(990, 0, 70, 70);
		cabecera.add(panel);
		panel.setLayout(null);
		
		panel.add(BotonesCabecera.carro());
		
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

		panel_2.add(BotonesCabecera.buscar(txtBuscar));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(920, 0, 70, 70);
		cabecera.add(panel_1);
		panel_1.setLayout(null);
		
		panel_1.add(BotonesCabecera.ajustes(4,null));
		
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
		nPlataformas.setText("PLATFORMS:");
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
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(214, 238, 300, 152);
		panel_3.add(scrollPane);
		
		descripcion = new JTextArea();
		descripcion.setWrapStyleWord(true);
		descripcion.setLineWrap(true);
		scrollPane.setViewportView(descripcion);
		
		vistaPreviaCaratula = new JLabel("Cover preview");
		vistaPreviaCaratula.setHorizontalAlignment(SwingConstants.CENTER);
		vistaPreviaCaratula.setHorizontalTextPosition(SwingConstants.CENTER);
		vistaPreviaCaratula.setOpaque(true);
		vistaPreviaCaratula.setBackground(Color.LIGHT_GRAY);
		vistaPreviaCaratula.setBounds(706, 114, 170, 240);
		panel_3.add(vistaPreviaCaratula);
		
		
		panel_3.add(Botones.save(j));

		
		plataforma = new JComboBox<String>();
		String[] listaP = new String[] {"PS4", "PS3",
				"PSVita", "XONE", "X360", "PC", "Wii U", "Wii", "3DS"};
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
		
		String[] generos = new String[] {"Action", "Adventure",
				"Construction and Management Simulation", "Fighting",
				"Flight Simulator", "Horror", "Life Simulation", "MMO",
				"Music", "Platform", "Puzzle", "Racing", "Role-Playing",
				"Sandbox", "Shooter", "Sports", "Stealth", "Strategy",
				"Vehicle Simulation"};
		
		for(int i = 0; i < generos.length; i++){
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
		panel_3.add(ePrecio);
		
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
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 1060, 471);
		fondo.setIcon(new ImageIcon(Modificar.class.getResource("/Imagenes/blizz.jpg")));
		panel_3.add(fondo);
	}
}
