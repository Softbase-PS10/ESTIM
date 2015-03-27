package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import vista.Principal;

public class BotonesMenu {

	public static JButton menuN3DS() {
		JButton button_7 = new JButton("");
		button_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_7.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/3ds.png")));
		button_7.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		button_7.setBounds(596, 322, 246, 125);

		button_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return button_7;
	}

	public static JButton menuWii() {
		JButton button_6 = new JButton("");
		button_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_6.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/wii.png")));
		button_6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		button_6.setBounds(313, 322, 246, 125);

		button_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return button_6;
	}

	public static JButton menuWiiU() {
		JButton button_5 = new JButton("");
		button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_5.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/wiiu.png")));
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		button_5.setBounds(30, 322, 246, 125);

		button_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return button_5;
	}

	public static JButton menuPC() {
		JButton button_4 = new JButton("");
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/pc.png")));
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		button_4.setBounds(596, 176, 246, 125);

		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return button_4;
	}

	public static JButton menuX360() {
		JButton button_3 = new JButton("");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/xbox 360.png")));
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		button_3.setBounds(313, 176, 246, 125);

		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return button_3;
	}

	public static JButton menuXONE() {
		JButton button_2 = new JButton("");
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/xbox One.png")));
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		button_2.setBounds(30, 176, 246, 125);

		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return button_2;
	}

	public static JButton menuVita() {
		JButton button_1 = new JButton("");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/psvita.png")));
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		button_1.setBounds(596, 34, 246, 125);

		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return button_1;
	}

	public static JButton menuPS3() {
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/ps3.png")));
		button.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, Color.BLACK, Color.BLACK));
		button.setBounds(313, 34, 246, 125);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return button;
	}

	public static JButton menuPS4() {
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED,
				Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		btnNewButton_1.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/Menu/ps4.png")));
		btnNewButton_1.setBounds(30, 34, 246, 125);

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return btnNewButton_1;
	}
}
