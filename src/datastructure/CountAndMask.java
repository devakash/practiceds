package datastructure;

public class CountAndMask {
	
	public static void main(String[] args) {
		String s="nitesh deepesh akash nitesh rameshnitesh";
		int count=0;
		String token[]=s.split(" ");
		for(int i=0;i<token.length;i++)
		{
			if(token[i].contains("nitesh")||token[i].contains("akash"))
			{
				count=count+1;
				token[i]=token[i].replace("nitesh", "xxxxxx");
				token[i]=token[i].replace("akash", "xxxxxx");
			}
		}
		
		for(String k:token)
		{
			System.out.print(k+" ");
		}
	}
	

}
