/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que contiene la creacion de botones del menu de la
 * 				pantalla principal, encapsulando su comportamiento
 */

package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;

import modelo.Juego;
import modelo.Plataforma;
import vista.Principal;

public class BotonesMenu {

	/* declaracion de metodos y funciones */

	/**
	 * Metodo que crea un boton de N3DS
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de Nintendo 3DS
	 */
	public static JButton menuN3DS(JFrame frame, ArrayList<Juego> cesta) {
		JButton n3ds = new JButton("");
		n3ds.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		n3ds.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/3ds.png")));
		n3ds.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		n3ds.setBounds(596, 322, 246, 125);

		n3ds.addActionListener(new PlatformListener(Plataforma.alias3DS, frame,
				cesta));

		return n3ds;
	}

	/**
	 * Metodo que crea un boton de Wii
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de Wii
	 */
	public static JButton menuWii(JFrame frame, ArrayList<Juego> cesta) {
		JButton wii = new JButton("");
		wii.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wii.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/wii.png")));
		wii.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		wii.setBounds(313, 322, 246, 125);

		wii.addActionListener(new PlatformListener(Plataforma.aliasWii, frame,
				cesta));

		return wii;
	}

	/**
	 * Metodo que crea un boton de Wii U
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de Wii U
	 */
	public static JButton menuWiiU(JFrame frame, ArrayList<Juego> cesta) {
		JButton wiiu = new JButton("");
		wiiu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		wiiu.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/wiiu.png")));
		wiiu.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		wiiu.setBounds(30, 322, 246, 125);

		wiiu.addActionListener(new PlatformListener(Plataforma.aliasWiiU,
				frame, cesta));

		return wiiu;
	}

	/**
	 * Metodo que crea un boton de PC
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de PC
	 */
	public static JButton menuPC(JFrame frame, ArrayList<Juego> cesta) {
		JButton pc = new JButton("");
		pc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pc.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/pc.png")));
		pc.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		pc.setBounds(596, 176, 246, 125);

		pc.addActionListener(new PlatformListener(Plataforma.aliasPC, frame,
				cesta));

		return pc;
	}

	/**
	 * Metodo que crea un boton de XBOX 360
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de XBOX 360
	 */
	public static JButton menuX360(JFrame frame, ArrayList<Juego> cesta) {
		JButton x360 = new JButton("");
		x360.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x360.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/xbox 360.png")));
		x360.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		x360.setBounds(313, 176, 246, 125);

		x360.addActionListener(new PlatformListener(Plataforma.aliasX360,
				frame, cesta));

		return x360;
	}

	/**
	 * Metodo que crea un boton de XBOX ONE
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de XBOX ONE
	 */
	public static JButton menuXONE(JFrame frame, ArrayList<Juego> cesta) {
		JButton xone = new JButton("");
		xone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		xone.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/xbox One.png")));
		xone.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		xone.setBounds(30, 176, 246, 125);

		xone.addActionListener(new PlatformListener(Plataforma.aliasXONE,
				frame, cesta));

		return xone;
	}

	/**
	 * Metodo que crea un boton de PS Vita
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de PS Vita
	 */
	public static JButton menuVita(JFrame frame, ArrayList<Juego> cesta) {
		JButton vita = new JButton("");
		vita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vita.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/psvita.png")));
		vita.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		vita.setBounds(596, 34, 246, 125);

		vita.addActionListener(new PlatformListener(Plataforma.aliasPSVita,
				frame, cesta));

		return vita;
	}

	/**
	 * Metodo que crea un boton de PS3
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de PS3
	 */
	public static JButton menuPS3(JFrame frame, ArrayList<Juego> cesta) {
		JButton ps3 = new JButton("");
		ps3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ps3.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/ps3.png")));
		ps3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		ps3.setBounds(313, 34, 246, 125);

		ps3.addActionListener(new PlatformListener(Plataforma.aliasPS3, frame,
				cesta));

		return ps3;
	}

	/**
	 * Metodo que crea un boton de PS4
	 * 
	 * @param frame
	 *            : frame sobre el que se crea el boton
	 * @param cesta
	 *            : carrito de la compra
	 * @return un menu de PS4
	 */
	public static JButton menuPS4(JFrame frame, ArrayList<Juego> cesta) {
		JButton ps4 = new JButton("");
		ps4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ps4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		ps4.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/ps4.png")));
		ps4.setBounds(30, 34, 246, 125);

		ps4.addActionListener(new PlatformListener(Plataforma.aliasPS4, frame,
				cesta));

		return ps4;
	}
}
