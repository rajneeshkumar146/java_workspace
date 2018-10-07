package Assingment_04_Array;

public class Q15_Subsequences {

	public static void main(String[] args) {
		int[] arr = { 1 , 2 ,3 , 4, 5 , 6, 7, 8, 9};

		int limit = (int) Math.pow(2, arr.length);
		int counter = 0;

		while (counter < limit) {
			int temp = counter;

			System.out.print("[");
			for (int i = 0; i < arr.length; i++) {
				int rem = temp % 2;

				if (rem == 1) {
					System.out.print(arr[i] + " ");
				}

				temp = temp / 2;
			}
			System.out.println("]");

			counter++;
		}
	}

}
