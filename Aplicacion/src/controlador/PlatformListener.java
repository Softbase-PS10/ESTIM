package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.Juego;
import modelo.Sentencias;
import vista.Listado;

public class PlatformListener implements ActionListener {

	private String alias;
	private Sentencias sql;
	private JFrame frame;

	public PlatformListener(String alias, JFrame frame) {
		this.alias = alias;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sql = new Sentencias();
		ArrayList<Juego> juegos = sql.listarJuegosPlataformaAlias(this.alias);
		sql.close();
		
		frame.dispose();
		
		Listado.listar(juegos);
	}

}
