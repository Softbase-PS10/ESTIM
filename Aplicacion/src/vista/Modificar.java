package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.Botones;
import controlador.BotonesCabecera;
import controlador.BotonesCategorias;


public class Modificar {

	private JFrame frmPantallaPrincipal;
	private JTextField txtBuscar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar window = new Modificar();
					window.frmPantallaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Modificar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaPrincipal = new JFrame();
		frmPantallaPrincipal.setTitle("Add/Modify - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Modificar.class.getResource("/Imagenes/E.png")));
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

		panel_2.add(BotonesCabecera.buscar());

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(920, 0, 70, 70);
		cabecera.add(panel_1);
		panel_1.setLayout(null);
		
		panel_1.add(BotonesCabecera.ajustes());
		
		JPanel categorias = new JPanel();
		categorias.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		categorias.setBackground(Color.DARK_GRAY);
		categorias.setBounds(0, 70, 1060, 30);
		frmPantallaPrincipal.getContentPane().add(categorias);
		categorias.setLayout(null);

		categorias.add(BotonesCategorias.atras());
		categorias.add(BotonesCategorias.ps3());
		categorias.add(BotonesCategorias.vita());
		categorias.add(BotonesCategorias.xone());
		categorias.add(BotonesCategorias.x360());
		categorias.add(BotonesCategorias.pc());
		categorias.add(BotonesCategorias.wiiu());
		categorias.add(BotonesCategorias.wii());
		categorias.add(BotonesCategorias.n3ds());
		categorias.add(BotonesCategorias.ps4());
		categorias.add(BotonesCategorias.adelante());
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 100, 1060, 471);
		frmPantallaPrincipal.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JFormattedTextField frmtdtxtfldTtulo = new JFormattedTextField();
		frmtdtxtfldTtulo.setBounds(53, 52, 140, 20);
		frmtdtxtfldTtulo.setText("TITLE:");
		frmtdtxtfldTtulo.setOpaque(false);
		frmtdtxtfldTtulo.setForeground(Color.WHITE);
		frmtdtxtfldTtulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmtdtxtfldTtulo.setEditable(false);
		frmtdtxtfldTtulo.setBorder(null);
		panel_3.add(frmtdtxtfldTtulo);
		
		JFormattedTextField frmtdtxtfldPrecio = new JFormattedTextField();
		frmtdtxtfldPrecio.setBounds(53, 83, 140, 20);
		frmtdtxtfldPrecio.setText("PRICE:");
		frmtdtxtfldPrecio.setOpaque(false);
		frmtdtxtfldPrecio.setForeground(Color.WHITE);
		frmtdtxtfldPrecio.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmtdtxtfldPrecio.setEditable(false);
		frmtdtxtfldPrecio.setBorder(null);
		panel_3.add(frmtdtxtfldPrecio);
		
		JFormattedTextField frmtdtxtfldAo = new JFormattedTextField();
		frmtdtxtfldAo.setBounds(53, 114, 140, 20);
		frmtdtxtfldAo.setText("YEAR:");
		frmtdtxtfldAo.setOpaque(false);
		frmtdtxtfldAo.setForeground(Color.WHITE);
		frmtdtxtfldAo.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmtdtxtfldAo.setEditable(false);
		frmtdtxtfldAo.setBorder(null);
		panel_3.add(frmtdtxtfldAo);
		
		JFormattedTextField frmtdtxtfldPlataformas = new JFormattedTextField();
		frmtdtxtfldPlataformas.setBounds(53, 145, 140, 20);
		frmtdtxtfldPlataformas.setText("PLATFORMS:");
		frmtdtxtfldPlataformas.setOpaque(false);
		frmtdtxtfldPlataformas.setForeground(Color.WHITE);
		frmtdtxtfldPlataformas.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmtdtxtfldPlataformas.setEditable(false);
		frmtdtxtfldPlataformas.setBorder(null);
		panel_3.add(frmtdtxtfldPlataformas);
		
