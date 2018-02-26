package APIClient;
/**
 * This class calculates the length of minimum array , which is equal to binaraion of another array.
 * A binarian is nothing but a 2^ sum of all array elements.
 * Eg: for array [0|1|2|0] the binarian is: 2^0+2^1+2^2+2^0=1+2+4+1=8
 * 
 * This class will return : 1 bcz [3]= 2^3=8
 * 
 */
public class RekutenBinarian {
	
	

	static int count = 0;

	public static void main(String[] args) {
		calc(8);
		System.out.println(count);
	}

	
	public static void calc(int i) {
		double b = Math.ceil(Math.log(i) / Math.log(2));
		if (Math.pow(2, b) != i) {
			count = count + 1;
			b = b - 1;
		}
		int number = new Double(i - Math.pow(2, b)).intValue();
		if (number != 1 && number > 0) {
			calc(number);
		}
		if (number == 1||number==0) {
			count = count + 1;
		}

	}

}
