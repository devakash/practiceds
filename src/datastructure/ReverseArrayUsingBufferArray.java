package datastructure;

//https://www.careercup.com/question?id=5181130190880768
public class ReverseArrayUsingBufferArray {
	public static void main(String[] args) {
		int i[]={1,2,3,4,5,6,7,8,9};
		int result[]=new int[i.length];
		int beginindex=i.length-1;
		for(int k=0;k<i.length;k++)
		{
			result[beginindex]=i[k];
			beginindex=beginindex-1;
		}
		
		for(int l:result)
		{
			System.out.print(l+" ");
		}
	}

}
