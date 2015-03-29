package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import vista.Listado;
import modelo.Juego;
import modelo.Sentencias;

public class PlatformListener implements ActionListener {

	private String alias;
	private Sentencias sql;

	public PlatformListener(String alias) {
		this.alias = alias;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sql = new Sentencias();
		ArrayList<Juego> juegos = sql.listarJuegosPlataformaAlias(this.alias);
		sql.close();
		
		Listado.listar(juegos);
	}

}
