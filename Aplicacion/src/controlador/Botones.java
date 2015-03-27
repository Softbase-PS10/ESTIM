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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
	public static JButton save(){
		JButton salvar = new JButton("Save");
		salvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		salvar.setBounds(961, 427, 89, 33);
		
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return salvar;
	}
}
