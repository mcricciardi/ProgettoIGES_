package interfacce;


import accessdb.ConstantsDB;
import intermediate.Conversion;
import intermediate.EntrancesManagement;
import intermediate.ProductManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entity.Product;
import entity.Entrance;


/**
 * @author Domenico
 * @version 1.1
 */
public class GestioneCassa {

	public GestioneCassa() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql:///sm";
			Connection con = DriverManager.getConnection(url, ConstantsDB.USER,ConstantsDB.PSW);
			jbInit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo per l'inizializzazione del frame
	 *
	 */
	public void jbInit(){
		font = new Font("Arial", Font.BOLD, 13);	//inizializzazione di font
		buttonCreate();	//creazione pulsanti
		creaPannello();	//creazione pannello
		
		//creazione frame
		jf = new JFrame("Gestione Cassa");
		jf.setSize(694,520);
		jf.setLocation(100,50);
		jf.getContentPane().add(BorderLayout.NORTH, gs);
		jf.getContentPane().add(pannello);
		jf.getContentPane().setBackground(new Color(179,152,125));
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Metodo per la creazione del pannello
	 *
	 */
	public void creaPannello(){
		pannello = new JPanel();	//creo un nuovo pannello
		pannello.setLayout(null);	//setto il layout a null
		gs = new JLabel("Gestione Cassa");			//creo l'oggetto gs con testo Gestione Cassa
		gs.setFont(new Font("Arial", Font.BOLD, 18));	//setto il carattere di gs
		gs.setForeground(new Color(255,227,198));	//setto il colore del carattere
		gs.setHorizontalAlignment(SwingConstants.CENTER);	//posiziono gs al centro della finestra
		
		//Creazione e settaggi degli oggetti del form
		ID = new JTextField();	
		ID.setFont(font);
		ID.addActionListener(new search());
		id = new JLabel("ID Prodotto");
		id.setFont(font);
		id.setForeground(Color.WHITE);
		Marca = new JTextField();
		Marca.setFont(font);
		marca = new JLabel("Marca");
		marca.setFont(font);
		marca.setForeground(Color.WHITE);
		descrizione = new JLabel("Descrizione");
		descrizione.setFont(font);
		descrizione.setForeground(Color.WHITE);
		Desc = new JTextField();
		Desc.setFont(font);
		prezzo = new JLabel("Prezzo");
		prezzo.setFont(font);
		prezzo.setForeground(Color.WHITE);
		Prz = new JTextField();
		Prz.setFont(font);
		sconto = new JLabel("Sconto");
		sconto.setFont(font);
		sconto.setForeground(Color.WHITE);
		Sconto = new JTextField();
		Sconto.setFont(font);
		Sconto.addActionListener(new sconto());
		perc = new JLabel("%");
		perc.setFont(font);
		perc.setForeground(Color.WHITE);
		
		//Creazione del messaggio di prodotto non trovato
		alarm = new JLabel();
		alarm.setForeground(Color.BLACK);
		alarm.setFont(font);
		alarm.setVisible(false);
		
		//creazione contenitore e disposizione degli elementi
		cont = new Container();
		cont.setSize(694,520);
		cont.add(reset).setBounds(400,240,140,25);
		cont.add(conferma).setBounds(220,240,140,25);
		cont.add(inserisci).setBounds(220,240,140,25);
		cont.add(id).setBounds(200,20,200,30);
		cont.add(ID).setBounds(320,25,200,25);
		cont.add(marca).setBounds(200,50,200,30);
		cont.add(Marca).setBounds(320,55,200,25);
		cont.add(descrizione).setBounds(200,80,200,30);
		cont.add(Desc).setBounds(320,85,200,25);
		cont.add(prezzo).setBounds(200,110,200,30);
		cont.add(Prz).setBounds(320,115,200,25);
		cont.add(sconto).setBounds(200,140,200,30);
		cont.add(Sconto).setBounds(320,145,100,25);
		cont.add(perc).setBounds(460,145,50,30);
		cont.add(alarm).setBounds(240, 295, 620,25);
		pannello.add(cont);	//aggiunta del contenitore al pannello
		pannello.setBackground(new Color(179,152,125));	//settaggio del colore di sfondo
	}

	/**
	 * Metodo per la creazione dei pulsanti
	 *
	 */
	public void buttonCreate(){
		conferma = button("Conferma", new Color(119,94,68), Color.WHITE);
        conferma.addMouseListener(new conferma());
        conferma.setFont(font);
        reset = button("Cancella", new Color(119,94,68), Color.WHITE);
        reset.addMouseListener(new reset());
        reset.setFont(font);
        inserisci = button("Inserisci", new Color(119,94,68), Color.WHITE);
        inserisci.addMouseListener(new insert());
        inserisci.setFont(font);
        inserisci.setVisible(false);
	}
	
	/**
	 * Metodo per il settaggio del pulsante
	 * @param name testo del pulsante
	 * @param color colore del pulsante
	 * @param fg colore del testo
	 * @return pulsante inizializzato
	 */
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        return but;
    }

