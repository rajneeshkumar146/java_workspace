package Assingment_04_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q11_Intersection_of_2_array_by_array_list {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
//		System.out.println("Enter Your size of array");
		int n1=scn.nextInt();
		Integer[] arr1=take_input(n1);
		Arrays.sort(arr1);
		
//		System.out.println("Enter Your size of array");
		int n2=scn.nextInt();
		Integer[] arr2=take_input(n2);
		Arrays.sort(arr2);
		
		ArrayList<Integer> result=getintersection(arr1,arr2);
		System.out.println(result);
		
		
				

		
	}
	
	public static Integer[] take_input(int n){
		Integer[] rv=new Integer[n];
//		System.out.println("Enter Your Elements");
		for(int i=0;i<n;i++){
			rv[i]=scn.nextInt();
		}
		return rv;
	}

	public static ArrayList<Integer> getintersection(Integer[] arr1,Integer[] arr2){
		
		ArrayList<Integer> result=new ArrayList<>();
		int i=0,j=0;
     while(i<arr1.length && j<arr2.length){
    	 if(arr1[i]==arr2[j]){
    		 result.add(arr1[i]);
    	 
    		 i++;
    		 j++;
    	 
    	 }
    	 else if(arr1[i]<arr2[j]){
    		 i++;
    	 }
    	 else{
    		 j++;
    	 }
    	 
     }
		
		
		return result;
		
	}
	
}