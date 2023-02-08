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
public class Balance {

	/**
	 * 
	 */
	public Balance() {
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		creaContenitore();
	}
	
	public void creaContenitore(){
		cont = new Container();
		cont.setSize(800,600);
		balance = new JLabel("Gestione Bilancio");
		balance.setFont(new Font("Arial", Font.BOLD, 18));
		balance.setForeground(new Color(255,227,198));
		cont.add(balance).setBounds(250,0,300,60);
		cont.add(insertExp).setBounds(220,120,230,32);
		cont.add(suppliesPay).setBounds(220,170,230,32);
		cont.add(printBal).setBounds(220,220,230,32);
	}
	
	public Container getContainer(){
		return cont;
	}
	
	public void buttonCreate(){
		insertExp = button("Inserisci spesa", new Color(119,94,68), Color.WHITE);
		insertExp.addMouseListener(new insert());
        insertExp.setFont(font);
        printBal = button("Stampa bilancio", new Color(119,94,68), Color.WHITE);
        printBal.addMouseListener(new print());
        printBal.setFont(font);
        suppliesPay = button("Pagamento fornitori", new Color(119,94,68), Color.WHITE);
        suppliesPay.addMouseListener(new pay());
        suppliesPay.setFont(font);
	}
	
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        return but;
    }
	
	class insert extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			InsertExpense expense = new InsertExpense();
			cont.removeAll();
			cont.add(expense.getContainer());
			cont.repaint();
		}
	}
	
	class pay extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			SuppliesPay sup = new SuppliesPay();
			cont.removeAll();
			cont.add(sup.getContainer());
			cont.repaint();
		}
	}
	
	class print extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			StampaBilancio print = new StampaBilancio();
			cont.removeAll();
			cont.add(print.getContainer());
			cont.repaint();
		}
	}
	
	private Container cont;
	private Font font;
	private JButton insertExp, printBal, suppliesPay;
	private JLabel balance;

}
