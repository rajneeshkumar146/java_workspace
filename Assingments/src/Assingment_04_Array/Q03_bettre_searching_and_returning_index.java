package Assingment_04_Array;

import java.util.Scanner;

public class Q03_bettre_searching_and_returning_index {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = take_input();
		display(arr);
		
		bubble_sort(arr);
		display(arr);
		
		System.out.println(better_search(arr));
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
	
	public static void bubble_sort(int[] arr){
		for(int count=1;count<arr.length;count++){
		for(int i=0;i<arr.length-count;i++){
			if(arr[i]>arr[i+1]){
				swap(arr,i,i+1);
			}
		}
		}
		
	}
	
	public static void swap(int[] arr,int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static int better_search(int[] arr) {
		System.out.println("Enter your number you want to search");
		int n = scn.nextInt();
		int le=0,re=(arr.length-1);
		while (le<=re) {
			int mid=(le+re)/2;
			if(arr[mid]==n){
				return mid;
			}
			else if(arr[mid]>n){
				re=mid-1;
			}
			else if(arr[mid]<n){
				le=mid+1;
			}
		}
		return -1;
	}

}