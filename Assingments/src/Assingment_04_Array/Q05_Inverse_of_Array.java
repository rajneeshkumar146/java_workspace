package Assingment_04_Array;

import java.util.Scanner;

public class Q05_Inverse_of_Array {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = take_input();
		display(arr);

		arr=inverse(arr);
		display(arr);
	}

	public static int[] take_input() {
		System.out.println("\tEnter size of array");
		int n = scn.nextInt();

		int[] rv = new int[n];

		for (int i = 0; i < rv.length; i++) {
			System.out.println("Enter your " + (i + 1) + "th element");
			rv[i] = scn.nextInt();
		}
		return rv;

	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println();
	}
	
	public static int[] inverse(int[] arr){
		int[] rv=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			int temp=arr[i];
			rv[temp]=i;
		}
		return rv;
	}

}
