package ex_1_2_19;

import java.util.HashMap;
import java.util.Map;








public class Year {
	Map<Integer,Day> days ;
	
	Map<Integer,String> dayCodes;
	int day;
	int month;
	int year;
	Map<Integer , Integer> maxMonthDaysValue  = new HashMap<Integer,Integer>();

	public int countTotalLeapYearBeforeTheYear(int year){
		
		int totalLeapYear = 0;
		for(int x = 2001 ; x<year ;x++){
			if((x%4) ==0){
				totalLeapYear++;
			}
		}
		return totalLeapYear;
	}
	
	
	
	public int calculateStartDayOfTheYear(int year){
		int startDay = 0;
		startDay =(year-2000 % 7) +countTotalLeapYearBeforeTheYear(year );
		
		return  startDay;
		
	}
	
	
	public String getDayInWords(){
		String returnValue = "";
		int dayId = day;
		for(int x = 1 ; x<month; x++){
				
				dayId = dayId +  maxMonthDaysValue.get(x);
		}
		
		System.out.println(dayId);
		return days.get(dayId).toString();
	
	}
	
	
	
	
	private void init(){
		if((this.year % 4) ==0){
			maxMonthDaysValue.put(2, 29); // leap year
		}else{
			maxMonthDaysValue.put(2, 28); // leap year
		}
		maxMonthDaysValue.put(1, 31);
		maxMonthDaysValue.put(3, 31);
		maxMonthDaysValue.put(4, 30);
		maxMonthDaysValue.put(5, 31);
		maxMonthDaysValue.put(6, 30);
		maxMonthDaysValue.put(7, 31);
		maxMonthDaysValue.put(8, 30);
		maxMonthDaysValue.put(9, 31);
		maxMonthDaysValue.put(10, 31);
		maxMonthDaysValue.put(11, 30);
		maxMonthDaysValue.put(12, 31);
	}
	
	Year(int year,int month, int day) {
		this.day = day;
		this.year = year;
		this.month = month;
		
		init();
		int numberOfDaysPerYear = 365;
		if((year %4) ==0 ){
			numberOfDaysPerYear =366;
		}
		int startDay = calculateStartDayOfTheYear(year);
		dayCodes = new HashMap<Integer,String>();
		dayCodes.put(0, "sun");
		dayCodes.put(1, "mon");
		dayCodes.put(2, "tue");
		dayCodes.put(3, "wed");
		dayCodes.put(4, "thu");
		dayCodes.put(5, "fri");
		dayCodes.put(6, "sat");
		days = new HashMap<Integer,Day>();
		for (int x = 1; x <= numberOfDaysPerYear; x++) {
			Day daylocal = new Day(dayCodes.get(startDay%7));
			days.put(x, daylocal);
	
					
			startDay++;
		}
		System.out.println("Total " + days.size());

	
	}
}
