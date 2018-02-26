package javaakash;

public class HighestProductNumbers {

	public static void main(String[] args) {
		int a[] = {9, 7,-8};

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}

		int product1=a[a.length-1]*a[a.length-2];
		int product2=a[0]*a[1];
		if( product1>product2 )
		{
			System.out.println(a[a.length-1]+"|"+a[a.length-2]);
		}
		else
		{
			System.out.println(a[0]+"|"+a[1]);
		}
	}

}
