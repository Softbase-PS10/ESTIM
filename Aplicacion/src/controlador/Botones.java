/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase que contiene la creacion de botones de diverso 
 * 				proposito, centralizando el comportamiento de dichos
 * 				botones, que sera el mismo en todas las pantallas.
 */

package controlador;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;

import modelo.*;
import vista.Info;
import vista.Modificar;

public class Botones {
	
	/**
	 * @return el boton de 'Aplicar' filtros, con su comportamiento
	 * implementado.
	 */
	public static JButton aplicarFiltros() {
		JButton aplicar = new JButton("Apply");
		aplicar.setBounds(84, 293, 66, 20);

		aplicar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return aplicar;
	}

	/**
	 * @return el boton de 'Guardar' los cambios al modificar un
	 * juego del catalogo.
	 */
	public static JButton save(final Juego j){
		JButton salvar = new JButton("Save");
		salvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		salvar.setBounds(961, 427, 89, 33);
		
		salvar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				boolean error = false;
				Sentencias s = new Sentencias();
				
				String titulo = Modificar.titulo.getText();
				if(titulo.length()==0){
					error = true;
					Modificar.eTitulo.setVisible(true);
				}
				else{
					Modificar.eTitulo.setVisible(false);
				}
				String precio = Modificar.precio.getText();
				if(precio.length()==0){
					error = true;
					Modificar.ePrecio.setVisible(true);
				}
				else{
					Modificar.ePrecio.setVisible(false);
				}
				String anyo = Modificar.anyo.getText();
				
				String valoracion = Modificar.valoracion.getText();
				
				String url = Modificar.url.getText();
				
				String descripcion =  Modificar.descripcion.getText();
				
				String plataforma = (String) Modificar.plataforma.getSelectedItem();
				Plataforma plat = s.listarPlataformaAlias(plataforma);
				
				ArrayList<String> genero = new ArrayList<String>();
				Component[] comp = Modificar.genero.getMenuComponents();
				for (int i = 0; i < comp.length; i++) {
					JCheckBoxMenuItem cb = (JCheckBoxMenuItem) comp[i];
					if(cb.isSelected()){
						genero.add(cb.getText());
					}
				}
				if(!error){
					if(j == null){
						int p = Integer.parseInt(precio);
						if(url.equals(""))
							url = "null";
						Juego j = new Juego(titulo,url,descripcion,anyo,
								valoracion,genero,p,plat);
						s.insertarJuego(j);
						Modificar.ocultarMod();
						Info.main(j);
					}
					else{
						j.setTitulo(titulo);
						j.setDescripcion(descripcion);
						j.setGenero(genero);
						j.setImagen(url);
						j.setLanzamiento(anyo);
						j.setPlataforma(plat);
						j.setPrecio(Integer.parseInt(precio));
						j.setRating(valoracion);
						s.actualizarJuego(j);
						Modificar.ocultarMod();
						Info.main(j);
					}
				}
			}
		});
		
		return salvar;
	}
}
