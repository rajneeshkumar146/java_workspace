package Assingment_04_Array;

import java.util.Arrays;
import java.util.Scanner;

public class Q12_Target_Sum_pairs {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		int target = scn.nextInt();
		printPair(arr, target);
	}
	
	private static void printPair(int[] arr, int target){
		Arrays.sort(arr);
		
		int left = 0, right = arr.length - 1;
		while(left < right){
			int sum = arr[left] + arr[right];
			
			if(sum == target){
				System.out.println(arr[left] + " and " + arr[right]);
				left++;
				right--;
			}
			else if(sum < target){
				left++;
			}
			else {
				right--;
			}
		}
	}
	
}