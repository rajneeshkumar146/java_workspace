package DynamicProgramming.set;

import java.util.Scanner;

public class Set07_CoinChange {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
	       int arr[] = {7 , 8 , 2};
	        int m = arr.length;
	        System.out.println( coinChange(arr, 0, 100));
	}

	private static int coinChange(int[] arr, int vidx, int n) {
		if(vidx==arr.length){
			if (n == 0) { //ek_hi_tarika_hai_Koi_bhi_coin_include_mat_karo.
				return 1;
			}else{
				return 0;
			}
		}
		
		

		if (n < 0) {
			return 0;
		}

		int case1 = coinChange(arr, vidx + 1, n);
		int case2 = coinChange(arr, vidx , n - arr[vidx]);

		return case1 + case2;

	}

}
