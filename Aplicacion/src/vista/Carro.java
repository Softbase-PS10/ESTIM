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
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Carro {

	/* declaracion de variables */
	private JFrame frmPantallaPrincipal;
	private JTextField txtBuscar;

	@SuppressWarnings("unused")
	private ArrayList<Juego> games; // asi se podra realizar la ordenacion mas
									// adelante
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carro window = new Carro();
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
	public Carro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmPantallaPrincipal;
		frmPantallaPrincipal = new JFrame();
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

		cabecera.add(BotonesCabecera.logo(frmPantallaPrincipal));

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

		opciones.add(BotonesCabecera.ajustes(2, null, frmPantallaPrincipal));

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

		JPanel principal = new JPanel();
		principal.setBounds(0, 100, 1060, 471);
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


			JPanel res = new JPanel();
			res.setLayout(null);
			res.setPreferredSize(new Dimension(700, 200));
			res.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			res.setBackground(Color.DARK_GRAY);

			JButton caratula = new JButton("");
			caratula.setSize(128, 180);
			caratula.setLocation(35, 11);
			caratula.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			caratula.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
					Color.BLACK, Color.BLACK, Color.BLACK));
			res.add(caratula);

			JFormattedTextField precio = new JFormattedTextField();
			precio.setSize(144, 60);
			precio.setLocation(596, 73);
			precio.setText("50\u20AC");
			precio.setOpaque(false);
			precio.setForeground(Color.WHITE);
			precio.setFont(new Font("Tahoma", Font.PLAIN, 40));
			precio.setEditable(false);
			precio.setBorder(null);
			res.add(precio);

			JFormattedTextField titulo = new JFormattedTextField();
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setSize(368, 20);
			titulo.setLocation(216, 90);
				titulo.setText("Half Life 3");
			titulo.setOpaque(false);
			titulo.setForeground(Color.WHITE);
			titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
			titulo.setEditable(false);
			titulo.setBorder(null);
			res.add(titulo);

			box.add(res);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setRolloverIcon(new ImageIcon(Carro.class.getResource("/Imagenes/B/botonP.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setOpaque(false);
			btnNewButton.setIcon(new ImageIcon(Carro.class.getResource("/Imagenes/B/botonSP.png")));
			btnNewButton.setBounds(857, 73, 69, 60);
			res.add(btnNewButton);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(35, 203, 990, 2);
			res.add(separator);
			
			JFormattedTextField frmtdtxtfldTotal = new JFormattedTextField();
			frmtdtxtfldTotal.setText("TOTAL:");
			frmtdtxtfldTotal.setOpaque(false);
			frmtdtxtfldTotal.setForeground(Color.WHITE);
			frmtdtxtfldTotal.setFont(new Font("Tahoma", Font.PLAIN, 40));
			frmtdtxtfldTotal.setEditable(false);
			frmtdtxtfldTotal.setBorder(null);
			frmtdtxtfldTotal.setBounds(401, 216, 144, 60);
			res.add(frmtdtxtfldTotal);
			
			JFormattedTextField formattedTextField = new JFormattedTextField();
			formattedTextField.setText("50\u20AC");
			formattedTextField.setOpaque(false);
			formattedTextField.setForeground(Color.WHITE);
			formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 40));
			formattedTextField.setEditable(false);
			formattedTextField.setBorder(null);
			formattedTextField.setBounds(596, 216, 144, 60);
			res.add(formattedTextField);
			
			JButton btnBuy = new JButton("Buy");
			btnBuy.setBounds(957, 433, 89, 23);
			res.add(btnBuy);
	}
}
