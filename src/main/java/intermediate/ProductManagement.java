
package intermediate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;

import accessdb.ConstantsDB;
import entity.Product;


/**
 * @author Domenico
 * @version 1.0
 */
public class ProductManagement {
	
	public ProductManagement(){
		createConnection();
	}

    public void setId(String id) {
        this.id = id;
    }

    public ProductManagement(String ID){
		createConnection();
		id = ID;
	}
	
	/**
	 * Metodo per istanziare una connessione col database
	 *
	 */
	private void createConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql:///sm";
			con = DriverManager.getConnection(url, ConstantsDB.USER,ConstantsDB.PSW);
			st = con.createStatement();
			prod = new Product();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Product getProduct(){
		try{
			rs = st.executeQuery("select id,marca,modello,categoria,prezzo,qta from prodotto where id=\""+id+"\"");
			if(rs.next()){
				prod.setID(rs.getString(1));
				prod.setMarca(rs.getString(2));
				prod.setModello(rs.getString(3));
				prod.setCategoria(rs.getString(4));
				prod.setPrz(rs.getString(5));
				prod.setQta(rs.getString(6));
			}
			else{
				prod.setID("");
				prod.setMarca("");
				prod.setModello("");
				prod.setCategoria("");
				prod.setPrz("");
				prod.setQta("");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return prod;
	}
	
	public Product getProductToAdd(){
		try{
			rs = st.executeQuery("select id,marca,modello,categoria,prezzo,qta from producttoadd");
			if(rs.next()){
				prod.setID(rs.getString(1));
				prod.setMarca(rs.getString(2));
				prod.setModello(rs.getString(3));
				prod.setCategoria(rs.getString(4));
				prod.setPrz(rs.getString(5));
				prod.setQta(rs.getString(6));
			}
			else{
				prod.setID("");
				prod.setMarca("");
				prod.setModello("");
				prod.setCategoria("");
				prod.setPrz("");
				prod.setQta("");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return prod;
	}
	
	public boolean insertProduct(Product product){
		String id,marca,modello,categoria,prezzo,qta;;
		boolean result=false;
		id=product.getID();
		marca=product.getMarca();
		modello=product.getModello();
		categoria=product.getCategoria();
		prezzo=product.getPrz();
		qta=product.getQta();
		try{
			
		
				ResultSet rs = st.executeQuery("select marca from prodotto where id=\""+id+"\"");
				if(!rs.next())
					if(!st.execute("insert into prodotto values(\""+id+"\",\""+marca+"\",\""+modello+"\",\""+categoria+"\",\""+prezzo+"\",\""+qta+"\")"))
						result=true;
					else
						result = updateProduct(product);
					if(flag==1)
						st.execute("delete from producttoadd where id=\""+id+"\"");
		
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updateProduct(Product product){
		String id,marca,modello,categoria,prezzo,qta;;
		boolean result=false;
		id=product.getID();
		marca=product.getMarca();
		modello=product.getModello();
		categoria=product.getCategoria();
		prezzo=product.getPrz();
		qta=product.getQta();
		try{
			ResultSet rs = st.executeQuery("select id from prodotto where id=\""+id+"\"");
			if(rs.next()){
				if(!prezzo.equals(""))
					if(!st.execute("update prodotto set prezzo=\""+prezzo+"\",qta=\""+qta+"\" where id=\""+id+"\""))
						result=true;
				else{
					if(!st.execute("update prodotto set qta=\""+qta+"\" where id=\""+id+"\""))
						result=true;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean removeProduct(){
		boolean ver = false;
		try{
			if(!st.execute("delete from prodotto where id=\""+id+"\""))
				ver = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ver;
	}
	
	public void setFlag(int flag){
		this.flag = flag;
	}
	
	
	
	private Product prod;
	private Connection con;
	private String id;
	private Statement st;
	private ResultSet rs;
	public int flag=0;
	private JLabel msg;

}
