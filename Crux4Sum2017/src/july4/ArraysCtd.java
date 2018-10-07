package july4;

public class ArraysCtd {

	public static void main(String[] args) {
		int[] arr = { 55, 11, 44, 22, 33 };
		selectionSort(arr);
		display(arr);
	}

	public static void bubbleSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					Swap(arr, i, i + 1);
				}
			}

			counter++;
		}
	}

	public static void selectionSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int ei = counter; ei < arr.length; ei++) {
				if (arr[counter - 1] > arr[ei]) {
					Swap(arr, counter - 1, ei);
				}
			}

			counter++;
		}
	}

	public static void insertionSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = counter; i > 0; i--) {
				if (arr[i - 1] > arr[i]) {
					Swap(arr, i, i - 1);
				} else {
					break;
				}
			}

			counter++;
		}
	}

	public static void Swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println(".");
	}

}
