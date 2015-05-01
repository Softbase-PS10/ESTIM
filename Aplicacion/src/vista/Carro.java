package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import modelo.Juego;
import controlador.BotonesCabecera;
import controlador.BotonesCategorias;

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
	public static void main(final JFrame frame, final ArrayList<Juego> cesta) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carro window = new Carro(frame, cesta);
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
	public Carro(JFrame frame, ArrayList<Juego> cesta) {
		frame.getContentPane().removeAll();
		initialize(frame, cesta);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frm, ArrayList<Juego> cesta) {
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

		opciones.add(BotonesCabecera.ajustes(2, null, frmPantallaPrincipal,
				cesta));

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

		box.add(res);

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

		Iterator<Juego> it = cesta.iterator();

		while (it.hasNext()) {
			Juego actual = it.next();
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(35, 11, 990, 194);
			box.add(panel);
			panel.setLayout(null);

			JButton caratula = new JButton("");
			caratula.setBounds(0, 0, 128, 180);
			panel.add(caratula);
			caratula.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			caratula.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
					Color.BLACK, Color.BLACK, Color.BLACK));

			JFormattedTextField precio = new JFormattedTextField();
			precio.setBounds(561, 62, 144, 60);
			panel.add(precio);
			precio.setText(actual.getPrecio()+"\u20AC");
			precio.setOpaque(false);
			precio.setForeground(Color.WHITE);
			precio.setFont(new Font("Tahoma", Font.PLAIN, 40));
			precio.setEditable(false);
			precio.setBorder(null);

			JFormattedTextField titulo = new JFormattedTextField();
			titulo.setBounds(180, 80, 368, 20);
			panel.add(titulo);
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setText(actual.getTitulo());
			titulo.setOpaque(false);
			titulo.setForeground(Color.WHITE);
			titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
			titulo.setEditable(false);
			titulo.setBorder(null);

			JSeparator separator = new JSeparator();
			separator.setBounds(0, 191, 990, 2);
			panel.add(separator);

			JButton btnNewButton = new JButton("");
			btnNewButton.setBounds(821, 62, 69, 60);
			panel.add(btnNewButton);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setRolloverIcon(new ImageIcon(Carro.class
					.getResource("/Imagenes/B/botonP.png")));
			btnNewButton.setBorder(null);
			btnNewButton.setOpaque(false);
			btnNewButton.setIcon(new ImageIcon(Carro.class
					.getResource("/Imagenes/B/botonSP.png")));
		}

	}
}
