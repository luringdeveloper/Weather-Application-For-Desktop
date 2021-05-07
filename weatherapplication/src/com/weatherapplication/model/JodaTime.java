package com.weatherapplication.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;

public class JodaTime {
	String day;
	String month;
	String year;
	Date date;
	private String dayOfWeek;

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}
	
	public String dayOfWeek() {
		return dayOfWeek;
	}

	public JodaTime()  {
				DateTime datetime = new DateTime();
				day = String.valueOf(datetime.getDayOfMonth());
				year = String.valueOf(datetime.getYear());
				int temp = datetime.getMonthOfYear();
		
				try {
				int intday=Integer.parseInt(day);
				int intyear=Integer.parseInt(year);
				String dateString = String.format("%d-%d-%d", intyear, temp, intday);
				Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
				dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
				}catch (Exception e) {
					System.out.println(e);
				}
				
				switch (temp) 
				{
					case 1: {
			
						month = "Jan";
						break;
					}
					case 2: {
			
						month = "Feb";
						break;
					}
					case 3: {
			
						month = "Mar";
						break;
					}
					case 4: {
			
						month = "Apr";
						break;
					}
					case 5: {
			
						month = "May";
						break;
					}
					case 6: {
			
						month = "June";
						break;
					}
					case 7: {
			
						month = "July";
						break;
					}
					case 8: {
			
						month = "Aug";
						break;
					}
					case 9: {
			
						month = "Sep";
						break;
					}
					case 10: {
			
						month = "Oct";
						break;
					}
					case 11: {
			
						month = "Nov";
						break;
					}
					case 12: {
			
						month = "Dec";
						break;
					}
			
					default:
						throw new IllegalArgumentException("Unexpected value: " + month);
				}
	}

	
}
