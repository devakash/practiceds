package datastructure;

/**
 * @author ajain5
 * @category array
 * 
 */
public class SortArray {

	/*
	 * Approach: Get the element at index i as first element, compare first
	 * element with rest of the element, if element index i+1 is less than the
	 * number at index i swap the values. Now Make the element at index i as
	 * first.
	 * 
	 * To reverse sort it, just change the less than sign to greater than sign.
	 */
	public static void main(String[] args) {
		int i[] = { 10, 6, 5, 7, 8 }; 
		for (int j = 0; j < i.length; j++) {

			for (int k = j + 1; k < i.length; k++) {
				if (i[k] < i[j]) {

					int temp = i[k];
					i[k] = i[j];
					i[j] = temp;
					
					/*
					without using 3rd variable
					i[k]=i[j]+i[k];
					i[j]=i[k]-i[j];
					i[k]=i[k]-i[j];
					*/
				}

			}
		}

		for (int k : i)
			System.out.println(k);
	}

}
