package datastructure;

public class FindMissingFromDuplicateArray {
	public static void main(String[] args) {
		int arr1[]={1,2,3,4,5,6,7};
		int arr2[]={1,3,4,7};
		
		outer: for(int i=0;i<arr1.length;i++)
		{
			int k=0;
			while(k<arr2.length)
			{
				if(arr1[i]==arr2[k])
				{
					continue outer;
				}
				k++;
			}
			System.out.print(arr1[i]+" ");
		}
		
	}
}
