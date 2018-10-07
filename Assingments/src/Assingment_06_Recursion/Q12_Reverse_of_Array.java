package Assingment_06_Recursion;

import java.util.Scanner;

public class Q12_Reverse_of_Array {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// System.out.println("enter your size of array");
		int n = scn.nextInt();
		int[] arr = take_input(n);
		int I=scn.nextInt();  //paticular_index.
		
		reverse_array(arr, 0, n - 1);
		dispaly(arr);
		System.out.print(arr[I]);

	}

	public static int[] take_input(int n) {
		int[] rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}
	
	private static void dispaly(int[] arr){
		for(int i:arr){
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static void reverse_array(int[] arr, int vfidx, int vlidx) {
		if (vfidx >= vlidx) {
			return;
		}
		swap(arr, vfidx, vlidx);
		reverse_array(arr, vfidx + 1, vlidx - 1);

	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
