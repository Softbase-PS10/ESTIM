/*
 * 
 */

package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Botones {
	
	public static JButton aplicarFiltros() {
		JButton btnNewButton_5 = new JButton("Apply");
		btnNewButton_5.setBounds(84, 293, 66, 20);

		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return btnNewButton_5;
	}

	public static JButton save(){
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(961, 427, 89, 33);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return btnNewButton_1;
	}
}
