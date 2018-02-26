package datastructure;

public class ReverseSortArray {
	
	public static void main(String[] args) {
		int i[]={10,6,5,7,8};
		
		for(int j=0;j<i.length-1;j++)
		{
			int first=i[j];
			
			for(int k=j+1;k<i.length;k++)
			{
				if(i[k]>first)
				{
					i[j]=i[k];
					i[k]=first;
					first=i[j];
				}
			}
		}
		
		for(int k:i)
		System.out.println(k);
	}
}
