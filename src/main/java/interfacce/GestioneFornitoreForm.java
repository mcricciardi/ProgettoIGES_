/*
 * Created on 14-giu-2005
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

import entity.Supplies;


/**
 * @author Enza
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GestioneFornitoreForm {
	
	public GestioneFornitoreForm()
	{
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		creaPannello();
	}
	
	public GestioneFornitoreForm(Supplies sup){
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		creaPannello();
		Supplies supplies = sup;
		idFornitore.setText(supplies.getPiva());
		nome.setText(supplies.getNome());
		cognome.setText(supplies.getCognome());
		telefono.setText(supplies.getTel());
		fax.setText(supplies.getFax());
		indirizzo.setText(supplies.getIndirizzo());
		debito.setText(supplies.getDebito());
		pagato.setText(supplies.getPagato());
	}
	
	public void creaPannello(){
		pannello = new JPanel();
		pannello.setLayout(null);
		aut = new JLabel();
		aut.setText("Gestione Fornitore");
		aut.setFont(new Font("Arial", Font.BOLD, 18));
		aut.setForeground(new Color(255,227,198));
		idFornitore = new JTextField();
		idFornitore.setFont(font);
		
		debito = new JTextField();
		debito.setFont(font);
		JLabel deb = new JLabel("Debito");
		deb.setFont(font);
		deb.setForeground(Color.WHITE);
		
		pagato = new JTextField();
		pagato.setFont(font);
		JLabel pag = new JLabel("Pagato");
		pag.setFont(font);
		pag.setForeground(Color.WHITE);
		
		JLabel idForn = new JLabel("P.IVA");
		idForn.setFont(font);
		idForn.setForeground(Color.WHITE);
		nome = new JTextField();
		nome.setFont(font);
		JLabel name = new JLabel("Nome");
		name.setFont(font);
		name.setForeground(Color.WHITE);
		cognome = new JTextField();
		cognome.setFont(font);
		JLabel surname = new JLabel("Cognome");
		surname.setFont(font);
		surname.setForeground(Color.WHITE);
		telefono = new JTextField();
		telefono.setFont(font);
		JLabel tel = new JLabel("Telefono");
		tel.setFont(font);
		tel.setForeground(Color.WHITE);
		fax = new JTextField();
		fax.setFont(font);
		JLabel fx = new JLabel("FAX");
		fx.setFont(font);
		fx.setForeground(Color.WHITE);
		indirizzo = new JTextField();
		indirizzo.setFont(font);
		JLabel address = new JLabel("Indirizzo");
		address.setFont(font);
		address.setForeground(Color.WHITE);
		msg = new JLabel();
		msg.setFont(font);
		msg.setForeground(Color.BLACK);
		msg.setVisible(false);
		cont = new Container();
		cont.setSize(800,600);
		cont.add(insert).setBounds(170,330,125,30);
		cont.add(remove).setBounds(295, 330, 125,30);
		cont.add(update).setBounds(420,330,125,30);
		cont.add(reset).setBounds(170,360,375,30);
		cont.add(msg).setBounds(250,400,375,30);
		cont.add(search).setBounds(500,60,100,25);
		cont.add(aut).setBounds(240,0,300,60);
		cont.add(idForn).setBounds(190,60,200,32);
		cont.add(idFornitore).setBounds(280,60,200,25);
		cont.add(name).setBounds(190,90,200,32);
		cont.add(nome).setBounds(280,90,200,25);
		cont.add(surname).setBounds(190,120,200,32);
		cont.add(cognome).setBounds(280,120,200,25);
		cont.add(tel).setBounds(190,150,200,32);
		cont.add(telefono).setBounds(280,150,200,25);
		cont.add(fx).setBounds(190,180,200,32);
		cont.add(fax).setBounds(280,180,200,25);
		cont.add(address).setBounds(190,210,200,32);
		cont.add(indirizzo).setBounds(280,210,200,25);
		cont.add(deb).setBounds(190,240,200,32);
		cont.add(debito).setBounds(280,240,200,25);
		cont.add(pag).setBounds(190,270,200,32);
		cont.add(pagato).setBounds(280,270,200,25);
	}
	
	public void buttonCreate(){
		insert = button("Inserisci", new Color(119,94,68), Color.WHITE);
		insert.setFont(font);
        insert.addMouseListener(new inserisci());
		remove = button("Cancella", new Color(119,94,68), Color.WHITE);
		remove.setFont(font);
        remove.addMouseListener(new remove());
        update = button("Aggiorna", new Color(119,94,68), Color.WHITE);
        update.setFont(font);
        update.addMouseListener(new update());
        reset = button("Reset Form", new Color(119,94,68), Color.WHITE);
        reset.setFont(font);
        reset.addMouseListener(new reset());
        search = button("Cerca", new Color(119,94,68), Color.WHITE);
        search.setFont(font);
        search.addMouseListener(new search());
	}
	
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        return but;
    }
	
	public Container getContainer(){
		return cont;
	}
	
	class inserisci extends MouseAdapter {

        public void mouseReleased(MouseEvent east){
        	SuppliesManagement supplies = new SuppliesManagement();
        	Supplies sup = new Supplies();
        	sup.setNome(nome.getText());
        	sup.setCognome(cognome.getText());
        	sup.setFax(fax.getText());
        	sup.setTel(telefono.getText());
        	sup.setPiva(idFornitore.getText());
        	sup.setIndirizzo(indirizzo.getText());
			
			sup.setDebito(debito.getText());
			sup.setPagato(pagato.getText());
			
        	if(supplies.insertSupplies(sup))
        		msg.setText("Fornitore inserito correttamente");
        	else
        		msg.setText("Impossibile inserire il fornitore");
            msg.setVisible(true);
        }

    }
	class remove extends MouseAdapter {

        public void mouseReleased(MouseEvent east){
        	SuppliesManagement supplies = new SuppliesManagement();
        	Supplies sup = new Supplies();
        	sup.setPiva(idFornitore.getText());
        	if(supplies.removeSupplies(sup))
        		msg.setText("Fornitore cancellato correttamente");
        	else
        		msg.setText("Fornitore non cancellato");
            msg.setVisible(true);
        }

    }
	
	class update extends MouseAdapter {

        public void mouseReleased(MouseEvent east){
        	SuppliesManagement supplies = new SuppliesManagement();
        	Supplies sup = new Supplies();
        	sup.setNome(nome.getText());
        	sup.setCognome(cognome.getText());
        	sup.setFax(fax.getText());
        	sup.setTel(telefono.getText());
        	sup.setPiva(idFornitore.getText());
        	sup.setIndirizzo(indirizzo.getText());
        	
        	sup.setDebito(debito.getText());
			sup.setPagato(pagato.getText());
        	if(supplies.updateSupplies(sup))
        		msg.setText("Parametri aggiornati correttamente");
        	else
        		msg.setText("Impossibile aggiornare i parametri");
            msg.setVisible(true);
        }

    }
	
	class reset extends MouseAdapter {

        public void mouseReleased(MouseEvent east){
        	idFornitore.setText("");
        	nome.setText("");
        	cognome.setText("");
        	telefono.setText("");
        	fax.setText("");
        	indirizzo.setText("");
        	debito.setText("");
        	pagato.setText("");
        	msg.setVisible(false);
        }

    }
	
	class search extends MouseAdapter{
		
		public void mouseReleased(MouseEvent east){
			SuppliesManagement supplies = new SuppliesManagement(idFornitore.getText());
			GestioneFornitoreForm fornitore = new GestioneFornitoreForm(supplies.getSupplies());
			cont.removeAll();
			cont.add(fornitore.getContainer());
			cont.repaint();			
		}
	}


	private JButton insert, remove, update, reset, search;
	private JMenuBar jmb;
	private JPanel pannello;
	private JFrame jf;
	private JLabel aut, msg,deb,pag;
	private Connection con;
	private Container cont;
	private JTextField idFornitore, nome, cognome, telefono, fax, indirizzo,debito,pagato;
	private Font font;
}