/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que contiene la creacion de botones de las categorias,
 * 				centralizando el comportamiento de dichos botones, que 
 * 				sera el mismo en todas las pantallas.
 * 				La barra de categorias es igual para todas las pantallas de 
 * 				la app.
 */

package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import modelo.Plataforma;
import vista.Principal;

public class BotonesCategorias {

	/**
	 * @return
	 */
	public static JButton atras() {
		JButton atras = new JButton("");
		atras.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/atras.png")));
		atras.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/atrasP.png")));
		atras.setBackground(new Color(51, 102, 204));
		atras.setBorder(new LineBorder(new Color(0, 0, 0)));
		atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		atras.setFocusable(false);
		atras.setForeground(Color.WHITE);
		atras.setFont(new Font("Tahoma", Font.BOLD, 14));
		atras.setBounds(0, 0, 53, 30);

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO el codigo de ir atras
			}
		});

		return atras;
	}

	/**
	 * @return un boton que redirige a la pantalla de listados de juegos de
	 *         PlayStation 3
	 */
	public static JButton ps3() {
		JButton ps3 = new JButton("");
		ps3.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PS3.png")));
		ps3.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PS3P.png")));
		ps3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ps3.setForeground(Color.WHITE);
		ps3.setFont(new Font("Tahoma", Font.BOLD, 14));
		ps3.setFocusable(false);
		ps3.setFocusPainted(false);
		ps3.setBorder(new LineBorder(new Color(0, 0, 0)));
		ps3.setBounds(212, 0, 106, 30);

		ps3.addActionListener(new PlatformListener(Plataforma.aliasPS3));

		return ps3;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de
	 *         PlayStation Vita
	 */
	public static JButton vita() {
		JButton vita = new JButton("");
		vita.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PSVITAP.png")));
		vita.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PSVITA.png")));
		vita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vita.setForeground(Color.WHITE);
		vita.setFont(new Font("Tahoma", Font.BOLD, 14));
		vita.setFocusable(false);
		vita.setFocusPainted(false);
		vita.setBorder(new LineBorder(new Color(0, 0, 0)));
		vita.setBounds(318, 0, 106, 30);

		vita.addActionListener(new PlatformListener(Plataforma.aliasPSVita));

		return vita;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de Xbox
	 *         ONE
	 */
	public static JButton xone() {
		JButton xone = new JButton("");
		xone.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/XONE.png")));
		xone.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/XONEP.png")));
		xone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		xone.setForeground(Color.WHITE);
		xone.setFont(new Font("Tahoma", Font.BOLD, 14));
		xone.setFocusable(false);
		xone.setFocusPainted(false);
		xone.setBorder(new LineBorder(new Color(0, 0, 0)));
		xone.setBounds(424, 0, 106, 30);

		xone.addActionListener(new PlatformListener(Plataforma.aliasXONE));

		return xone;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de Xbox
	 *         360
	 */
	public static JButton x360() {
		JButton x360 = new JButton("");
		x360.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/X360P.png")));
		x360.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/X360.png")));
		x360.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x360.setForeground(Color.WHITE);
		x360.setFont(new Font("Tahoma", Font.BOLD, 14));
		x360.setFocusable(false);
		x360.setFocusPainted(false);
		x360.setBorder(new LineBorder(new Color(0, 0, 0)));
		x360.setBounds(530, 0, 106, 30);

		x360.addActionListener(new PlatformListener(Plataforma.aliasX360));

		return x360;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de PC
	 */
	public static JButton pc() {
		JButton pc = new JButton("");
		pc.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PC.png")));
		pc.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PCP.png")));
		pc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pc.setForeground(Color.WHITE);
		pc.setFont(new Font("Tahoma", Font.BOLD, 14));
		pc.setFocusable(false);
		pc.setFocusPainted(false);
		pc.setBorder(new LineBorder(new Color(0, 0, 0)));
		pc.setBounds(636, 0, 106, 30);

		pc.addActionListener(new PlatformListener(Plataforma.aliasPC));

		return pc;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de WiiU
	 */
	public static JButton wiiu() {
		JButton wiiu = new JButton("");
		wiiu.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/WIIUP.png")));
		wiiu.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/WIIU.png")));
		wiiu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wiiu.setForeground(Color.WHITE);
		wiiu.setFont(new Font("Tahoma", Font.BOLD, 14));
		wiiu.setFocusable(false);
		wiiu.setFocusPainted(false);
		wiiu.setBorder(new LineBorder(new Color(0, 0, 0)));
		wiiu.setBounds(742, 0, 106, 30);

		wiiu.addActionListener(new PlatformListener(Plataforma.aliasWiiU));

		return wiiu;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de Wii
	 */
	public static JButton wii() {
		JButton wii = new JButton("");
		wii.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/WII.png")));
		wii.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/WIIP.png")));
		wii.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wii.setForeground(Color.WHITE);
		wii.setFont(new Font("Tahoma", Font.BOLD, 14));
		wii.setFocusable(false);
		wii.setFocusPainted(false);
		wii.setBorder(new LineBorder(new Color(0, 0, 0)));
		wii.setBounds(848, 0, 106, 30);

		wii.addActionListener(new PlatformListener(Plataforma.aliasWii));

		return wii;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de
	 *         Nintendo New 3DS
	 */
	public static JButton n3ds() {
		JButton n3ds = new JButton("");
		n3ds.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/N3DSP.png")));
		n3ds.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/N3DS.png")));
		n3ds.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		n3ds.setForeground(Color.WHITE);
		n3ds.setFont(new Font("Tahoma", Font.BOLD, 14));
		n3ds.setFocusable(false);
		n3ds.setFocusPainted(false);
		n3ds.setBorder(new LineBorder(new Color(0, 0, 0)));
		n3ds.setBounds(954, 0, 106, 30);

		n3ds.addActionListener(new PlatformListener(Plataforma.alias3DS));

		return n3ds;
	}

	/**
	 * @return un boton que redirige a la pantalla de listado de juegos de
	 *         PlayStation 4
	 */
	public static JButton ps4() {
		JButton ps4 = new JButton("");
		ps4.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PS4P.png")));
		ps4.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/PS4.png")));
		ps4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ps4.setBackground(new Color(51, 102, 255));
		ps4.setForeground(Color.WHITE);
		ps4.setFont(new Font("Tahoma", Font.BOLD, 14));
		ps4.setFocusable(false);
		ps4.setFocusPainted(false);
		ps4.setBorder(new LineBorder(new Color(0, 0, 0)));
		ps4.setBounds(106, 0, 106, 30);

		ps4.addActionListener(new PlatformListener(Plataforma.aliasPS4));

		return ps4;
	}

	/**
	 * @return
	 */
	public static JButton adelante() {
		JButton adelante = new JButton("");
		adelante.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/alante.png")));
		adelante.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/alanteP.png")));
		adelante.setOpaque(false);
		adelante.setForeground(Color.WHITE);
		adelante.setFont(new Font("Tahoma", Font.BOLD, 14));
		adelante.setFocusable(false);
		adelante.setContentAreaFilled(false);
		adelante.setBorder(new LineBorder(new Color(0, 0, 0)));
		adelante.setBackground(new Color(51, 102, 204));
		adelante.setBounds(53, 0, 53, 30);

		adelante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return adelante;
	}
}
