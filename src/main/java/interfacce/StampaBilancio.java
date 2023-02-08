/*
 * Created on 15-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfacce;


import intermediate.Conversion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StampaBilancio {


	public StampaBilancio() {
		font = new Font("Arial", Font.BOLD, 13);
		buttonCreate();
		createContainer();
	}
	
	public void createContainer(){
		cont = new Container();
		cont.setSize(694,520);
		sb = new JLabel("Stampa Bilancio");
		sb.setFont(new Font("Arial", Font.BOLD, 18));
		sb.setForeground(new Color(255,227,198));
		Da = new JLabel("Da:");
		Da.setFont(font);
		Da.setForeground(Color.white);
		dayDA = new JTextField();
		dayDA.setFont(font);
		A = new JLabel("A:");
		A.setFont(font);
		A.setForeground(Color.white);
		slash = new JLabel("/");
		slash.setFont(font);
		slash.setForeground(Color.white);
		slash1 = new JLabel("/");
		slash1.setFont(font);
		slash1.setForeground(Color.white);
		slash2 = new JLabel("/");
		slash2.setFont(font);
		slash2.setForeground(Color.white);
		slash3 = new JLabel("/");
		slash3.setFont(font);
		slash3.setForeground(Color.white);
		dayA = new JTextField();
		dayA.setFont(font);
		monthDA = new JTextField();
		monthDA.setFont(font);
		monthA = new JTextField();
		monthA.setFont(font);
		yearDA = new JTextField();
		yearDA.setFont(font);
		yearA = new JTextField();
		yearA.setFont(font);
		cont.add(sb).setBounds(300,15,250,60);
		cont.add(reset).setBounds(400,250,140,25);
		cont.add(search).setBounds(240,250,140,25);
		cont.add(Da).setBounds(260,110,50,32);
		cont.add(A).setBounds(260,150,50,32);
		cont.add(dayDA).setBounds(320,110,40,25);
		cont.add(slash).setBounds(363,110,10,32);
		cont.add(monthDA).setBounds(370,110,40,25);
		cont.add(slash1).setBounds(413,150,10,32);
		cont.add(yearDA).setBounds(420,110,60,25);
		cont.add(dayA).setBounds(320,150,40,25);
		cont.add(slash2).setBounds(413,110,10,32);
		cont.add(monthA).setBounds(370,150,40,25);
		cont.add(slash3).setBounds(363,150,10,32);
		cont.add(yearA).setBounds(420,150,60,25);
	}
	
	public void buttonCreate(){
		search = button("Cerca", new Color(119,94,68), Color.WHITE);
		search.addMouseListener(new search());
		search.setFont(font);
		reset = button("Cancella", new Color(119,94,68), Color.WHITE);
        reset.addMouseListener(new reset());
        reset.setFont(font);
        annulla = button("Annulla", new Color(119,94,68), Color.WHITE);
        annulla.addMouseListener(null);
        annulla.setFont(font);
	}
	
	public JButton button(String name, Color color, Color fg){
        JButton but = new JButton(name);
        but.setBackground(color);
        but.setForeground(fg);
        return but;
    }
	
	public class search extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			try{
				Date data = new Date();
				Conversion conv = new Conversion();
				String[] periodo = {"","","","","",""};
				periodo[0] = dayDA.getText();
				periodo[1] = monthDA.getText();
				periodo[2] = yearDA.getText();
				if(dayA.getText().equals(""))
					periodo[3] = conv.getNumber(data.getDay());
				else
					periodo[3] = dayA.getText();
				if(monthA.getText().equals(""))
					periodo[4] = conv.getNumber(data.getMonth()+1);
				else
					periodo[4] = monthA.getText();
				if(yearA.getText().equals(""))
					periodo[5] = conv.getNumber(data.getYear()+1900);
				else
					periodo[5] = yearA.getText();
				PrintBalanceResult printBalance = new PrintBalanceResult(periodo);
				cont.removeAll();
				cont.add(printBalance.getContainer());
				cont.repaint();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public class reset extends MouseAdapter{
		public void mouseReleased(MouseEvent east){
			try{
				dayDA.setText("");
				dayA.setText("");
				monthDA.setText("");
				monthA.setText("");
				yearDA.setText("");
				yearA.setText("");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public Container getContainer(){
		return cont;
	}
	
	private JButton search, reset, annulla;
	private Font font;
	private JFrame jf;
	private Container cont;
	private JPanel pannello;
	private JLabel sb, Da, A, slash, slash1, slash2, slash3;
	private JTextField dayDA, monthDA, yearDA, dayA, monthA, yearA;
}
