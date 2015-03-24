import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;


public class prueba {

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
					prueba window = new prueba();
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
	public prueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaPrincipal = new JFrame();
		frmPantallaPrincipal.setTitle("Pantalla principal - Estim");
		frmPantallaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(prueba.class.getResource("/Imagenes/E.png")));
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
		
		JButton logo = new JButton("");
		logo.setFocusPainted(false);
		logo.setContentAreaFilled(false);
		logo.setBorder(null);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/logoP.png")));
		logo.setBorderPainted(false);
		logo.setOpaque(false);
		logo.setMargin(new Insets(0, 0, 0, 0));
		logo.setBounds(33, 11, 97, 48);
		cabecera.add(logo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(990, 0, 70, 70);
		cabecera.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/carroP.png")));
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/carro.png")));
		btnNewButton_3.setBounds(0, 0, 70, 70);
		panel.add(btnNewButton_3);
		
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
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/buscar.png")));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBounds(0, 0, 30, 30);
		panel_2.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(920, 0, 70, 70);
		cabecera.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/ajustesP.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/settings.png")));
		btnNewButton.setBounds(0, 0, 70, 70);
		panel_1.add(btnNewButton);
		
		JPanel categorias = new JPanel();
		categorias.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		categorias.setBackground(Color.DARK_GRAY);
		categorias.setBounds(0, 70, 1060, 30);
		frmPantallaPrincipal.getContentPane().add(categorias);
		categorias.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/atras.png")));
		btnNewButton_2.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/atrasP.png")));
		btnNewButton_2.setBackground(new Color(51, 102, 204));
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(0, 0, 53, 30);
		categorias.add(btnNewButton_2);
		
		JButton ps3 = new JButton("");
		ps3.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/PS3.png")));
		ps3.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/PS3P.png")));
		ps3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ps3.setForeground(Color.WHITE);
		ps3.setFont(new Font("Tahoma", Font.BOLD, 14));
		ps3.setFocusable(false);
		ps3.setFocusPainted(false);
		ps3.setBorder(new LineBorder(new Color(0, 0, 0)));
		ps3.setBounds(212, 0, 106, 30);
		categorias.add(ps3);
		
		JButton vita = new JButton("");
		vita.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/PSVITAP.png")));
		vita.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/PSVITA.png")));
		vita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vita.setForeground(Color.WHITE);
		vita.setFont(new Font("Tahoma", Font.BOLD, 14));
		vita.setFocusable(false);
		vita.setFocusPainted(false);
		vita.setBorder(new LineBorder(new Color(0, 0, 0)));
		vita.setBounds(318, 0, 106, 30);
		categorias.add(vita);
		
		JButton xone = new JButton("");
		xone.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/XONE.png")));
		xone.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/XONEP.png")));
		xone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		xone.setForeground(Color.WHITE);
		xone.setFont(new Font("Tahoma", Font.BOLD, 14));
		xone.setFocusable(false);
		xone.setFocusPainted(false);
		xone.setBorder(new LineBorder(new Color(0, 0, 0)));
		xone.setBounds(424, 0, 106, 30);
		categorias.add(xone);
		
		JButton x360 = new JButton("");
		x360.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/X360P.png")));
		x360.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/X360.png")));
		x360.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x360.setForeground(Color.WHITE);
		x360.setFont(new Font("Tahoma", Font.BOLD, 14));
		x360.setFocusable(false);
		x360.setFocusPainted(false);
		x360.setBorder(new LineBorder(new Color(0, 0, 0)));
		x360.setBounds(530, 0, 106, 30);
		categorias.add(x360);
		
		JButton pc = new JButton("");
		pc.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/PC.png")));
		pc.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/PCP.png")));
		pc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pc.setForeground(Color.WHITE);
		pc.setFont(new Font("Tahoma", Font.BOLD, 14));
		pc.setFocusable(false);
		pc.setFocusPainted(false);
		pc.setBorder(new LineBorder(new Color(0, 0, 0)));
		pc.setBounds(636, 0, 106, 30);
		categorias.add(pc);
		
		JButton wiiu = new JButton("");
		wiiu.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/WIIUP.png")));
		wiiu.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/WIIU.png")));
		wiiu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wiiu.setForeground(Color.WHITE);
		wiiu.setFont(new Font("Tahoma", Font.BOLD, 14));
		wiiu.setFocusable(false);
		wiiu.setFocusPainted(false);
		wiiu.setBorder(new LineBorder(new Color(0, 0, 0)));
		wiiu.setBounds(742, 0, 106, 30);
		categorias.add(wiiu);
		
		JButton wii = new JButton("");
		wii.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/WII.png")));
		wii.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/WIIP.png")));
		wii.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wii.setForeground(Color.WHITE);
		wii.setFont(new Font("Tahoma", Font.BOLD, 14));
		wii.setFocusable(false);
		wii.setFocusPainted(false);
		wii.setBorder(new LineBorder(new Color(0, 0, 0)));
		wii.setBounds(848, 0, 106, 30);
		categorias.add(wii);
		
		JButton n3ds = new JButton("");
		n3ds.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/N3DSP.png")));
		n3ds.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/N3DS.png")));
		n3ds.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		n3ds.setForeground(Color.WHITE);
		n3ds.setFont(new Font("Tahoma", Font.BOLD, 14));
		n3ds.setFocusable(false);
		n3ds.setFocusPainted(false);
		n3ds.setBorder(new LineBorder(new Color(0, 0, 0)));
		n3ds.setBounds(954, 0, 106, 30);
		categorias.add(n3ds);
		
		final JButton ps4 = new JButton("");
		ps4.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/PS4P.png")));
		ps4.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/PS4.png")));
		ps4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ps4.setBackground(new Color(51, 102, 255));
		ps4.setForeground(Color.WHITE);
		ps4.setFont(new Font("Tahoma", Font.BOLD, 14));
		ps4.setFocusable(false);
		ps4.setFocusPainted(false);
		ps4.setBorder(new LineBorder(new Color(0, 0, 0)));
		ps4.setBounds(106, 0, 106, 30);
		categorias.add(ps4);
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/alante.png")));
		button_8.setRolloverIcon(new ImageIcon(prueba.class.getResource("/Imagenes/B/alanteP.png")));
		button_8.setOpaque(false);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_8.setFocusable(false);
		button_8.setContentAreaFilled(false);
		button_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_8.setBackground(new Color(51, 102, 204));
		button_8.setBounds(53, 0, 53, 30);
		categorias.add(button_8);
		
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
		frmtdtxtfldFiltros.setText("FILTROS");
		frmtdtxtfldFiltros.setBounds(10, 11, 171, 20);
		filtros.add(frmtdtxtfldFiltros);
		
		JFormattedTextField frmtdtxtfldPrecio = new JFormattedTextField();
		frmtdtxtfldPrecio.setText("Precio:");
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
		frmtdtxtfldA.setText("a");
		frmtdtxtfldA.setOpaque(false);
		frmtdtxtfldA.setForeground(Color.WHITE);
		frmtdtxtfldA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldA.setEditable(false);
		frmtdtxtfldA.setBorder(null);
		frmtdtxtfldA.setBounds(81, 73, 19, 20);
		filtros.add(frmtdtxtfldA);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 73, 51, 20);
		filtros.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setName("");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(20, 131, 130, 20);
		filtros.add(comboBox);
		
		JFormattedTextField frmtdtxtfldGnero = new JFormattedTextField();
		frmtdtxtfldGnero.setText("G\u00E9nero");
		frmtdtxtfldGnero.setOpaque(false);
		frmtdtxtfldGnero.setForeground(Color.WHITE);
		frmtdtxtfldGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldGnero.setEditable(false);
		frmtdtxtfldGnero.setBorder(null);
		frmtdtxtfldGnero.setBounds(20, 104, 171, 20);
		filtros.add(frmtdtxtfldGnero);
		
		JFormattedTextField frmtdtxtfldPlataforma = new JFormattedTextField();
		frmtdtxtfldPlataforma.setText("Plataforma");
		frmtdtxtfldPlataforma.setOpaque(false);
		frmtdtxtfldPlataforma.setForeground(Color.WHITE);
		frmtdtxtfldPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmtdtxtfldPlataforma.setEditable(false);
		frmtdtxtfldPlataforma.setBorder(null);
		frmtdtxtfldPlataforma.setBounds(20, 162, 171, 20);
		filtros.add(frmtdtxtfldPlataforma);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setName("");
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setBounds(20, 187, 130, 20);
		filtros.add(comboBox_1);
		
		JButton btnNewButton_5 = new JButton("Aplicar");
		btnNewButton_5.setBounds(84, 293, 66, 20);
		filtros.add(btnNewButton_5);
		
		JFormattedTextField frmtdtxtfldValoracin = new JFormattedTextField();
		frmtdtxtfldValoracin.setText("Valoraci\u00F3n");
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("a");
		formattedTextField.setOpaque(false);
		formattedTextField.setForeground(Color.WHITE);
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		formattedTextField.setEditable(false);
		formattedTextField.setBorder(null);
		formattedTextField.setBounds(81, 252, 19, 20);
		filtros.add(formattedTextField);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(99, 252, 51, 20);
		filtros.add(textField_3);
		
		JPanel principal = new JPanel();
		principal.setBounds(190, 100, 870, 471);
		frmPantallaPrincipal.getContentPane().add(principal);
		principal.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		btnNewButton_1.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/ps4.png")));
		btnNewButton_1.setBounds(30, 34, 246, 125);
		principal.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/ps3.png")));
		button.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		button.setBounds(313, 34, 246, 125);
		principal.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/psvita.png")));
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		button_1.setBounds(596, 34, 246, 125);
		principal.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/xbox One.png")));
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		button_2.setBounds(30, 176, 246, 125);
		principal.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/xbox 360.png")));
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		button_3.setBounds(313, 176, 246, 125);
		principal.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/pc.png")));
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		button_4.setBounds(596, 176, 246, 125);
		principal.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_5.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/wiiu.png")));
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		button_5.setBounds(30, 322, 246, 125);
		principal.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_6.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/wii.png")));
		button_6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		button_6.setBounds(313, 322, 246, 125);
		principal.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_7.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/Menu/3ds.png")));
		button_7.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		button_7.setBounds(596, 322, 246, 125);
		principal.add(button_7);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 870, 471);
		lblNewLabel.setIcon(new ImageIcon(prueba.class.getResource("/Imagenes/blis.jpg")));
		principal.add(lblNewLabel);
	}
}
