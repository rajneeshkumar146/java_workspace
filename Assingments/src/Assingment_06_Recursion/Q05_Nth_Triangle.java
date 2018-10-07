package Assingment_06_Recursion;

import java.util.Scanner;

public class Q05_Nth_Triangle {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("enter number of row's");
		int n = scn.nextInt();
		System.out.println(triangle(n, 0, 1));

	}

	public static int triangle(int n, int res, int i) {

		if (i > n) {
			return 0;
		}

		res = triangle(n, res, i + 1); // oha_tk_ke_i_traingle_ka_sum_i_ke_pass_hai_and_i+1_ke_liye_recursive_call.
		return res + i;

	}

}
