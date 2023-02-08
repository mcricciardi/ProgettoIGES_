
/*
 * Created on 16-giu-2005
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
public class Persone {

	/**
	 * 
	 */
	public Persone() {
		nome="";
		cognome ="";
		indirizzo ="";
		tel ="";
		fax ="";
	}
	
	public void setNome(String str){
		nome = str;
	}
	public void setCognome(String str){
		cognome = str;
	}
	public void setIndirizzo(String str){
		indirizzo = str;
	}
	public void setTel(String str){
		tel = str;
	}
	public void setFax(String str){
		fax = str;
	}
	

	public String getNome(){
		return nome;
	}
	public String getCognome(){
		return cognome;
	}
	public String getIndirizzo(){
		return indirizzo;
	}
	public String getTel(){
		return tel;
	}
	public String getFax(){
		return fax;
	}
	
	private String nome, cognome, indirizzo, tel, fax;

}
