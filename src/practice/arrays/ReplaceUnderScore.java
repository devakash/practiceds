package practice.arrays;

public class ReplaceUnderScore {
	
	public static void main(String[] args) {
		
		char ch[]={'t','h','i','s','_','i','_','s','_','a','k','a','s','h','1','2','3','4','5','6'};
		
		for(int i=0; i<ch.length;i++)
		{
			if(ch[i]!='_')
			{
				continue;
			}
			else
			{
				for(int k=ch.length-3;k>i;k--)
				{
					ch[k+2]=ch[k];
					ch[k]='_';
				}
			}
			ch[i]='%';
			ch[i+1]='2';
			ch[i+2]='0';
		}
		
		for(char c:ch)
		{
			System.out.print(c+" ");
		}
		
	}

}
