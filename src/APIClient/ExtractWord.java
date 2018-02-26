package APIClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractWord {
	
	public static void main(String[] args) {
		String testString="PFM 3.0 on L1 executed with 0.0 % passed on date 2016-08-08";
		Pattern pattern = Pattern.compile("(?<=with).*?(?=%)");
        Matcher matcher = pattern.matcher(testString);
        while(matcher.find()){
            System.out.println(matcher.group(0).trim());
        }
	}

}
