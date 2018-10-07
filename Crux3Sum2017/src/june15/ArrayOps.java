package june15;

public class ArrayOps {

	public static void main(String[] args) {
		// int[] arr = {22, 55, 99, 44, 11, 88};
		// display(arr);
		//
		// int max = max(arr);
		// System.out.println(max);
		//
		// System.out.println(linearSearch(arr, 11));
		// System.out.println(linearSearch(arr, 110));
		//
		// display(arr);
		// reverse(arr);
		// display(arr);

		 int[] arr = {3, 4, 0, 1, 2};
		 int[] rot = rotate(arr, 2);
		 display(rot);
	}

	public static void display(int[] kuchbhi) {
		for (int val : kuchbhi) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static int max(int[] arr) {
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	// index or -1
	public static int linearSearch(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data) {
				return i;
			}
		}

		return -1;
	}

	public static void reverse(int[] arr) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			Swap(arr, left, right);
			left++;
			right--;
		}
	}

	public static void Swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] rotate(int[] arr, int k) {
		int[] rot = new int[arr.length];
		int ridx = 0;

		k = k % arr.length;
		if (k < 0) {
			k = k + arr.length;
		}

		for (int i = arr.length - k; i < arr.length; i++) {
			rot[ridx] = arr[i];
			ridx++;
		}

		for (int i = 0; i < arr.length - k; i++) {
			rot[ridx] = arr[i];
			ridx++;
		}

		return rot;
	}

	public static int[] inverse(int[] arr) {
		int[] inv = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inv[arr[i]] = i;
		}

		return inv;
	}

}
