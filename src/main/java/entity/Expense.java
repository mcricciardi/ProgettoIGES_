
/*
 * Created on 17-giu-2005
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
public class Expense {
	
	public Expense(){
		day = "";
		month = "";
		year = "";
		importo = "";
		conto = "";
		desc = "";
	}
	
	public void setDay(String day){
		this.day = day;
	}
	
	public void setMonth(String month){
		this.month = month;
	}
	
	public void setYear(String year){
		this.year = year;
	}
	
	public void setAmount(String amount){
		importo = amount;
	}
	
	public void setCount(String count){
		conto = count;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	
	public String getDay(){
		return day;
	}
	
	public String getMonth(){
		return month;
	}
	
	public String getYear(){
		return year;
	}
	
	public String getAmount(){
		return importo;
	}
	
	public String getCount(){
		return conto;
	}
	
	public String getDesc(){
		return desc;
	}
	
	private String day, month, year, importo, conto, desc;

}
