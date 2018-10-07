package Assingment_06_Recursion;

import java.util.Scanner;

public class Q09_return_last_index_of_data_in_array {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

//		System.out.println("enter your size of array");
		int n = scn.nextInt();
		int[] arr = take_input(n);
//		System.out.println("enter number you want to find");
		int m = scn.nextInt();
		System.out.println(lastindex(arr, 0, m));

	}

	public static int[] take_input(int n) {
		int[] rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static int lastindex(int[] arr, int vidx, int data) {
		if(vidx==arr.length){
			return -1;
		}
		
		
		int num=lastindex(arr,vidx+1,data);
		if(num==-1){
			if(arr[vidx]==data){
				return vidx;
			}
		}
		
		return num;

	}

}
