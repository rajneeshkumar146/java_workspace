package Assingment_06_Recursion;

import java.util.Scanner;

public class Q14_Bubble_Sort {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

//		 System.out.println("enter your size of array");
		 int n = scn.nextInt();
		 int[] arr = take_input(n);
		arr = bubble_sort(arr, 0, 0);
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
			System.out.print(arr[i] + " ");
		}

	}

	public static int[] bubble_sort(int[] arr, int vidx, int fix) { // in_buublee_sort_last_number_is_always_fix_so_here_fix_represent_this

		if(fix==arr.length-1){
			return arr;
		}
		
		if (vidx == arr.length - fix-1) {
			arr = bubble_sort(arr, 0 , fix+1);
			return arr;
		}
		if (arr[vidx] > arr[vidx + 1]) {
			int temp = arr[vidx];
			arr[vidx] = arr[vidx + 1];
			arr[vidx + 1] = temp;
		}
		arr = bubble_sort(arr, vidx + 1, fix);
		
		return arr;
	}
}
