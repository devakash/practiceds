package remotereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextParser {
	
	public String getValue(String fileName,String key) throws IOException
	{
		
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		String line;
		while((line=br.readLine())!=null)
		{
			String arr[]=line.split(":");
			if(!arr[0].trim().equalsIgnoreCase(key))
			{
				continue;
			}
			else{
				return arr[1].trim();
			}
		}
		br.close();
		return null;
	}

}
