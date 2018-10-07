package Array;

public class largest_number_2nd {

	public static void main(String[] args) {
		int[] arr = { 10, 8, 7, -1, 5 };
		larNum2(2, arr);

	}

	public static void larNum2(int n, int[] arr) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j + 1] > arr[j]) {
					swap(arr, j + 1, j);
				}
			}
		}

		System.out.println("2nd largest number is: " + arr[1]);
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
