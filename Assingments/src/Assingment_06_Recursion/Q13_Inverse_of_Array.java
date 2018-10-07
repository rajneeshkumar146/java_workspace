package Assingment_06_Recursion;

import java.util.Scanner;

public class Q13_Inverse_of_Array {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();
		int[] arr = take_input(n);
		int I=scn.nextInt();
		
		inverse(arr, 0);
		display(arr);
		System.out.print(arr[I]);
		

	}

	public static int[] take_input(int n) {
		int[] rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	public static void inverse(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

	int temp=arr[vidx];
		inverse(arr, vidx+1);
		arr[temp]=vidx;
		
	}
	

}
