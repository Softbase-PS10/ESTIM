package controlador;

import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import vista.Principal;

public class BotonesCabecera {

	public static JButton buscar() {
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4
				.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/buscar.png")));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBounds(0, 0, 30, 30);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return btnNewButton_4;
	}

	public static JButton ajustes() {
		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/ajustesP.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/settings.png")));
		btnNewButton.setBounds(0, 0, 70, 70);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return btnNewButton;
	}

	public static JButton carro() {
		JButton carro = new JButton("");
		carro.setRolloverIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/carroP.png")));
		carro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		carro.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/B/carro.png")));
		carro.setBounds(0, 0, 70, 70);

		carro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return carro;
	}

	public static JButton logo() {
		JButton logo = new JButton("");
		logo.setFocusPainted(false);
		logo.setContentAreaFilled(false);
		logo.setBorder(null);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setIcon(new ImageIcon(Principal.class
				.getResource("/Imagenes/logoP.png")));
		logo.setBorderPainted(false);
		logo.setOpaque(false);
		logo.setMargin(new Insets(0, 0, 0, 0));
		logo.setBounds(33, 11, 97, 48);
		logo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return logo;
	}

}
