
/*
 * Created on 16-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package intermediate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import accessdb.ConstantsDB;
import entity.Administrator;


/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdminAccess {
	
	public AdminAccess(Administrator admin){
		this.admin = admin;
	}
	
	public boolean verify(){
		boolean ver = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql:///sm";
			Connection con = DriverManager.getConnection(url, ConstantsDB.USER,ConstantsDB.PSW);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select nome from amministratore where login='"+admin.getLogin()+"' && password='"+admin.getPassword()+"'");
			if(rs.next()) ver=true;
		}
		catch(Exception e){
			
		}
		return ver;
	}
	
	private Administrator admin;

}
