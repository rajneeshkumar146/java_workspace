package Assingment_04_Array;

import java.util.Scanner;

public class Q10_Insertion_sort {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = take_input();
		display(arr);
		
		insertion_sort(arr);
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
	
	public static void insertion_sort(int[] arr){
		for(int count=1;count<arr.length;count++){
			for(int i=count;i>0;i--){
				if(arr[i-1]>arr[i]){
					swap(arr,i-1,i);
				}else{
					break;
				}
				
			}
		}
	}
	
	public static void swap(int[] arr,int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		
	}
	
}