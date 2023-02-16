package interfacce;


import intermediate.Conversion;
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

import entity.Product;


public class GestioneProductForm {
	
	public GestioneProductForm(){
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		creaContenitore();
		idProdotto.setText("");
    	marca.setText("");
    	modello.setText("");
    	categoria.setText("");
    	prezzo.setText("");
		initialize();
		}
	
	public GestioneProductForm(Product prod, int flag){
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		creaContenitore();
		this.flag = flag;
		idProdotto.setText(prod.getID());
		marca.setText(prod.getMarca());
		modello.setText(prod.getModello());
		categoria.setText(prod.getCategoria());
		prezzo.setText(prod.getPrz());
		qta.setText(prod.getQta());
		initialize();
	}
	
	/**
	 * Metodo per il salvataggio della quantit� letta dal campo qta
	 *
	 */
	private void initialize(){
		if(!qta.getText().equals(""))
			oldQta = Integer.parseInt(qta.getText());
		else
			oldQta = 0;
		newQta = 0;
		sum = 0;
	}
	
	/**
	 * Metodo per la creazione del contenitore che deve incapsulare gli oggetti
	 *
	 */
	public void creaContenitore(){
		aut = new JLabel();
		aut.setText("Gestione Prodotti");
		aut.setFont(new Font("Arial", Font.BOLD, 18));
		aut.setForeground(new Color(255,227,198));
		idProdotto = new JTextField();
		idProdotto.setFont(font);
		JLabel idProd = new JLabel("ID Prodotto");
		idProd.setFont(font);
		idProd.setForeground(Color.WHITE);
		marca = new JTextField();
		marca.setFont(font);
		JLabel mar = new JLabel("Marca");
		mar.setFont(font);
		mar.setForeground(Color.WHITE);
		modello = new JTextField();
		modello.setFont(font);
		JLabel mod = new JLabel("Modello");
		mod.setFont(font);
		mod.setForeground(Color.WHITE);
		categoria = new JTextField();
		categoria.setFont(font);
		JLabel cat = new JLabel("Categoria");
		cat.setFont(font);
		cat.setForeground(Color.WHITE);
		prezzo = new JTextField();
		prezzo.setFont(font);
		JLabel prez = new JLabel("Prezzo");
		prez.setFont(font);
		prez.setForeground(Color.WHITE);
		JLabel Qta = new JLabel("Quantit�");
		Qta.setFont(font);
		Qta.setForeground(Color.WHITE);
		qta = new JTextField();
		qta.setFont(font);
		msg = new JLabel();
		msg.setFont(font);
		msg.setVisible(false);
		cont = new Container();
		cont.setSize(800,600);
		//aggiunta degli oggetti al contenitore
		//specificandone le misure e le posizioni
		cont.add(insert).setBounds(170,330,125,30);
		cont.add(remove).setBounds(295, 330, 125,30);
		cont.add(update).setBounds(420,330,125,30);
		cont.add(reset).setBounds(170,360,375,30);
		cont.add(msg).setBounds(250,400,375,30);
		cont.add(search).setBounds(500,60,100,25);
		cont.add(aut).setBounds(240,0,300,60);
		cont.add(idProd).setBounds(190,60,200,32);
		cont.add(idProdotto).setBounds(280,60,200,25);
		cont.add(mar).setBounds(190,90,200,32);
		cont.add(marca).setBounds(280,90,200,25);
		cont.add(mod).setBounds(190,120,200,32);
		cont.add(modello).setBounds(280,120,200,25);
		cont.add(cat).setBounds(190,150,200,32);
		cont.add(categoria).setBounds(280,150,200,25);
		cont.add(prez).setBounds(190,180,200,32);
		cont.add(prezzo).setBounds(280,180,200,25);
		cont.add(Qta).setBounds(190,210,200,32);
		cont.add(qta).setBounds(280,210,200,25);
	}
	
