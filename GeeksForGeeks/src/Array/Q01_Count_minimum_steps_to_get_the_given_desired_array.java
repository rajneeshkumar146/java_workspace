package Array;

public class Q01_Count_minimum_steps_to_get_the_given_desired_array {

	public static void main(String[] args) {

		int[] arr = { 99999998, 99999998, 99999998, 99999998, 1 };

		System.out.println(MinStepsIrr(arr));
		System.out.println(MinStepsRec(arr, true));

	}

	public static int MinStepsRec(int[] arr, boolean flag0) {

		if (flag0 == false) {
			return 0;
		}

		int x = 0;
		int y = 0;
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 && arr[i] != 0) {
				arr[i]--;
				count++;
				flag = true;
			}
		}
		if (flag != false) {
			x = count + MinStepsRec(arr, flag0);
		}

		flag0 = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				flag0 = true;
			}
		}

		if (flag0 == true) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] /= 2;
			}

			y = 1 + MinStepsRec(arr, flag0);
		}
		return x + y;

	}

	public static int MinStepsIrr(int[] arr) {

		int x = 0;
		int y = 0;

		for (int count = 0; true; count++) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 != 0 && arr[i] != 0) {
					arr[i]--;
					x++;
				}
			}
			boolean flag = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					flag = true;
				}
			}
			if (flag == true) {
				for (int i = 0; i < arr.length; i++) {
					arr[i] /= 2;
				}

				y++;
			} else {
				break;
			}
		}

		return x + y;

	}

}
