package june18;

import java.util.Scanner;

public class rotate {

	public static void main(String[] args) {
		int[] arr = ArrayUtils.takeInput();
		ArrayUtils.display(arr);
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of rotations ");
		int r = scn.nextInt();
		
		int left1 = 0;
		int right1 = arr.length - 1 - r;
		int left2 = arr.length - r;
		int right2 = arr.length - 1;
		
		// part1 rev
		reverse(arr, left1, right1);
		
		// part2 rev
		reverse(arr, left2, right2);
		
		// whole rev
		reverse(arr, 0, arr.length - 1);
		
		ArrayUtils.display(arr);
	}
	
	private static void reverse(int[] arr, int left, int right){
		while(left < right){
			ArrayUtils.swap(arr, left, right);
			left++;
			right--;
		}
	}

}
