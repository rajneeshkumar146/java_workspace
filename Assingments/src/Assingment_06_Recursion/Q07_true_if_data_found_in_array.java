package Assingment_06_Recursion;

import java.util.Scanner;

public class Q07_true_if_data_found_in_array {

public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		System.out.println("enter your size of array");
		int n = scn.nextInt();
		int[] arr=take_input(n);
//		System.out.println("enter number you want to find");
		int m=scn.nextInt();
		System.out.println(find(arr,0,m));

	}
	
	public static int[] take_input(int n){
		int[] rv=new int[n];
		for(int i=0;i<n;i++){
			rv[i]=scn.nextInt();
		}
		return rv;
	}
	
	public static boolean find(int[] arr,int vidx,int data){
		if(vidx==arr.length){
			return false;
		}
		if(arr[vidx]==data){
			return true;
		}
		boolean res=find(arr,vidx+1,data);
		return res;
		
	}

}
