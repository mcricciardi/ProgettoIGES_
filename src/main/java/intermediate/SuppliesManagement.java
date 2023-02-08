
/*
 * Created on 15-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package intermediate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import accessdb.ConstantsDB;
import entity.Supplies;


/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SuppliesManagement {
	
	public SuppliesManagement(){
		createConnection();
	}
	
	public SuppliesManagement(String ID){
		createConnection();
		id = ID;
	}
	
	private void createConnection(){
		try{
			sup = new Supplies();
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql:///sm";
			con = DriverManager.getConnection(url, ConstantsDB.USER,ConstantsDB.PSW);
			st = con.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Supplies getSupplies(){
		try{
			sup.setNome("");
			sup.setCognome("");
			sup.setIndirizzo("");
			sup.setPiva("");
			sup.setTel("");
			sup.setFax("");
			sup.setDebito("");
			sup.setPagato("");
			rs = st.executeQuery("select nome,cognome,indirizzo,piva,tel,fax,debito,pagato from fornitori where piva=\""+id+"\"");
			if(rs.next()){
				sup.setNome(rs.getString(1));
				sup.setCognome(rs.getString(2));
				sup.setIndirizzo(rs.getString(3));
				sup.setPiva(rs.getString(4));
				sup.setTel(rs.getString(5));
				sup.setFax(rs.getString(6));
				sup.setDebito(rs.getString(7));
				sup.setPagato(rs.getString(8));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return sup;
	}
	
	public boolean insertSupplies(Supplies forn){
		String name,last,tel,fax,address,piva,deb,pag;
		boolean result=false;
		name=forn.getNome();
		last=forn.getCognome();
		tel=forn.getTel();
		fax=forn.getFax();
		address=forn.getIndirizzo();
		piva=forn.getPiva();
		deb=forn.getDebito();
		pag=forn.getPagato();
		try{
			if(st.execute("insert into fornitori values(\""+name+"\",\""+last+"\",\""+address+"\",\""+piva+"\",\""+tel+"\",\""+fax+"\",\""+deb+"\",\""+pag+"\")"));
					result=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean removeSupplies(Supplies forn){
		String name,last,tel,fax,address,piva;
		boolean result=false;
		name=forn.getNome();
		last=forn.getCognome();
		tel=forn.getTel();
		fax=forn.getFax();
		address=forn.getIndirizzo();
		piva=forn.getPiva();
		try{
			if(!st.execute("delete from fornitori where piva=\""+piva+"\""))
					result=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updateSupplies(Supplies forn){
		String name,last,tel,fax,address,piva,deb,pag;
		boolean result=false;
		name=forn.getNome();
		last=forn.getCognome();
		tel=forn.getTel();
		fax=forn.getFax();
		address=forn.getIndirizzo();
		piva=forn.getPiva();
		deb=forn.getDebito();
		pag=forn.getPagato();
		try{
			if(!st.execute("update fornitori set nome=\""+name+"\", cognome=\""+last+"\", tel=\""+tel+"\", fax=\""+fax+"\", indirizzo=\""+address+"\",debito=\""+deb+"\",pagato=\""+pag+"\" where piva=\""+piva+"\""))
					result=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updateSuppliesPayement(Supplies forn){
		String pagato, debito, piva;
		boolean result=false;
		pagato = forn.getPagato();
		debito = forn.getDebito();
		piva = forn.getPiva();
		Date data = new Date();
		try{
			if(!st.execute("update fornitori set pagato=\""+pagato+"\", debito=\""+debito+"\" where piva=\""+piva+"\""))
					result=true;
			if(!pagato.equals(""))
				st.execute("insert into spese values(\""+data.getDate()+"\",\""+(data.getMonth()+1)+"\",\""+(data.getYear()+1900)+"\",\"Pagamento "+piva+"\",\""+debito+"\",\""+pagato+"\")"); // \"\"
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	private Supplies sup;
	private Connection con;
	private String id, n;
	private Statement st;
	private ResultSet rs;

}
