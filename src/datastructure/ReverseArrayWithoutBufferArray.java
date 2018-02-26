package datastructure;

public class ReverseArrayWithoutBufferArray {
	
	public static void main(String[] args) {
		int i[]={1,2,3,4,5,6,7,8,9};
		int beginIndex=i.length-1;
		for(int k=0;k<i.length/2;k++)
		{
			int temp=i[k];
			i[k]=i[beginIndex];
			i[beginIndex]=temp;
			beginIndex=beginIndex-1;
		}
		
		for(int l:i)
		{
			System.out.print(l+" ");
		}
	}

}
