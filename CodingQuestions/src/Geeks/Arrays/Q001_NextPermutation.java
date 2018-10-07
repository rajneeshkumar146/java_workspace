package Geeks.Arrays;

import java.util.Scanner;

public class Q001_NextPermutation {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
//		6 1 2 3 1 3 3
		int[] arr = ArrayInput(scn.nextInt());

		int index = -1;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			for (int i = 0, j = arr.length - 1; i >= j; i++, j--) {
				swap(arr, i, j);
			}
		} else {
			int idx = -1;
			int nxBig = Integer.MAX_VALUE;
			for (int i = index + 1; i < arr.length; i++) {
				if (arr[i] > arr[index] && arr[i] <= nxBig) { // <=?, 1 2 3 1 3 3 => 1 2 3 3 1 3
					nxBig = arr[i];
					idx = i;
				}
			}
			
			for(int i=index+1,j=arr.length-1;i<=j;i++,j--){
				swap(arr, i, j);
			}

		}
		
		for(int val:arr){
			System.out.print(val +" ");
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
