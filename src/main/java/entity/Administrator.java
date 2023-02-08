package entity;

/**
 * @author Domenico
 * @version 1.0
 */
public class Administrator extends Persone {
	
	/**
	 * Settaggio variabili login e password
	 *
	 */
	public Administrator(){
		login="";
		password="";
	}
	
	/**
	 * Metodo per settare la login nel bean
	 * @param log
	 */
	public void setLogin(String log){
		login = log;
	}
	
	/**
	 * Metodo per settare la password nel bean
	 * @param passwd
	 */
	public void setPassword(String passwd){
		password = passwd;
	}
	
	/**
	 * Metodo per restituire la login contenuta nel bean
	 * @return login
	 */
	public String getLogin(){
		return login;
	}
	
	/**
	 * Metodo per restituire la password contenuta nel bean
	 * @return password
	 */
	public String getPassword(){
		return password;
	}
	
	private String login, password;

}
