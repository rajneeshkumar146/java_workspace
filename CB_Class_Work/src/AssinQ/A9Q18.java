package AssinQ;

public class A9Q18 {

	public static void main(String[] args) {

	}

	public static void sort102(int[] arr) {

		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0;

		while (mid <= hi) {
			if (arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[lo];
				arr[lo] = temp;
				lo++;
				mid++;

			} else if (arr[mid] == 1) {
				mid++;
			} else {
				int temp = arr[mid];
				arr[mid] = arr[hi];
				arr[hi] = temp;
				hi--;
			}
		}

	}

}
