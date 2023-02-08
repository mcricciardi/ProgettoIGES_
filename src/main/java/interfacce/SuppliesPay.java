
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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Supplies;


/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SuppliesPay {

	public SuppliesPay() {
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		createContainer();
	}
	
	public void createContainer(){
		cont = new Container();
		cont.setSize(694,520);
		ie = new JLabel("Pagamento fornitori");
		ie.setFont(new Font("Arial", Font.BOLD, 18));
		ie.setForeground(new Color(255,227,198));
		msg = new JLabel("");
		msg.setFont(font);
		msg.setVisible(false);
		idLabel = new JLabel("P. I.V.A.");
		idLabel.setFont(font);
		idLabel.setForeground(Color.white);
		id = new JTextField();
		id.setFont(font);
		amountLabel = new JLabel("Importo");
		amountLabel.setFont(font);
		amountLabel.setForeground(Color.white);
		amount = new JTextField();
		amount.setFont(font);
		deb = new JLabel("Debito");
		deb.setFont(font);
		deb.setForeground(Color.white);
		debito = new JTextField();
		debito.setFont(font);
		cont.add(ie).setBounds(250,0,300,60);
		cont.add(pay).setBounds(240,190,120,25);
		cont.add(insert).setBounds(370,190,120,25);
		cont.add(idLabel).setBounds(190,80,200,32);
		cont.add(id).setBounds(280,80,200,25);
		cont.add(search).setBounds(490,80,110,25);
		cont.add(amountLabel).setBounds(190,110,100,32);
		cont.add(amount).setBounds(280,110,200,25);
		cont.add(deb).setBounds(190,140,100,32);
		cont.add(debito).setBounds(280,140,200,25);
		cont.add(msg).setBounds(250,350,400,50);
	}
	
	public void buttonCreate(){
		search = button("Cerca", new Color(119,94,68), Color.WHITE);
		search.addMouseListener(new search());
		search.setFont(font);
		pay = button("Paga", new Color(119,94,68), Color.WHITE);
		pay.addMouseListener(new pay());
		pay.setFont(font);
		insert = button("Inserisci", new Color(119,94,68), Color.WHITE);
		insert.addMouseListener(new submit());
		insert.setFont(font);
	}
	
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        return but;
    }
	
	class pay extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			if(!amount.getText().equals("")){
				SuppliesManagement supplies = new SuppliesManagement();
				Supplies sup = new Supplies();
				sup.setPagato(amount.getText());
				sup.setDebito(debito.getText());
				sup.setPiva(id.getText());
        		if(supplies.updateSuppliesPayement(sup))
        			msg.setText("Parametri aggiornati correttamente");
        		else
        			msg.setText("Impossibile aggiornare i parametri");
            	msg.setVisible(true);
            	id.setText("");
				amount.setText("");
				debito.setText("");
			}
		}
	}
	
	class submit extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			if(!amount.getText().equals("")){
				SuppliesManagement supplies = new SuppliesManagement();
				Supplies sup = new Supplies();
				sup.setPagato(amount.getText());
				sup.setDebito(debito.getText());
			//	sup.setPagato("");
				sup.setPiva(id.getText());
				if(supplies.updateSuppliesPayement(sup))
					msg.setText("Parametri aggiornati correttamente");
				else
					msg.setText("Impossibile aggiornare i parametri");
				msg.setVisible(true);
				id.setText("");
				amount.setText("");
				debito.setText("");
			}
		}
	}
	
	class search extends MouseAdapter{
		
		public void mouseReleased(MouseEvent east){
			SuppliesManagement supplies = new SuppliesManagement(id.getText());
			Supplies sup = supplies.getSupplies();
			amount.setText(sup.getPagato());
		}
	}
	
	public Container getContainer(){
		return cont;
	}
	
	private JButton insert, search, pay;
	private Font font;
	private Container cont;
	private JPanel pannello;
	private JLabel ie, amountLabel, idLabel, deb, msg;
	private JTextField amount, id, debito;
}
