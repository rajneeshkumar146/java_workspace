package Assingment_06_Recursion;

import java.util.Scanner;

public class Q08_return_first_index_of_data_in_array {

public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		System.out.println("enter your size of array");
		int n = scn.nextInt();
		int[] arr=take_input(n);
//		System.out.println("enter number you want to find");
		int m=scn.nextInt();
		System.out.println(firstindex(arr,0,m));

	}
	
	public static int[] take_input(int n){
		int[] rv=new int[n];
	
		for(int i=0;i<n;i++){
			rv[i]=scn.nextInt();
		}
		return rv;
	}
	
	public static int firstindex(int[] arr,int vidx,int data){
		if(vidx==arr.length){
			return -1;
		}
		
		if(arr[vidx]==data){
			return vidx;
		}
		int num=firstindex(arr,vidx+1,data);
		return num;
		
	}

}
