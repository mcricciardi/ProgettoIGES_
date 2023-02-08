package interfacce;


import accessdb.ConstantsDB;
import intermediate.AdminAccess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entity.Administrator;



/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Autentication {

	/**
	 * 
	 */
	public Autentication() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql:///sm";
			con = DriverManager.getConnection(url, ConstantsDB.USER,ConstantsDB.PSW);
			jbInit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void jbInit() throws Exception{
		buttonCreate();
		creaPannello();
		jf = new JFrame("Login");
		jf.setSize(350,200);
		jf.getContentPane().add(BorderLayout.NORTH, aut);
		jf.getContentPane().add(pannello);
		jf.getContentPane().setBackground(new Color(125,82,0));
		jf.setLocation(100,50);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void creaPannello(){
		pannello = new JPanel();
		pannello.setLayout(null);
		aut = new JLabel();
		aut.setFont(new Font("Arial", Font.BOLD, 12));
		aut.setForeground(Color.WHITE);
		
		login = new JTextField();
		JLabel log = new JLabel("Login");
		log.setFont(new Font("Arial", Font.BOLD, 12));
		log.setForeground(Color.WHITE);
		
		password = new JPasswordField();
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Arial", Font.BOLD, 12));
		pass.setForeground(Color.WHITE);
		
		JLabel aute = new JLabel("Accesso amministratore");
		aute.setFont(new Font("Arial", Font.BOLD, 17));
		aute.setForeground(new Color(255,227,198));
		
		JLabel img = new JLabel(new ImageIcon("sfondo_autentica.jpg"));
		img.setBorder(null);
		
		cont = new Container();
		cont.setSize(400,200);
		cont.add(aute).setBounds(75,5,270,20);
		cont.add(invia).setBounds(140,100,60,20);
		cont.add(log).setBounds(110,45,100,20);
		cont.add(login).setBounds(150,45,100,20);
		cont.add(pass).setBounds(85,70,100,20);
		cont.add(password).setBounds(150,70,100,20);
		cont.add(img).setBounds(0,0,350,200);
		pannello.add(cont);
		pannello.setBackground(new Color(179,152,125));
	}
	
	public void buttonCreate(){
		invia = button("Invia", new Color(119,94,68), Color.WHITE);
        invia.addMouseListener(new ok());
	}
	
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        but.setBorder(null);
        return but;
    }
	
	class ok extends MouseAdapter {

        public void mouseReleased(MouseEvent east){
            Administrator admin = new Administrator();
            admin.setLogin(login.getText());
            admin.setPassword(password.getText());
            AdminAccess verify = new AdminAccess(admin);
            if(verify.verify()){
            	MainWindow main = new MainWindow();
            	jf.setVisible(false);
            }
            else{
            	login.setText("");
            	password.setText("");
            	aut.setText("Login o password errata");
            	jf.repaint();
            }
        }

    }
	

	public static void main(String[] args) {
		Autentication aut = new Autentication();
	}
	private JButton invia, reset;
	private JMenuBar jmb;
	private JPanel pannello;
	private JFrame jf;
	private JLabel aut;
	private Connection con;
	private Container cont;
	private JTextField login;
	private JPasswordField password;
}
