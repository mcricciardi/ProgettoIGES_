/*
 * Created on 15-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfacce;

import intermediate.ProductManagement;

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

public class CercaProdotto {
	
	public CercaProdotto()
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
	aut.setText("Cerca Prodotto");
	aut.setFont(new Font("Arial", Font.BOLD, 18));
	aut.setForeground(new Color(255,227,198));
	aut.setHorizontalAlignment(SwingConstants.CENTER);
	idProdotto = new JTextField();
	JLabel idProd = new JLabel("ID Prodotto");
	cont = new Container();
	idProd.setFont(font);
	idProd.setForeground(Color.WHITE);
	idProdotto.setFont(font);
	invia.setFont(font);
	cancella.setFont(font);
	cont.setSize(800,600);
	cont.add(aut).setBounds(220,0,300,60);
	cont.add(invia).setBounds(250,140,110,30);
	cont.add(cancella).setBounds(370, 140, 110,30);
	cont.add(idProd).setBounds(190,80,200,32);
	cont.add(idProdotto).setBounds(280,80,200,25);
}

	public void buttonCreate(){
		invia = button("Cerca", new Color(119,94,68), Color.WHITE);
		invia.addMouseListener(new invia());
		cancella = button("Cancella", new Color(119,94,68), Color.WHITE);
		cancella.addMouseListener(new reset());
		}

	public JButton button(String name, Color color, Color fg){
		JButton but = new JButton(name);
		but.setBackground(color);
		but.setForeground(fg);
		return but;
		}

	class invia extends MouseAdapter {

		public void mouseReleased(MouseEvent east){
			try{
				ProductManagement prodMan = new ProductManagement(idProdotto.getText());
				GestioneProductForm prod = new GestioneProductForm(prodMan.getProduct(),0);
				cont.removeAll();
				cont.add(prod.getContainer());
				cont.repaint();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}

		}
	class reset extends MouseAdapter {

		public void mouseReleased(MouseEvent east){
				try{
					idProdotto.setText("");
				}
				catch(Exception e){
					e.printStackTrace();
				}
		}

	}
		
		public Container getContainer(){
			return cont;
		}


		private JButton invia, cancella;
		private JMenuBar jmb;
		private JPanel pannello;
		private JFrame jf;
		private JLabel aut;
		private Connection con;
		private Container cont;
		private JTextField idProdotto;
		private Font font;
}




