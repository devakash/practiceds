package javaakash;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class createLast5Days {
	
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal=Calendar.getInstance();
		for(int i=0;i<5;i++)
		{
		cal.add(Calendar.DAY_OF_YEAR, -i);
		System.out.println(dateFormat.format(cal.getTime()));
		cal.add(Calendar.DAY_OF_YEAR, i);
		}
		
	}

}
