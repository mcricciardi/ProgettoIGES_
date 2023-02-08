
/*
 * Created on 20-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package intermediate;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PrintTextArea extends JTextArea{
	
	
	public PrintTextArea(JTextArea jt, String title) {
		this.title = title;
		append(jt.getText() + '\n');
	}
	
		public void print(Graphics g) {
			g.setFont(new Font("Times New Roman", Font.BOLD, 24));
			FontMetrics fontMetrics = g.getFontMetrics();
			int lineHeight = fontMetrics.getHeight();
			if(title.equals("Entrate"))
				g.translate(50, 100);
			else
				g.translate(250,0);
			g.drawString(title, 0, 0);
			int y = 2 * lineHeight;
			g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			fontMetrics = g.getFontMetrics();
			lineHeight = fontMetrics.getHeight();
			StringTokenizer tokens = new StringTokenizer(getText(), "\t\r\n");
			int i = 0;
			while (tokens.hasMoreTokens()) {
				String s = tokens.nextToken();
				if(i==3)
					y += lineHeight;
				if(tokens.countTokens()==1)
					y += lineHeight;
				if(i%3==0)
					g.drawString(s, 0, y);
				if(i%3==1&&tokens.countTokens()>1)
					g.drawString(s, 60, y);
				if(i%3==2||tokens.countTokens()==0){
					g.drawString(s, 175, y);
					y += lineHeight;}
				i++;
			}
		}
	
	private String title;

}
