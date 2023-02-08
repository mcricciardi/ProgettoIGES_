
package entity;

/**
 * @author Domenico
 *
 * @version 1.0
 */
public class Entrance {
	
	public Entrance(){
		day = "";
		month = "";
		year = "";
		id = "";
		importo = "";
	}
	
	/**
	 * Metodo per settare il giorno
	 * @param day oggetto di tipo stringa
	 */
	public void setDay(String day){
		this.day = day;
	}
	
	/**
	 * Metodo per settare il mese
	 * @param month oggetto di tipo stringa
	 */
	public void setMonth(String month){
		this.month = month;
	}
	
	/**
	 * Metodo per settare l'anno
	 * @param year oggetto di tipo stringa
	 */
	public void setYear(String year){
		this.year = year;
	}
	
	/**
	 * Metodo per settare il codice identificativo del prodotto
	 * @param ID oggetto di tipo stringa
	 */
	public void setID(String ID){
		id = ID;
	}
	
	/**
	 * Metodo per settare il prezzo del prodotto venduto
	 * @param amount oggetto di tipo stringa
	 */
	public void setAmount(String amount){
		importo = amount;
	}
	
	
	/**
	 * Metodo che restituisce il giorno
	 * @return String giorno
	 */
	public String getDay(){
		return day;
	}
	
	/**
	 * Metodo che restituisce il mese
	 * @return String mese
	 */
	public String getMonth(){
		return month;
	}
	
	/**
	 * Metodo che restituisce l'anno
	 * @return String anno
	 */
	public String getYear(){
		return year;
	}
	
	/**
	 * Metodo che restituisce il codice identificativo del prodotto
	 * @return String ID prodotto
	 */
	public String getID(){
		return id;
	}
	
	/**
	 * Metodo che restituisce il prezzo del prodotto venduto
	 * @return String importo
	 */
	public String getAmount(){
		return importo;
	}
	
	private String day, month, year, id, importo;

}