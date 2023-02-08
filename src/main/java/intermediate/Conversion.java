
package intermediate;

/**
 * @author Domenico
 *
 * @version 1.0
 */
public class Conversion {
	
	/**
	 * Metodo per la conversione da Integer a String
	 * @param number oggetto Integer da convertire
	 * @return String numero convertito
	 */
	public String getNumber(int number){
		String num="";
		while(number>0||(number%10)>0){
			int n=number%10;
			switch(n){
				case 1: num = "1"+num;	break;
				case 2: num = "2"+num;	break;
				case 3: num = "3"+num;	break;
				case 4: num = "4"+num;	break;
				case 5: num = "5"+num;	break;
				case 6: num = "6"+num;	break;
				case 7: num = "7"+num;	break;
				case 8: num = "8"+num;	break;
				case 9: num = "9"+num;	break;
				default: num = "0"+num;
			}
			number/=10;
		}
		return num;
	}
	
	/**
	 * Metodo per la conversione da Float a String
	 * @param number oggetto Float da convertire
	 * @return String numero convertito
	 */
	public String getNumber(float number){
		String num="";
		int numero = (int)number;
		int decimal = (int)((number*100)-(numero*100));
		num+="."+getNumber(decimal);
		while(numero>0||(numero%10)>0){
			int n=(int)numero%10;
			switch(n){
				case 1: num = "1"+num;	break;
				case 2: num = "2"+num;	break;
				case 3: num = "3"+num;	break;
				case 4: num = "4"+num;	break;
				case 5: num = "5"+num;	break;
				case 6: num = "6"+num;	break;
				case 7: num = "7"+num;	break;
				case 8: num = "8"+num;	break;
				case 9: num = "9"+num;	break;
				default: num = "0"+num;
			}
			numero/=10;
		}
		return num;
	}
	
	/**
	 * Metodo per la conversione da stringa ad intero
	 * @param number oggetto di tipo String da convertire
	 * @return int oggetto convertito
	 */
	public int getNumber(String number){
		int num;
		if(!number.equals(""))
			num = Integer.parseInt(number);
		else
			num = 0;
		return num;
	}
	
	/**
	 * Metodo per la conversione da stringa a float
	 * @param number oggetto di tipo stringa da convertire
	 * @return float oggetto convertito
	 */
	public float getNumberFloat(String number){
		float num;
		if(!number.equals(""))
			num = Float.parseFloat(number);
		else
			num = 0;
		return num;
	}

}
