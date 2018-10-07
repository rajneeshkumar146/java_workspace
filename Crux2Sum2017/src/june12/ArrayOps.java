package june12;

import java.util.Scanner;

public class ArrayOps {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = { 10, 50, 2, 83, 19, 6 };
		// display(arr);
		//
		// System.out.println(max(arr));
		// System.out.println(linearSearch(arr, 83));
		// System.out.println(linearSearch(arr, 830));
		//
		// display(arr);
		// reverse(arr);
		// display(arr);

//		int[] arr = { 2, 4, 0, 1, 3 };
//		int[] inv = inverse(arr);
//		display(inv);
		
//		int[] arr = {10, 20, 30, 35, 40, 45, 50, 55, 60, 65, 70, 80, 90, 100};
//		System.out.println(binarySearch(arr, 800));
		
		int[] arr = {55, 11, 44, 33, 22};
		insertionSort(arr);
		display(arr);
	}

	public static int[] takeInput() {
		System.out.println("Enter the size of array");
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			System.out.println("Enter the value for " + i + "th element");
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + "\t");
			val = 0;
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

	public static int linearSearch(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data) {
				return i;
			}
		}

		return -1;
	}

	public static void reverse(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
	}

	public static int[] inverse(int[] arr) {
		int[] inv = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inv[arr[i]] = i;
		}

		return inv;
	}

	public static int[] rotate(int[] arr, int k) {
		k = k % arr.length;
		if (k < 0) {
			k = k + arr.length;
		}

		int[] rot = new int[arr.length];
		int ridx = 0;

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

	public static int binarySearch(int[] arr, int data) {
		int lo = 0, hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (data == arr[mid]) {
				return mid;
			} else if (data > arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return -1;
	}
	
	public static void bubbleSort(int[] arr){
		int counter = 1;
		
		while(counter <= arr.length - 1){
			for(int i = 0; i < arr.length - counter; i++){
				if(arr[i] > arr[i + 1]){
					swap(arr, i, i + 1);
				}
			}
			
			counter++;
		}
	}
	
	public static void selectionSort(int[] arr){
		int counter = 1;
		
		while(counter <= arr.length - 1){
			for(int i = counter; i < arr.length; i++){
				if(arr[counter - 1] > arr[i]){
					swap(arr, counter - 1, i);
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
					swap(arr, i - 1, i);
				} else {
					break;
				}
			}
			
			counter++;
		}
	}

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
