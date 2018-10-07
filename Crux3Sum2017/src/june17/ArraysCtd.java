package june17;

import java.util.Arrays;

public class ArraysCtd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		// System.out.println(binarySearch(arr, 20));
		// System.out.println(binarySearch(arr, 200));

//		int[] arr = { 55, 11, 44, 33, 22 };
//		display(arr);
//		insertionSort(arr);
//		display(arr);
		
		int[] arr = {1, 2, 3, 4};
		subset(arr);
	}

	public static int binarySearch(int[] arr, int data) {
		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (data > arr[mid]) {
				lo = mid + 1;
			} else if (data < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
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
		System.out.println();
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
			for (int i = counter; i < arr.length; i++) {
				if (arr[counter - 1] > arr[i]) {
					Swap(arr, counter - 1, i);
				}
			}
			counter++;
		}
	}

	public static void insertionSort(int[] arr){
		int counter = 1;
		
		while(counter <= arr.length - 1){
			for(int i = counter; i > 0; i--){
				if(arr[i - 1] > arr[i]){
					Swap(arr, i - 1, i);
				} else {
					break;
				}
			}
			
			counter++;
		}
	}

	public static void subset(int[] arr){
		int limit = (int)Math.pow(2, arr.length);
		
		int count = 0;
		while(count < limit){
			int temp = count;
			
			for(int i = 0; i < arr.length; i++){
				int rem = temp % 2;
				temp = temp / 2;
				
				if(rem == 1){
					System.out.print(arr[i] + "\t");
				}
			}
			
			System.out.println();
			count++;
		}
	}

	
	
	
	
	
	
	
	
}
