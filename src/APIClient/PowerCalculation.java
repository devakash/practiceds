package APIClient;

public class PowerCalculation {
	
	public static void main(String[] args) {
		System.out.println(new PowerCalculation().pow(2, 3));
	}
	
	int pow(int base, int power){
	    if(power == 0) return 1;
	    return base * pow(base, --power);
	}
}
