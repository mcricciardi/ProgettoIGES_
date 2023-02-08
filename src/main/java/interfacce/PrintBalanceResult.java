package interfacce;


import intermediate.PrintTextArea;
import intermediate.EntrancesManagement;
import intermediate.ExitsManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * @author Domenico
 * @version 1.1
 */
public class PrintBalanceResult {
	
	/**
	 * Inizializzazione delle variabili
	 * @param period periodo per la ricerca
	 */
	public PrintBalanceResult(String[] period){
		font = new Font("Comic Sans MS", Font.BOLD, 20);
		entrate = new JTextArea();
		entrate.setBackground(new Color(230,255,255));
		entrate.setFont(new Font("Arial",Font.BOLD,14));
		entrate.setEditable(false);
		spese = new JTextArea();
		spese.setBackground(new Color(230,255,255));
		spese.setFont(new Font("Arial",Font.BOLD,14));
		spese.setEditable(false);
		ExitsManagement exitMan = new ExitsManagement();
		leggiSpese(exitMan.getExit(period));
		EntrancesManagement entryMan = new EntrancesManagement();
		leggiEntrate(entryMan.getEntrance(period));
		buttonCreate();
		createContainer();
	}
	
	/**
	 * Metodo per la creazione del contenitore
	 *
	 */
	public void createContainer(){
		intestazione = new JLabel();
		intestazione.setText("Stampa Bilancio");
		intestazione.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
		intestazione.setForeground(Color.RED);
		intestazione.setHorizontalAlignment(SwingConstants.CENTER);
		entrance = new JLabel("Entrate");
		entrance.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		entrance.setForeground(Color.BLUE);
		exits = new JLabel("Spese");
		exits.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		exits.setForeground(Color.BLUE);
		cont = new Container();
		cont.setSize(800,600);
		cont.add(intestazione).setBounds(280, 25, 250, 40);
		cont.add(stampa).setBounds(330,500,140,30);
		cont.add(entrance).setBounds(15,60,100,30);
		cont.add(entrate).setBounds(15,90,380,400);
		cont.add(exits).setBounds(730,60,100,30);
		cont.add(spese).setBounds(405,90,380,400);
	}
	
	/**
	 * Lettura delle entrate passate tramite ArrayList
	 * @param dati
	 */
	private void leggiEntrate(ArrayList dati){
		float totale=0;
		String str="";
		if(dati!=null)
		for(int i=0; i<dati.size(); i++){
			str+=dati.get(i).toString();
			i++;
			str+=dati.get(i).toString();
			i++;
			str+=dati.get(i).toString()+"\n";
			if(i>5&&!dati.get(i).toString().equals("")) totale+=Float.parseFloat(dati.get(i).toString());
		}
		str+="\n\nTotale:\t\t\t"+totale;
		entrate.setText(str);
	}
	
	/**
	 * Lettura delle spese passate tramite ArrayList
	 * @param dati
	 */
	private void leggiSpese(ArrayList dati){
		float totale=0;
		String str="";
		for(int i=0; i<dati.size(); i++){
			str+=dati.get(i).toString();
			i++;
			str+=dati.get(i).toString();
			i++;
			str+=dati.get(i).toString()+"\n";
			if(i>5&&!dati.get(i).toString().equals("")) totale+=Float.parseFloat(dati.get(i).toString());
		}
		str+="\n\nTotale:\t\t\t"+totale;
		spese.setText(str);
	}
	
	/**
	 * Restituzione del contenitore creato
	 * @return Container
	 */
	public Container getContainer(){
		return cont;
	}
	
	/**
	 * Creazione dei pulsanti
	 *
	 */
	public void buttonCreate(){
		stampa = button("Stampa", new Color(200,200,50), Color.BLACK);
		stampa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new print();
			}
		});
		stampa.setFont(font);
	}
	
	/**
	 * Inizializzazione dei pulsanti
	 * @param name nome che verr� visualizzato sul pulsante
	 * @param color colore di sfondo del pulsante
	 * @param fg colore del testo del pulsante
	 * @return JButton
	 */
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        return but;
    }
	
	/**
	 * Stampa il contenuto delle tabelle
	 * @author Domenico
	 * @version 1.0
	 */
	class print extends Frame{
		public print(){
			PrintJob printJob = Toolkit.getDefaultToolkit().getPrintJob(this,"Bilancio",null);
			PrintTextArea printEntry = new PrintTextArea(entrate,"Entrate");
			PrintTextArea printExits = new PrintTextArea(spese,"Spese");
			if (printJob == null)
			return;
			try {
				Graphics g = printJob.getGraphics();
				printEntry.print(g);
				printExits.print(g);
				g.dispose();
				}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				printJob.end();
			}
		}
	}
	
	private JTextArea entrate, spese;
	private JLabel intestazione, entrance, exits;
	private Font font;
	private Container cont;
	private JButton stampa;

}
