package interfacce;


import intermediate.Conversion;
import intermediate.ExitsManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Expense;


/**
 * @author Domenico
 * @version 1.0
 */
public class InsertExpense {

	public InsertExpense() {
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		createContainer();
	}
	
	/**
	 * Metodo per la creazione del contenitore
	 *
	 */
	public void createContainer(){
		Date data = new Date();
		int month = data.getMonth()+1;
		String mese;
		Conversion conv = new Conversion();
		if(month<10) mese = "0"+conv.getNumber(month);
		else	mese = conv.getNumber(month);
		cont = new Container();
		cont.setSize(800,600);
		ie = new JLabel("Inserisci Spesa");
		ie.setFont(new Font("Arial", Font.BOLD, 18));
		ie.setForeground(new Color(255,227,198));
		dateLabel = new JLabel("Data");
		dateLabel.setFont(font);
		dateLabel.setForeground(Color.white);
		date = new JTextField(data.getDate()+"/"+mese+"/"+(data.getYear()+1900));
		date.setFont(font);
		amountLabel = new JLabel("Importo");
		amountLabel.setFont(font);
		amountLabel.setForeground(Color.white);
		amount = new JTextField();
		amount.setFont(font);
		countLabel = new JLabel("Numero conto");
		countLabel.setFont(font);
		countLabel.setForeground(Color.white);
		count = new JTextField();
		count.setFont(font);
		descLabel = new JLabel("Descrizione");
		descLabel.setFont(font);
		descLabel.setForeground(Color.white);
		desc = new JTextField();
		desc.setFont(font);
		//aggiunta degli oggetti al contenitore
		//specificandone le misure e le posizioni
		cont.add(ie).setBounds(280,15,250,60);
		cont.add(reset).setBounds(350,270,140,25);
		cont.add(insert).setBounds(200,270,140,25);
		cont.add(dateLabel).setBounds(80,150,50,32);
		cont.add(date).setBounds(180,150,140,25);
		cont.add(amountLabel).setBounds(350,150,100,32);
		cont.add(amount).setBounds(450,150,140,25);
		cont.add(countLabel).setBounds(80,185,140,32);
		cont.add(count).setBounds(180,185,140,25);
		cont.add(descLabel).setBounds(350,185,140,32);
		cont.add(desc).setBounds(450,185,140,25);
	}
	
	/**
	 * Metodo per la creazione dei pulsanti
	 *
	 */
	public void buttonCreate(){
		insert = button("Inserisci", new Color(119,94,68), Color.WHITE);
		insert.addMouseListener(new submit());
		insert.setFont(font);
		reset = button("Cancella", new Color(119,94,68), Color.WHITE);
        reset.addMouseListener(new reset());
        reset.setFont(font);
	}
	
	/**
	 * Metodo per l'inizializzazione del pulsante
	 * @param name nome del pulsante da creare
	 * @param color colore di sfondo del pulsante
	 * @param fg colore del testo
	 * @return JButton
	 */
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        return but;
    }
	
	/**
	 * Inserisce la spesa nel database
	 * @author Domenico
	 * @version 1.0
	 */
	class submit extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			if(count.getText().equals("")) return;
			try{
				int amount = Integer.parseInt(count.getText());
				if(amount<=0) return;
			}
			catch(Exception e){
				return;
			}
			ExitsManagement exit = new ExitsManagement();
			Expense spesa = new Expense();
			spesa.setAmount(amount.getText());
			spesa.setCount(count.getText());
			spesa.setDesc(desc.getText());
			spesa.setDay(date.getText().substring(0,2));
			spesa.setMonth(date.getText().substring(3,5));
			spesa.setYear(date.getText().substring(6,10));
			exit.addExit(spesa);
			date.setText("");
			amount.setText("");
			desc.setText("");
			count.setText("");
		}
	}
	
	/**
	 * Reset dei campi del form
	 * @author Domenico
	 * @version 1.0
	 */
	class reset extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
				date.setText("");
				amount.setText("");
				desc.setText("");
				count.setText("");
		}
	}
	
	/**
	 * Metodo per la restituzione del contenitore creato
	 * @return Container
	 */
	public Container getContainer(){
		return cont;
	}
	
	private JButton insert, reset;
	private Font font;
	private Container cont;
	private JPanel pannello;
	private JLabel ie, dateLabel, amountLabel, countLabel, descLabel;
	private JTextField date, amount, count, desc;
}
