
/*
 * Created on 17-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package intermediate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import accessdb.ConstantsDB;
import entity.Expense;


/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ExitsManagement {
	public ExitsManagement(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql:///sm";
			con = DriverManager.getConnection(url, ConstantsDB.USER,ConstantsDB.PSW);
			st = con.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean addExit(Expense exp){
		String day, month, year, amount, count, desc;
		day = exp.getDay();
		month = exp.getMonth();
		year = exp.getYear();
		amount = exp.getAmount();
		count = exp.getCount();
		desc = exp.getDesc();
		if(day.substring(0,1).equals("0"))
			day=exp.getDay().substring(1,2);
		if(month.substring(0,1).equals("0"))
			month=exp.getMonth().substring(1,2);
		boolean ver = false;
		try{
			if(!st.execute("insert into spese values(\""+day+"\",\""+month+"\",\""+year+"\",\""+desc+"\",\""+amount+"\",\""+count+"\")"))
				ver = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ver;
	}
	
	public ArrayList getExit(String[] period){
		ArrayList spese= new ArrayList();
		spese.add("Data\t");
		spese.add("Descrizione\t\t");
		spese.add("Importo");
		spese.add("");
		spese.add("\t\t");
		spese.add("");
		try{
			ResultSet rs = st.executeQuery("select day,month,year,descrizione,importo from spese where (day>="+period[0]+" &&" +
					" month>="+period[1]+" && year>="+period[2]+" && year<="+period[5]+" && month<="+period[4]+") || (month<="+period[4]+" && " +
							"year>="+period[2]+" && month>"+period[1]+" && year<="+period[5]+")");
			int i=0;
			while(rs.next()){
				spese.add(rs.getString(1)+"."+rs.getString(2)+"."+rs.getString(3)+"\t");
				if(rs.getString(4).length()<14)
					spese.add(rs.getString(4)+"\t\t");
				else
					if(rs.getString(4).length()<20)
						spese.add(rs.getString(4)+"\t");
					else
						spese.add(rs.getString(4).substring(0,17)+".\t");
				spese.add(rs.getString(5));
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return spese;
	}
	
	private String day, month, year, importo, conto, desc;
	private Connection con;
	private Statement st;

}