	/**
	 * 
	 * @author Domenico
	 * Classe per la ricerca del prodotto nella tabella prodotto
	 */
	class search implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ProductManagement product = new ProductManagement(ID.getText());
			Product prod = product.getProduct();
			Marca.setText(prod.getMarca());
			Desc.setText(prod.getCategoria());
			Prz.setText(prod.getPrz());
			
			//se il prodotto non esiste sostituisce conferma con inserisci
			//per inserire il prodotto nella tabella producttoadd del DB
			if(Marca.getText().equals("")&&Desc.getText().equals("")&&Prz.getText().equals("")){
				alarm.setText("Prodotto non trovato, compilare i campi e premere inserisci!");
				conferma.setVisible(false);
				inserisci.setVisible(true);
				alarm.setVisible(true);
			}
		}
	}

	/**
	 * 
	 * @author Domenico
	 * Classe per l'effettuazione dello sconto
	 */
	class sconto implements ActionListener{
		public void actionPerformed(ActionEvent e){
			float amount = Float.parseFloat(Prz.getText());
			float sc = Float.parseFloat(Sconto.getText());
			amount -=(amount*sc/100);
			Conversion ent = new Conversion();
			Prz.setText(ent.getNumber(amount));
			Sconto.setText("");
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * Classe per la conferma del prodotto acquistato
	 */
	class conferma extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			if(Prz.getText().equals("")){
				alarm.setText("Compilare correttamente il campo \"Prezzo\"!");
				alarm.setVisible(true);
				return;}
			if(ID.getText().equals("")){
				alarm.setText("Compilare correttamente il campo \"ID Prodotto\"!");
				alarm.setVisible(true);
				return;}
			Date data = new Date();
			EntrancesManagement entrata = new EntrancesManagement();
			Conversion entConv = new Conversion();
			Entrance entry = new Entrance();
			entry.setDay(entConv.getNumber(data.getDate()));
			entry.setMonth(entConv.getNumber(data.getMonth()+1));
			entry.setYear(entConv.getNumber(data.getYear()+1900));
			entry.setAmount(Prz.getText());
			entry.setID(ID.getText());
			entrata.addEntrance(entry);
			ID.setText("");
			Marca.setText("");
			Desc.setText("");
			Prz.setText("");
			Sconto.setText("");
		}
	}

	/**
	 * 
	 * @author Domenico
	 * Classe per l'inserimento di un prodotto non trovato nel DB
	 */
	class insert extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			if(Prz.getText().equals("")||ID.getText().equals(""))
				return;
			Date data = new Date();
			EntrancesManagement entrata = new EntrancesManagement();
			Conversion entConv = new Conversion();
			Entrance entry = new Entrance();
			entry.setDay(entConv.getNumber(data.getDate()));
			entry.setMonth(entConv.getNumber(data.getMonth()+1));
			entry.setYear(entConv.getNumber(data.getYear()+1900));
			entry.setAmount(Prz.getText());
			entry.setID(ID.getText());
			//entrata.addEntranceNotFound(entry);
			Product prod = new Product();
			prod.setMarca(Marca.getText());
			prod.setID(ID.getText());
			prod.setCategoria(Desc.getText());
			prod.setPrz(Prz.getText());
			prod.setModello("");
			prod.setQta("1");
			ProductManagement prodToAdd = new ProductManagement();
			//prodToAdd.insertProductNotFound(prod);
			ID.setText("");
			Marca.setText("");
			Desc.setText("");
			Prz.setText("");
			Sconto.setText("");
			inserisci.setVisible(false);
			conferma.setVisible(true);
			alarm.setVisible(false);
			cont.repaint();
		}
	}

	/**
	 * 
	 * @author Domenico
	 * Classe per il reset del form
	 */
	class reset extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
				ID.setText("");
				Marca.setText("");
				Desc.setText("");
				Prz.setText("");
				Sconto.setText("");
				inserisci.setVisible(false);
				conferma.setVisible(true);
				alarm.setVisible(false);
				cont.repaint();
		}
	}

	public static void main(String[] args) {
		GestioneCassa gestione = new GestioneCassa();
	}
	
	private Connection con;	//oggetto di tipo Connection per la connessione al DB
	private JFrame jf;	//oggetto di tipo JFrame per la visualizzazione della finestra
	private JButton reset, conferma, inserisci;	//oggetti di tipo JButton per le manipolazioni sui prodotti
	private Container cont;	//oggetto di tipo Container che funge da contenitore per i pulsanti, label e testi
	private JPanel pannello;	//oggetto di tipo JPanel per l'incapsulamento del contenitore
//	oggetti di tipo JLabel per gli attributi del prodotto e comunicazione con l'operatore
	private JLabel id, marca, descrizione, prezzo, gs, sconto, perc, alarm;	
	private JTextField ID, Marca, Desc, Prz, Sconto;	//oggetti di tipo JTextField per l'inserimento dei parametri
	private Font font;	//oggetto di tipo Font per il settaggio del carattere
}
