package Assingment_06_Recursion;


import java.util.Scanner;

public class Q06_True_if_sorted_array {

public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		System.out.println("enter your size of array");
		int n = scn.nextInt();
		int[] arr=take_input(n);
		System.out.println(sorted(arr,0));

	}
	public static int[] take_input(int n){
		int[] rv=new int[n];
		for(int i=0;i<n;i++){
			rv[i]=scn.nextInt();
		}
		return rv;
	}

	public static boolean sorted(int[] arr,int vidx){
		if(vidx==arr.length-1){
			return true;
		}
		
		if(arr[vidx]>arr[vidx+1]){
			return false;
		}
		
		boolean res=sorted(arr,vidx+1);
		return res;
		
	}
	
}
