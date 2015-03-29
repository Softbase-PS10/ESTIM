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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controlador.Botones;
import controlador.BotonesCabecera;
import controlador.BotonesCategorias;
import controlador.BotonesMenu;

public class Principal {

	private JFrame frmPantallaPrincipal;
	private JTextField txtBuscar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaPrincipal = new JFrame();
		frmPantallaPrincipal.setTitle("Main window - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Principal.class.getResource("/Imagenes/E.png")));
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

		panel_2.add(BotonesCabecera.buscar(txtBuscar));

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
		filtros.setBounds(0, 100, 191, 471);
		frmPantallaPrincipal.getContentPane().add(filtros);
		filtros.setLayout(null);

		JFormattedTextField frmtdtxtfldFiltros = new JFormattedTextField();
		frmtdtxtfldFiltros.setBorder(null);
		frmtdtxtfldFiltros.setEditable(false);
		frmtdtxtfldFiltros.setForeground(Color.WHITE);
		frmtdtxtfldFiltros.setOpaque(false);
		frmtdtxtfldFiltros.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmtdtxtfldFiltros.setText("FILTERS");
		frmtdtxtfldFiltros.setBounds(10, 11, 171, 20);
		filtros.add(frmtdtxtfldFiltros);

		JFormattedTextField frmtdtxtfldPrecio = new JFormattedTextField();
		frmtdtxtfldPrecio.setText("Price:");
		frmtdtxtfldPrecio.setOpaque(false);
		frmtdtxtfldPrecio.setForeground(Color.WHITE);
		frmtdtxtfldPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldPrecio.setEditable(false);
		frmtdtxtfldPrecio.setBorder(null);
		frmtdtxtfldPrecio.setBounds(20, 42, 171, 20);
		filtros.add(frmtdtxtfldPrecio);

		textField = new JTextField();
		textField.setBounds(20, 73, 51, 20);
		filtros.add(textField);
		textField.setColumns(10);

		JFormattedTextField frmtdtxtfldA = new JFormattedTextField();
		frmtdtxtfldA.setText("to");
		frmtdtxtfldA.setOpaque(false);
		frmtdtxtfldA.setForeground(Color.WHITE);
		frmtdtxtfldA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldA.setEditable(false);
		frmtdtxtfldA.setBorder(null);
		frmtdtxtfldA.setBounds(80, 73, 19, 20);
		filtros.add(frmtdtxtfldA);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 73, 51, 20);
		filtros.add(textField_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Action",
				"Adventure", "Construction and Management Simulation",
				"Fighting", "Flight Simulator", "Horror", "Life Simulation",
				"MMO", "Music", "Platform", "Puzzle", "Racing", "Role-Playing",
				"Sandbox", "Shooter", "Sports", "Stealth", "Strategy",
				"Vehicle Simulation" }));
		comboBox.setToolTipText("");
		comboBox.setName("");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(20, 131, 130, 20);
		filtros.add(comboBox);

		JFormattedTextField frmtdtxtfldGnero = new JFormattedTextField();
		frmtdtxtfldGnero.setText("Genre:");
		frmtdtxtfldGnero.setOpaque(false);
		frmtdtxtfldGnero.setForeground(Color.WHITE);
		frmtdtxtfldGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldGnero.setEditable(false);
		frmtdtxtfldGnero.setBorder(null);
		frmtdtxtfldGnero.setBounds(20, 104, 171, 20);
		filtros.add(frmtdtxtfldGnero);

		JFormattedTextField frmtdtxtfldPlataforma = new JFormattedTextField();
		frmtdtxtfldPlataforma.setText("Platform:");
		frmtdtxtfldPlataforma.setOpaque(false);
		frmtdtxtfldPlataforma.setForeground(Color.WHITE);
		frmtdtxtfldPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldPlataforma.setEditable(false);
		frmtdtxtfldPlataforma.setBorder(null);
		frmtdtxtfldPlataforma.setBounds(20, 162, 171, 20);
		filtros.add(frmtdtxtfldPlataforma);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1
				.setModel(new DefaultComboBoxModel(
						new String[] { "PS4", "PS3", "PSVITA", "XONE", "X360",
								"PC", "WII-U", "WII", "N3DS" }));
		comboBox_1.setToolTipText("");
		comboBox_1.setName("");
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setBounds(20, 187, 130, 20);
		filtros.add(comboBox_1);

		filtros.add(Botones.aplicarFiltros());

		JFormattedTextField frmtdtxtfldValoracin = new JFormattedTextField();
		frmtdtxtfldValoracin.setText("Rating:");
		frmtdtxtfldValoracin.setOpaque(false);
		frmtdtxtfldValoracin.setForeground(Color.WHITE);
		frmtdtxtfldValoracin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldValoracin.setEditable(false);
		frmtdtxtfldValoracin.setBorder(null);
		frmtdtxtfldValoracin.setBounds(20, 221, 171, 20);
		filtros.add(frmtdtxtfldValoracin);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(20, 252, 51, 20);
		filtros.add(textField_2);

		JFormattedTextField frmtdtxtfldTo = new JFormattedTextField();
		frmtdtxtfldTo.setText("to");
		frmtdtxtfldTo.setOpaque(false);
		frmtdtxtfldTo.setForeground(Color.WHITE);
		frmtdtxtfldTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldTo.setEditable(false);
		frmtdtxtfldTo.setBorder(null);
		frmtdtxtfldTo.setBounds(80, 252, 19, 20);
		filtros.add(frmtdtxtfldTo);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(99, 252, 51, 20);
		filtros.add(textField_3);

		JPanel principal = new JPanel();
		principal.setBounds(190, 100, 870, 471);
		frmPantallaPrincipal.getContentPane().add(principal);
		principal.setLayout(null);

		principal.add(BotonesMenu.menuPS4(frmPantallaPrincipal));
		principal.add(BotonesMenu.menuPS3(frmPantallaPrincipal));
		principal.add(BotonesMenu.menuVita(frmPantallaPrincipal));
		principal.add(BotonesMenu.menuXONE(frmPantallaPrincipal));
		principal.add(BotonesMenu.menuX360(frmPantallaPrincipal));
		principal.add(BotonesMenu.menuPC(frmPantallaPrincipal));
		principal.add(BotonesMenu.menuWiiU(frmPantallaPrincipal));
		principal.add(BotonesMenu.menuWii(frmPantallaPrincipal));
		principal.add(BotonesMenu.menuN3DS(frmPantallaPrincipal));

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 870, 471);
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/blis.jpg")));
		principal.add(lblNewLabel);
	}
}
