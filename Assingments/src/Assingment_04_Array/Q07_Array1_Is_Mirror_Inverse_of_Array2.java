package Assingment_04_Array;

import java.util.Scanner;

public class Q07_Array1_Is_Mirror_Inverse_of_Array2 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = take_input();
		display(arr);
		
		int[] arr1 = take_input();
		display(arr1);

		boolean result=inverse(arr,arr1);
		System.out.println(result);
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
	
	public static boolean inverse(int[] arr1,int[] arr2){

		int[] rv2=new int[arr2.length];
		for(int i=0;i<arr2.length;i++){
			int temp=arr2[i];
			rv2[temp]=i;
		}
		
		for(int i=0;i<arr1.length;i++){
			if(arr1[i]!=rv2[i]){
				return false;
			}
		}
		return true;
	}
}
