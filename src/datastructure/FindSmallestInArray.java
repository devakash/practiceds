package datastructure;

public class FindSmallestInArray {
	static int smallest;

	public static void main(String[] args) {

		int i[] = { 4, 5, 7, 8, 10, 11, 2, 13, 11 };
		smallest = i[0];
		for (int j = 0; j < i.length; j++) {
			if (i[j] < smallest) {
				smallest = i[j];
			}
		}

		System.out.println(smallest);
	}

}
