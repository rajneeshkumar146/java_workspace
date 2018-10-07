package TwoDArray.Questions;

import java.util.Scanner;

public class Q09_ShiftMatrix {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		int r = scn.nextInt();
		int c = scn.nextInt();
		int k = scn.nextInt();
		int[][] arr = new int[r][c];
		
		input(arr, r, c);
		
		for (int row = 0; row < r; row++) {
			reverse(arr, row, 0, k - 1);
			reverse(arr, row, k, c - 1);
			reverse(arr, row, 0, c - 1);
		}

		display(arr);
		
	}
	
	private static void input(int[][] arr,int r,int c){
		for(int row=0;row<r;row++){
			for(int col=0;col<c;col++){
				arr[row][col]=scn.nextInt();
			}
		}
		
	}
	
	private static void display(int[][] arr){
		for (int[] ar : arr) {
			for (int i : ar) {
				System.out.print(i + " " );
			}
			System.out.println();
		}

	}

	private static void reverse(int[][] arr, int i, int j, int k) {

		while (j <= k) {
			swap(arr, i, j, k);
			j++;
			k--;
		}
	}

	private static void swap(int[][] arr, int i, int j, int k) {
		int temp = arr[i][j];
		arr[i][j] = arr[i][k];
		arr[i][k] = temp;
	}

}
