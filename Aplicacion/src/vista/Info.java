package vista;
import java.awt.EventQueue;
import modelo.Juego;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;


public class Info {

	private JFrame frmInformacinDelProduc;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(Juego juego) {
		final Juego jue = juego;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info window = new Info(jue);
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
		
		JPanel Cabecera = new JPanel();
		Cabecera.setLayout(null);
		Cabecera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Cabecera.setBackground(Color.BLACK);
		Cabecera.setBounds(0, 0, 1065, 70);
		frmInformacinDelProduc.getContentPane().add(Cabecera);
		
		JButton Logo = new JButton("");
		Logo.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/logoP.png")));
		Logo.setOpaque(false);
		Logo.setMargin(new Insets(0, 0, 0, 0));
		Logo.setFocusPainted(false);
		Logo.setContentAreaFilled(false);
		Logo.setBorderPainted(false);
		Logo.setBorder(null);
		Logo.setBounds(33, 11, 97, 48);
		Cabecera.add(Logo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(990, 0, 70, 70);
		Cabecera.add(panel_1);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/carro.png")));
		button_1.setBounds(0, 0, 70, 70);
		panel_1.add(button_1);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(650, 20, 192, 30);
		Cabecera.add(textField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(841, 20, 30, 30);
		Cabecera.add(panel_2);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/buscar.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setBorder(null);
		button_2.setBounds(0, 0, 30, 30);
		panel_2.add(button_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/settings.png")));
		btnNewButton.setBounds(921, 11, 70, 48);
		Cabecera.add(btnNewButton);
		
		JPanel Categoria = new JPanel();
		Categoria.setLayout(null);
		Categoria.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Categoria.setBackground(Color.DARK_GRAY);
		Categoria.setBounds(0, 70, 1060, 30);
		frmInformacinDelProduc.getContentPane().add(Categoria);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/atras.png")));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setFocusable(false);
		button.setBorder(new LineBorder(new Color(0, 0, 0)));
		button.setBackground(new Color(51, 102, 204));
		button.setBounds(0, 0, 53, 30);
		Categoria.add(button);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/PS3.png")));
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_3.setFocusable(false);
		button_3.setFocusPainted(false);
		button_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_3.setBounds(212, 0, 106, 30);
		Categoria.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/PSVITA.png")));
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_4.setFocusable(false);
		button_4.setFocusPainted(false);
		button_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_4.setBounds(318, 0, 106, 30);
		Categoria.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/XONE.png")));
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5.setFocusable(false);
		button_5.setFocusPainted(false);
		button_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_5.setBounds(424, 0, 106, 30);
		Categoria.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/X360.png")));
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_6.setFocusable(false);
		button_6.setFocusPainted(false);
		button_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_6.setBounds(530, 0, 106, 30);
		Categoria.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/PC.png")));
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_7.setFocusable(false);
		button_7.setFocusPainted(false);
		button_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_7.setBounds(636, 0, 106, 30);
		Categoria.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/WIIU.png")));
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_8.setFocusable(false);
		button_8.setFocusPainted(false);
		button_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_8.setBounds(742, 0, 106, 30);
		Categoria.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/WII.png")));
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_9.setFocusable(false);
		button_9.setFocusPainted(false);
		button_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_9.setBounds(848, 0, 106, 30);
		Categoria.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/N3DS.png")));
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_10.setFocusable(false);
		button_10.setFocusPainted(false);
		button_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_10.setBounds(954, 0, 106, 30);
		Categoria.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/PS4.png")));
		button_11.setForeground(Color.WHITE);
		button_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_11.setFocusable(false);
		button_11.setFocusPainted(false);
		button_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_11.setBackground(new Color(51, 102, 255));
		button_11.setBounds(106, 0, 106, 30);
		Categoria.add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/alante.png")));
		button_12.setOpaque(false);
		button_12.setForeground(Color.WHITE);
		button_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_12.setFocusable(false);
		button_12.setContentAreaFilled(false);
		button_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_12.setBackground(new Color(51, 102, 204));
		button_12.setBounds(53, 0, 53, 30);
		Categoria.add(button_12);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(122, 141, 152, 260);
		frmInformacinDelProduc.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/pes_2014-2352260.jpg")));
		
		JLabel Titulo = new JLabel("T\u00EDtulo:");
		Titulo.setForeground(Color.WHITE);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Titulo.setBounds(405, 127, 88, 30);
		frmInformacinDelProduc.getContentPane().add(Titulo);
		
		JTextArea RespTitulo = new JTextArea();
		RespTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RespTitulo.setEditable(false);
		RespTitulo.setTabSize(12);
		RespTitulo.setOpaque(false);
		RespTitulo.setBackground(new Color(255, 255, 255));
		RespTitulo.setBorder(null);
		RespTitulo.setForeground(Color.WHITE);
		RespTitulo.setText(juego.getTitulo() + "\r\n");
		RespTitulo.setBounds(525, 136, 372, 31);
		frmInformacinDelProduc.getContentPane().add(RespTitulo);
		
		JLabel Precio = new JLabel("Precio:");
		Precio.setForeground(Color.WHITE);
		Precio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Precio.setBounds(405, 172, 53, 20);
		frmInformacinDelProduc.getContentPane().add(Precio);
		
		JTextArea RespPrecio = new JTextArea();
		RespPrecio.setOpaque(false);
		RespPrecio.setForeground(Color.WHITE);
		RespPrecio.setEditable(false);
		RespPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RespPrecio.setText(juego.getPrecio() + "\u20AC");
		RespPrecio.setBounds(525, 174, 200, 23);
		frmInformacinDelProduc.getContentPane().add(RespPrecio);
		
		JLabel Anio = new JLabel("A\u00F1o:");
		Anio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Anio.setForeground(Color.WHITE);
		Anio.setBounds(405, 213, 53, 20);
		frmInformacinDelProduc.getContentPane().add(Anio);
		
		JTextArea RespAnio = new JTextArea();
		RespAnio.setForeground(Color.WHITE);
		RespAnio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RespAnio.setOpaque(false);
		RespAnio.setText(juego.getLanzamiento());
		RespAnio.setBounds(525, 215, 282, 23);
		frmInformacinDelProduc.getContentPane().add(RespAnio);
		
		JLabel Plataforma = new JLabel("Plataforma:");
		Plataforma.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Plataforma.setForeground(Color.WHITE);
		Plataforma.setBounds(405, 244, 88, 20);
		frmInformacinDelProduc.getContentPane().add(Plataforma);
		
		JTextArea RespPlataforma = new JTextArea();
		RespPlataforma.setOpaque(false);
		RespPlataforma.setForeground(Color.WHITE);
		RespPlataforma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RespPlataforma.setText(juego.getPlataforma().getNombre());
		RespPlataforma.setBounds(525, 246, 254, 23);
		frmInformacinDelProduc.getContentPane().add(RespPlataforma);
		
		JLabel Genero = new JLabel("G\u00E9nero:");
		Genero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Genero.setForeground(Color.WHITE);
		Genero.setBounds(405, 275, 72, 20);
		frmInformacinDelProduc.getContentPane().add(Genero);
		
		JTextArea RespGenero = new JTextArea();
		RespGenero.setOpaque(false);
		RespGenero.setText(juego.getGenero().toString());
		RespGenero.setForeground(Color.WHITE);
		RespGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RespGenero.setBounds(525, 277, 200, 23);
		frmInformacinDelProduc.getContentPane().add(RespGenero);
		
		JLabel Descripcion = new JLabel("Descripci\u00F3n:");
		Descripcion.setForeground(Color.WHITE);
		Descripcion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Descripcion.setBounds(405, 319, 110, 20);
		frmInformacinDelProduc.getContentPane().add(Descripcion);
		
		JTextArea RespDescripcion = new JTextArea();
		RespDescripcion.setForeground(Color.WHITE);
		RespDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RespDescripcion.setText(juego.getDescripcion());
		RespDescripcion.setOpaque(false);
		RespDescripcion.setBounds(525, 321, 525, 164);
		frmInformacinDelProduc.getContentPane().add(RespDescripcion);
		
		JLabel Valoracion = new JLabel("Valoraci\u00F3n:");
		Valoracion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Valoracion.setForeground(Color.WHITE);
		Valoracion.setBounds(405, 494, 88, 20);
		frmInformacinDelProduc.getContentPane().add(Valoracion);
		
		JTextArea RespValoracion = new JTextArea();
		RespValoracion.setOpaque(false);
		RespValoracion.setForeground(Color.WHITE);
		RespValoracion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		RespValoracion.setText(juego.getRating());
		RespValoracion.setBounds(525, 495, 98, 22);
		frmInformacinDelProduc.getContentPane().add(RespValoracion);
		
		JButton Carro = new JButton("A\u00F1adir al carro");
		Carro.setBounds(923, 525, 110, 23);
		frmInformacinDelProduc.getContentPane().add(Carro);
		
		JMenu menu = new JMenu("New menu");
		menu.setBounds(923, 141, 76, 76);
		frmInformacinDelProduc.getContentPane().add(menu);
		menu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		menu.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/B/settings.png")));
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.setSelected(true);
		mntmModificar.setHorizontalAlignment(SwingConstants.LEFT);
		menu.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		menu.add(mntmEliminar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		menu.add(mntmSalir);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Info.class.getResource("/Imagenes/blizz.jpg")));
		Fondo.setBounds(0, 100, 1065, 472);
		frmInformacinDelProduc.getContentPane().add(Fondo);
		
		JMenuBar menuBar = new JMenuBar();
		frmInformacinDelProduc.setJMenuBar(menuBar);
		
		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mntmModificar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnAdmin.add(mntmModificar_1);
		
		JMenuItem mntmEliminar_1 = new JMenuItem("Eliminar");
		mnAdmin.add(mntmEliminar_1);
		
		
		JMenuItem mntmSalir_1 = new JMenuItem("Salir");
		mnAdmin.add(mntmSalir_1);
	}
}
