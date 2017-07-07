package ex_1_2_19;

import java.util.HashMap;
import java.util.Map;

public class Date {
	private final int month;
	private final int day;
	private final int year;
	Map<Integer , Integer> maxMonthDaysValue  = new HashMap<Integer,Integer>();
	
	
	private boolean isValid(){
		
		
		
		return isYearValid() && isMonthValid() && isDayValid() ;
		
	}
	
	
	
	
	private boolean isDayValid(){
		final int max_day_valid = maxMonthDaysValue.get(this.month);
		final int min_day_valid = 1;
		if((this.day >= min_day_valid) &&(this.day <=max_day_valid) ){
			return true;
		}
		
		else{
			return false;
		}
	}
	
	public String dayOfTheWeekInWords(){
		return null;
	}
	
	
	private boolean isYearValid(){
		final int max_year_value = Integer.MAX_VALUE;
		final int min_year_value = 0;
		if(this.year > min_year_value && this.year < max_year_value ){
			return true;
		}
		else{
			return false;
		}
	}
	

	
	public boolean isMonthValid(){
		final int max_month_valid = 12;
		final  int min_month_valid = 1;
		if(this.month<=max_month_valid  && this.month>= min_month_valid){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	 Date(String date)
	{
		
		
		String[] parsedDate = date.split("/");
		
		int m = Integer.valueOf(parsedDate[0]);
		int d = Integer.valueOf(parsedDate[1]);
		int y = Integer.valueOf(parsedDate[2]);
 		maxMonthDaysValue.put(1, 31);
		
		if((y % 4) ==0){
			maxMonthDaysValue.put(2, 29); // leap year
		}else{
			maxMonthDaysValue.put(2, 28); // leap year
		}

		maxMonthDaysValue.put(3, 31);
		maxMonthDaysValue.put(4, 30);
		maxMonthDaysValue.put(5, 31);
		maxMonthDaysValue.put(6, 30);
		maxMonthDaysValue.put(7, 31);
		maxMonthDaysValue.put(8, 30);
		maxMonthDaysValue.put(9, 31);
		maxMonthDaysValue.put(11, 30);
		maxMonthDaysValue.put(12, 31);
		
		
		month = m;
		day = d;
		year = y;
		
		if(!isValid()){
			throw new IllegalArgumentException();
		}
	}

	
	

	
	public Date(int m, int d, int y) {
		maxMonthDaysValue.put(1, 31);
		
		if((y % 4) ==0){
			maxMonthDaysValue.put(2, 29); // leap year
		}else{
			maxMonthDaysValue.put(2, 28); // leap year
		}

		maxMonthDaysValue.put(3, 31);
		maxMonthDaysValue.put(4, 30);
		maxMonthDaysValue.put(5, 31);
		maxMonthDaysValue.put(6, 30);
		maxMonthDaysValue.put(7, 31);
		maxMonthDaysValue.put(8, 30);
		maxMonthDaysValue.put(9, 31);
		maxMonthDaysValue.put(11, 30);
		maxMonthDaysValue.put(12, 31);
		
		
		month = m;
		day = d;
		year = y;
		
		if(!isValid()){
			throw new IllegalArgumentException();
		}
		
	}

	public int month() {
		return month;
	}

	public int day() {
		return day;
	}

	public int year() {
		return year;
	}

	public String toString() {
		return month() + "/" + day() + "/" + year();

	}
}
