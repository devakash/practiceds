package reportsql;

public class ZeroOne {
	public static void main(String[] args) {

		int i[] = { 0,0,0,0,0,1,1,1,1,1 };
		int oneCounter = i.length - 1;
		for (int j = 0; j < i.length; j++) {
			if (i[j] == 1) {
				while (oneCounter > j && i[oneCounter] != 0) {
					oneCounter = oneCounter - 1;

				}
				if (oneCounter > j) {
					i[oneCounter--] = 1;
					i[j] = 0;
				} else {
					break;
				}
			}
		}

		for (int k : i) {
			System.out.print(k);
		}

	}

	public int[] withTempArr(int[] i) {
		int result[] = new int[i.length];

		int zeroCounter = 0, oneCounter = i.length - 1;
		for (int j = 0; j < i.length; j++) {
			if (i[j] == 0)
				result[zeroCounter++] = i[j];
			else
				result[oneCounter--] = i[j];

		}

		for (int k : result) {
			System.out.print(k);
		}

		return result;
	}
}
