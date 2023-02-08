
/*
 * Created on 15-giu-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package entity;

/**
 * @author Domenico
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Supplies extends Persone {
	
	public Supplies(){
		piva="";
		pagato="";
		debito ="";
	}
	
	
	public void setPiva(String str){
		piva = str;
	}
	
	public void setPagato(String pay){
		pagato = pay;
	}
	
	public void setDebito(String deb){
		debito = deb;
	}
	

	public String getPiva(){
		return piva;
	}
	
	public String getPagato(){
		return pagato;
	}
	
	public String getDebito(){
		return debito;
	}
	
	private String piva, pagato, debito;

}
