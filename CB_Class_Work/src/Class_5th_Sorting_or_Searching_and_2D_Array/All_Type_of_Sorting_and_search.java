package Class_5th_Sorting_or_Searching_and_2D_Array;

import java.util.Scanner;

public class All_Type_of_Sorting_and_search {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr;
		arr = take_input();

	}

	public static int[] take_input() {
		System.out.println("Enter Size of array");
		int n = scn.nextInt();
		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			System.out.println("Enter Your" + (i + 1) + "Element");
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void display(int[] arr) {
		for (int val : arr)
			System.out.print(val + "\t");
		System.out.println();
	}

	public static void linear_search(int[] arr) {
		System.out.println("Enter Your searchred element");
		int n = scn.nextInt();
		int le = 0, re = arr.length - 1, mid = 0; // le=left,re=reight
		for (int i = 0; le<=re; i++) {
			mid = (le + re) / 2;

			if (arr[mid] == n)
				System.out.println(mid);

			else if (arr[mid] < n)
				le = mid + 1;

			else
				re = mid - 1;

		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[i] = temp;
	}

	public static void bubble_sort(int[] arr) {

		for (int counter = 1; counter < arr.length; counter++) {

			for (int i = 0; i < arr.length - counter; i++) {

				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}

			}
		}
	}

	public static void selection_sort(int[] arr) {

		for (int counter = 1; counter < arr.length; counter++) {

			for (int i = counter; i < arr.length; i++) {
				if (arr[i-1] > arr[i]) {
				swap(arr,i-1,i);
				}
			}
		}

	}

	public static void insertion_sort(int[] arr){
		for (int counter = 1; counter < arr.length; counter++) {

			for (int i = counter; i>0; i--) {
				if (arr[i] > arr[i+1]) {
				swap(arr,i,i+1);
				}
				else{
					break;
				}
			}
		}
		
	}
}
