package datastructure;

//https://www.careercup.com/question?id=5181130190880768
public class ReverseArrayFromMid {

	public static void main(String[] args) {
		int i[]={1,2,3,4,5,6,7,8,9};
		int result[]=reverseArray(i, 2);
		
		for(int jj:result)
		{
			System.out.print(jj+" ");
		}
	}
	private static int[] reverseArray(int[] A, int k) {
        for (int i = 0; i < A.length; i += k) {
            int left = i;
            // in case right larger than A.length
            int right = Math.min(i + k - 1, A.length - 1);

            // reverse sub array
            while (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }
        }

        return A;
    }
}
