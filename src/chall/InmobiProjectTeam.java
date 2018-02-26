package chall;

import java.util.Scanner;

public class InmobiProjectTeam {
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int numTCase=scn.nextInt();
		
		int ipArr[][]=new int[numTCase][];
		for(int i=0; i<numTCase;i++)
		{
			int k=Integer.parseInt(scn.next());
			int arr[]=new int[k];
			for(int j=0;j<arr.length;j++)
			{
				arr[j]=scn.nextInt();
			}
			ipArr[i]=arr;
		}
		
		for(int i=0; i<ipArr.length;i++)
		{
			int ii[]=ipArr[i];
			
			ii=getSortedArr(ii);
			
			int len=ii.length-1;
			
			int out[]=new int[ii.length/2];
			
			for(int o=0;o<ii.length/2;o++)
			{
				
				out[o]=ii[o]+ii[len];
				
				len=len-1;
			}
			
			out=getSortedArr(out);
			System.out.println(out[0]-out[out.length-1]);
		}
	}

	public static int[] getSortedArr(int [] ii)
	{
		for(int k=0;k<ii.length;k++)
		{
			for(int l=k+1;l<ii.length;l++)
			{
				if(ii[k]<ii[l])
				{
					int temp=ii[l];
					ii[l]=ii[k];
					ii[k]=temp;
				}
			}
		}
		
		return ii;
	}
}



