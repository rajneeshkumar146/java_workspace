package Arrays;

import java.util.Scanner;

public class Q003_EqulibrimPoint {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int[] arr = new int[N];
		for (int j = 0; j < N; j++) {
			arr[j] = scn.nextInt();
		}
		System.out.println(equilibrium(arr));
	}

	public static int equilibrium(int arr[]) {
		if (arr.length < 3) {
			return -1;
		}

		int leftsum = 0;
		int left = 0;

		while (left < arr.length - 2) {
			leftsum += arr[left];
			left++;
		}

		left--;
		boolean flag = false;
		int right = arr.length - 2;
		int rightsum = arr[arr.length - 1];
		while (right >= 0 && left >= 0) {
			if (leftsum == rightsum) {
				flag = true;
				break;
			}

			leftsum -= arr[left];
			rightsum += arr[right];
			left--;
			right--;
		}

		if (!flag)
			return -1;
		else
			return right;
	}

}
