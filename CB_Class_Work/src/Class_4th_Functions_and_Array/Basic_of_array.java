package Class_4th_Functions_and_Array;

import java.util.Scanner;

public class Basic_of_array {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = take_input();
		display(arr);
		arr=reverse(arr);
		display(arr);
	}

	public static int[] take_input() {
		System.out.println("Enter size of array");
		int n = scn.nextInt();
		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			System.out.println("Enter" + (i+1) + "th element");
			rv[i] = scn.nextInt();
		}
		return rv;

	}

	public static void display(int[] arr) {
		for (int val : arr)
			System.out.print(val + "\t");
         System.out.println();
	}

	public static void max(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];

		}
		System.out.println("Your Maximum Value is :" + max);

	}
  
	public static void linera_search(int[] arr){
		System.out.println("Enter your value you want to search");
		int n=scn.nextInt();
		
		for(int i=0;i<arr.length;i++){
			if(arr[i] == n)
				System.out.println("yes value is present at position:" + i);
		}
		
	}
	
	public static int[] rotate(int[] arr){
		System.out.println("Enter Your rotation index");
		int n=scn.nextInt();
		int[] temp=new int[arr.length];
		int j=0;
        for(int i=arr.length-n;i<arr.length;i++){
        	temp[j]=arr[i];
        	j++;
        }
        for(int i=0;j<temp.length;i++){
        	temp[j]=arr[i];
        	j++;
        }
        return temp;
		
	}

	public static int[] reverse(int[] arr){
		

		for(int le=0,re=arr.length-1;le<=re;le++,re--){
			int temp=arr[le];
			arr[le]=arr[re];
			arr[re]=temp;
		}
		return arr;
	}

}
