/*
 * Created on 15-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfacce;


import intermediate.SuppliesManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CercaFornitore {
	
	public CercaFornitore()
	{
		try{
			font = new Font("Arial", Font.BOLD, 13);
			jbInit();
			}
		catch(Exception e){
			e.printStackTrace();
			}
		}
	public void jbInit() throws Exception{
		buttonCreate();
		creaPannello();
	}

	public void creaPannello(){
	aut = new JLabel();
	aut.setText("Cerca Fornitore");
	aut.setFont(new Font("Arial", Font.BOLD, 18));
	aut.setForeground(new Color(255,227,198));
	aut.setHorizontalAlignment(SwingConstants.CENTER);
	idFornitore = new JTextField();
	JLabel idForn = new JLabel("ID Fornitore");
	cont = new Container();
	idForn.setFont(font);
	idForn.setForeground(Color.white);
	idFornitore.setFont(font);
	cerca.setFont(font);
	cancella.setFont(font);
	cont.setSize(800,600);
	cont.add(aut).setBounds(220,0,300,60);
	cont.add(cerca).setBounds(250,140,110,30);
	cont.add(cancella).setBounds(370, 140, 110,30);
	cont.add(idForn).setBounds(190,80,200,32);
	cont.add(idFornitore).setBounds(280,80,200,25);
}

	public void buttonCreate(){
		cerca = button("Cerca", new Color(119,94,68), Color.WHITE);
		cerca.addMouseListener(new search());
		cancella = button("Cancella", new Color(119,94,68), Color.WHITE);
		cancella.addMouseListener(new reset());
		}

	public JButton button(String name, Color color, Color fg){
		JButton but = new JButton(name);
		but.setBackground(color);
		but.setForeground(fg);
		return but;
		}

	class search extends MouseAdapter {

		public void mouseReleased(MouseEvent east){
			SuppliesManagement supplies = new SuppliesManagement(idFornitore.getText());
			GestioneFornitoreForm fornitore = new GestioneFornitoreForm(supplies.getSupplies());
			cont.removeAll();
			cont.add(fornitore.getContainer());
			cont.repaint();
			}

		}
	class reset extends MouseAdapter {

		public void mouseReleased(MouseEvent east){
				try{
					idFornitore.setText("");
				}
				catch(Exception e){
					e.printStackTrace();
				}
		}

	}
		
		public Container getContainer(){
			return cont;
		}


		private JButton cerca, cancella;
		private JMenuBar jmb;
		private JPanel pannello;
		private JFrame jf;
		private JLabel aut;
		private Connection con;
		private Container cont;
		private JTextField idFornitore;
		private Font font;
}



