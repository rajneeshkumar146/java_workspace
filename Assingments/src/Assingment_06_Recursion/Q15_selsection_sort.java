package Assingment_06_Recursion;

import java.util.Scanner;

public class Q15_selsection_sort {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

//		System.out.println("enter your size of array");
		int n = scn.nextInt();
		int[] arr = take_input(n);
		arr = selection_sort(arr, 0, 0);
		display(arr);

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
			System.out.println(arr[i] + " ");
		}

	}

	public static int[] selection_sort(int[] arr, int vidx, int fix) {

		if(fix==arr.length-1){
			return arr;
		}
		
		if(vidx==arr.length-1){
			arr = selection_sort(arr, fix, fix+1);
            return arr;
		}
		
		
		if (arr[fix] > arr[vidx+1]) {
			int temp = arr[fix];
			arr[fix] = arr[vidx+1];
			arr[vidx+1] = temp;
		}
		arr = selection_sort(arr, vidx + 1, fix);
		return arr;

	}

}