		JFormattedTextField frmtdtxtfldGneros = new JFormattedTextField();
		frmtdtxtfldGneros.setBounds(53, 176, 140, 20);
		frmtdtxtfldGneros.setText("GENRES:");
		frmtdtxtfldGneros.setOpaque(false);
		frmtdtxtfldGneros.setForeground(Color.WHITE);
		frmtdtxtfldGneros.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmtdtxtfldGneros.setEditable(false);
		frmtdtxtfldGneros.setBorder(null);
		panel_3.add(frmtdtxtfldGneros);
		
		JFormattedTextField frmtdtxtfldValoracin = new JFormattedTextField();
		frmtdtxtfldValoracin.setBounds(53, 207, 140, 20);
		frmtdtxtfldValoracin.setText("RATING:");
		frmtdtxtfldValoracin.setOpaque(false);
		frmtdtxtfldValoracin.setForeground(Color.WHITE);
		frmtdtxtfldValoracin.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmtdtxtfldValoracin.setEditable(false);
		frmtdtxtfldValoracin.setBorder(null);
		panel_3.add(frmtdtxtfldValoracin);
		
		JFormattedTextField frmtdtxtfldDescripcin = new JFormattedTextField();
		frmtdtxtfldDescripcin.setBounds(53, 238, 140, 20);
		frmtdtxtfldDescripcin.setText("DESCRIPTION:");
		frmtdtxtfldDescripcin.setOpaque(false);
		frmtdtxtfldDescripcin.setForeground(Color.WHITE);
		frmtdtxtfldDescripcin.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmtdtxtfldDescripcin.setEditable(false);
		frmtdtxtfldDescripcin.setBorder(null);
		panel_3.add(frmtdtxtfldDescripcin);
		
		JFormattedTextField frmtdtxtfldUrlCartula = new JFormattedTextField();
		frmtdtxtfldUrlCartula.setBounds(53, 399, 140, 20);
		frmtdtxtfldUrlCartula.setText("COVER URL:");
		frmtdtxtfldUrlCartula.setOpaque(false);
		frmtdtxtfldUrlCartula.setForeground(Color.WHITE);
		frmtdtxtfldUrlCartula.setFont(new Font("Tahoma", Font.BOLD, 16));
		frmtdtxtfldUrlCartula.setEditable(false);
		frmtdtxtfldUrlCartula.setBorder(null);
		panel_3.add(frmtdtxtfldUrlCartula);
		
		textField = new JTextField();
		textField.setBounds(214, 52, 300, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 85, 60, 20);
		textField_1.setColumns(10);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(214, 116, 60, 20);
		textField_2.setColumns(10);
		panel_3.add(textField_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(214, 209, 60, 20);
		textField_5.setColumns(10);
		panel_3.add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setBounds(214, 401, 300, 20);
		textField_7.setColumns(10);
		panel_3.add(textField_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(214, 238, 300, 152);
		panel_3.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JLabel lblVistaPreviaCartula = new JLabel("Cover preview");
		lblVistaPreviaCartula.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaPreviaCartula.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVistaPreviaCartula.setOpaque(true);
		lblVistaPreviaCartula.setBackground(Color.LIGHT_GRAY);
		lblVistaPreviaCartula.setBounds(706, 114, 170, 240);
		panel_3.add(lblVistaPreviaCartula);
		
		panel_3.add(Botones.save());
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PS4", "PS3", "PSVITA", "XONE", "X360", "PC", "WII-U", "WII", "N3DS"}));
		comboBox.setBounds(214, 145, 300, 20);
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Action", "Adventure", "Construction and Management Simulation", "Fighting", "Flight Simulator", "Horror", "Life Simulation", "MMO", "Music", "Platform", "Puzzle", "Racing", "Role-Playing", "Sandbox", "Shooter", "Sports", "Stealth", "Strategy", "Vehicle Simulation"}));
		comboBox_1.setBounds(214, 176, 300, 20);
		panel_3.add(comboBox_1);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1060, 471);
		label.setIcon(new ImageIcon(Modificar.class.getResource("/Imagenes/blizz.jpg")));
		panel_3.add(label);
	}
}
