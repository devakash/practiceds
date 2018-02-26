package datastructure;

import java.util.Scanner;

/*
 * This class converts 12 hours clock time to 24 hours clock equivalent.
 * Note :12:00:00AM in 12 hours clock is equal to 00:00:00 in 24 hours.
 */

public class TimeConvert {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String time = in.next();
	        calculateTime(time);
	    }
	 
	 static void calculateTime(String time)
	 {
		 int hour=0;
		 String token[]=time.split(":");
		 String sub=token[2].substring(0, 2);
		 
		 if(time.contains("PM") || time.contains("pm"))
		 {
			 if(Integer.parseInt(token[0])==12)
			 {
				hour=12; 
			 }
			 else{
				 hour=Integer.parseInt(token[0])+12; 
			 }
			 
			 String s=hour+":"+token[1]+":"+sub;
			 System.out.println(s); 
		 }
		 else
		 {
			 String hou="00";
			 if(Integer.parseInt(token[0])==12)
			 {
				 hou="00"; 
			 } 
			 else{
				 hou=token[0]; 
			 }
			 String s=hou+":"+token[1]+":"+sub;
			 System.out.println(s);
		 }
		 
	 }

}
