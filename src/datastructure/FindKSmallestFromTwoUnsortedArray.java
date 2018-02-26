package datastructure;

public class FindKSmallestFromTwoUnsortedArray {

	public static void main(String[] args) {
		int arr1[] = { 10, 3, 4, 5, 23, 1 }; //1,3,4,5,10,23

		int arr2[] = { 4, 86, 2, 9, 6, 11 }; //2,4,6,9,11,86
		
		
		
		
		arr1 = sortArr(arr1);

		arr2 = sortArr(arr2);

		int small = 0;
		if (arr1.length > arr2.length) {
			small = arr2.length;
		} else {
			small = arr1.length;
		}
		
		int smal=arr1[0];
		//int l=0;
		
		for (int i = 0; i < 2; i++) {

			if (arr1[i] < smal) {
				smal = arr1[i];
			} else if (arr2[i] < small) {
				smal = arr2[i];
			}

		}
		
		
		System.out.println(smal);

	}

	public static int[] sortArr(int i[]) {
		for (int j = 0; j < i.length; j++) {
			for (int k = j + 1; k < i.length; k++) {
				if (i[j] > i[k]) {
					int temp = i[j];
					i[j] = i[k];
					i[k] = temp;
				}
			}

		}
		return i;
	}

}
