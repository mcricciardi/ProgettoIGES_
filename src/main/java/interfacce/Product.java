
/*
 * Created on 17-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfacce;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Product {

	/**
	 * 
	 */
	public Product() {
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		creaContenitore();
	}
	
	public void creaContenitore(){
		cont = new Container();
		cont.setSize(694,520);
		balance = new JLabel("Gestione Magazzino");
		balance.setFont(new Font("Arial", Font.BOLD, 18));
		balance.setForeground(new Color(255,227,198));
		cont.add(balance).setBounds(255,0,300,60);
		cont.add(search).setBounds(255,120,200,25);
		cont.add(manage).setBounds(255,150,200,25);
	}
	
	public Container getContainer(){
		return cont;
	}
	
	public void buttonCreate(){
		search = button("Cerca", new Color(119,94,68), Color.WHITE);
		search.addMouseListener(new search());
		search.setFont(font);
		manage = button("Gestisci prodotto", new Color(119,94,68), Color.WHITE);
        manage.addMouseListener(new manage());
        manage.setFont(font);
	}
	
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        return but;
    }
	
	class search extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			CercaProdotto prod = new CercaProdotto();
			cont.removeAll();
			cont.add(prod.getContainer());
			cont.repaint();
		}
	}
	
	class manage extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			GestioneProductForm prod = new GestioneProductForm();
			cont.removeAll();
			cont.add(prod.getContainer());
			cont.repaint();
		}
	}
	
	private Container cont;
	private Font font;
	private JButton search, manage;
	private JLabel balance;

}
