
package intermediate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import accessdb.ConstantsDB;
import entity.Entrance;


/**
 * @author Domenico
 * @version 1.0
 */
public class EntrancesManagement {
	
	public EntrancesManagement(){
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
	
	/**
	 * Metodo per l'aggiunta delle entrate
	 * @param ent oggetto di tipo entrance per l'aggiornamento delle entrate
	 * @return boolean vero se la tabella entrate � stat aggiornata, falso altrimenti
	 */
	public boolean addEntrance(Entrance ent){
		boolean ver=false;
		id = ent.getID();
		day = ent.getDay();
		month = ent.getMonth();
		year = ent.getYear();
		importo = ent.getAmount();
		try{
			if(!st.execute("insert into entrate values(\""+day+"\",\""+month+"\",\""+year+"\",\""+id+"\",\""+importo+"\")"))
				ver=true;
			ResultSet rs = st.executeQuery("select qta from prodotto where id=\""+id+"\"");
			if(rs.next()) qta = Integer.parseInt(rs.getString(1))-1;
			else
				return false;
			Conversion QTA = new Conversion();
			if(st.execute("update prodotto set qta=\""+QTA.getNumber(qta)+"\" where id=\""+id+"\""))
				ver=false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ver;
	}
	
	/**
	 * Metodo per lettura delle entrate dal database
	 * @param period 
	 * @return
	 */
	public ArrayList getEntrance(String[] period){
		ArrayList entrate= new ArrayList();
		entrate.add("Data\t");
		entrate.add("Prodotto\t\t");
		entrate.add("Importo");
		entrate.add("");
		entrate.add("\t\t");
		entrate.add("");
		try{
			ResultSet rs = st.executeQuery("select day,month,year,id,importo from entrate where (day>="+period[0]+" &&" +
					" month>="+period[1]+" && year>="+period[2]+" && year<="+period[5]+" && month<="+period[4]+") || (month<="+period[4]+" && " +
					"year>="+period[2]+" && month>"+period[1]+" && year<="+period[5]+")");
			int i=3;
			while(rs.next()){
				entrate.add(rs.getString(1)+"."+rs.getString(2)+"."+rs.getString(3)+"\t");
				entrate.add(rs.getString(4)+"\t\t");
				entrate.add(rs.getString(5));
			}
		}
		catch(Exception e){
			System.out.println("entrate\t"+e.getMessage());
		}
		return entrate;
	}
	

	
	private String id, importo, day, month, year;
	private int qta;
	private Connection con;
	private Statement st;

}
