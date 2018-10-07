package Array;

public class Seperate_negative_and_positive_numbers_Using_constant_space {

	public static void main(String[] args) {
		int[] arr = { -5, 7, -3, -4, 9, 10, -1, 11 };
		// Method_1_Irr(arr);
		// Method_1_Rec(arr, false);
		arr = Method_2_mergeing(arr, 0, arr.length - 1);
		display(arr);

	}

	private static void display(int[] arr) {
		System.out.print("[");
		for (int e : arr) {
			System.out.print(e + ",");
		}
		System.out.println("]");

	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void Method_1_Irr(int[] arr) { // O(n^2)

		for (int j = 0; j < arr.length; j++) {
			boolean flag = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > 0 && arr[i + 1] < 0) {
					swap(arr, i, i + 1);
					flag = true;
				}
			}
			if (flag == false) {
				break;
			}
		}

	}

	public static void Method_1_Rec(int[] arr, boolean flag) {// O(n^2)

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > 0 && arr[i + 1] < 0) {
				swap(arr, i, i + 1);
				flag = true;
			}
		}
		if (flag == false) {
			return;
		}

		Method_1_Rec(arr, false);
	}

	public static int[] Method_2_mergeing(int[] arr, int lo, int re) { // O(nlog(n))_but_using_auxiliary_Space_temp_Array.
		if (lo == re) {
			int[] recu_arr = new int[1];
			recu_arr[0] = arr[lo];
			return recu_arr;
		}

		int mid = (lo + re) / 2;
		int[] ral = Method_2_mergeing(arr, lo, mid); // recursive_array_left
		int[] rar = Method_2_mergeing(arr, mid + 1, re); // Recursive_array_right

		return merging(ral, rar);

	}

	private static int[] merging(int[] ral, int[] rar) {

		int[] arr = new int[ral.length + rar.length];
		int i = 0, j = 0, k = 0;

		while (i < ral.length && j < rar.length) {
			if (ral[i] < 0) {
				arr[k] = ral[i];
				i++;
				k++;
			} else if (rar[j] < 0) {
				arr[k] = rar[j];
				j++;
				k++;
			} else {
				break;
			}

		}

		while (i < ral.length) {
			arr[k] = ral[i];
			k++;
			i++;
		}

		while (j < rar.length) {
			arr[k] = rar[j];
			k++;
			j++;

		}

		return arr;
	}

}