	/**
	 * Metodo per la creazione dei pulsanti
	 *
	 */
	public void buttonCreate(){
		insert = button("Inserisci", new Color(119,94,68), Color.WHITE);
		insert.setFont(font);
	    insert.addMouseListener(new invia());
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
		
	public Container getContainer(){
		return cont;
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.2
	 * 
	 */
	class invia extends MouseAdapter {

		public void mouseReleased(MouseEvent east){
			String id = idProdotto.getText();
			if(id.equals(""))
				return;
			Conversion conversion = new Conversion();
			ProductManagement prodMan = new ProductManagement();
			Product prodotto = new Product();
			
			if(id.length()<10 || id.length()>15){
				msg.setText("ID Prodotto non valido");
				msg.setVisible(true);
				return;
			}
			prodotto.setCategoria(categoria.getText());
			prodotto.setID(id);
			prodotto.setMarca(marca.getText());
			prodotto.setModello(modello.getText());
			prodotto.setPrz(prezzo.getText());
			if(oldQta==0)
				prodotto.setQta(qta.getText());
	        else{
	        	if(!qta.getText().equals(""))
	        		newQta = conversion.getNumber(qta.getText());
	        	else
	        		newQta = 0;
	        	if(!prodMan.getProduct().getQta().equals(""))
	        	newQta+= Integer.parseInt(prodMan.getProduct().getQta());
	        	prodotto.setQta(conversion.getNumber(newQta));
	        }
	        prodMan.setFlag(flag);
			if(prodMan.insertProduct(prodotto)){
				msg.setText("Prodotto inserito correttamente");
			}
	        else
	        	msg.setText("Impossibile inserire il prodotto");
			flag = 0;
	        msg.setVisible(true);
	        idProdotto.setText("");
	        marca.setText("");
	        modello.setText("");
	        categoria.setText("");
	        prezzo.setText("");
	        qta.setText("");
		}

	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class remove extends MouseAdapter {

		public void mouseReleased(MouseEvent east){
			Product prodotto = new Product();
			prodotto.setID(idProdotto.getText());
			ProductManagement prodMan = new ProductManagement(idProdotto.getText());
			if(prodMan.removeProduct())
				msg.setText("Prodotto eliminato correttamente");
			else
				msg.setText("Impossibile eliminare il prodotto");
			msg.setVisible(true);
			idProdotto.setText("");
			marca.setText("");
			modello.setText("");
			categoria.setText("");
			prezzo.setText("");
			qta.setText("");
			flag = 0;
		}

	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class update extends MouseAdapter {

		public void mouseReleased(MouseEvent east){
			Conversion conversion = new Conversion();
			ProductManagement prodMan = new ProductManagement(idProdotto.getText());
			Product prodotto = new Product();
			prodotto.setCategoria(categoria.getText());
			prodotto.setID(idProdotto.getText());
			prodotto.setMarca(marca.getText());
			prodotto.setModello(modello.getText());
			prodotto.setPrz(prezzo.getText());
			if(oldQta==0)
				prodotto.setQta(qta.getText());
			else{
				if(!qta.getText().equals(""))
					newQta = conversion.getNumber(qta.getText());
	        	else
	        		newQta = 0;
	        	sum = Integer.parseInt(prodMan.getProduct().getQta())+newQta;
	        	prodotto.setQta(conversion.getNumber(sum));
			}
			System.out.println("newQta="+newQta+"\toldQta="+oldQta);
	        	
			if(prodMan.updateProduct(prodotto))
				msg.setText("Prodotto aggiornato correttamente");
	        else
	        	msg.setText("Impossibile aggiornare il prodotto");
	        msg.setVisible(true);
	        flag = 0;
	        idProdotto.setText("");
	        marca.setText("");
	        modello.setText("");
	        categoria.setText("");
	        prezzo.setText("");
	        qta.setText("");
		}

	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class reset extends MouseAdapter {

		public void mouseReleased(MouseEvent east){
			idProdotto.setText("");
			marca.setText("");
			modello.setText("");
			categoria.setText("");
			prezzo.setText("");
			qta.setText("");
			msg.setVisible(false);
			flag = 0;
		}

	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.2
	 */
	class search extends MouseAdapter{
			
		public void mouseReleased(MouseEvent east){
			String id;
			if(idProdotto.getText().length()>15)
				id = idProdotto.getText().substring(0,16);
			else
				id = idProdotto.getText();
			ProductManagement prodMan = new ProductManagement(id);
			Product prod = prodMan.getProduct();
			marca.setText(prod.getMarca());
			modello.setText(prod.getModello());
			categoria.setText(prod.getCategoria());
			prezzo.setText(prod.getPrz());
			qta.setText(prod.getQta());
			flag = 0;
		}
	}

	private JButton insert, remove, update, reset, search;
	private JMenuBar jmb;
	private JPanel pannello;
	private JFrame jf;
	private JLabel aut, msg;
	private Connection con;
	private Container cont;
	private JTextField idProdotto, marca, modello, categoria, prezzo, qta;
	private Font font;
	private int oldQta, newQta, sum, flag;
}