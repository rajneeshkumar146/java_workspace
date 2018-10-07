package Assingment_04_Array;

import java.util.Arrays;
import java.util.Scanner;

public class Q13_Target_Triplet_Sum {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		
		int target = scn.nextInt();
		printTriplets(arr, target);
	}

	private static void printTriplets(int[] arr, int target){
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++){
			int left = i + 1, right = arr.length - 1;
			int nt = target - arr[i];  //now_try_to_achieve_nt_because_below_code_behave_like_a_Pair_targetSum.
			
			while(left < right){
				int sum = arr[left] + arr[right];
				
				if(sum == nt){
					System.out.println(arr[i] + ", " + arr[left] + " and " + arr[right]);
					left++;
					right--;
				}
				else if(sum < nt){
					left++;
				}
				else {
					right--;
				}
			}
		}
	}
		
	
}