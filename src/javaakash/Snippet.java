package javaakash;

public class Snippet {

	public static void main(String[] args) {
		String desiredOutput = "";
		String testSuite[] = { "PFM 3.0", "L2", "Excel" };
		for (int k = 0; k < testSuite.length; k++) {
			String temp = testSuite[k];
			temp = "'" + temp + "'";
			desiredOutput = temp + "," + desiredOutput;
		}

		if (desiredOutput.length() > 0) {
			desiredOutput = desiredOutput.substring(0, desiredOutput.length() - 1);

		}
		System.out.println(desiredOutput);
	}

}
