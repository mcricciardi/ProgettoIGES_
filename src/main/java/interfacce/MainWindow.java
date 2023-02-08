
package interfacce;


import intermediate.ProductManagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 * @author Domenico
 * @version 1.0
 */
public class MainWindow {
	
	public MainWindow(){
		font = new Font("Comic Sans MS", Font.BOLD, 20);
		buttonCreate();
		creaPannello();
		creaMenu();
		jbInit();
	}
	
	/**
	 * Inizializzazione del frame
	 *
	 */
	public void jbInit(){
		
		
		jf = new JFrame("Gestione Negozio");
		jf.setSize(694,520);
		jf.setLocation(100,50);
		jf.setJMenuBar(jmb);
		jf.getContentPane().add(pannello);
		
		jf.getContentPane().setBackground(new Color(179,152,125));
		jf.setResizable(true);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Inizializzazione del pannello principale
	 *
	 */
	public void creaPannello(){
		pannello = new JPanel();
		pannello.setLayout(null);
		
		mw = new JLabel("Gestione negozio");
		mw.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
		mw.setForeground(Color.WHITE);
		mw.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel img = new JLabel(new ImageIcon("sfondo_main.jpg"));
		img.setBorder(null);
		
		cont = new Container();
		cont.setSize(694,520);
		cont.add(balance).setBounds(10,260,100,30);
		cont.add(store).setBounds(150,260,100,30);
		cont.add(supplier).setBounds(280,260,100,30);
		cont.add(img).setBounds(0,-10,694,480);
		
		
		pannello.add(cont);
		pannello.setBackground(new Color(179,152,125));
		
		
	}
	/**
	 * Creazione dei pulsanti
	 *
	 */
	public void buttonCreate(){
		balance = button("Bilancio", (new Color(254,253,248)), (new Color(163,27,29)));
		balance.setBorder(null);
        balance.addMouseListener(new paintBalance());
        balance.setFont(font);
        store = button("Magazzino", (new Color(254,253,248)), (new Color(163,27,29)));
        store.setBorder(null);
        store.addMouseListener(new paintProduct());
        store.setFont(font);
        supplier = button("Fornitori", (new Color(254,253,248)), (new Color(163,27,29)));
        supplier.setBorder(null);
        supplier.addMouseListener(new GestisciFornitori());
        supplier.setFont(font);
	}
	
	/**
	 * Inizializzazione del pulsante tramite parametri
	 * @param name nome che verr� visualizzato sul pulsante
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
	 * Creazione della barra degli strumenti
	 *
	 */
	public void creaMenu(){
		jmb = new JMenuBar();
		searchProd = new JMenuItem("Cerca");
		searchProd.addMouseListener(new prodSearch());
		gestProd = new JMenuItem("Gestisci");
		gestProd.addMouseListener(new gestProd());
		addProd = new JMenuItem("Prodotti aggiunti");
		addProd.addMouseListener(new addProd());
		searchSup = new JMenuItem("Cerca");
		searchSup.addMouseListener(new searchForn());
		gestSup = new JMenuItem("Gestisci");
		gestSup.addMouseListener(new GestisciFornitori());
		insertExp = new JMenuItem("Inserisci Spesa");
		insertExp.addMouseListener(new inserExpense());
		printBal = new JMenuItem("Stampa");
		printBal.addMouseListener(new printBalance());
		paySup = new JMenuItem("Paga fornitore");
		paySup.addMouseListener(new paySup());
		bilancio = new JMenu("Bilancio");
		product = new JMenu("Prodotto");
		fornitore = new JMenu("Fornitore");
		main = new JMenu("Main");
		main.addMouseListener(new returnToHome());
		product.add(searchProd);
		product.add(gestProd);
		product.add(addProd);
		fornitore.add(searchSup);
		fornitore.add(gestSup);
		bilancio.add(paySup);
		bilancio.add(insertExp);
		bilancio.add(printBal);
		jmb.add(main);
		jmb.add(product);
		jmb.add(fornitore);
		jmb.add(bilancio);
		
	}
	
	/**
	 * Restituzione del contenitore
	 * @return Container
	 */
	public Container getContainer(){
		return cont;
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class paySup extends MouseAdapter{
		
		public void mouseReleased(MouseEvent east){
			try{
				SuppliesPay supplies = new SuppliesPay();
				pannello.removeAll();
				pannello.add(supplies.getContainer());
				pannello.repaint();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void mouseOver(MouseEvent event){
			
		}
	}
	
	public Frame getFrame(){
		return jf;
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class printBalance extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			StampaBilancio bil = new StampaBilancio();
			pannello.removeAll();
			pannello.add(bil.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class inserExpense extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			InsertExpense bil = new InsertExpense();
			pannello.removeAll();
			pannello.add(bil.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class prodSearch extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			CercaProdotto bil = new CercaProdotto();
			pannello.removeAll();
			pannello.add(bil.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class GestisciFornitori extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			GestioneFornitoreForm bil = new GestioneFornitoreForm();
			pannello.removeAll();
			pannello.add(bil.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class searchForn extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			CercaFornitore forn = new CercaFornitore();
			pannello.removeAll();
			pannello.add(forn.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class gestProd extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			GestioneProductForm forn = new GestioneProductForm();
			pannello.removeAll();
			pannello.add(forn.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class paintBalance extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			Balance bal = new Balance();
			pannello.removeAll();
			pannello.add(bal.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class paintProduct extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			Product prod = new Product();
			pannello.removeAll();
			pannello.add(prod.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class paintSupplier extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			Balance bal = new Balance();
			pannello.removeAll();
			pannello.add(bal.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class addProd extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			ProductManagement prodMan = new ProductManagement();
			entity.Product prod = prodMan.getProductToAdd();
			GestioneProductForm gestione = new GestioneProductForm(prod,1);
			pannello.removeAll();
			pannello.add(gestione.getContainer());
			jf.repaint();
		}
	}
	
	/**
	 * 
	 * @author Domenico
	 * @version 1.0
	 */
	class returnToHome extends MouseAdapter{
		public void mousePressed(MouseEvent east){
			pannello.removeAll();
			pannello.add(MainWindow.this.getContainer());
			jf.repaint();
		}
	}
	
	public static void main(String[] args) {
		MainWindow main = new MainWindow();
	}
	
	private JButton balance, store, supplier;
	private Font font;
	private JFrame jf;
	private Container cont;
	private JPanel pannello;
	private JLabel mw;
	private JMenu bilancio, product, fornitore, main;
	private JMenuItem searchProd, searchSup, gestProd, gestSup, insertExp, printBal, paySup, addProd;
	private JMenuBar jmb;
	private Image image;
	private int originalImageWidth;
	private int originalImageHeight;
}
