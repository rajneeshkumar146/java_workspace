package Array;

public class Rearrange_Array_In_max_min_Form {

	public static void main(String[] args) {

	}

	public static void RAIMMF(int[] arr) {

		int[] temp_arr = new int[arr.length];
		int le = 0;
		int re = arr.length - 1;

		boolean flag = true;

		for (int i = 0; i < arr.length; i++) {
			if (flag) {
				temp_arr[i] = arr[le++];
			} else {
				temp_arr[i] = arr[re--];
			}

			flag = !flag;
		}

		arr = temp_arr.clone();

	}

}
