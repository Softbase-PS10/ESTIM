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
		sql = new Sentencias();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Juego> juegos = sql.listarJuegosPlataformaAlias(this.alias);
		
		Listado.listar(juegos);
	}

}
