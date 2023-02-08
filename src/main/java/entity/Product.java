package entity;

/**
 * @author Domenico
 * @version 1.0
 */
public class Product {
	
	public Product(){
		id ="";
		marca ="";
		modello = "";
		prezzo ="";
		qta ="";
		categoria ="";
	}
	
	/**
	 * Metodo per settare il codice identificativo del prodotto
	 * @param id
	 */
	public void setID(String id){
		this.id = id;
	}
	
	/**
	 * Metodo per settare la marca del prodotto
	 * @param marca
	 */
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	/**
	 * Metodo per settare il modello di prodotto
	 * @param modello
	 */
	public void setModello(String modello){
		this.modello = modello;
	}
	
	/**
	 * Metodo per settare il prezzo del prodotto
	 * @param prezzo
	 */
	public void setPrz(String prezzo){
		this.prezzo = prezzo;
	}
	
	/**
	 * Metodo per settare la quantit� del prodotto
	 * @param qta
	 */
	public void setQta(String qta){
		this.qta = qta;
	}
	
	/**
	 * Metodo per settare la categoria a cui appartiene il prodotto
	 * @param categoria
	 */
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
	
	/**
	 * Metodo per le restituzione del codice identificativo del prodotto
	 * @return ID
	 */
	public String getID(){
		return id;
	}
	
	/**
	 * Metodo per la restituzione della marca del prodotto
	 * @return marca
	 */
	public String getMarca(){
		return marca;
	}
	
	/**
	 * Metodo per la restituzione del modello del prodotto
	 * @return modello
	 */
	public String getModello(){
		return modello;
	}
	
	/**
	 * Metodo per la restituzione del prezzo del prodotto
	 * @return prezzo
	 */
	public String getPrz(){
		return prezzo;
	}
	
	/**
	 * Metodo per la restituzione della quantit� del prodotto
	 * @return quantit�
	 */
	public String getQta(){
		return qta;
	}
	
	/**
	 * Metodo per la restituzione della categoria a cui appartiene il prodotto
	 * @return categoria
	 */
	public String getCategoria(){
		return categoria;
	}
	
	private String id, marca, modello, prezzo, qta, categoria;

}
