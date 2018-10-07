package Q001_030;

import java.util.Scanner;

public class Q004_ChefAndSequence_CHEFSQ {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr1 = ArrayInput(n);
			int m = scn.nextInt();
			int[] arr2 = ArrayInput(m);

			int i = 0, j = 0;
			while (j < m && i < n) {
				if (arr1[i] == arr2[j]) {
					i++;
					j++;
				}else{
					i++;
				}
			}
			
			if(j==m){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
			
		}
	}

	private static int[] ArrayInput(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

}
