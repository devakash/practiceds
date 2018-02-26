package chall;

public class SBinary {

	public static void main(String[] args) {
		int toSort[] = { 0, 1, 0, 1, 0, 1, 1, 1, 0, 1 };
		int begin = 0;
		int end = toSort.length - 1;
		while (begin < end) {
			if (0 == toSort[begin]) {
				begin++;

			} else if (1 == toSort[end]) {
				end--;
			} else {
				toSort[begin] = 0;
				toSort[end] = 1;
			}
		}
	}

}
